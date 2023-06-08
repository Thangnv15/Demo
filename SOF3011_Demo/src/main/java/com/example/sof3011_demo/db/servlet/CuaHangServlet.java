package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.CuaHang;
import com.example.sof3011_demo.db.repository.RePoCuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(value = {"/CuaHang/hien-thi","/CuaHang/add","/CuaHang/update","/CuaHang/delete","/CuaHang/detail"})
public class CuaHangServlet extends HttpServlet {
    RePoCuaHang repo = new RePoCuaHang();
    ArrayList<CuaHang> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/hien-thi")) {
            list = repo.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/CuaHang.jsp").forward(request, response);
        }else if (uri.contains("/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = repo.getByid(id);
            request.setAttribute("cuaHang",cuaHang);
            request.getRequestDispatcher("/view/detail/cuaHangDetail.jsp").forward(request,response);
        }else if (uri.contains("/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang =repo.getByid(id);
            repo.xoa(cuaHang);
            response.sendRedirect("/CuaHang/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setDiaChi(diaChi);

            cuaHang.setThanhPho(thanhPho);
            cuaHang.setQuocGia(quocGia);
            repo.add(cuaHang);
            response.sendRedirect("/CuaHang/hien-thi");
        }else if (uri.contains("/update")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setDiaChi(diaChi);

            cuaHang.setThanhPho(thanhPho);
            cuaHang.setQuocGia(quocGia);
            repo.update(cuaHang);
            response.sendRedirect("/CuaHang/hien-thi");
        }
    }
}
