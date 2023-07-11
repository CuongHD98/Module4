<%--
  Created by IntelliJ IDEA.
  User: HDC
  Date: 7/7/2023
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dictionary</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Dictionary</h2>
    <form method="post">
        <div class="form-group">
            <label for="english">English:</label>
            <input type="text" class="form-control" id="english" placeholder="Enter English" name="english">
        </div>
        <button type="submit" class="btn btn-default">Change</button>
    </form>
    <span>VietNam : ${vietnam} </span>
</div>

</body>
</html>
