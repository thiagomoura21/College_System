package system;

import controllers.CourseController;
import controllers.LoginController;
import controllers.StudentController;

public class SystemCollege {

	private static SystemCollege instance;

	private CourseController courseController;
	private LoginController loginController;
	private StudentController studentController;

	private SystemCollege() {
		this.loginController = new LoginController();
	}

	public boolean loginAdmin(String name, String password) {logonSuccessful(); return true; 
		/*
		boolean loginResult = loginController.loginAdmin(name, password);
		if (loginResult) {
			logonSuccessful();
			return true;
		} else
			return false;*/
	}

	public boolean loginStudent(String name, String password) {
		return false;

	}

	private void logonSuccessful() {
		this.studentController = new StudentController();
		this.courseController = new CourseController();
		System.out.println("Oi deu certo");
	}

	public static SystemCollege getInstanceSystem() {
		if (instance == null)
			instance = new SystemCollege();

		return instance;
	}

	// Admin functions

	public String getAllCourses() {
		return courseController.getAllCourses();
	}

	public String getAllStudents() {
		return studentController.getAllStudents();
	}

	public String getStudentsInCourse(int idCourse) {
		return studentController.getStudentsInCourse(idCourse);
	}

	public void setStudentInCourse(int idStudent, int idCourse) {

		studentController.setStudentInCourse(idStudent, idCourse);
	}

	public void addNewCourse(String courseName) {
		
		courseController.insertCourse(courseName);
	}

	public String addNewStudent(String name, String address, String nationality) {

		studentController.insertStudent(name, address, nationality);
		int idStudent = studentController.getStudentIdByName(name);
		String loginResult = loginController.generateLogin(idStudent);
		return loginResult;
	}

	public void deleteStudentById(int idStudent) {
		studentController.deleteStudent(idStudent);
		loginController.deleteLogin(idStudent);
	}
	
	public void deleteCourse(int idCourse) {
		courseController.deleteCourse(idCourse);
		studentController.deleteCourseInStudents(idCourse);
	}

	public void updateStudent(int id, String name, String address, String nationality) {
		studentController.updateStudent(id, name, address, nationality);
	}

	// Student functions
	/*

	public String getCourseEnrolled(int idStudent) {

		int idCourse = studentController.getIdCourse(idStudent);
		return courseController.getCourseInformations(idCourse);
	}
*/
	public String getPerfilStudentById(int idStudent) {
		return studentController.getStudentInformationsById(idStudent);
	}
	
	public String getPerfilStudent() {
		int idStudent = loginController.getStudentId();
		return studentController.getStudentInformationsById(idStudent);
	}

}