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
public interface PublicationBeanRemote {

    public String addPublication(Publication publication);

    public List searchByTitle(String title);

    public List listPulication();

    public List searchAuthor(String author);

    public List searchByTitleAndAuthor(String title, String author);
}
