/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mk.rc.entity.Publication;
import org.mk.rc.intf.ReservationBeanRemote;

/**
 *
 * @author alemnew
 */
public class ReservationAction extends ActionSupport {

    ReservationBeanRemote reservationBean = lookupReservationBeanRemote();
    private Long pubId;
    private Long userId;
    private List<Publication> publication ;

    public String reservePublication() {
        if (reservationBean.reserve(getPubId(), getUserId()).equals("ReservationMade")) {
            addActionMessage("The reserved successfully. We will contact you up one return.");
            return SUCCESS;
        }
        return ERROR;
    }
    public String listPublication(){
        setPublication(reservationBean.searchByUser(getUserId()));
        return SUCCESS;
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
     * @return the publication
     */
    public List<Publication> getPublication() {
        return publication;
    }

    /**
     * @param publication the publication to set
     */
    public void setPublication(List<Publication> publication) {
        this.publication = publication;
    }

    

}    
