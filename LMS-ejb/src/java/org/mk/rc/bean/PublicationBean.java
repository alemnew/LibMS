/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.mk.rc.entity.Publication;
import org.mk.rc.intf.PublicationBeanRemote;

/**
 *
 * @author alemnew
 */
@Stateless
public class PublicationBean implements PublicationBeanRemote {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @PersistenceContext
    private EntityManager em;

    public String addPublication(Publication publication) {

        Query query = em.createQuery("SELECT p FROM Publication p WHERE p.pubId = :pubId");
        query.setParameter("pubId", publication.getPubId());
        if (query.getResultList().size() > 0) {
            em.merge(publication);
            return "PublicationUpdated";
        }
        persist(publication);
        return "publicatinAdded";
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List searchByTitle(String title) {
        Query query = em.createQuery("SELECT p FROM Publication p WHERE p.title = :title");
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public List listPulication() {
        Query query = em.createQuery("select p from Publication p");
        return query.getResultList();
    }

    @Override
    public List searchAuthor(String author) {
        Query query = em.createQuery("SELECT p FROM Publication p WHERE p.author = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }

    @Override
    public List searchByTitleAndAuthor(String title, String author) {
        Query query = em.createQuery("SELECT p FROM Publication p WHERE p.author = :author AND p.title = :title");
        query.setParameter("author", author);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public List searchByPubId(Long pubId) {
        Query query = em.createQuery("SELECT p FROM Publication p WHERE p.pubId = :pubId");
        query.setParameter("pubId", pubId);
        return query.getResultList();
    }

    @Override
    public String deletePublication(Long pubId) {
        Query query = em.createQuery("SELECT p FROM Publication p WHERE p.pubId = :pubId");
        query.setParameter("pubId", pubId);
        if (query.getResultList().size() > 0) {
            List<Publication> publication = query.getResultList();
            for (Publication p : publication) {
                em.remove(p);
            }
            return "PublicationRemoved";
        }
        return "publicatinNotFound";
    }
}
