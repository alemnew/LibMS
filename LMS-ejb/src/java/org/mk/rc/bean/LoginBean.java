/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import org.mk.rc.intf.LoginBeanRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.mk.rc.entity.Users;

/**
 *
 * @author alemnew
 */
@Stateless
public class LoginBean implements LoginBeanRemote {

    @PersistenceContext(unitName = "LMS-ejbPU")
    private EntityManager em;

    public String authenticateUser(Users user) {
        try {
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.email = :email");
            query.setParameter("email", user.getEmail());
            Object obj = query.getSingleResult();

            if (obj.equals(null)) {
                return "UserNotFound";
            }
            Users usr = (Users) obj;
            if (usr.getPassword().equals(user.getPassword())) {
                return "Autheniticated";
            } else {
                return "UserNotFound";
            }
        } catch (NoResultException e) {
            return null;
        }

    }

    public void persist(Object object) {
        em.persist(object);
    }
}
