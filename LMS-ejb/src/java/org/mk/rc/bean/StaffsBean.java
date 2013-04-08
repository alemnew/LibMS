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
import org.mk.rc.entity.Staffs;
import org.mk.rc.intf.StaffsBeanRemote;

/**
 *
 * @author alemnew
 */
@Stateless
public class StaffsBean implements StaffsBeanRemote {
    @PersistenceContext(unitName = "LMS-ejbPU")
    private EntityManager em;

      @Override
      public String registerStaff(Staffs staff) {
        Query query = em.createQuery("SELECT s.email FROM Staffs s WHERE s.email = :email");
        query.setParameter("email", staff.getEmail());
        List list = query.getResultList();
        if (list.size()>0) {
            return "EmailAlreadyRegistered";
        }
        persist(staff);
        
        return "registered";

}

    public void persist(Object object) {
        em.persist(object);
    }
}
