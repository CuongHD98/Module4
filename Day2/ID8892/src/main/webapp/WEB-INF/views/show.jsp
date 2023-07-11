<%--
  Created by IntelliJ IDEA.
  User: HDC
  Date: 7/10/2023
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sandwich</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <h2>Sandwich </h2>
    <form method="post">
        <div class="custom-control custom-checkbox mb-3">
            <input type="checkbox" class="custom-control-input" id="Lettuce" name="condiment" value="Lettuce">
            <label class="custom-control-label" for="Lettuce">Lettuce</label>
        </div>
        <div class="custom-control custom-checkbox mb-3">
            <input type="checkbox" class="custom-control-input" id="Tomato" name="condiment" value="Tomato">
            <label class="custom-control-label" for="Tomato">Tomato</label>
        </div>
        <div class="custom-control custom-checkbox mb-3">
            <input type="checkbox" class="custom-control-input" id="Mustard" name="condiment" value="Mustard">
            <label class="custom-control-label" for="Mustard">Mustard</label>
        </div>
        <div class="custom-control custom-checkbox mb-3">
            <input type="checkbox" class="custom-control-input" id="Sprouts" name="condiment" value="Sprouts">
            <label class="custom-control-label" for="Sprouts">Sprouts</label>
        </div>

        <br>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
