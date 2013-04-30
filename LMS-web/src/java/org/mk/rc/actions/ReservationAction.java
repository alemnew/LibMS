/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mk.rc.entity.Publication;
import org.mk.rc.entity.Reservation;
import org.mk.rc.intf.ReservationBeanRemote;

/**
 *
 * @author alemnew
 */
public class ReservationAction extends ActionSupport {

    ReservationBeanRemote reservationBean = lookupReservationBeanRemote();
    private Long pubId;
    private Long userId;
    private Long id;
    private List<Reservation> reservation;
    private List<ReservationDummy> reservationDummy;
    private ReservationDummy res;

    public String reservePublication() throws Exception {
        if (reservationBean.reserve(getPubId(), getUserId()).equals("ReservationMade")) {
            addActionMessage("The reserved successfully. We will contact you up on return.");
            return SUCCESS;
        } else if (reservationBean.reserve(getPubId(), getUserId()).equals("RecoredFound")) {
            addActionMessage("The Publication is already reserved. We will contact you up on return.");
            return SUCCESS;
        }

        return ERROR;
    }

    public String listPublication() throws Exception {
        ReservationDummy dummy = null;
        List<ReservationDummy> reser = new ArrayList<ReservationDummy>();
        List res = reservationBean.searchByUser(getUserId());
        if (res.size() == 0) {
            return ERROR;
        }
        setReservation(res);
        int s = 0;
        s = reservation.size();
       // System.out.println(s);
        if (s != 0) {
            List<Publication> p = null;
            for (Reservation r : reservation) {
                dummy = new ReservationDummy();
               // System.out.println(r.getPubId());
                p = reservationBean.getPublication(r.getPubId());
                if (p.size() > 0) {
                    //System.out.println(p.get(0).getAuthor());
                    dummy.setPubId(p.get(0).getPubId());
                    dummy.setPubDate(p.get(0).getPubDate());
                    dummy.setAuthor(p.get(0).getAuthor());
                    dummy.setTitle(p.get(0).getTitle());
                    dummy.setType(p.get(0).getType());
                    dummy.setExpRetDate(r.getExpectedDate());
                    dummy.setId(r.getId());
                    reser.add(dummy);
                }

            }
            setReservationDummy(reser);
            return SUCCESS;
        }
        return ERROR;
    }

    public String removeReservation() throws Exception {
      //  System.out.println("I am gona be removed" + getId());
        if (reservationBean.cancelReservation(getId())) {
            return SUCCESS;
        }
        return ERROR;
    }

    private ReservationBeanRemote lookupReservationBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ReservationBeanRemote) c.lookup("java:global/LMS-ejb/ReservationBean!org.mk.rc.intf.ReservationBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    /**
     * @return the pubId
     */
    public Long getPubId() {
        return pubId;
    }

    /**
     * @param pubId the pubId to set
     */
    public void setPubId(Long pubId) {
        this.pubId = pubId;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the reservation
     */
    public List<Reservation> getReservation() {
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    /**
     * @return the reservationDummy
     */
    public List<ReservationDummy> getReservationDummy() {
        return reservationDummy;
    }

    /**
     * @param reservationDummy the reservationDummy to set
     */
    public void setReservationDummy(List<ReservationDummy> reservationDummy) {
        this.reservationDummy = reservationDummy;
    }

    /**
     * @return the res
     */
    public ReservationDummy getRes() {
        return res;
    }

    /**
     * @param res the res to set
     */
    public void setRes(ReservationDummy res) {
        this.res = res;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
