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
public class UsersAction extends ActionSupport{
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    private RegistrationBeanRemote registrationBean;
    
    public String registerUser() throws Exception {
        try {
            Context c = new InitialContext();
            registrationBean = (RegistrationBeanRemote) c.lookup("java:global/LMS-ejb/RegistrationBean!org.mk.rc.intf.RegistrationBeanRemote");
        if(registrationBean.addPublication(getfName(), getlName(), getEmail(), getPassword(), getPhoneNumber(), 
                getAddress()).equalsIgnoreCase("UserRegistered")){
            return SUCCESS;
        }
        return ERROR;
         } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);

        }
    }
    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
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

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
