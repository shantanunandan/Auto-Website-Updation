package ResumeUpdate;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.*;

public class Screen_1 {
	FileReader read;
	BufferedReader data;
	FileWriter file;
	BufferedWriter write ;
	boolean flag,flag1;
	JFrame Screen1, Screen2;
	JPanel ButtonPanel1,ButtonPanel2;
	JLabel loginLabel1,passwordLabel,passwordLabel1,naukariLoginLabel,naukariPasswordLabel,monsterLoginLabel,monsterPasswordLabel
	,shineLoginLabel,shinePasswordLabel,timesLoginLabel,timesPasswordLabel;
	JTextField Login,RePassword,naukariLogin,naukariPassword,monsterLogin,monsterPassword,shineLogin,shinePassword,timesLogin,timesPassword;
	JPasswordField Password;
	JButton Submit1,Submit2,Reset,NewUser,Cancel1,Cancel2;
	String Login1,Password1,RePassword1,naukariLogin1,naukariPassword1,monsterLogin1,monsterPassword1,shineLogin1,shinePassword1,timesLogin1,timesPassword1;
    
	
	//Writing relative path for the application
	public String path = new File("").getAbsolutePath();
	
	//writing data on notepad
	public void write(String input) throws IOException{
		try{
		file = new FileWriter(path+"\\TextFile.txt",true);
	
		write = new BufferedWriter(file);
		write.write(input);
		//System.out.println(input);
		write.newLine();
		write.close();
		//System.out.println("write");

		}//try
		catch(Exception e){
			e.printStackTrace();
		}//catch
		finally{
			write.close();
		}//finally
	  }//write
	
	
	//Reading data from notepad
	public String read(int num) throws IOException{
			String readdata;
			String[] data1=new String[20];
	       try {
			//String[] s;
	    	System.out.println(path);
			read = new FileReader(path+"\\TextFile.txt");
			data = new BufferedReader(read);
			
			//while(data.readLine() != null){
				for(int i=0; i<data1.length;i++){
					data1[i]=data.readLine();
					if(data1[i] == null){
					break;
					}//if
					//else{
					//	readdata=data1[num];
					 	//System.out.println(data1[i] + i);
					 //	System.out.println(data1.length);
				//	}//else
			
				}//for
				 // }//while
		}//try
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}//catch
		finally{
			data.close();
		}//finally
		//System.out.println(data1[0]);
	    readdata=data1[num];
		return readdata;
		}//read

	public boolean caseSensitiveComparision(String text1, String text2){
		if(text1.length() == text2.length()){
		flag=text1.equals(text2);
		System.out.println(flag);
		}
		return flag;
	}//caseSensitiveComparision
	
	public boolean ignoreCaseComparision(String text1, String text2){
		if(text1.length() == text2.length()){
		flag1=text1.equalsIgnoreCase(text2);
		System.out.println(flag1);
		}
		return flag1;
	}//ignorecaseComparision
	
	public String masterUserNamePopup( String dataFromUser , JTextField f,JFrame frame) throws IOException{
		//System.out.println(read(0));
		String dataFromDB=read(0);
		if((dataFromUser.length() == 0)){
		JOptionPane.showMessageDialog(frame,
			    " Login/Password is either blank or incorrect",
			    "Warning",
			    JOptionPane.WARNING_MESSAGE);
		f.requestFocus();
		//return text;
		}
		else if((ignoreCaseComparision(dataFromDB, dataFromUser)== false)){
			JOptionPane.showMessageDialog(frame,
				    " Login/Password is either blank or incorrect",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
			f.requestFocus();
		}
		return dataFromUser;
	}//popup1
	
	
	public String masterPassPopup( String dataFromUser , JTextField f,JFrame frame) throws IOException{
		//System.out.println(read(1));
		String dataFromDB=read(1);
		if((dataFromUser.length() == 0)){
		JOptionPane.showMessageDialog(frame,
			    " Login/Password is either blank or incorrect",
			    "Warning",
			    JOptionPane.WARNING_MESSAGE);
		f.requestFocus();
		//return text;
		}
		else if((caseSensitiveComparision(dataFromDB, dataFromUser)== false)){
			JOptionPane.showMessageDialog(frame,
				    " Login/Password is either blank or incorrect",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
			f.requestFocus();
		}
		return dataFromUser;
	}//popup1
	
	public String popup(String button, String text , JTextField f,JFrame frame){
		 if(text.length() == 0  ){	
		JOptionPane.showMessageDialog(frame,
			    button+" field is blank ....",
			    "Warning",
			    JOptionPane.WARNING_MESSAGE);
		f.requestFocus();
		 }
		return text;
	}//popup2
	
	public Screen_1(){
		Screen1 = new JFrame("Login");
		Screen1.setLocation(520, 220);
		ButtonPanel1 = new JPanel();
		loginLabel1 = new JLabel("UserID");
		passwordLabel = new JLabel("Password");
		loginLabel1.setPreferredSize(new Dimension(256, 24));
		passwordLabel.setPreferredSize(new Dimension(256, 24));
		Login = new JTextField();
	//	Login.addActionListener(new LoginLitner());
		Password = new JPasswordField();
   //	Password.addActionListener(new PasswordListner());
		Submit1 = new JButton("Sign In");
		//Adding Litstener to Submit button
		Submit1.addActionListener(new Submit1Listner());
		NewUser= new JButton("New User");
		NewUser.addActionListener(new NewUserListener());
		Cancel1=new JButton("Cancel");
		Cancel1.addActionListener(new Cancel1Listener());
		ButtonPanel1.setLayout(new BoxLayout(ButtonPanel1,BoxLayout.Y_AXIS));
		//setting the size of panel
		ButtonPanel1.add(loginLabel1);
		//Added loginlabel to panel
		ButtonPanel1.add(Login);
		//Added login textfeild to panel
		ButtonPanel1.add(passwordLabel);
		//Added passwordlabel to panel
		ButtonPanel1.add(Password);
		//Added password textfeild to panel
		ButtonPanel1.add(Submit1);
		//Added submit button to panel
		ButtonPanel1.add(NewUser);
		ButtonPanel1.add(Cancel1);
		Screen1.getContentPane().add(BorderLayout.CENTER, ButtonPanel1);
		//Added panel to frame
		Screen1.pack();
		Screen1.setVisible(true);
		Screen1.setResizable(false);
		//Made the frame visible
		CloseListener cl = new CloseListener(
	    	    "Are you sure you want to exit the application",
	    	    "Exit Application");
	    	//Screen1 = new JFrame("Closing an Application");
	    	Screen1.addWindowListener( cl );
		//Closing operation of frame
	}// implement method
	

	public static void main(String args[]) throws InterruptedException{
		Screen_1 screen1 = new Screen_1();
	}// main method
	
	 public void secondScreen(){
		 Screen2 =new JFrame("Master Login");
		 Screen2.setLocation(520, 140);
		 ButtonPanel2= new JPanel();
		 loginLabel1 = new JLabel("New UserID");
		 loginLabel1.setPreferredSize(new Dimension(256, 24));
		 passwordLabel = new JLabel("New Password");
		 passwordLabel.setPreferredSize(new Dimension(256, 24));
		 passwordLabel1= new JLabel("Re-Enter New Password");
		 passwordLabel1.setPreferredSize(new Dimension(256, 24));
		 Login = new JTextField();
		 Password = new JPasswordField();
		 RePassword = new JTextField();
		 ButtonPanel2.add(loginLabel1);
		 ButtonPanel2.add(Login);
		 ButtonPanel2.add(passwordLabel);
		 ButtonPanel2.add(Password);
		 ButtonPanel2.add(passwordLabel1);
		 ButtonPanel2.add(RePassword);
		 naukariLoginLabel= new JLabel("Naukari User_ID");
		 naukariLoginLabel.setPreferredSize(new Dimension(256, 24));
		 naukariLogin= new JTextField();
		 naukariPasswordLabel= new JLabel("Naukari Password");
		 naukariPasswordLabel.setPreferredSize(new Dimension(256, 24));
		 naukariPassword= new JTextField();
		 ButtonPanel2.add(naukariLoginLabel);
		 ButtonPanel2.add(naukariLogin);
		 ButtonPanel2.add(naukariPasswordLabel);
		 ButtonPanel2.add(naukariPassword);
		 monsterLoginLabel= new JLabel("Monster User_ID");
		 monsterLoginLabel.setPreferredSize(new Dimension(200, 25));
		 monsterLogin= new JTextField();
		 monsterPasswordLabel= new JLabel("Monster Password");
		 monsterPasswordLabel.setPreferredSize(new Dimension(200, 25));
		 monsterPassword= new JTextField();
		 ButtonPanel2.add(monsterLoginLabel);
		 ButtonPanel2.add(monsterLogin);
		 ButtonPanel2.add(monsterPasswordLabel);
		 ButtonPanel2.add(monsterPassword);
		 shineLoginLabel= new JLabel("Shine Login_ID");
		 shineLoginLabel.setPreferredSize(new Dimension(200, 25));
		 shineLogin= new JTextField();
		 shinePasswordLabel= new JLabel("Shine Password");
		 shinePasswordLabel.setPreferredSize(new Dimension(200, 25));
		 shinePassword= new JTextField();
		 ButtonPanel2.add(shineLoginLabel);
		 ButtonPanel2.add(shineLogin);
		 ButtonPanel2.add(shinePasswordLabel);
		 ButtonPanel2.add(shinePassword);
		 timesLoginLabel= new JLabel("TimesJob Login_ID");
		 timesLoginLabel.setPreferredSize(new Dimension(200, 25));
		 timesLogin= new JTextField();
		 timesPasswordLabel= new JLabel("TimesJob Password");
		 timesPasswordLabel.setPreferredSize(new Dimension(200, 25));
		 timesPassword= new JTextField();
		 ButtonPanel2.add(timesLoginLabel);
		 ButtonPanel2.add(timesLogin);
		 ButtonPanel2.add(timesPasswordLabel);
		 ButtonPanel2.add(timesPassword);
		 Submit2= new JButton("Submit");
		 Submit2.addActionListener(new Submit2Litenear());
		 ButtonPanel2.add(Submit2);
		 Reset=new JButton("Reset");
		 Reset.addActionListener(new ResetListener());
		 ButtonPanel2.add(Reset);
		 ButtonPanel2.setLayout(new BoxLayout(ButtonPanel2,BoxLayout.Y_AXIS));
		 Screen2.getContentPane().add(BorderLayout.CENTER,ButtonPanel2);
		 Screen2.pack();
		 Screen2.setVisible(true);
		 Screen2.setResizable(false);
		 Screen2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 CloseListener cl = new CloseListener(
		    	    "The action will erase all your data. Are you sure you want to exit the application ?",
		    	    "Exit Application");
		    	//Screen1 = new JFrame("Closing an Application");
		    	Screen2.addWindowListener( cl );
	 }// secondScreen method
    
    /**
     *  This class will help you take control of the frame closing process by
     *  providing a WindowListener with some common features that might be used
     *  when closing an application. That is you can:
     *	<ul>
     *  <li>display an application closing confirmation message which will give
     *    the user a chance to cancel the close request
     *  <li>invoke a provide Action. This action might be used to save the state
     *    of the application for the next time it is used.
     *  </ul>
     *
     *  This class will invoke the setDefaultCloseOperation(...) method with an
     *  appropriate value. The default will be set to EXIT_ON_CLOSE. The default
     *  can be changed by invoking the setDisoseOnClose() method with "true", in
     *  which case DISPOSE_ON_CLOSE will be used. This value will be set to
     *  DO_NOTHING_ON_CLOSE if the user does not confirm the application closing
     *  message. Finally, the close action is free to set this property to any
     *  value.
     */
    public class CloseListener extends WindowAdapter
    {
    	private String message;
    	private String title;
    	private Action closeAction;
    	private boolean disposeOnClose = false;

    	/**
    	 *  Display a confirmation message upon closing the application
    	 *
    	 *  @param message  the confirmation message
    	 *  @param title    the text used for the title bar of the dialog
    	 */
    	public CloseListener(String message, String title)
    	{
    		this(message, title, null);
    	}

    	/**
    	 *  Specify an Action to be invoked upon closing the application.
    	 *
    	 *  @param closeAction  the Action to be invoked upon closing the application
    	 */
    	public CloseListener(Action closeAction)
    	{
    		this(null, null, closeAction);
    	}

    	/**
    	 *  Display a confirmation message upon closing the application and
    	 *	and invoke a closing action.
    	 *
    	 *  @param message      the confirmation message
    	 *  @param title        the text used for the title bar of the dialog
    	 *  @param closeAction  the Action to be invoked upon closing the application
    	 */
    	public CloseListener(String message, String title, Action closeAction)
    	{
    		this.message = message;
    		this.title = title;
    		this.closeAction = closeAction;
    	}

    	/**
    	 *  Set the default close operation to be dispose on close. Typically would
    	 *  be used in a multi frame application. This way only when the last frame
    	 *  is closed will the JVM be shut down.
    	 *
    	 *  @param disposeOnClose  true for DISPOSE_ON_CLOSE, false for EXIT_ON_CLOSE
    	 */
    	public void setDisposeOnClose(boolean disposeOnClose)
    	{
    		this.disposeOnClose = disposeOnClose;
    	}

    	@Override
    	public void windowClosing(WindowEvent e)
    	{
    		Screen1 = (JFrame)e.getComponent();

    		//  Confirm with the user to close the frame

    		if (! confirmWindowClosing(Screen1))
    		{
    			Screen1.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
    			return;
    		}

    		//  Set the close option. Setting it here allows the close action to
    		//  prevent the window from closing by resetting the close option to
    		//  DO_NOTHING_ON_CLOSE.

    		if (disposeOnClose)
    			Screen1.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    		else
    			Screen1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    		//  Confirmation received, so do the exit processing

    		if (closeAction != null)
    		{
    			ActionEvent ae = new ActionEvent(Screen1, ActionEvent.ACTION_PERFORMED, "");
    			closeAction.actionPerformed( ae );
    		}
    	}

    	private boolean confirmWindowClosing(JFrame frame)
    	{
    		if (message == null) return true;

    		int result = JOptionPane.showConfirmDialog(
    			frame,
    			message,
    			title,
    			JOptionPane.YES_NO_OPTION);

    		return (result == JOptionPane.YES_OPTION) ? true : false;
    	}//confirmWindowClosing
    }//CloseListener
    
    public void close(){
    CloseListener cl = new CloseListener(
    	    "Are you sure you want to exit the application",
    	    "Exit Application");
    	//Screen1 = new JFrame("Closing an Application");
    	Screen1.addWindowListener( cl );
    }
    
    public class Cancel1Listener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
    		int n = JOptionPane.showConfirmDialog(
    			    Screen1,
    			    "Would you like exit ?",
    			    "Warning",
    			    JOptionPane.YES_NO_OPTION);
    		  if(n == 0){
    			  Screen1.setVisible(true);
            	  Screen1.dispose();
    			  System.out.println(JOptionPane.YES_OPTION);
              }
         }//Warning Box
    }//NewUserListener
    
    //MAster login credentials comapare and taking
    public class Submit1Listner implements ActionListener {
    	public void actionPerformed(ActionEvent ev) {
			try {
				new Full();
				new OutputDisplay("We are checking for account validation"+"\n"
				 		+ "If user id and password matches then we will goto websites for updation. " +"\n"
				 		+ "You will get a complete report once we are done",4*1000);
				 new OutputDisplay(path+"\n"+"You can get the complete updation report"+"\n"+"from the above address",1*60*1000);
			     Login1=masterUserNamePopup(Login.getText(),Login,Screen1);
			     //read(0); 
			    // System.out.println(read(0));
    		     Password1=masterPassPopup(Password.getText(),Password, Screen1);
    		     //read(1);
    		    // System.out.println(read(1));
			     Submit1.setText("Please Wait....");
			     if(flag==true && flag1==true){
			    	 (new Screen_1_Naukari()).operation(read(7),read(8));
			    	 (new Screen_1_Monster()).operation(read(9),read(10));
			    	 (new Screen_1_Shine()).operation(read(5),read(6));
			    	 (new Screen_1_Times()).operation(read(3),read(4));
			    	 
			     }//if
			}//try
			catch (IOException e) {
				e.printStackTrace();
			}//catch
 catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}//actionPerformed method of SubmitLitner
    }//SubmitListner1 class
    
    
    //New user button ....
    public class NewUserListener implements ActionListener{
    	public void actionPerformed(ActionEvent ev){
    		secondScreen();
    	}//actionperformed
    }//NewUserListener
    
    public void reset(JTextField j){
    	j.setText(null);
    }//reset
    
    
    //reset button
    public class ResetListener implements ActionListener{
    	public void actionPerformed(ActionEvent ev){
    		int n = JOptionPane.showConfirmDialog(
    			    Screen2,
    			    "This action will erase all data. You still want to continue ?",
    			    "Warning",
    			    JOptionPane.YES_NO_OPTION);
    		  if(n == 0){
    		reset(naukariLogin);
    		reset(naukariPassword);
    		reset(monsterLogin);
    		reset(monsterPassword);
    		reset(shineLogin);
    		reset(shinePassword);
    		reset(timesLogin);
    		reset(timesPassword);
    	  }//if
    	}//actionperformed
    }//resetlistner
    
    
    //new user form submit
    public class Submit2Litenear implements ActionListener{
    	@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent ev){
    		try{
    		Submit2.setText("Please Wait.....");
    		String[] data={Login.getText(),Password.getText(),RePassword.getText(),naukariLogin.getText(),naukariPassword.getText(),monsterLogin.getText(),monsterPassword.getText(),
    				        shineLogin.getText(),shinePassword.getText(),timesLogin.getText(),timesPassword.getText() };
    		
    		for(int i=0;i<20;i++){
    			System.out.println(data.length);
    		
    			if(data[0].length()==0){
  		          Login1=popup("Master Login username feild is blank",(Login.getText()),Login,Screen2);
  			      break; 
  			    }else{ Login1=Login.getText();
  			    write(Login1);
  			    //data1[0]=Login1;
  			    }

    			if(data[1].length()==0){
    		          Password1=popup("Master Login password feild is blank",(Password.getText()),Password,Screen2);
    			      break; 
    			    }else{ Password1=Password.getText();
    			    write(Password1);
    			    //data1[1]=Password1;
    			    }
    			
    			if(data[2].length()==0){
    		          RePassword1=popup("Master Login password feild is blank",(RePassword.getText()),RePassword,Screen2);
    			      break; 
    			    }else{ RePassword1=RePassword.getText();
    			    write(RePassword1);
    			    //data1[2]=RePassword1;
    			    }
    			
    			if((caseSensitiveComparision(data[1], data[2])== false)){
    				JOptionPane.showMessageDialog(Screen2,
    					    " Master Login Password does't match. Please re-enter....",
    					    "Warning",
    					    JOptionPane.WARNING_MESSAGE);
    				RePassword.requestFocus();
    				break;
    			}//password comparision
    			
    			if(data[3].length()==0){
    		          naukariLogin1=popup("Naukari username feild is blank",(naukariLogin.getText()),naukariLogin,Screen2);
    			      break; 
    			    }else{ naukariLogin1=naukariLogin.getText();
    			    write(naukariLogin1);
    			    //data1[3]=naukariLogin1;
    			    }
    			
    			if(data[4].length()==0){
    		         naukariPassword1=popup("Naukari password feild is blank",(naukariPassword.getText()),naukariPassword,Screen2);
    		         break;  
    		        }else{ naukariPassword1=naukariPassword.getText();
    		        write(naukariPassword1);
    		        //data1[4]=naukariPassword1;
    			    }
    			
    			if(data[5].length()==0){
    		         monsterLogin1=popup("Monster username feild is blank",(monsterLogin.getText()),monsterLogin,Screen2);
    		         break;  
    		         }else{ monsterLogin1=monsterLogin.getText();
    		         write(monsterLogin1);
    		         //data1[5]=monsterLogin1;
     			    }
    			
    			if(data[6].length()==0){
    			     monsterPassword1=popup("Monster password feild is blank",(monsterPassword.getText()),monsterPassword,Screen2);
    		         break;  
    		         }else{ monsterPassword1=monsterPassword.getText();
    		         write(monsterPassword1);
    		         //data1[6]=monsterPassword1;
     			    }
    			
    			if(data[7].length()==0){
    		         shineLogin1=popup("Shine username feild is blank",(shineLogin.getText()),shineLogin,Screen2);
    		         break;  
    		         }else{ shineLogin1=shineLogin.getText();
    		         write(shineLogin1);
    		         //data1[7]=shineLogin1;
     			    }
    			
    			if(data[8].length()==0){
    		         shinePassword1=popup("Shine password feild is blank",(shinePassword.getText()),shinePassword,Screen2);
    		         break;  
    		         }else{ shinePassword1=shinePassword.getText();
    		         write(shinePassword1);
    		         //data1[8]=shinePassword1;
     			    }
    			
    			if(data[9].length()==0){
    		         timesLogin1=popup("TimesJobs username feild is blank",(timesLogin.getText()),timesLogin,Screen2);
    		         break;  
    		         }else{ timesLogin1=timesLogin.getText();
    		         write(timesLogin1);
    		         //data1[9]=timesLogin1;
     			    }
    			
    			if(data[10].length()==0){
    		         timesPassword1=popup("TimesJobs password feild is blank",(timesPassword.getText()),timesPassword,Screen2);
    		         break;  
    		         }else{ timesPassword1=timesPassword.getText();
    		         write(timesPassword1);
    		         //data1[10]=timesPassword1;
     			    }
    			break;
    		}//for
    	  }//try
    	  catch(Exception e){
    		  e.printStackTrace();
    		  }//catch	
    	  }//actionperformed
    }//Submit2Listener
}//outer class

