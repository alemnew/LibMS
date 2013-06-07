/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.mk.rc.entity.Staffs;
import org.mk.rc.entity.Users;
import org.mk.rc.intf.LoginBeanRemote;

/**
 *
 * @author alemnew
 */
@Stateless
public class LoginBean implements LoginBeanRemote {

    @PersistenceContext(unitName = "LMS-ejbPU")
    private EntityManager em;

    public Users authenticateUser(String email, String password) {
        try {
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Users> user = query.getResultList();

            if(user.size()> 0){
                return user.get(0);
            }
           else
                return null;
        } catch (NoResultException e) {
            return null;
        }

    }
    
    @Override
    public Staffs authenticateStaff(String email, String password) {
       try {
            Query query = em.createQuery("SELECT s FROM Staffs s WHERE s.email = :email AND s.password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Staffs> staff = query.getResultList();

            if(staff.size()> 0){
                return staff.get(0);
            }
           else
                return null;
        } catch (NoResultException e) {
            return null;
        }
    }
    public void persist(Object object) {
        em.persist(object);
    }

}
