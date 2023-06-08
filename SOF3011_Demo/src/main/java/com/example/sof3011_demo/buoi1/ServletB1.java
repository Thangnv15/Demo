package com.example.sof3011_demo.buoi1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletB1", value = "/test")
public class ServletB1 extends HttpServlet {

    ArrayList<Nguoi> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = " Nguyen Van A 12345";
        Nguoi nguoi1 = new Nguoi(1, "Nguyen Van A", "Ha Noi", 1);
        Nguoi nguoi2 = new Nguoi(2, "Nguyen X C", "Ha Noi", 0);
        Nguoi nguoi3 = new Nguoi(3, "Nguyen Van D", "Thai Binh", 1);
        list.add(nguoi1);
        list.add(nguoi2);
        list.add(nguoi3);
        request.setAttribute("list", list);
        request.setAttribute("tenview", ten);
        request.getRequestDispatcher("/view/b1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
