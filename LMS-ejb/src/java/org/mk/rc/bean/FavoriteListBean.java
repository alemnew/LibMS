/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.mk.rc.entity.Publication;
import org.mk.rc.intf.FavoriteListBeanRemote;

/**
 *
 * @author alemnew
 */
@Stateful
public class FavoriteListBean implements FavoriteListBeanRemote {

    List<Publication> favoriteList = new ArrayList<Publication>();

    @Override
    public void addToFavorite(Publication publication) {
        favoriteList.add(publication);
    }

    @Override
    public void removeFromFavorite(Long pubId) {
        for (int i = 0; i < favoriteList.size(); i++) {
            if (favoriteList.get(i).getPubId().equals(pubId)) {
                favoriteList.remove(i);
                break;
            }

        }
    }

    @Override
    public void removeAll() {
        favoriteList = new ArrayList<Publication>();
    }

    @Override
    public List<Publication> getFavorite() {
        return favoriteList;
    }

    @Override
    public boolean contains(Long pubId) {
        for (int i = 0; i < favoriteList.size(); i++) {
            if (favoriteList.get(i).getPubId().equals(pubId)) {
                favoriteList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    @Remove
    public void remove() {
        favoriteList = null;
    }
}
