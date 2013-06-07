/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.mk.rc.entity.Reservation;
import org.mk.rc.intf.ReservationBeanRemote;


/**
 *
 * @author alemnew
 */
@Stateless
public class ReservationBean implements ReservationBeanRemote {

    @PersistenceContext(unitName = "LMS-ejbPU")
    private EntityManager em;

    @Override
      
    public String reserve(Long pubId, Long userId) {
         Query query = em.createQuery("SELECT r FROM Reservation r where r.pubId=:pubId AND r.userId=:userId");
        query.setParameter("pubId", pubId);
        query.setParameter("userId", userId);
        List<Reservation> res = query.getResultList();
        if (res.size() > 0) {
            for (Reservation r : res) {
                em.remove(r);
            }
            return "RecoredFound";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MONTH, 1);
        Date retDate = cal.getTime();

        Reservation reservation = new Reservation();
        reservation.setPubId(pubId);
        reservation.setUserId(userId);
        reservation.setResDate(sdf.format(now));
        reservation.setExpectedDate(sdf.format(retDate));
        persist(reservation);
        return "ReservationMade";
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public boolean cancelReservation(Long id) {
        Query query = em.createQuery("SELECT r FROM Reservation r where r.id=:id");
        query.setParameter("id", id);
        List<Reservation> res = query.getResultList();
        if (res.size() > 0) {
            for (Reservation r : res) {
                em.remove(r);
            }
            return true;
        }
        return false;
    }

    @Override
    public List searchByUser(Long userId) {
        Query query = em.createQuery("SELECT r FROM Reservation r where r.userId=:userId");
        query.setParameter("userId", userId);
        List<Reservation> res = query.getResultList();
        if (res.size() > 0) {
            return res;
        }
        return null;
    }

    @Override
    public List getPublication(Long pubId) {
        Query query = em.createQuery("SELECT p FROM Publication p where p.pubId=:pubId");
        query.setParameter("pubId", pubId);
        return query.getResultList();
    }

    @Override
    public List searchByPublication(Long pubId) {
        Query query = em.createQuery("SELECT r FROM Reservation r where r.pubId=:pubId");
        query.setParameter("pubId", pubId);
        List<Reservation> res = query.getResultList();
        if (res.size() > 0) {
            return res;
        }
        return null;
    }
}
