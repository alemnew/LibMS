/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import javax.ejb.Remote;

/**
 *
 * @author alemnew
 */
@Remote
public interface LoginBeanRemote {

    public String authenticate(String username, String password );
    
}
