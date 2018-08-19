/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author metes
 */
public class First extends Greetings{
   @Override
   public void myInit(){
       super.myInit();
        javax.swing.JButton myb=new javax.swing.JButton();
        myb.setBounds((int)(2*R.WINDOW_WIDTH/3.3), bPanelHeight()/3,(int)( R.WIDTH/18), (int)(bPanelHeight()/2.3));
        myb.setText("Next >");
        myb.setVisible(true);
        myb.setEnabled(true);
        myb.addMouseListener(jButton1_MouseListener());
        setBottomComponent(myb);
        myb=new javax.swing.JButton();
        myb.setBounds((int)(2*R.WINDOW_WIDTH/2.55), bPanelHeight()/3,(int)( R.WIDTH/18), (int)(bPanelHeight()/2.3));
        myb.setText("Cancle");
        myb.setVisible(true);
        myb.setEnabled(true);
        myb.addMouseListener(jButton2_MouseListener());
        setBottomComponent(myb);
        javax.swing.JTextPane myl = new javax.swing.JTextPane();
        myl.setText("Welcome to the "+extract.getName()+" Setup Wizard.");
        myl.setFont(new java.awt.Font("Tahoma", 1, R.WINDOW_HEIGHT/15));
        myl.setBounds(5,10,getMiddleBounds().width,getMiddleBounds().height/5);
        myl.setEnabled(false);
        myl.setDisabledTextColor(Color.BLACK);
        setMiddleComponent(myl);
        myl = new javax.swing.JTextPane();
        myl.setText(extract.getFIRST_MESSAGE());
        myl.setFont(new java.awt.Font("Tahoma", 0, R.WINDOW_HEIGHT/30));
        myl.setBounds(5,getMiddleBounds().height/3,getMiddleBounds().width,getMiddleBounds().height);
        //myl.setEnabled(false);
        myl.setDisabledTextColor(Color.BLACK);
        setMiddleComponent(myl);
   }
    MouseListener jButton1_MouseListener(){
    
    return new MouseListener(){
          @Override
          public void mouseClicked(MouseEvent e) {
              System.out.println("Dabla re");
              Last welcome=  new Last();
              welcome.setExtract(extract);
              welcome.myInit();
              setVisible(false);
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
    
    MouseListener jButton2_MouseListener(){
    
    return new MouseListener(){
          @Override
          public void mouseClicked(MouseEvent e) {
              System.out.println("Dabla re");
              
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
