/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mk.rc.intf.LoanBeanRemote;

/**
 *
 * @author alemnew
 */
public class LoanAction extends ActionSupport{
    LoanBeanRemote loanBean = lookupLoanBeanRemote();
    private Long userId;
    private Long pubId;
    

    public String checkOut() {
        if(loanBean.checkOut(getPubId(), getUserId()).equals("LoanRecorded")){
            addActionMessage("Loan Successfully Recoded!");
            return SUCCESS;
        }
        return ERROR;
    }
    public String checkIn(){
        if(loanBean.checkIn(getPubId()))
        {
            return SUCCESS;
        }
        return ERROR;
    }
    private LoanBeanRemote lookupLoanBeanRemote() {
        try {
            Context c = new InitialContext();
            return (LoanBeanRemote) c.lookup("java:global/LMS-ejb/LoanBean!org.mk.rc.intf.LoanBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
    
    
    
}
