/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mk.rc.entity.Users;
import org.mk.rc.intf.UsersBeanRemote;

/**
 *
 * @author alemnew
 */
public class ProfileAction extends ActionSupport{
    UsersBeanRemote usersBean = lookupUsersBeanRemote();
    private List< Users> user;
    private Users users = new Users();
    private Long userId;
    private String currentPswd;
    private String newPswd;
    private String confirmPswd;
   
    
    public String diplayProfile() throws Exception {
        setUser((List<Users>)usersBean.displayProfile(getUserId()));      
        return SUCCESS;
    }
    public String editProfile() throws Exception {
       System.out.println(getUsers().getEmail());
        if(usersBean.editProfile(getUsers())) {
            addActionMessage("Congratulations, profile updated successfully!"); 
            return SUCCESS;
        }
        addActionError("Oops, something went wrong! Profile not updated.");
        return ERROR;
       
    }
    public String changePassword() throws Exception {
        if(usersBean.changePassword(getUserId(), getCurrentPswd(), getNewPswd())){
            addActionMessage("Password changed successfully!");
            return SUCCESS;
        }    
        addActionError("Oops, The old password is incorrect!");
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
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the user
     */
    public List< Users> getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(List< Users> user) {
        this.user = user;
    }

    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * @return the currentPswd
     */
    public String getCurrentPswd() {
        return currentPswd;
    }

    /**
     * @param currentPswd the currentPswd to set
     */
    public void setCurrentPswd(String currentPswd) {
        this.currentPswd = currentPswd;
    }

    /**
     * @return the newPswd
     */
    public String getNewPswd() {
        return newPswd;
    }

    /**
     * @param newPswd the newPswd to set
     */
    public void setNewPswd(String newPswd) {
        this.newPswd = newPswd;
    }

    /**
     * @return the confirmPswd
     */
    public String getConfirmPswd() {
        return confirmPswd;
    }

    /**
     * @param confirmPswd the confirmPswd to set
     */
    public void setConfirmPswd(String confirmPswd) {
        this.confirmPswd = confirmPswd;
    }
    
    
    
    
}
