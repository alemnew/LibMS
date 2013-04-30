/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.mk.rc.entity.Publication;
import org.mk.rc.intf.FavoriteListBeanRemote;
import org.mk.rc.intf.ReservationBeanRemote;

/**
 *
 * @author alemnew
 */
public class FavoriteAction extends ActionSupport {
    ReservationBeanRemote reservationBean = lookupReservationBeanRemote();

    /**
     * @return the favList
     */
    public  List<Publication> getFavList() {
        return favList;
    }

    /**
     * @param aFavList the favList to set
     */
    public  void setFavList(List<Publication> aFavList) {
        favList = aFavList;
    }
    FavoriteListBeanRemote favoriteListBean;
    private  List<Publication> favList = new ArrayList<Publication>();
    Publication publication = new Publication();
    private Long pubId;
    private String title;
    private String type;
    private String pubDate;
    private String author;
    private String callnumber;
    private String status;
    private HttpServletRequest request;
    private int numFav;
    private Long userId;

    private void initRequest() {
        if (request == null) {
            request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        }
    }

    public String addToFav() throws Exception {
        initRequest();
        setUpFavListBean();
        if (favoriteListBean.contains(Long.parseLong(request.getParameter("pubId")))) {
            addActionMessage("Successfully added to Favorite List");
            return SUCCESS;
        }
        publication.setAuthor(request.getParameter("author"));
        publication.setCallnumber(request.getParameter("callnumber"));
        publication.setPubDate(request.getParameter("pubDate"));
        publication.setPubId(Long.parseLong(request.getParameter("pubId")));
        publication.setStatus(request.getParameter("pubId"));
        publication.setTitle(request.getParameter("title"));
        publication.setType(request.getParameter("type"));

        favoriteListBean.addToFavorite(publication);
        System.out.println(favoriteListBean.noFavList());
        addActionMessage("Successfully added to Favorite List ");
        return SUCCESS;
    }

    public String removeFromFav() throws Exception {
        initRequest();
        setUpFavListBean();
        favoriteListBean.removeFromFavorite(Long.parseLong(request.getParameter("pubId")));
        if (favoriteListBean.getFavorite() == null) {
            request.getSession().setAttribute("sfsbean", null);
            favoriteListBean.remove();
            return SUCCESS;
        }
        return ERROR;
    }

    public String getFavListContent() throws Exception {
        initRequest();
        setUpFavListBean();
        setFavList(favoriteListBean.getFavorite());
        setNumFav(favoriteListBean.noFavList());
        return SUCCESS;
    }
    
    public String removeAllFav() throws Exception {
        initRequest();
        setUpFavListBean();
        favoriteListBean.removeAll();
        addActionMessage("Favorite is empty!");
        return SUCCESS;
    }
    public String submitToReservation() throws Exception {
        initRequest();
        setUpFavListBean();
        favList = favoriteListBean.getFavorite();
        if(favList.size()== 0){
            addActionError("Oops, Nothing in Favorite list!");
            return ERROR;
        }
        for(int i = 0; i < favList.size(); i++){
            reservationBean.reserve(favList.get(i).getPubId(), userId);
        }
        favoriteListBean.removeAll();
        addActionMessage("Your Favorite publications are reserved! We will contact soon.");
        return SUCCESS;
    }

    private void setUpFavListBean() {
        try {
            if (favoriteListBean == null) {
                favoriteListBean = (FavoriteListBeanRemote) request.getSession().getAttribute("sfsbean");
            }

            if (favoriteListBean == null) {
                Context c = new InitialContext();
                favoriteListBean = (FavoriteListBeanRemote) c.lookup("java:global/LMS-ejb/FavoriteListBean!org.mk.rc.intf.FavoriteListBeanRemote");
                // favoriteListBean = (FavoriteListBeanRemote) PortableRemoteObject.narrow(obj, FavoriteListBeanRemote.class);
                request.getSession().setAttribute("sfsbean", favoriteListBean);
            }
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
     * @return the callnumber
     */
    public String getCallnumber() {
        return callnumber;
    }

    /**
     * @param callnumber the callnumber to set
     */
    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the numFav
     */
    public int getNumFav() {
        return numFav;
    }

    /**
     * @param numFav the numFav to set
     */
    public void setNumFav(int numFav) {
        this.numFav = numFav;
    }

    private ReservationBeanRemote lookupReservationBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ReservationBeanRemote) c.lookup("java:global/LMS-ejb/ReservationBean!org.mk.rc.intf.ReservationBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
}
