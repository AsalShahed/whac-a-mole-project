package com.example.whack_a_mole;

import static java.lang.String.valueOf;

import android.os.AsyncTask;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//generic , första är String som motsvarar parametrar, andra prameter är framsteg, och sista är resultatet
/**
 * @author Judy & Chahed
 * DA393A
 */
 public class MessageSender  extends AsyncTask<String, Object, Void>  {
 	
 	Socket socket;
	ObjectOutputStream oos;
	Object player;
	String userName;
	String level;
	
	
	
	
	 //parametrar inom parentesen alltså String med tre punkter betyder att den tar emot hur många
	// parametrar som helst, alltså utan gräns kan vara noll upp till obegränsta, i vårt fall vill
	// vi mata in namn samt nivån på spelet
	//Koden som vi vill exekvera i eget tråd
	
	
	
	 @Override
	protected Void doInBackground(String... strings) {
		userName = strings [0];
		level = strings [1];
		player =  userName +"\n" + level ;
		
		
		try {
				socket= new Socket("192.168.1.179", 8884);
				System.out.println("********************");
				System.out.println("Connected to server");
				System.out.println("********************");
				oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(player);
				oos.flush();
			    
		} catch (IOException e) {
			e.printStackTrace();
			//	socket.close();
		}
		return null;
	 }
 }
