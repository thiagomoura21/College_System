package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import system.SystemCollege;
import view.admin.services.courses.AddNewCourseView;
import view.admin.services.courses.AssignStudentCourse;
import view.admin.services.courses.ChoiceACourse;
import view.admin.services.courses.ChoiceACourseToDelete;
import view.admin.services.students.AddNewStudent;
import view.admin.services.students.ChoiceAStudentToDelete;
import view.admin.services.students.ChoiceAStudentToUpdate;
import view.admin.services.students.SearchStudent;
import view.main.ViewLogin;

/**
 * Admin Dashboard containing all the functions defined for an admin. These
 * functions are activated from the button menu. instantiating and redirecting
 * the necessary jframe when necessary.
 * 
 *  @author thiagomoura21
 */
public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 6244993357481124230L;

	private JPanel contentPane;
	private SystemCollege system;

	public AdminDashboard(int x, int y) {

		// Acquiring the unique instance of the system
		system = SystemCollege.getInstanceSystem();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 450, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Administrator");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(141, 12, 171, 41);
		contentPane.add(lblTitle);

		// JButton for function of show all courses.
		JButton btnAllCourses = new JButton("View All Courses");
		btnAllCourses.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, system.getAllCourses(), "Courses", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAllCourses.setBounds(67, 158, 324, 25);
		contentPane.add(btnAllCourses);

		JButton btnNewCourse = new JButton("Add a New Course");
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				AddNewCourseView addCourseView = new AddNewCourseView(x, y);
				addCourseView.setVisible(true);
			}
		});
		btnNewCourse.setBounds(67, 85, 324, 25);
		contentPane.add(btnNewCourse);

		// JButton for function of show all students.
		JButton btnAllStudents = new JButton("View All Students");
		btnAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, system.getAllStudents(), "Students",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAllStudents.setBounds(67, 245, 324, 25);
		contentPane.add(btnAllStudents);

		// JButton for function of show all students in a course.
		// This button creating a Jframe for choice a course and execute the function.
		JButton btnViewAllStudentsCourse = new JButton("View all the Students in a Course");
		btnViewAllStudentsCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceACourse choiceCourseView = new ChoiceACourse(x, y);
				choiceCourseView.setVisible(true);
			}
		});
		btnViewAllStudentsCourse.setBounds(67, 282, 324, 25);
		contentPane.add(btnViewAllStudentsCourse);

		// JButton for function of delete a student.
		// This button creating a Jframe for choice a student and execute the deletion.
		JButton btnNewButton = new JButton("Delete a Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceAStudentToDelete choiceStudentView = new ChoiceAStudentToDelete(x, y);
				choiceStudentView.setVisible(true);
			}
		});
		btnNewButton.setBounds(67, 359, 324, 25);
		contentPane.add(btnNewButton);

		// JButton for function of create a student.
		// This button creating a Jframe for entered the student informations and
		// execute.
		JButton btnAddANewStudent = new JButton("Add a New Student");
		btnAddANewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				AddNewStudent addStudentView = new AddNewStudent(x, y);
				addStudentView.setVisible(true);
			}
		});
		btnAddANewStudent.setBounds(67, 322, 324, 25);
		contentPane.add(btnAddANewStudent);

		// JButton for function of update a student.
		// This button creating a Jframe for entered the student new informations and
		// execute the update.
		JButton btnUpdateStudent = new JButton("Update a Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceAStudentToUpdate choiceStudentUpdate = new ChoiceAStudentToUpdate(x, y);
				choiceStudentUpdate.setVisible(true);
			}
		});
		btnUpdateStudent.setBounds(67, 396, 324, 25);
		contentPane.add(btnUpdateStudent);

		// JButton for function of assign a student into a course chosen.
		// This button creating a Jframe for the choice of student and course.
		JButton assignStudentCourse = new JButton("Assign Student into Course");
		assignStudentCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				AssignStudentCourse assignStudent = new AssignStudentCourse(x, y);
				assignStudent.setVisible(true);
			}
		});
		assignStudentCourse.setBounds(67, 195, 324, 25);
		contentPane.add(assignStudentCourse);

		// JButton for function of delete a course.
		// This button creating a Jframe for choice a course and execute the deletion.
		JButton deleteCourse = new JButton("Delete a Course");
		deleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceACourseToDelete courseToDelete = new ChoiceACourseToDelete(x, y);
				courseToDelete.setVisible(true);
			}
		});
		deleteCourse.setBounds(67, 121, 324, 25);
		contentPane.add(deleteCourse);

		// JButton for function of search a student by name.
		// This button creating a Jframe for inform the name of the student.
		JButton btnSearchStudentByName = new JButton("Search Student By Name");
		btnSearchStudentByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				SearchStudent searchStudent = new SearchStudent(x, y);
				searchStudent.setVisible(true);
			}
		});
		btnSearchStudentByName.setBounds(67, 433, 324, 25);
		contentPane.add(btnSearchStudentByName);
		// JButton for function of logout.
		// This button clear the actual instance of the system and create a Jframe
		// initial of login.
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				system.clearInstanceSystem();
				ViewLogin loginAgain = new ViewLogin(getX(), getY());
				dispose();
				loginAgain.setVisible(true);
			}
		});
		btnLogout.setBounds(169, 476, 117, 25);
		btnLogout.setBackground(new Color(240, 128, 128));
		contentPane.add(btnLogout);

		JLabel label = new JLabel("___________________________________________________");
		label.setBounds(46, 218, 392, 15);
		contentPane.add(label);

	}
}
