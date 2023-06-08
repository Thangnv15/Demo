package com.example.sof3011_demo.db.repository;


import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.CuaHang;
import com.example.sof3011_demo.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class RePoCuaHang {
    public ArrayList<CuaHang> getAll() {
        ArrayList<CuaHang> list = new ArrayList<>();
        try (Session ss = HibernateUtil.getFACTORY().openSession()) {
            Query query = ss.createQuery("From CuaHang order by Ten desc ");
            list = (ArrayList<CuaHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public CuaHang getByid(UUID id){
        CuaHang cuaHang = new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            cuaHang = session.get(CuaHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cuaHang;
    }
    public Boolean add(CuaHang cuaHang) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void xoa(CuaHang cuaHang) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
