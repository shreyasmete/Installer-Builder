/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author metes
 */
public class Last extends Greetings{
    @Override
   public void myInit(){
       super.myInit();
        javax.swing.JButton myb=new javax.swing.JButton();
        myb.setBounds((int)(2*R.WINDOW_WIDTH/3.3), bPanelHeight()/3,(int)( R.WIDTH/18), (int)(bPanelHeight()/2.3));
        myb.setText("Finish");
        myb.setVisible(true);
        myb.setEnabled(true);
        myb.addMouseListener(jButton1_MouseListener());
        setBottomComponent(myb);
        
        
   }
    MouseListener jButton1_MouseListener(){
    
    return new MouseListener(){
          @Override
          public void mouseClicked(MouseEvent e) {
              try {
                  System.out.println("Finished");
                  System.exit(1);
                  super.finalize();
              } catch (Throwable ex) {
                  Logger.getLogger(Last.class.getName()).log(Level.SEVERE, null, ex);
              }
          }

          @Override
          public void mousePressed(MouseEvent e) {
              }

          @Override
          public void mouseReleased(MouseEvent e) {
               }

          @Override
          public void mouseEntered(MouseEvent e) {
              }

          @Override
          public void mouseExited(MouseEvent e) {
              }

          
        };
    }
    
}
