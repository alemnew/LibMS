/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import org.mk.rc.intf.LoginBeanRemote;
import javax.ejb.Stateless;

/**
 *
 * @author alemnew
 */
@Stateless
public class LoginBean implements LoginBeanRemote {

    
    public String authenticate(String username, String password ) {
       if(username.equals("admin") && password.equals("admin")){
            return "Welcome " + username +"!"; 
        }
        else{
            return "Username or password is not correct! ";
        }
        
      
    }

   

}
