/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import javax.ejb.Remote;
import org.mk.rc.entity.Staffs;
import org.mk.rc.entity.Users;

/**
 *
 * @author alemnew
 */
@Remote
public interface LoginBeanRemote {

    public Users authenticateUser(String email, String password);

    public Staffs authenticateStaff(String email, String password);
    
}
