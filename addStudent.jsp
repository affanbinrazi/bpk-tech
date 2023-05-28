<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h1>Add New Student</h1>
    <form action="AddStudentServlet" method="POST">
        <label>First Name:</label>
        <input type="text" name="firstName"><br><br>
        
        <label>Last Name:</label>
        <input type="text" name="lastName"><br><br>
        
        <label>Date of Birth:</label>
        <input type="date" name="dob"><br><br>
        
        <label>Parent's Name:</label>
        <input type="text" name="parentName"><br><br>
        
        <label>Address:</label>
        <input type="text" name="address"><br><br>
        
        <label>City:</label>
        <input type="text" name="city"><br><br>
        
        <label>Phone Number:</label>
        <input type="text" name="phoneNumber"><br><br>
        
        <input type="submit" value="Add Student">
    </form>
</body>
</html>


</body>
</html>