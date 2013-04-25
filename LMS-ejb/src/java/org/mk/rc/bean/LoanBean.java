/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.mk.rc.intf.LoanBeanRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.mk.rc.entity.Loan;
import org.mk.rc.entity.Publication;


/**
 *
 * @author alemnew
 */
@Stateless    
public class LoanBean implements LoanBeanRemote {
    @PersistenceContext(unitName = "LMS-ejbPU")
    private EntityManager em;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String checkOut(Long pubId, Long userId) {
        Date today =  new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, 25); //need to automatic from DB
        Date retDate = c.getTime();
        
        Loan loan = new Loan();
        loan.setPubId(pubId);
        loan.setUserId(userId);
        loan.setLoanDate(sdf.format(today));
        loan.setReturnDate(sdf.format(retDate));
        persist(loan);
        return "LoanRecorded";
    }

    @Override
    public boolean checkIn(Long pubId) {
        Query query = em.createQuery("SELECT l FROM Loan l WHERE l.pubId=:pubId");
        query.setParameter("pubId", pubId);
        List<Loan> loan = query.getResultList();
        if(loan.size()>0){
            for(Loan l: loan){
                em.remove(l);
            }
            updatePub(pubId);
            return true;
        }
        return false;
    }
    public String extendLoan(Long pubId, Long userId)
    {
         Date today =  new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, 25); //need to automatic from DB
        Date retDate = c.getTime();
        
        Query query = em.createQuery("SELECT l FROM Loan l WHERE l.pubId=:pubId AND l.userId=:userId");
        query.setParameter("pubId", pubId);
        query.setParameter("userId", userId);
        List<Loan> loan = query.getResultList();
        if(loan.size()>0){
            for(Loan l: loan){
                l.setReturnDate(sdf.format(retDate));
                em.merge(l);
            }
            return null;
        }
        return null;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    void updatePub(Long pubId){
        Query query = em.createQuery("SELECT p FROM Publication p WHERE p.pubId=:pubId");
        query.setParameter("pubId", pubId);
        List<Publication> publication = query.getResultList();
        for(Publication p: publication){
            p.setStatus("Available");
            em.merge(p);
        }
    }

}
