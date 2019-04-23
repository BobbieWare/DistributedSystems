package Beans;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author Bob
 */
@Singleton
@LocalBean
@Startup
public class CounterBean implements CounterInterface
{

    private int userCount;

    private int postCount;

    @Override
    public int getUserCount()
    {
        return userCount;
    }

    @Override
    public void incUserCount()
    {
        userCount++;
    }

    @Override
    public int getPostCount()
    {
        return postCount;
    }

    @Override
    public void incPostCount()
    {
        postCount++;
    }

    public CounterBean()
    {
    }
}
