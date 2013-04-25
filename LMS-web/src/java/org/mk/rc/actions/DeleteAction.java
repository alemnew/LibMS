/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.lang3.StringUtils;
import org.mk.rc.entity.Publication;
import org.mk.rc.intf.PublicationBeanRemote;

/**
 *
 * @author alemnew
 */
public class DeleteAction extends ActionSupport{

    private Long pubId;
    private String numOfPub = null;
    private List<Publication> pubList;
    PublicationBeanRemote publicationBean = lookupPublicationBeanRemote();

   
    public String deletePublication() throws Exception {
        if(publicationBean.deletePublication(getPubId()).equalsIgnoreCase("PublicationRemoved")){
            addActionMessage("Publication Successfully Deleted!");
            return SUCCESS;
       }
      addActionError("Oops, Something went wrong.");
      return ERROR;
    }

    /**
     * @return the title
     */
    private PublicationBeanRemote lookupPublicationBeanRemote() {
        try {
            Context c = new InitialContext();
            return (PublicationBeanRemote) c.lookup("java:global/LMS-ejb/PublicationBean!org.mk.rc.intf.PublicationBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    /**
     * @return the numOfPub
     */
    public String getNumOfPub() {
        return numOfPub;
    }

    /**
     * @param numOfPub the numOfPub to set
     */
    public void setNumOfPub(String numOfPub) {
        this.numOfPub = numOfPub;
    }

    /**
     * @return the pubList
     */
    public List<Publication> getPubList() {
        return pubList;
    }

    /**
     * @param pubList the pubList to set
     */
    public void setPubList(List<Publication> pubList) {
        this.pubList = pubList;
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
}
