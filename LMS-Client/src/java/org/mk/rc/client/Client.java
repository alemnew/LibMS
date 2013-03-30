/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.ejb.EJB;
import org.mk.rc.intf.RegistrationBeanRemote;


/**
 *
 * @author alemnew
 */
public class Client {
    @EJB
    private static RegistrationBeanRemote registrationBean;
   
   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        
        Client client = new Client();
       try {
           System.out.print("What do you want? ");
           String option = br.readLine();
           if(option.equalsIgnoreCase("u")) {
               client.regUser();
           }
           else if(option.equalsIgnoreCase("p")) {
               client.addPub();
           }
           else if(option.equalsIgnoreCase("s")){
               client.regStaff();
           }
           else {
               System.out.println("Please select valid operation");
               option = br.readLine();
           }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void regStaff(){
       String fullName = null;
        String username = null;
        String email = null;
        String password = null;
       try {
          
            System.out.print("Enter full Name: ");
            fullName = br.readLine();
            System.out.print("Enter username: ");
            username = br.readLine();
            System.out.print("Enter Email: ");
            email = br.readLine();
            System.out.print("Enter Password: ");
            password = br.readLine();
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

       System.out.println(registrationBean.registerStaff(username, password, fullName, email));
    }
    public void regUser(){
        String fname = null;
        String lname = null;
        String email = null;
        String password = null;
        String phoneNumber = null;
       try {
          
            System.out.print("Enter First Name: ");
            fname = br.readLine();
            System.out.print("Enter Last Name: ");
            lname = br.readLine();
            System.out.print("Enter Email: ");
            email = br.readLine();
            System.out.print("Enter Password: ");
            password = br.readLine();
            System.out.print("Enter phone number: ");
            phoneNumber = br.readLine();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


       System.out.println(registrationBean.registerUser(fname, lname, email, password, phoneNumber, "address"));
    }
    public void addPub(){
        String title = null;
        String type = null;
        String pubDate = null;
        String author = null;
        String callNumber = null;
        String status = null;
        
         try {
          
            System.out.print("Enter tiel: ");
            title = br.readLine();
            System.out.print("Enter type: ");
            type = br.readLine();
            System.out.print("Enter publication date: ");
            pubDate = br.readLine();
            System.out.print("Enter author: ");
            author = br.readLine();
            System.out.print("Enter call number: ");
            callNumber = br.readLine();
            System.out.print("Enter status: ");
            status = br.readLine();
            System.out.println(registrationBean.addPublication(title, type, pubDate, author, callNumber, status));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        
    }
}
