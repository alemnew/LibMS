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
public class PublicatonAction extends ActionSupport implements ModelDriven<Publication> {

    private Publication publication = new Publication();
    private String numOfPub = null;
    private List<Publication> pubList;
    PublicationBeanRemote publicationBean = lookupPublicationBeanRemote();

    public void validate() {
        if (StringUtils.isEmpty(getPublication().getAuthor())) {
            addFieldError("author", getText("error.author"));
        }
        if (StringUtils.isEmpty(getPublication().getCallnumber())) {
            addFieldError("callnumber", getText("error.callnumber"));
        }
        if (StringUtils.isEmpty(getPublication().getPubDate())) {
            addFieldError("pubDate", getText("error.pubdate"));
        }
        if (StringUtils.isEmpty(getPublication().getStatus())) {
            addFieldError("status", getText("error.status"));
        }
        if (StringUtils.isEmpty(getPublication().getTitle())) {
            addFieldError("title", getText("error.title"));
        }
        if (StringUtils.isEmpty(getPublication().getType())) {
            addFieldError("type", getText("error.type"));
        }
    }

    public String insertPublication() throws Exception {
        if (publicationBean.addPublication(getPublication()).equalsIgnoreCase("publicatinAdded")) {
            addActionMessage("New Publication successfully Recoreded!");
            return SUCCESS;
        }
        return ERROR;
    }

    public String listPublication() throws Exception {
        /* if (!getPublication().getAuthor().trim().equals("") && !getPublication().getTitle().trim().equals("")) {
         setPubList(publicationBean.searchByTitleAndAuthor(getPublication().getTitle(), getPublication().getAuthor()));
         setNumOfPub(getPubList().size() + " publications");
         } else*/ if (getPublication().getTitle().trim().equals("")) {//&& getPublication().getAuthor().trim().equals("")) {
            setPubList((List<Publication>) publicationBean.listPulication());
            setNumOfPub(getPubList().size() + " publications");
        } else if (!getPublication().getTitle().trim().equals("")) {
            setPubList(publicationBean.searchByTitle(getPublication().getTitle()));
            setNumOfPub(getPubList().size() + " publications");
        }/* else if (!getPublication().getAuthor().trim().equals("")) {
         setPubList(publicationBean.searchAuthor(getPublication().getAuthor()));
         setNumOfPub(getPubList().size() + " publications"); 
         }*/
        return SUCCESS;
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

    @Override
    public Publication getModel() {
        return getPublication();
    }

    /**
     * @return the publication
     */
    public Publication getPublication() {
        return publication;
    }

    /**
     * @param publication the publication to set
     */
    public void setPublication(Publication publication) {
        this.publication = publication;
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
}
