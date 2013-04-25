/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.mk.rc.entity.Users;
import org.mk.rc.intf.UsersBeanRemote;

/**
 *
 * @author alemnew
 */
@Stateless
public class UsersBean implements UsersBeanRemote {

    private static long serialVersionUID = 1L;
    @PersistenceContext(unitName = "LMS-ejbPU")
    private EntityManager em;

    public String registerUser(Users user) {
        Query query = em.createQuery("SELECT u.email FROM Users u WHERE u.email = :email");
        query.setParameter("email", user.getEmail());
        List list = query.getResultList();
        if (list.size() > 0) {
            return "EmailAlreadyRegistered";
        }
        persist(user);

        return "UserRegistered";

    }
    List<Users> user;

    public List findAll() throws Exception {
        Query query = em.createQuery("select u from Users u");
        return query.getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List displayProfile(Long userId) {
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.userId = :userId");
        query.setParameter("userId", userId);
        List list = query.getResultList();
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public boolean editProfile(Users user) {
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.userId = :userId");
        query.setParameter("userId", user.getUserId());
        List list = query.getResultList();
        if (list.size() > 0) {
            em.merge(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean changePassword(Long userId, String currentPswd, String newPswd) {
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.userId = :userId AND u.password=:currentPswd");
        query.setParameter("userId", userId);
        query.setParameter("currentPswd", currentPswd);
        List<Users> list = query.getResultList();
        if (list.size() > 0) {
            for (Users usr : list) {
                usr.setPassword(newPswd);
                em.merge(usr);
            }
            return true;
        }
        return false;
    }
}
