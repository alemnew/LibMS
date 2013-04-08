/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import javax.ejb.Remote;
import org.mk.rc.entity.Staffs;

/**
 *
 * @author alemnew
 */
@Remote
public interface StaffsBeanRemote {
    public String registerStaff(Staffs staff);
}
