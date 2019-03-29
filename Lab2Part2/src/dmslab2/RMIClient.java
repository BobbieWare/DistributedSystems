/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmslab2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author bobbie
 */
public class RMIClient
{

	public static void main(String[] args)
	{
		try
		{
			Registry registry = LocateRegistry.getRegistry();
			System.out.println("Registry is created...");
			RMIGreeting remoteProxy = (RMIGreeting) registry.lookup("randomNumberRMI");
			Scanner input = new Scanner(System.in);
			boolean guess = false;
			while (!guess)
			{
				System.out.println("Enter a random number as a guess: ");
				int message = input.nextInt();
				guess = remoteProxy.haveGuess(message);
			}

		} catch (RemoteException e)
		{
			System.err.println("Unable to use registry: " + e);
		} catch (NotBoundException e)
		{
			System.err.println("Name greeting not currently bound: " + e);
		} catch (ClassCastException e)
		{
			System.err.println("Class Cast Exception: " + e);
		}
	}
}
