/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author metes
 */
public class Extract {
    Bin  bin;

    public Extract() {
        this.bin = new Bin();
    }

public void addFiles(){
        bin.setSOURCE("D:\\E\\Downloads\\Programs");
        bin.setDESTINATION("C:\\Program Files");
        bin.addFile();
        bin.printPaths();
        bin.setNAME_APP("JaiMata Di 2.0");
        setFIRST_MESSAGE("This will install "+bin.getNAME_APP()+" on your computer.\n\n"+
                "It is recommended that you close all other application before continuing.\n\n"+
                "Click Next to continue, or Cancle to exit Setup"
                );
            try {
            InputStream i= getClass().getResource("/setup/leftpanel.jpg").openStream();
            bin.setLeftImage(R.readFully(i));
            i= getClass().getResource("/setup/icon.png").openStream();
            bin.setIconImage(R.readFully(i));
          } catch (IOException ex) {
            Logger.getLogger(Greetings.class.getName()).log(Level.SEVERE, null, ex);
          }
        
}
public byte[] getLeftImage(){
return bin.getLeftImage();
}
public byte[] getIconImage(){
return Bin.getIconImage();
}


public String getName() {
        return bin.getNAME_APP();
    }

    public void setName(String name) {
        bin.setNAME_APP(name);
    }
public void createBin(){
try {
            File binFile=new File("Data0.bin");
    try (FileOutputStream fos = new FileOutputStream(binFile); 
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        oos.writeObject(bin);
    }
       
        } catch (IOException ex) {
            Logger.getLogger(Extract.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void install(){
    try {
            File binFile;
            binFile = new File("Data0.bin");
        try (FileInputStream fis = new FileInputStream(binFile); 
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            bin=(Bin)ois.readObject();
        }
       
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Extract.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    /*   DONT FORGET TO UN_COMMENT FOLLOWING */

             //bin.install();
}
   
  public static String getFIRST_MESSAGE() {
        return Bin.FIRST_MESSAGE;
    }

    public static void setFIRST_MESSAGE(String FIRST_MESSAGE) {
        Bin.FIRST_MESSAGE = FIRST_MESSAGE;
    }

    public static String getLICENSE_AGREEMENT() {
        return Bin.LICENSE_AGREEMENT;
    }

    public static void setLICENSE_AGREEMENT(String LICENSE_AGREEMENT) {
        Bin.LICENSE_AGREEMENT = LICENSE_AGREEMENT;
    }

    public static String getFINISH_MESSAGE() {
        return Bin.FINISH_MESSAGE;
    }

    public static void setFINISH_MESSAGE(String FINISH_MESSAGE) {
        Bin.FINISH_MESSAGE = FINISH_MESSAGE;
    }  
}
///*  String SOURCE="";
//    String DESTINATION="";*/