<%--
  Created by IntelliJ IDEA.
  User: HDC
  Date: 7/10/2023
  Time: 5:05 PM
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
<div class="container">
    <h2>Caculator</h2>
    <form action="" method="post">
        <input type="text" name="num1" placeholder="number1">
        <input type="text" name="num2" placeholder="number2">
        <br>
        <button type="submit" name="pheptinh" value="+">Cong</button>
        <button type="submit" name="pheptinh" value="-">Tru</button>
        <button type="submit" name="pheptinh" value="*">Nhan</button>
        <button type="submit" name="pheptinh" value="/">Chia</button>
    </form>
    <h3>Result : ${result}</h3>

</div>

</body>
</html>
