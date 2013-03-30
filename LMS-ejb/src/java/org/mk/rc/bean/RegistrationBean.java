/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import java.util.List;
import org.mk.rc.intf.RegistrationBeanRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.mk.rc.entity.Publication;
import org.mk.rc.entity.Staffs;
import org.mk.rc.entity.Users;

/**
 *
 * @author alemnew
 */
@Stateless
public class RegistrationBean implements RegistrationBeanRemote {
    private static long serialVersionUID = 1L;
    
    @PersistenceContext 
    private EntityManager em;
    public String registerUser(String fname, String lname, String email, String pswd, String phone, String address){
        Users user = new Users();
        user.setfName(fname);
        user.setlName(lname);
        user.setEmail(email);
        user.setPassword(pswd);
        user.setPhoneNumber(phone);
        user.setAddress(address);
        
        em.persist(user);
        
        return "UserRegistered";
        
    }
    
     public String addPublication(String title, String type, String pubDate, String author, String callNumber, String status) {
        Publication publication = new Publication();
        publication.setTitle(title);
        publication.setType(type);
        publication.setPubDate(pubDate);
        publication.setAuthor(author);
        publication.setCallNumber(callNumber);
        publication.setStatus(status);
        
        em.persist(publication);
        return "publicatinAdded";
    }
     
    @Override
      public String registerStaff(String username, String password, String fullName, String email) {
        Staffs staff = new Staffs();
        staff.setFname(fullName);
        staff.setUsername(username);
        staff.setEmail(email);
        staff.setPassword(password);
        
        em.persist(staff);
        
        return "registered";
        //List <Staffs> list = em.createQuery("FROM Staffs res").getResultList();
        // \n Number of staffs : " +list.size();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
