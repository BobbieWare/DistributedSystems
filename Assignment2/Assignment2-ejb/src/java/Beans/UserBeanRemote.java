package Beans;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Bob
 */
@Remote
public interface UserBeanRemote
{

    /**
     *
     * @param username
     */
    void addUser(String username);

    /**
     *
     * @return
     */
    ArrayList<String> getUsernames();
    
}
