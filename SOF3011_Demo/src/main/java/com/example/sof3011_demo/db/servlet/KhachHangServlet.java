package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.KhachHang;
import com.example.sof3011_demo.db.repository.RePoKhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {"/KhachHangServlet","/KhachHangServlet/add","/KhachHangServlet/update","/KhachHangServlet/delete","/KhachHangServlet/detail"})
public class KhachHangServlet extends HttpServlet {
    RePoKhachHang repo = new RePoKhachHang();
    ArrayList<KhachHang> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/KhachHangServlet")) {
            list = repo.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("KhachHang.jsp").forward(request, response);
        }else if (uri.contains("/KhachHangServlet/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = repo.getByid(id);
            request.setAttribute("khachHang",khachHang);
            request.getRequestDispatcher("/view/detail/khachHangDetail.jsp").forward(request,response);
        }else if (uri.contains("/KhachHangServlet/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang =repo.getByid(id);
            repo.xoa(khachHang);
            response.sendRedirect("/KhachHangServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String ho = request.getParameter("ho");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHang.setNgaySinh(ngaySinh);
            repo.add(khachHang);
            response.sendRedirect("/KhachHangServlet");
        }else if (uri.contains("/update")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String ho = request.getParameter("ho");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHang.setNgaySinh(ngaySinh);
            repo.update(khachHang);
            response.sendRedirect("/KhachHangServlet");
        }
    }
}
