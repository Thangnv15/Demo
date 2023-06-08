package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.SanPham;
import com.example.sof3011_demo.db.repository.RePoSanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {"/SanPham/hien-thi","/SanPham/add","/SanPham/update","/SanPham/delete","/SanPham/detail"})
public class SanPhamServlet extends HttpServlet {
    RePoSanPham repo = new RePoSanPham();
    ArrayList<SanPham> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            list = repo.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/SanPham.jsp").forward(request, response);
        }else if (uri.contains("/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = repo.getByid(id);
            request.setAttribute("sanPham",sanPham);
            request.getRequestDispatcher("/view/detail/sanPhamDetail.jsp").forward(request,response);
        }else if (uri.contains("/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham =repo.getByid(id);
            repo.xoa(sanPham);
            response.sendRedirect("/SanPham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham();
            sanPham.setMa(ma);
            sanPham.setTen(ten);
            repo.add(sanPham);
            response.sendRedirect("/SanPham/hien-thi");
        }else if(uri.contains("/update")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham();
            sanPham.setMa(ma);
            sanPham.setTen(ten);
            repo.update(sanPham);
            response.sendRedirect("/SanPham/hien-thi");
        }
    }
}
