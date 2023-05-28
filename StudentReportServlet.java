package com.ex.servlet;

import com.ex.dao.StudentDAO;
import file.Student;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentReportServlet extends HttpServlet {
	private StudentDAO studentDAO;

	public void init() throws ServletException {
		studentDAO = new StudentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve students with scores above 60%
		List<Student> students = studentDAO.getStudentsAbove60Percent();

		// Set the student list as an attribute in the request
		request.setAttribute("students", students);

		// Forward the request to student_report.jsp
		request.getRequestDispatcher("student_report.jsp").forward(request, response);
	}
}
