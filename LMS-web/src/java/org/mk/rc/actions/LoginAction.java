/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.lang3.StringUtils;
import org.mk.rc.entity.Users;
import org.mk.rc.intf.LoginBeanRemote;

/**
 *
 * @author alemnew
 */
public class LoginAction extends ActionSupport {

    private String email;
    private String password;
    private LoginBeanRemote loginBean = lookupLoginBeanRemote();

    public void validate() {
        if (StringUtils.isEmpty(getEmail())) {
            addFieldError("email", "Email can not be empity!");
        }
        if (StringUtils.isEmpty(getPassword())) {
            addFieldError("password", "Password can not be empity! ");
        }
    }

    public String authenticateUser() throws Exception {
        Map session = ActionContext.getContext().getSession();
        Users usr = loginBean.authenticateUser(getEmail(), getPassword());
        try {
            if (usr.equals(null)) {
                addActionError("Oops, Incorrect Email or Password!");
                session.put("loggedin", "false");
                session.put("user", "none");
                return ERROR;
            } else {
                session.put("loggedin", "true");
                session.put("user", usr.getUserId());
                addActionMessage("Login Successful! Welcome " + usr.getFirstName());
                return SUCCESS;
            }
        } catch (NullPointerException ex) {
            addActionError("Oops, Incorrect Email or Password!");
            session.put("loggedin", "false");
            session.put("user", "none");
            return ERROR;
        }

    }

    public String authenticateStaff() throws Exception {
        return "success";

    }

    private LoginBeanRemote lookupLoginBeanRemote() {
        try {
            Context c = new InitialContext();
            return (LoginBeanRemote) c.lookup("java:global/LMS-ejb/LoginBean!org.mk.rc.intf.LoginBeanRemote");
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);
        }
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
