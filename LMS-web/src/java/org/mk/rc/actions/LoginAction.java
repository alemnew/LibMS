/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
public class LoginAction extends ActionSupport implements ModelDriven {

    private Users user = new Users();
    
    private LoginBeanRemote loginBean = lookupLoginBeanRemote();

    public void validate() {
        if(StringUtils.isEmpty(user.getEmail())) {
            addFieldError("email", "Email can not be empity!");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            addFieldError("password", "Password can not be empity! ");
        }
    }
    public String authenticateUser() throws Exception {

        if (loginBean.authenticateUser(getUser()).equals("Autheniticated")) {
            return SUCCESS;
        }
        else if (loginBean.authenticateUser(getUser()).equals(null)) {
            return ERROR;
        }
        return LOGIN;

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

    @Override
    public Object getModel() {
        return getUser();
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }
}
