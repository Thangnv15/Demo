package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.MauSac;
import com.example.sof3011_demo.db.repository.RePoMauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = {"/MauSac/hien-thi","/mau-sac/add"})
public class MauSacServlet extends HttpServlet {
    RePoMauSac repo = new RePoMauSac();
    ArrayList<MauSac> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = repo.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/MauSac.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten ");
        MauSac mauSac = new MauSac();
        mauSac.setMa(ma);
        mauSac.setTen(ten);
        repo.add(mauSac);
        response.sendRedirect("/MauSac/hien-thi");
    }
}
