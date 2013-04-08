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
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long pubId;
    private String resDate;
    private String expectedDate;

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
     * @return the resDate
     */
    public String getResDate() {
        return resDate;
    }

    /**
     * @param resDate the resDate to set
     */
    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    /**
     * @return the expectedDate
     */
    public String getExpectedDate() {
        return expectedDate;
    }

    /**
     * @param expectedDate the expectedDate to set
     */
    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }
    

}
