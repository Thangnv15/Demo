<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 07/03/2023
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
</head>
<body class="container">
<%@include file="layout/header.jsp" %>
<form action="/sinh-vien/add" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">id</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="id" value="${sinhVien.id}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">name</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="name" value="${sinhVien.name}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">address</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="address" value="${sinhVien.address}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">status</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="status" value="${sinhVien.status}"><br>
        </div>
    </div>
    <button type="submit">Update</button>
</form>
<%@include file="layout/footer.jsp" %>
</body>
</html>
