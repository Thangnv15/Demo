package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.NhanVien;
import com.example.sof3011_demo.db.entity.SanPham;
import com.example.sof3011_demo.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RePoNhanVien {
    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> list = new ArrayList<>();
        try(Session ss = HibernateUtil.getFACTORY().openSession()) {
            Query query = ss.createQuery("From NhanVien order by Ten desc ");
            list = (ArrayList<NhanVien>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public NhanVien getByid(UUID id){
        NhanVien nhanVien = new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            nhanVien = session.get(NhanVien.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nhanVien;
    }
    public Boolean add(NhanVien nhanVien){
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void xoa(NhanVien nhanVien) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        Session ss = HibernateUtil.getFACTORY().openSession();
//        Query query = ss.createQuery("From NhanVien");
//        List<NhanVien> list = query.getResultList();
//        for (NhanVien nv : list){
//            System.out.println(nv.getId()+"  "+nv.getNgaySinh());
//        }
//    }
}
