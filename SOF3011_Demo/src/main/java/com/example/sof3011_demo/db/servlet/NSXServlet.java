package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.NSX;
import com.example.sof3011_demo.db.repository.RePoNSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {"/NSX/hien-thi",
        "/NSX/add", "/NSX/update", "/NSX/delete", "/NSX/detail"
})
public class NSXServlet extends HttpServlet {
    RePoNSX repo = new RePoNSX();
    ArrayList<NSX> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/NSX/hien-thi")) {
            list = repo.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/NSX.jsp").forward(request, response);
        } else if (uri.contains("/NSX/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = repo.getByid(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/detail/nsxDetail.jsp").forward(request, response);
        } else if (uri.contains("/NSX/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = repo.getByid(id);
            repo.xoa(nsx);
            response.sendRedirect("/NSX/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NSX nsx = new NSX();
        nsx.setMa(ma);
        nsx.setTen(ten);
        repo.add(nsx);
        response.sendRedirect("/NSX/hien-thi");
//        if (uri.contains("/add")) {
//
//        }else if (uri.contains("/update")){
//            String ma = request.getParameter("ma");
//            String ten = request.getParameter("ten");
//            NSX nsx = new NSX();
//            nsx.setMa(ma);
//            nsx.setTen(ten);
//            repo.update(nsx);
//            response.sendRedirect("/NSX/hien-thi");
//        }

    }
}
