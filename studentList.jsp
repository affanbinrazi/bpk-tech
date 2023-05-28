<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <table border="">
        <tr>
            <th>Student ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Parent's Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Phone Number</th>
        </tr>
        <%-- Retrieve student data from the database and populate the table --%>
        <%@ page import="com.ex.dao.StudentDAO" %>
        <%@ page import="file.Student" %>
        <%@ page import="java.util.*" %>
        <% 
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = studentDAO.getAllStudents();
            
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getStudentId() %></td>
            <td><%= student.getFirstName() %></td>
            <td><%= student.getLastName() %></td>
            <td><%= student.getDateOfBirth() %></td>
            <td><%= student.getParentName() %></td>
            <td><%= student.getAddress() %></td>
            <td><%= student.getCity() %></td>
            <td><%= student.getPhoneNumber() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
    