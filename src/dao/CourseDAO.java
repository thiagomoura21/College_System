package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Course;
import entities.Student;

public class CourseDAO {

	private Connection connection;

	public CourseDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public int insert(Course course) {
		String sql;

		try {
			sql = "INSERT INTO TB_STUDENT " + "(NAME)" + " VALUES (?);";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, course.getName());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return getCourseIdByName(course.getName());
	}

	private int getCourseIdByName(String nameCourse) {

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_COURSE WHERE NAME=" + nameCourse + ";");

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				return response.getInt("ID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String getCourseById(int idCourse) {
		
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_COURSE WHERE ID=" + idCourse + ";");

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				return makeCourse(response).toString();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<String> getAllCourses() {

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_COURSE");

			ResultSet response = stmt.executeQuery();

			List<String> result = new ArrayList<String>();

			while (response.next()) {
				result.add(makeCourse(response).toString());
			}

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Course makeCourse(ResultSet response) throws SQLException {

		Course course = new Course();
		course.setId(response.getInt("ID"));
		course.setName(response.getString("NAME"));

		return course;
	}

}
