/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.lang3.StringUtils;
import org.mk.rc.entity.Staffs;
import org.mk.rc.intf.StaffsBeanRemote;

/**
 *
 * @author alemnew
 */
public class StaffsAction extends ActionSupport implements ModelDriven<Staffs> {

    private Staffs staff = new Staffs();
    StaffsBeanRemote staffsBean = lookupStaffsBeanRemote();

    public void validate(){
        if(StringUtils.isEmpty(getStaff().getFullname())){
            addFieldError("fullname", "Fullname can not be empity");
        }
        if(StringUtils.isEmpty(getStaff().getEmail())){
            addFieldError("email", "Fullname can not be empity");
        }
        if(StringUtils.isEmpty(getStaff().getPassword())){
            addFieldError("password", "Fullname can not be empity");
        }
        if(StringUtils.isEmpty(getStaff().getUsername())){
            addFieldError("username", "Fullname can not be empity");
        }
       
    }
    public String registerStaff() throws Exception {
        if (staffsBean.registerStaff(getStaff()).equalsIgnoreCase("registered")) {
            addActionMessage("Staff Registered Successfully");
            return SUCCESS;
        }else if(staffsBean.registerStaff(getStaff()).equalsIgnoreCase("EmailAlreadyRegistered")) {
            addActionError(getText("error.email.used"));
            return INPUT;
        }
        return ERROR;

    }

    private StaffsBeanRemote lookupStaffsBeanRemote() {
        try {
            Context c = new InitialContext();
            return (StaffsBeanRemote) c.lookup("java:global/LMS-ejb/StaffsBean!org.mk.rc.intf.StaffsBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public Staffs getModel() {
        return getStaff();
    }

    /**
     * @return the staff
     */
    public Staffs getStaff() {
        return staff;
    }

    /**
     * @param staff the staff to set
     */
    public void setStaff(Staffs staff) {
        this.staff = staff;
    }

   
}
