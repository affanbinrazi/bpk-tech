package com.ex.servlet;

import com.ex.dao.StudentDAO;
import file.Student;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String parentName = request.getParameter("parentName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String phoneNumber = request.getParameter("phoneNumber");

        // Create a new Student object
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dob);
        student.setParentName(parentName);
        student.setAddress(address);
        student.setCity(city);
        student.setPhoneNumber(phoneNumber);

        // Add the student to the database
        studentDAO.addStudent(student);

        // Redirect to student_list.jsp
        response.sendRedirect("studentList.jsp");
    }
}

