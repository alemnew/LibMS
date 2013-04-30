/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author alemnew
 */

public class ReservationDummy implements Serializable{
    
    private Long Id;
    private Long pubId;
    private String title;
    private String author;
    private String pubDate;
    private String type;
    private String expRetDate;

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

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
     * @return the expRetDate
     */
    public String getExpRetDate() {
        return expRetDate;
    }

    /**
     * @param expRetDate the expRetDate to set
     */
    public void setExpRetDate(String expRetDate) {
        this.expRetDate = expRetDate;
    }
    
    
}
