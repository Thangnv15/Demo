package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.DongSP;
import com.example.sof3011_demo.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class RePoDongSP {
    public ArrayList<DongSP> getAll() {
        ArrayList<DongSP> list = new ArrayList<>();
        try (Session ss = HibernateUtil.getFACTORY().openSession()) {
            Query query = ss.createQuery("From DongSP order by Ten desc");
            list = (ArrayList<DongSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public DongSP getByid(UUID id) {
        DongSP dongSP = new DongSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            dongSP = session.get(DongSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }

    public Boolean add(DongSP dongSP) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(DongSP dongSP) {
        Transaction transaction = null ;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void xoa(DongSP dongSP) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
