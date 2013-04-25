/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.lang3.StringUtils;
import org.mk.rc.entity.Users;
import org.mk.rc.intf.UsersBeanRemote;

/**
 *
 * @author alemnew
 */
public class UsersAction extends ActionSupport implements ModelDriven{
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    UsersBeanRemote usersBean = lookupUsersBeanRemote();
    private Users user = new Users();
    
    private String size;
    
    public void validate() {
         if(StringUtils.isEmpty(getUser().getAddress())){
            addFieldError("address", getText("error.address"));
        }
        if(StringUtils.isEmpty(getUser().getEmail())){
            addFieldError("email", getText("error.email"));
        }
         if(StringUtils.isEmpty(getUser().getFirstName())){
            addFieldError("firstname", getText("error.firstname"));
        }
          if(StringUtils.isEmpty(getUser().getLastName())){
            addFieldError("lastname", getText("error.lastname"));
        } if(StringUtils.isEmpty(getUser().getPassword())){
            addFieldError("password", getText("error.password"));
        }
         if(StringUtils.isEmpty(getUser().getPhoneNumber())){
            addFieldError("phonenumber", getText("error.phonenumber"));
        }
          
    }
    public String registerUser() throws Exception {
     
        if(usersBean.registerUser(getUser()).equalsIgnoreCase("UserRegistered")){
            addActionMessage("Registration Successful!");
            return SUCCESS;
        }else if(usersBean.registerUser(getUser()).equalsIgnoreCase("EmailAlreadyRegistered")) {
            addActionError(getText("error.email.used"));
            return INPUT;
        }
        return ERROR;
         
    }
    
    public String findAll() throws Exception {
        
        List <Users> users = usersBean.findAll();
         size = users.size() + "Users";
         System.out.println(size);
        return SUCCESS;
    }
    public String editProfile() throws Exception {
        if(usersBean.editProfile(getUser())) {
            addActionMessage("Congratulations, profile updated successfully!"); 
            return SUCCESS;
        }
        addActionError("Oops, something went wrong! Profile not updated.");
        return ERROR;
       
    }
    
    
    private UsersBeanRemote lookupUsersBeanRemote() {
        try {
            Context c = new InitialContext();
            return (UsersBeanRemote) c.lookup("java:global/LMS-ejb/UsersBean!org.mk.rc.intf.UsersBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
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

    @Override
    public Object getModel() {
        return getUser();
    }

    
}
