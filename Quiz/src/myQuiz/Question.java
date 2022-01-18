package myQuiz;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Question implements ActionListener{

private String username=null;
private String username2=null;
boolean turn=false;	
	
  
	
	
	String[] questions = 	{
					"Πως ονομάζεται ο εικονιζόμενος;",
					"Πως ονομάζεται το μυθικό τέρας μου είχε σώμα ανθρώπου και κεφάλι και ουρά ταύρου;",
					"Μαζί με ποιον πραγματοποίησε ο Δαίδαλος την πρώτη πτήση της ανθρώπινης ιστορίας;",
					"<html>Πως ονομάζεται ο άγρυπνος φρουρός της πύλης του Άδη, που δεν πείραζε εκείνους που<br> ήθελαν να μπουν αλλά κατασπάραζε όλους όσους τολμούσαν να βγουν;<html>",
					"<html>Πως ονομάζεται το μυθικό τέρας που είχε φρικτή μορφή, αντί για μαλλιά είχε φίδια στο κεφάλι και μετέτρεπε σε πέτρα όποιον την κοιτούσε;</html>",
					"<html>Σε ποιον τιτάνα, ο Δίας έθεσε σαν τιμωρία να κουβαλάει στους ώμους του τον Ουράνιο Θόλο,<br> δηλαδή τον ουρανό;</html>",
					"Ποιοι ήταν οι αρχηγοί των Ελλήνων στον τρωικό πόλεμο;",
					"<html>Πως ονομάζεται ο κύκλωπας που ο Οδυσσέας και οι σύντροφοι του τύφλωσαν για να <br> δραπετεύσουν από την σπηλιά του;</html>",
					"<html>Σε ποιον ανέθεσε ο Πιλέας βασιλιάς της Ιωλκού, σαν αποστολή  να φέρει<br> το Χρυσόμμαλο Δέρας;</html>",
					"Ποιος από τους παρακάτω σκότωσε την Μέδουσα;",
				    "<html>Ποιανού ήταν η ιδέα της δημιουργίας του Δούριου Ίππου, ο οποίος έπαιξε σημαντικό<br> παράγοντα στην νίκη των Ελλήνων στο Τρωικό πόλεμο;</html>",
				    "<html>Ποιος από τους παρακάτω ήταν θεός της φωτιάς και προστάτης των μεταλλουργών<br> και των τεχνιτών;</html>",
				    "Ποιος από τους παρακάτω ήταν ο αγγελιοφόρος των θεών;",
				    "<html>Ποια από τις κόρες του Δία, ήταν γνωστή ως η θεά της σοφίας των τεχνών και <br>του σώφρονος πολέμου.</html>",
				    "Ποιος από τους παρακάτω ήταν γνωστός ως ο θεός του κάτω κόσμου;",
				    "<html>Ποιος είναι ο εικονιζόμενος ήρωας της Ιλιάδας, τον οποίο η μητέρα του Θέτις <br>προσπάθησε να τον κάνει άτρωτο αφήνοντας του όμως ένα τρωτό σημείο, τη φτέρνα τού;</html>",
				    "Ποιος είναι ο εικονιζόμενος ήρωας που ηγήθηκε της Αργοναυτικής Εκστρατείας:",
				    "Ποιος ήρωας της αρχαίας ελληνικής μυθολογίας σκότωσε τον Μινώταυρο;",
				    "Ποιος ήρωας θανάτωσε το εικονιζόμενο μυθικό πλάσμα, τη Λερναία Ύδρα;",
				    "Πως ονομάζεται το εικονιζόμενο πλάσμα, το οποίο σκοτώθηκε από τον Βελλερεφόντη;"
				   
					
				};
	
	String[][] options = 	{
					{"Οδυσσέας","Αχιλλέας","Ηρακλής","Θησέας"},
					{"Κένταυρος","Μινώταυρος","Κέρβερος","Πήγασος"},
					{"Προμηθέας","Αγαμέμνονας","Πάρις","Ίκαρος"},
					{"Κένταυρος","Κέρβερος","Γρύπας","Χίμαιρα"},
					{"Σφίγγα","Σκύλλα","Σειρήνα","Μέδουσα"},
					{"Τον Κρόνο","Τον Άτλα","Τον Προμηθέα","Τον  Κριό"},
					{"Αγαμέμνονας και Μενέλαος","Έκτορας και Πάρις","Αχιλλέας και Πάτροκλος","Ορέστης και Τηλέμαχος"},
					{"Αγκαίο","Θεόκριτο","Φόρκυο","Πολύφημο"},
					{"Στον Ίκαρο","Στον Περσέα","Στον Ιάσωνα","Στον Διομήδη"},
					{"Ο Περσέας","Ο Ηρακλής","Ο Ιάσωνας","Ο Θησέας"},
					{"Του Αχιλλέα","Του Οδυσσέα","Του Αγαμέμνονα","Του Μενέλαου"},
					{"Ο Άρης"," Ο Διόνυσος","Ο Ήφαιστος","Ο Ηρακλής"},
					{"Ο Απόλλωνας","Ο Ερμής","Ο Άρης","Ο Ποσειδώνας"},
					{"Η θεά Εστία","Η θεά Άρτεμις","Η θεά Αφροδίτη","Η θεά Αθηνά"},
					{"Ο Άδης","Ο Άρης","Ο Ερμής","Ο Δίας"},
					{"Ο Αχιλλέας","Ο Πάτροκλος","Ο Μενέλαος ","Ο Πάρης"},
					{"Ο Περσέας","Ο Θησέας","Ο Οδυσσέας ","Ο Ιάσωνας"},
					{"Ο Οδυσσέας","Ο Ηρακλής","Ο Θησέας ","Ο Περσέας"},
					{"Ο Ιάσωνας","Ο Ηρακλής","Ο Θησέας ","Ο Περσέας"},
					{"Σφίγγα","Χίμαιρα","Λιοντάρι της Νεμέας ","Γρύπας"}
					
					
					
					
					
	};
	
	String[]images= {
			         "Images/Picture1.jpg",
		             "Images/Picture2.jpg",
					 "Images/Picture3.jpg",
					 "Images/Picture4.jpg",
					 "Images/Picture5.jpg",
		             "Images/Picture6.jpg",
					 "Images/Picture7.jpg",
					 "Images/Picture8.jpg",
					 "Images/Picture9.jpg",
					 "Images/Picture10.jpg",
					 "Images/Picture11.jpg",
		             "Images/Picture12.jpg",
					 "Images/Picture13.jpg",
					 "Images/Picture14.jpg",
					 "Images/Picture15.jpg",
					 "Images/Picture16.jpg",
					 "Images/Picture17.jpg",
					 "Images/Picture18.jpg",
					 "Images/Picture19.png",
					 "Images/Picture20.jpg"
					
					 };
	
	char[] answers = 		{
					'C',
					'B',
					'D',
					'B',
					'D',
					'B',
					'A',
					'D',
					'C',
					'A',
					'B',
					'C',
					'B',
					'D',
					'A',
					'A',
					'D',
					'C',
					'B',
					'B'
					
				
					
					
					
				};
	
	char answer;
	int index;
	int score_player1 =0;
	int score_player2 =0;
	int total_questions = questions.length;
	int result;
	int seconds=60;
	

	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	
	JLabel question_label =new JLabel();
	JLabel question_icon =new JLabel();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField result_player1 = new JTextField();
	JTextField result_player2 = new JTextField();
	
	
	
	
	Timer timer = new Timer(1000, new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
	seconds--;
	seconds_left.setText(String.valueOf(seconds));
	if(seconds<=0) {
	displayAnswer();
	}
	}
	});

	
	
	//Constructor for 1 player
	public Question(String username) {
		this.username=username;
	
       showQuestions();
		
	

	
	}
	
	//Constructor for 2 players
	public Question(String username,String username2) {
		this.username=username;
		this.username2=username2;
	    showQuestions();	
	}
	
	
	public void showQuestions() {
		
		//question frame design
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,800);
		frame.getContentPane().setBackground(new Color(112, 128, 160));
		frame.setLayout(null);
		frame.setResizable(false);
		textfield.setFont(new Font("Arial Unicode MS",Font.BOLD,30));
		textfield.setBounds(0,0,900,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(50, 150, 250));

		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);

		question_label.setBounds(30,50,800,50);
		question_label.setForeground(new Color(225,225,225));
		question_label.setFont(new Font("Arial Unicode MS",Font.BOLD,18));
		

		buttonA.setBounds(50,400,50,50);
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");

		buttonB.setBounds(50,470,50,50);
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		buttonC.setBounds(50,540,50,50);
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");

		buttonD.setBounds(50,610,50,50);
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");

		answer_labelA.setBounds(110,375,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,25,25));
		answer_labelA.setFont(new Font("Arial Unicode MS",Font.PLAIN,25));

		answer_labelB.setBounds(110,445,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,25,25));
		answer_labelB.setFont(new Font("Arial Unicode MS",Font.PLAIN,25));

		answer_labelC.setBounds(110,515,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,25,25));
		answer_labelC.setFont(new Font("Arial Unicode MS",Font.PLAIN,25));

		answer_labelD.setBounds(110,585,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,25,25));
		answer_labelD.setFont(new Font("Arial Unicode MS",Font.PLAIN,25));

		seconds_left.setBounds(550,585,150,80);
		seconds_left.setBackground(new Color(255,255,255));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,50));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));

		time_label.setBounds(550,525,150,80);
		time_label.setFont(new Font("Arial Unicode MS",Font.PLAIN,20));
		time_label.setText("Time left");
	

		result_player1.setBounds(270,225,200,100);
		result_player1.setBackground(new Color(25,25,25));
		result_player1.setForeground(new Color(25,255,0));
		result_player1.setFont(new Font("Ink Free",Font.BOLD,14));
		result_player1.setBorder(BorderFactory.createBevelBorder(1));
		result_player1.setHorizontalAlignment(JTextField.CENTER);
		result_player1.setEditable(false);

		result_player2.setBounds(270,325,200,100);
		result_player2.setBackground(new Color(25,25,25));
		result_player2.setForeground(new Color(25,255,0));
		result_player2.setFont(new Font("Ink Free",Font.BOLD,14));
		result_player2.setBorder(BorderFactory.createBevelBorder(1));
		result_player2.setHorizontalAlignment(JTextField.CENTER);
		result_player2.setEditable(false);

		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(question_label);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public void nextQuestion() {
		
		// if there is another question
	    if(index<total_questions) {	
	    
	    	 
	        // if it is player's two turn
	        if (username2!=null && turn==true){
	        	textfield.setText("Player2: "+username2);
	        	frame.getContentPane().setBackground(new Color(255,102,102));
		        	textfield.setForeground(new Color(255,102,102));
		        	turn=false;
			    
		
			//if it is player's one turn    
	        } else if(username2!=null && turn==false){
	        	frame.getContentPane().setBackground(new Color(112, 128, 160));
	        	textfield.setForeground(new Color(112, 128, 160));
	        	textfield.setText("Player1: "+username);
	        	turn=true;
	        
	        	//if there is only one player
	        } else {
	
	        	frame.getContentPane().setBackground(new Color(112, 128, 160));
	        	textfield.setForeground(new Color(112, 128, 160));
	        	textfield.setText("Player: "+username);
	        	turn=true;
	        	
	        
	        }
	      
	        //initiate question
	        question_label.setText(questions[index]);
	        answer_labelA.setText(options[index][0]);
	        answer_labelB.setText(options[index][1]);
	        answer_labelC.setText(options[index][2]);
	        answer_labelD.setText(options[index][3]);
	        ImageIcon image= new ImageIcon(images[index]);
	        question_icon.setIcon(image);
	        question_icon.setBounds(30, 120, 400, 250);
	        frame.add(question_icon);
	        
	        //start timer
	        timer.start();
	  
	    //game ends     
	    } else {
	    	
	    	buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
            
			textfield.setText("Results");
			question_label.setText("");
			answer_labelA.setText("");
			answer_labelB.setText("");
			answer_labelC.setText("");
			answer_labelD.setText("");
			
			//results for 2 players
			if (username2!=null) {
				result_player1.setText(username+": "+score_player1);
				result_player2.setText(username2+": "+score_player2);
				frame.add(result_player1);
				frame.add(result_player2);
				
				
			} else { //results for 1 player
				result_player1.setText(username+": "+score_player1);
				frame.add(result_player1);
				
				//saving player's score
				Score sc = new Score();
				sc.addScore(username,score_player1);
				
			}

				

				
				
				
		}
		
				
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {

	buttonA.setEnabled(false);
	buttonB.setEnabled(false);
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);


	if(e.getSource()==buttonA) {
	answer= 'A';
	//if player gave right answer
	if(answer == answers[index]) {
		if(turn==true) {
			score_player1=score_player1+100;
		} else {
			score_player2=score_player2+100;
		}
		
		
	}
	}
	
	if(e.getSource()==buttonB) {
	answer= 'B';
	//if player gave right answer
	if(answer == answers[index]) {
		if(turn==true) {
			score_player1=score_player1+100;
		} else {
			score_player2=score_player2+100;
		}
	}
	}
	
	if(e.getSource()==buttonC) {
	answer= 'C';
	//if player gave right answer
	if(answer == answers[index]) {
		if(turn==true) {
			score_player1=score_player1+100;
		} else {
			score_player2=score_player2+100;
		}
	}
	}
	if(e.getSource()==buttonD) {
	answer= 'D';
	//if player gave right answer
	if(answer == answers[index]) {
		if(turn==true) {
			score_player1=score_player1+100;
		} else {
			score_player2=score_player2+100;
		}
	}
	}
	displayAnswer();
	}
	
	
	// show the right answer
	public void displayAnswer() {

	timer.stop();

	buttonA.setEnabled(false);
	buttonB.setEnabled(false);
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);

	//change wrong answers red
	if(answers[index] != 'A')
	answer_labelA.setForeground(new Color(255,0,0));
	if(answers[index] != 'B')
	answer_labelB.setForeground(new Color(255,0,0));
	if(answers[index] != 'C')
	answer_labelC.setForeground(new Color(255,0,0));
	if(answers[index] != 'D')
	answer_labelD.setForeground(new Color(255,0,0));

	//stop and restart timer
	Timer pause = new Timer(2000, new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {

	answer_labelA.setForeground(new Color(25,25,25));
	answer_labelB.setForeground(new Color(25,25,25));
	answer_labelC.setForeground(new Color(25,25,25));
	answer_labelD.setForeground(new Color(25,25,25));

	answer = ' ';
	seconds=60;
	seconds_left.setText(String.valueOf(seconds));
	buttonA.setEnabled(true);
	buttonB.setEnabled(true);
	buttonC.setEnabled(true);
	buttonD.setEnabled(true);
	index++;
	nextQuestion();
	}
	});
	pause.setRepeats(false);
	pause.start();
	}
	
	
}

