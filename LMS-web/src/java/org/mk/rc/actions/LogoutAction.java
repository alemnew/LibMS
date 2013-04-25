/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

/**
 *
 * @author michael
 */
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

    public String logout() throws Exception { 
        Map session = ActionContext.getContext().getSession();
        session.remove("loggedin"); 
        session.remove("user");
        addActionMessage("Successfully Logout");
        return SUCCESS;
    }
}
