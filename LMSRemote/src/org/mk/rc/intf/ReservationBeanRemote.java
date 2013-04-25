/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author alemnew
 */
@Remote
public interface ReservationBeanRemote {

    public String reserve(Long pubId, Long userId);

    public String cancelReservation(Long id);

    public List searchByUser(Long userId);

    public List searchByPublication(String pubId);

}
