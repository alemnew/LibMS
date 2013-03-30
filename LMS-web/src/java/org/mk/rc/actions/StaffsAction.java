/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mk.rc.intf.RegistrationBeanRemote;

/**
 *
 * @author alemnew
 */
public class StaffsAction extends ActionSupport{
    private String username;
    private String password;
    private String fullname;
    private String email;

    private RegistrationBeanRemote registrationBean;
    
    public String registerStaff() throws Exception {
       try {
            Context c = new InitialContext();
            registrationBean = (RegistrationBeanRemote) c.lookup("java:global/LMS-ejb/RegistrationBean!org.mk.rc.intf.RegistrationBeanRemote");
           if (registrationBean.registerStaff(getUsername(), getPassword(), getFullname(), getEmail()).equalsIgnoreCase("registered")) {
                return SUCCESS;
            } 
                return ERROR;
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);

        }
        //return SUCCESS;
    }
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

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
