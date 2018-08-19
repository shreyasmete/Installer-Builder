/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author metes
 */
public class Setup extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
       Extract extract= new Extract();
        extract.addFiles();
        extract.createBin();
        extract.install();
        First welcome=  new First();
        welcome.setExtract(extract);
        welcome.myInit();
        
        Inters q1=  new Inters();
        q1.setExtract(extract);
        q1.myInit();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
