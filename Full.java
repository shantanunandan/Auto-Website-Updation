package ResumeUpdate;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Full {

   @SuppressWarnings("serial")
     Full(final String massage) {
      final JLabel label = new JLabel();
      int timerDelay = 1000;
      new Timer(timerDelay , new ActionListener() {
         int timeLeft = 4;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (timeLeft > 0) {
               label.setText(massage+"\n"+"Closing in " + timeLeft + " seconds");
               timeLeft--;
            } else {
               //((Timer)e.getSource()).stop();
               Window win = SwingUtilities.getWindowAncestor(label);
               win.setVisible(false);
            }
         }
      }){{setInitialDelay(0);}}.start();

      JOptionPane.showMessageDialog(null, label);

   }
public void j() throws InterruptedException{  new OutputDisplay("We are checking for account validation"+"\n"
	 		+ "If user id and password matches then we will goto websites for updation. " +"\n"
	 		+ "Please Wait....",4*1000);
}

Full() throws InterruptedException{
	j();
}
   public static void main(String[] args) throws InterruptedException {
     
         Full f =  new Full("gf");
           new Full("jhsf"+
           "\n"+"jgfd"
        		   );
         //f.j();
           new Full();
   }
}
