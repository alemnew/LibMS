/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mk.rc.intf.LoginBeanRemote;

/**
 *
 * @author alemnew
 */
public class LoginAction {

    private String username;
    private String password;
    
    private LoginBeanRemote loginBean;

    public String execute() throws Exception {
        /*try {
            Context c = new InitialContext();
            loginBean = (LoginBeanRemote) c.lookup("java:global/LMS-ejb/LoginBean!org.mk.rc.intf.LoginBeanRemote");
            if (loginBean.authenticate().equalsIgnoreCase("sucess")) {
                return "success";
            } else {
                return "error";
            }
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);

        }*/
        if(getUsername().equalsIgnoreCase("user") && getPassword().equalsIgnoreCase("password")){
            return "success";
        }
        return "failure";

    }

    /*private LoginBeanRemote lookupLoginBeanRemote() {
     try {
     Context c = new InitialContext();
     return (LoginBeanRemote) c.lookup("java:global/LMS-ejb/LoginBean!org.mk.rc.intf.LoginBeanRemote");
     } catch (NamingException ne) {
     ne.printStackTrace();
     throw new RuntimeException(ne);
     }
     }*/

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
