<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/7/2023
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</head>
<body>
<form action="/SanPham/update" method="post" class="container">
    <div class="mb-3">
        <label  class="form-label">Ma</label>
        <input type="text" class="form-control" name="ma" value="${sanPham.ma}">
    </div>
    <div class="mb-3">
        <label  class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" value="${sanPham.ten}">
    </div>

    <button type="submit" class="btn btn-primary">update</button>
</form>
</body>
</html>
