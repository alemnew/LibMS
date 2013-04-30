/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alemnew
 */
@Entity
public class Comments implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subject;
    private String content;
    private String rcvDate;
    private String sennderEmail;
    private String senderName;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the rcvDate
     */
    public String getRcvDate() {
        return rcvDate;
    }

    /**
     * @param rcvDate the rcvDate to set
     */
    public void setRcvDate(String rcvDate) {
        this.rcvDate = rcvDate;
    }

    /**
     * @return the sennderEmail
     */
    public String getSennderEmail() {
        return sennderEmail;
    }

    /**
     * @param sennderEmail the sennderEmail to set
     */
    public void setSennderEmail(String sennderEmail) {
        this.sennderEmail = sennderEmail;
    }

    /**
     * @return the senderName
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * @param senderName the senderName to set
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    
}
