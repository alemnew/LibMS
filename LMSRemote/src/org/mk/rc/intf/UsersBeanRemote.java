/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mk.rc.intf;

import java.util.List;
import javax.ejb.Remote;
import org.mk.rc.entity.Users;

/**
 *
 * @author alemnew
 */
@Remote
public interface UsersBeanRemote {

    public String registerUser(Users user);

    public List<Users> findAll() throws Exception;

    public List displayProfile(Long userId);

    public boolean editProfile(Users user);

    public boolean changePassword(Long userId, String currentPswd, String newPswd);
}
