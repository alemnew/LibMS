/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import java.util.List;
import javax.ejb.Remote;
import org.mk.rc.entity.Publication;

/**
 *
 * @author alemnew
 */
@Remote
public interface FavoriteListBeanRemote {

    public void addToFavorite(Publication publication);

    public void removeFromFavorite(Long pubId);

    public void removeAll();

    public List<Publication> getFavorite();

    public void remove();

    public boolean contains(Long pubId);
}
