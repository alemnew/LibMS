/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import javax.ejb.Remote;

/**
 *
 * @author alemnew
 */
@Remote
public interface RegistrationBeanRemote {

   public String registerUser(String fname, String lname, String email, String pswd, String phone, String address);
   public String addPublication(String title, String type, String pubDate, String author, String callNumber, String status) ;
   public String registerStaff(String username, String password, String fullName, String email);
    
}
