<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/26/2023
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

</head>
<body>
<form action="/CuaHang/add" method="post" class="container">
    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia Chi</label>
        <input type="text" class="form-control" name="diaChi">
    </div>
    <div class="mb-3">
        <label class="form-label">Thanh Pho</label>
        <input type="text" class="form-control" name="thanhPho">
    </div>
    <div class="mb-3">
        <label class="form-label">Quoc Gia</label>
        <input type="text" class="form-control" name="quocGia">
    </div>
    <button type="submit" class="btn btn-primary">Them</button>
</form>
<table class="table table-hover">
    <thead>
    <th>ID</th>
    <th>Ma</th>
    <th>Ten</th>
    <th>DiaChi</th>
    <th>ThanhPho</th>
    <th>QuocGia</th>
    <th colspan="2">Action</th>
    </thead>
    <tbody>
    <c:forEach var="l" items="${list}">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ten}</td>
            <td>${l.diaChi}</td>
            <td>${l.thanhPho}</td>
            <td>${l.quocGia}</td>
            <td><a href="/CuaHang/detail?id=${l.id}">Detail</a></td>
            <td><a href="/CuaHang/delete?id=${l.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
