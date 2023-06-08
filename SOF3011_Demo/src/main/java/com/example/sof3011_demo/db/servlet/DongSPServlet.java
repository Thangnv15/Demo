package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.DongSP;
import com.example.sof3011_demo.db.repository.RePoDongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {"/DongSP/hien-thi","/DongSP/add","/DongSP/update","/DongSP/detail","/DongSP/delete"})
public class DongSPServlet extends HttpServlet {
    RePoDongSP repo = new RePoDongSP();
    ArrayList<DongSP> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            list = repo.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/DongSP.jsp").forward(request, response);
        }else if (uri.contains("/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = repo.getByid(id);
            request.setAttribute("dongSP",dongSP);
            request.getRequestDispatcher("/view/detail/dongSPDetail.jsp").forward(request,response);
        }else if (uri.contains("/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP =repo.getByid(id);
            repo.xoa(dongSP);
            response.sendRedirect("/DongSP/hien-thi");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP();
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            repo.add(dongSP);
            response.sendRedirect("/DongSP/hien-thi");
        }else if (uri.contains("/update")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP();
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            repo.update(dongSP);
            response.sendRedirect("/DongSP/hien-thi");
        }
    }
}
