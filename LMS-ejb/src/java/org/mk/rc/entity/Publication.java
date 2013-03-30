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
public class Publication implements Serializable {
   //  private static long serialVersionUID = 1L;

    
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pubId;
    private String title;
    private String type;
    private String pubDate;
    private String author;
    private String callNumber;
    private String status;

    /**
     * @return the pubId
     */
    public Long getPubId() {
        return pubId;
    }

    /**
     * @param pubId the pubId to set
     */
    public void setPubId(Long pubId) {
        this.pubId = pubId;
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
