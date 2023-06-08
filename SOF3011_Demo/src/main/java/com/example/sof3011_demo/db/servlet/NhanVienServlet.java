package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.NhanVien;
import com.example.sof3011_demo.db.repository.RePoNhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {"/NhanVienServlet",
        "/NhanVienServlet/add",
        "/NhanVienServlet/detail",
        "/NhanVienServlet/update",
        "/NhanVienServlet/delete"})
public class NhanVienServlet extends HttpServlet {
    RePoNhanVien repo = new RePoNhanVien();
    ArrayList<NhanVien> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/NhanVienServlet")) {
            list = repo.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("NhanVien.jsp").forward(request, response);
        } else if (uri.contains("/NhanVienServlet/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = repo.getByid(id);
            request.setAttribute("nhanVien",nhanVien);
            request.getRequestDispatcher("/view/detail/nhanVienDetail.jsp").forward(request,response);
        }else if (uri.contains("/NhanVienServlet/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien =repo.getByid(id);
            repo.xoa(nhanVien);
            response.sendRedirect("/NhanVienServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String mauKhau = request.getParameter("matKhau");
            int trangThai = Integer.parseInt(request.getParameter("trangThai"));
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException p) {
                throw new RuntimeException(p);
            }
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(mauKhau);
            nhanVien.setTrangThai(trangThai);
            nhanVien.setNgaySinh(ngaySinh);
            repo.add(nhanVien);
            response.sendRedirect("/NhanVienServlet");
        } else if (uri.contains("/update")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String mauKhau = request.getParameter("matKhau");
            int trangThai = Integer.parseInt(request.getParameter("trangThai"));
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException p) {
                throw new RuntimeException(p);
            }
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(mauKhau);
            nhanVien.setTrangThai(trangThai);
            nhanVien.setNgaySinh(ngaySinh);
            repo.update(nhanVien);
            response.sendRedirect("/NhanVienServlet");
        }

    }
}
