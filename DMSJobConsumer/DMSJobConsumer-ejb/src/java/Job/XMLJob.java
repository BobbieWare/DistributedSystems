/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Job;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Bob
 */
public class XMLJob implements Serializable
{
    public File job;

    public XMLJob(File job)
    {
        this.job = job;
    }

    public XMLJob()
    {
       this.job = null; 
    }
}
