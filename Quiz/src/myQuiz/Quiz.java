package myQuiz;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;


public class Quiz implements ActionListener{
	
	
	boolean multiplayer;
	
	JFrame frame = new JFrame();
	JLabel start; 
	JTextArea textarea2 = new JTextArea();
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton help;
	JTextField user1=new JTextField();;
	JTextField user2=new JTextField();;
   

   @Override
	public void actionPerformed(ActionEvent e) {
	 
	   //menu design
	   JFrame frame2 = new JFrame();
	   frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame2.setSize(800,800);
	   frame2.getContentPane().setBackground(new Color(112, 128, 160));
	   frame2.setLayout(null);
	   frame2.setResizable(false);
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
	   frame2.add(textarea);
		
	   //start button
	    button4=new JButton("Go");
	    button4.setBounds(340, 500, 100, 50);
		button4.addActionListener(this);
		button4.setBackground(Color.green);
		button4.setFont(new Font("Arial Unicode MS",Font.BOLD,25));
		frame2.add(button4);
	   
	   
		// 1 player button
		if (e.getActionCommand().equals("1 player")) {
			multiplayer=false;
			
			//add username to new frame
			JLabel user1_label;
			user1_label = new JLabel("Please enter username");
			user1.setBounds(285,300, 200,30);
			user1_label.setBounds(275,250, 500,50);
			user1_label.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,20));
			user1_label.setForeground(Color.white);
			user1.setText("");
			frame2.add(user1_label);
			frame2.add(user1);
			frame.dispose();
			frame2.show();
		
		
			//2 players button
		}else if (e.getActionCommand().equals("2 players")) {
			multiplayer=true;
			
			//add usernames to new frame
			JLabel user1_label;
			JLabel user2_label;
			user1_label= new JLabel("Please enter username for player 1");
			user2_label = new JLabel("Please enter username for player 2");
			user1_label.setBounds(215,150, 500,50);
			user2_label.setBounds(215,300, 500,50);
			user1.setBounds(285,200, 200,30);
			user2.setBounds(285,350, 200,30); 
			user1_label.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,20));
			user1_label.setForeground(Color.white);
			user2_label.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,20));
			user2_label.setForeground(Color.white);
			frame2.add(user1);
			frame2.add(user2);
			frame2.add(user1_label);
			frame2.add(user2_label);
			
			frame.dispose();
			frame2.show();
		
			
		//start game button
		}else if(e.getActionCommand().equals("Go")) {
			frame2.dispose();
			
			//if it is one player
			if( multiplayer==false) {
				 //check username	
				if(user1.getText().equals("")) {
					
					JOptionPane.showMessageDialog(frame2, "Please enter username.");
					
					
				 //start questions
				}else {
			        Question quest= new Question(user1.getText());
			        quest.nextQuestion();
				}
			
				//if there are two players
			}else {
				//check usernames
				if (user1.getText().equals("")) {
					JOptionPane.showMessageDialog(frame2, "Please enter username for player one.");
					
				
				} else if (user2.getText().equals("")) {
					JOptionPane.showMessageDialog(frame2, "Please enter username for player two.");
					
					
				} else {
					 //start questions
					Question quest= new Question(user1.getText(),user2.getText());
					quest.nextQuestion();
				}
	
			}
			
		// see high score button	
		}else if (e.getActionCommand().equals("High score")) {
		    
		    Score score = new Score();
		    score.showHighscore();
		
		//help button
		}else if (e.getActionCommand().equals("Help")) {
		    
			ShowInstructions();
		   
		    	
		}
		
	}
		public Quiz() {
			
	   }
		

	public void ShowMenu() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(112, 128, 160));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textarea2.setBounds(0,0,800,50);
		textarea2.setLineWrap(true);
		textarea2.setWrapStyleWord(true);
		textarea2.setBackground(new Color(25,25,25));
		textarea2.setForeground(new Color(50, 150, 250));
		textarea2.setFont(new Font("Arial Unicode MS",Font.BOLD,25));
		textarea2.setBorder(BorderFactory.createBevelBorder(1));
		textarea2.setEditable(false);
		textarea2.setText("MytholoQuiz");
		frame.add(textarea2);
		
		start = new JLabel("Welcome");
		start.setForeground(Color.white);
		start.setBounds(285, 90, 500, 100);
		//start.setBackground();
		start.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,50));
		frame.add(start);
		
		//1 player button
		button1=new JButton("1 player");
		button1.setBounds(285, 250, 200, 50);
		button1.addActionListener(this);
		button1.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,20));
		frame.add(button1);
		
		//2 players button
		button2=new JButton("2 players");
		button2.setBounds(285, 320, 200, 50);
		button2.addActionListener(this);
		button2.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,20));
		frame.add(button2);
		
		// see high score
		button3=new JButton("High score");
		button3.setBounds(285, 390, 200, 50);
		button3.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,20));
		button3.addActionListener(this);
		frame.add(button3);
		
		// open instructions
		help= new JButton("Help");
		help.setBounds(285, 460, 200, 50);
		help.addActionListener(this);
		help.setFont(new Font("Arial Unicode MS" ,Font.PLAIN,20));
		frame.add(help);
		
		
		frame.show();
	}
	public void ShowInstructions() {
		
		// help frame design
		JFrame help_frame = new JFrame();
		JLabel help_label = new JLabel();
		help_frame.setSize(800,800);
		help_frame.getContentPane().setBackground(new Color(112, 128, 160));
		help_frame.setLayout(null);
		help_frame.setResizable(false);
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
	    help_frame.add(textarea);
		help_label.setFont(new Font("Arial Unicode MS",Font.BOLD,16));
		help_label.setBounds(100, 100, 400, 450);
		help_label.setText("<html>Απαντήστε σωστά σε όσες περισσότερες ερωτήσεις μπορείτε και κερδίστε πόντους!!<br>"
				          + "Πατήστε την επιλογή '1 player' για έναν παίκτη<br> ή την επιλογή '2 players' και <br> "
				          + "ανταγωνιστείτε με κάποιο φίλο σας.<br><br>"
				          + "Για το παιχνίδι ενός παίκτη έχετε στην διάθεσή σας 60 δευτερόλεπτα για να επιλέξετε <br>"
				          + "ένα από τα κουμπιά A, B, C, D. Κάθε σωστή απάντηση λαμβάνει 100 πόντους. Επιλέξτε το <br>"
				          + "κουμπί 'High Score' για να δείτε το υψηλότερο σκόρ στο ατομικό παιχνίδι. <br><br>"
				          + "Για το παιχνίδι 2 παικτών έχετε στην διάθεσή σας 60 δευτερόλεπτα ο κάθε ένας για να <br>"
				          + "απαντήσετε εναλλάξ στις ερωτήσεις. Κάθε σωστή απάντηση λαμβάνει 100 πόντους. <br><br>"
				          + "Καλή διασκέδαση!!</html>");
		help_frame.add(help_label);
		help_frame.show();
	}


	public static void main(String[] args) {
	    
		Quiz quiz = new Quiz();
		quiz.ShowMenu();

	}

	    
	

}

	
