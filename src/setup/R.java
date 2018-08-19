/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Screen;


/**
 *
 * @author metes
 */
public class R {
    public static final int WIDTH=(int)(Screen.getPrimary().getVisualBounds().getWidth());
    public static final int HEIGHT=(int)(Screen.getPrimary().getVisualBounds().getHeight());
    public static final int WINDOW_WIDTH=(int)(Screen.getPrimary().getVisualBounds().getWidth()/2.65);
    public static final int WINDOW_HEIGHT=(int)(Screen.getPrimary().getVisualBounds().getHeight()/1.85);
    public static byte[] readFully(InputStream i){
        byte[] tempImage=null; 
        try {
            
            byte temp[]=new byte[1];
            tempImage=new byte[i.available()] ;
            for(int ii=0;i.read(temp,0,1)>0;ii++){
            tempImage[ii]=temp[0];
            }
        
                  
        } catch (IOException ex) {
            Logger.getLogger(Greetings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tempImage;
    }
}
