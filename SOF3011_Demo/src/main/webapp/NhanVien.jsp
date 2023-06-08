<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/26/2023
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</head>
<body>
<form action="/NhanVienServlet/add" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên Đệm</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="tenDem"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Họ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ho"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Gioi Tinh</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="gioiTinh"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ngày Sinh</label>
        <div class="col-sm-10">
            <input class="form-control" type="date" name="ngaySinh"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa Chỉ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="diaChi"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">SĐT</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="sdt"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mật Khẩu</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="matKhau"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">trang thai</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="trangThai"><br>
        </div>
    </div>
    <button type="submit">Them</button>
</form>
<table class="table table-hover">
    <thead>
    <th>ID</th>
    <th>Ma</th>
    <th>Ho va Ten</th>
    <th>GioiTinh</th>
    <th>NgaySinh</th>
    <th>DiaChi</th>
    <th>Sdt</th>
    <th>MatKhau</th>
    <th>TrangThai</th>
    <th colspan="2">Action</th>
    </thead>
    <tbody>
    <c:forEach var="l" items="${list}">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ho} ${l.tenDem} ${l.ten}</td>
            <td>${l.gioiTinh}</td>
            <td>${l.ngaySinh}</td>
            <td>${l.diaChi}</td>
            <td>${l.sdt}</td>
            <td>${l.matKhau}</td>
            <td>
                <c:if test="${l.trangThai == 1}">Passed</c:if>
                <c:if test="${l.trangThai == 0}">Failed</c:if>
            </td>
            <td><a href="/NhanVienServlet/detail?id=${l.id}">Detail</a></td>
            <td><a href="/NhanVienServlet/delete?id=${l.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
