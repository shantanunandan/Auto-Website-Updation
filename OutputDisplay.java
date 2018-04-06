package ResumeUpdate;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
public class OutputDisplay {

	static JFrame frame;
	JPanel  panel;
	JTextArea area;

	    OutputDisplay(String ip,int time) throws InterruptedException{
		frame = new JFrame("Output");
		frame.setLocation(400, 220);
		panel = new JPanel();
		area = new JTextArea();
		area.setSize(200, 200);
		int j=0;
		String[] t = {ip}; 
	    for(int i=0;i<t.length;i++){
	    	area.append(t[i]+"\n");
	    }//for
		panel.add(area);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.pack();
		frame.setSize(400, 400);
		frame.setVisible(true);
	    Timer timer = new Timer(time, new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            frame.setVisible(false);
	        }
	    });
	    timer.start();
	    }
	 
	    OutputDisplay(String dialogue,String path,int time) throws InterruptedException{
		frame = new JFrame("Output");
		frame.setLocation(400, 220);
		panel = new JPanel();
		area = new JTextArea();
		area.setSize(200, 200);
		int j=0;
		String[] t = {dialogue}; 
	    for(int i=0;i<t.length;i++){
	    	area.append(t[i]+"\n");
	    }//for
		panel.add(area);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.pack();
		frame.setSize(400, 400);
		frame.setVisible(true);
    	Thread.sleep(time);
    	j++;
		if(j==1){
			frame.setVisible(false);
		}//if
		frame.setResizable(false);
	    }//constructor
	    
	    OutputDisplay(String dialogue,String path,String path1,int time) throws InterruptedException{
		frame = new JFrame("Output");
		frame.setLocation(400, 220);
		panel = new JPanel();
		area = new JTextArea();
		area.setSize(200, 200);
		int j=0;
		String[] t = {dialogue}; 
	    for(int i=0;i<t.length;i++){
	    	area.append(t[i]+"\n");
	    }//for
		panel.add(area);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.pack();
		frame.setSize(400, 400);
		frame.setVisible(true);
    	Thread.sleep(time);
    	j++;
		if(j==1){
			frame.setVisible(false);
		}//if
		frame.setResizable(false);
	    }//constructor
	    
	   static void dialogue (String massage) throws InterruptedException{
		  JFrame frame = new JFrame("Output");
			frame.setLocation(400, 220);
		  JPanel	panel = new JPanel();
		  JTextArea	area = new JTextArea();
			area.setSize(200, 200);
			int j=0;
			String[] t = {massage}; 
		    for(int i=0;i<t.length;i++){
		    	area.append(t[i]+"\n");
		    }//for
			panel.add(area);
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			frame.getContentPane().add(BorderLayout.CENTER, panel);
			frame.pack();
			frame.setSize(400, 400);
			frame.setVisible(true);
	    	Thread.sleep(20*1000);
	    	j++;
			if(j==1){
				frame.setVisible(false);
			}//if
			frame.setResizable(false);
	    }//dialogue
	    
	 public static void main(String[] args) throws InterruptedException{
		 new OutputDisplay("We are checking for account validation"+"\n"
		 		+ "If user id and password matches then we will goto websites for updation. " +"\n"
		 		+ "Please Wait....",2*1000);
	 }//main
	}//OutputDisplay


