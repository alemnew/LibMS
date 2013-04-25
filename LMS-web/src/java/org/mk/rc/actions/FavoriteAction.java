/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mk.rc.intf.FavoriteListBeanRemote;

/**
 *
 * @author alemnew
 */
public class FavoriteAction extends ActionSupport {
    FavoriteListBeanRemote favoriteListBean = lookupFavoriteListBeanRemote();

    private FavoriteListBeanRemote lookupFavoriteListBeanRemote() {
        try {
            Context c = new InitialContext();
            return (FavoriteListBeanRemote) c.lookup("java:global/LMS-ejb/FavoriteListBean!org.mk.rc.intf.FavoriteListBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
