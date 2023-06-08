package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.repository.RePoChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {"/ChucVuServlet","/chuc-vu/add","/chuc-vu/detail","/chuc-vu/update","/chuc-vu/delete"})
public class ChucVuServlet extends HttpServlet {
    RePoChucVu repo = new RePoChucVu();
    ArrayList<ChucVu> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/ChucVuServlet")) {
            list = repo.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("ChucVu.jsp").forward(request, response);
        }else if (uri.contains("/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = repo.getByid(id);
            request.setAttribute("chucVu",chucVu);
            request.getRequestDispatcher("/view/detail/chucVuDetail.jsp").forward(request,response);
        }else if (uri.contains("/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu =repo.getByid(id);
            repo.xoa(chucVu);
            response.sendRedirect("/ChucVuServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            repo.add(chucVu);
            response.sendRedirect("/ChucVuServlet");
        }else if (uri.contains("update")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            repo.update(chucVu);
            response.sendRedirect("/ChucVuServlet");
        }

    }
}
