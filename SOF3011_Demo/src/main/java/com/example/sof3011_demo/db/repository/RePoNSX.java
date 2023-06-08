package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.NSX;
import com.example.sof3011_demo.db.entity.SanPham;
import com.example.sof3011_demo.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class RePoNSX {
    public ArrayList<NSX> getAll() {
        ArrayList<NSX> list = new ArrayList<>();
        try (Session ss = HibernateUtil.getFACTORY().openSession()) {
            Query query = ss.createQuery("From NSX order by Ten desc");
            list = (ArrayList<NSX>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NSX getByid(UUID id) {
        NSX nsx = new NSX();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nsx = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public Boolean add(NSX nsx) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void xoa(NSX nsx) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
