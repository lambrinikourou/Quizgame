package myQuiz;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Score {
	int highscore=0;
	String highscore_user;
	JFrame frame = new JFrame();
	
	public void addScore(String username, int score) {
		
		//create scores.txt if it doesn't exist
		try {
		      File myObj = new File("scores.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		// save user's username and score
		try (PrintWriter pw = new PrintWriter(new FileWriter("scores.txt", true))) {
            pw.println(username + ":" + score );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	   }
	
	   //saves file in list and find the highscore
	   public void showHighscore() {
		   try (Scanner in = new Scanner(new File("scores.txt"))) {
	            String s[];
	           while (in.hasNextLine()) {
	                s = in.nextLine().split(":");
	                if ( Integer.parseInt(s[1])> highscore) {
	                	highscore = Integer.parseInt(s[1]);
	                	highscore_user=s[0];
	                }
	                }
	            
	      } catch (IOException e) {
	            System.out.println(e.getMessage());
	      }
		   
		   JLabel hscore = new JLabel();
		   JLabel hscore_user = new JLabel();
		   
		   JTextArea textarea = new JTextArea();
		   textarea.setBounds(0,0,800,50);
		   textarea.setLineWrap(true);
		   textarea.setWrapStyleWord(true);
		   textarea.setBackground(new Color(25,25,25));
		   textarea.setForeground(new Color(50, 150, 250));
		   textarea.setFont(new Font("Arial Unicode MS",Font.BOLD,25));
		   textarea.setBorder(BorderFactory.createBevelBorder(1));
		   textarea.setEditable(false);
		   textarea.setText("MytholoQuiz");
		   frame.add(textarea);
		  
		  hscore.setFont(new Font("Arial Unicode MS",Font.BOLD,30));
		  hscore_user.setFont(new Font("Arial Unicode MS",Font.BOLD,30));
		 
		  hscore.setBounds(285, 200, 500, 100);
			
		  hscore_user.setBounds(285, 300, 500, 100);
		   
		   frame.setSize(800,800);
		   frame.getContentPane().setBackground(new Color(112, 128, 160));
			
		   frame.setLayout(null);
		   frame.setResizable(false);
		  
		   hscore.setText("Highscore: " +highscore  );
		   hscore_user.setText("User: " +highscore_user );
		   frame.add(hscore);
		   frame.add(hscore_user);
		   frame.show();
	    
	   }
	
 

	  
	
}
