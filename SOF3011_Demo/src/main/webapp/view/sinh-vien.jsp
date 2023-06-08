<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 07/03/2023
  Time: 00:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
<body class="container">
<%@include file="layout/header.jsp" %>
<h3>Danh sách sinh vien</h3>
<table class="table">
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>address</td>
        <td>status</td>
        <td>action</td>
    </tr>
    </thead>
    <c:forEach items="${listSinhVien}" var="sinhVien">
        <tr>
            <td>${sinhVien.id}</td>
            <td>${sinhVien.name}</td>
            <td>${sinhVien.address}</td>
            <td><c:if test="${sinhVien.status == 1}">Passed</c:if>
                <c:if test="${sinhVien.status == 0}">Failed</c:if></td>
            <td>
                <button class="btn"><a href="/sinh-vien/detail?id=${sinhVien.id}">Sua</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href ='/view/create.jsp'">Them Sinh Vien</button>
<p>xin chào bạn sinh viên</p>
<%@include file="layout/footer.jsp" %>
</body>
</html>

