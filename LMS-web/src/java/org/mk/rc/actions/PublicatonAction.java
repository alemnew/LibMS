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
public class PublicatonAction extends ActionSupport{
    private String title;
    private String type;
    private String pubDate;
    private String author;
    private String callNumber;
    private String status;

    private RegistrationBeanRemote registrationBean;
    
    public String addPublication() throws Exception {
        try {
            Context c = new InitialContext();
            registrationBean = (RegistrationBeanRemote) c.lookup("java:global/LMS-ejb/RegistrationBean!org.mk.rc.intf.RegistrationBeanRemote");
        if(registrationBean.addPublication(getTitle(), getType(), getPubDate(), getAuthor(), 
                getCallNumber(),getStatus()).equalsIgnoreCase("publicatinAdded")){
            return SUCCESS;
        }
        return ERROR;
         } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);

        }
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * @param pubDate the pubDate to set
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the callNumber
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * @param callNumber the callNumber to set
     */
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
