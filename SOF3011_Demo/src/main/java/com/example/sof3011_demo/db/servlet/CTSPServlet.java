package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChiTietSP;
import com.example.sof3011_demo.db.repository.RePoCTSP;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CTSPServlet", value = "/CTSP/hien-thi")
public class CTSPServlet extends HttpServlet {
    RePoCTSP re = new RePoCTSP();
    ArrayList<ChiTietSP> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = re.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/ChiTietSP.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
