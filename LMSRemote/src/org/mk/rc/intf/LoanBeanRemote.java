/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import javax.ejb.Remote;

/**
 *
 * @author alemnew
 */
@Remote
public interface LoanBeanRemote {

    public String checkOut(Long pubId, Long userId);

    public boolean checkIn(Long pubId);
    
    public String extendLoan(Long pubId, Long userId);
}
