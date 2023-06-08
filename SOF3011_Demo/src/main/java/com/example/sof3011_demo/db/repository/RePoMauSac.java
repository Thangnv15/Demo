package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.MauSac;
import com.example.sof3011_demo.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class RePoMauSac {
    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> list = new ArrayList<>();
        try (Session ss = HibernateUtil.getFACTORY().openSession()) {
            Query query = ss.createQuery("From MauSac order by Ten desc");
            list = (ArrayList<MauSac>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean add(MauSac mauSac) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
