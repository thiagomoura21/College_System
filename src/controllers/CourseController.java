package controllers;

import java.util.List;

import dao.CourseDAO;
import entities.Course;

public class CourseController {

	private CourseDAO courseDao;

	public CourseController() {
		this.courseDao = new CourseDAO();
	}

	public String getCourseInformations(int idCourse) {
		String result = courseDao.getCourseById(idCourse);
		if(result != null)
			return result;
		else
			return "No course!";
	}

	public String getAllCourses() {
		List<Course> courses = courseDao.getAllCourses();
		if (!courses.isEmpty()) {
			String result = "";

			for (Course c : courses) {
				result += c.toString() + System.lineSeparator();
			}
			return result;
			
		} else
			return "No courses registered!";
	}

	public void insertCourse(String courseName) {
		courseDao.insert(courseName);
	}

	public void deleteCourse(int idCourse) {
		courseDao.deleteCourse(idCourse);
	}
}
