package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.ChiTietSP;
import com.example.sof3011_demo.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class RePoCTSP {
    public ArrayList<ChiTietSP> getAll() {
        ArrayList<ChiTietSP> list = new ArrayList<>();
        try (Session ss = HibernateUtil.getFACTORY().openSession()) {
            Query query = ss.createQuery("From ChiTietSP order by Ten desc ");
            list = (ArrayList<ChiTietSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChiTietSP getById(UUID id) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            chiTietSP = session.get(ChiTietSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public Boolean add(ChiTietSP chiTietSP) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
