/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author metes
 */
public class Bin implements Serializable{
    static String SOURCE;
    static String DESTINATION;
    static String NAME_OF_PARENT="";
    static String NAME_APP="";
    static String FIRST_MESSAGE="";
    static String LICENSE_AGREEMENT="";
    static String FINISH_MESSAGE="";

    
    static byte[] leftImage;
    static byte[] iconImage;
    static Map <String,byte[]> data;
    static ArrayList <String> startProcesses;
    
    public static byte[] getIconImage() {
        return iconImage;
    }

    public void setIconImage(byte[] iconImage) {
        Bin.iconImage = iconImage;
    }
    
    public String getNAME_APP() {
        return NAME_APP;
    }

    public void setNAME_APP(String NAME_APP) {
        Bin.NAME_APP = NAME_APP;
    }
    
    
    public byte[] getLeftImage() {
        return leftImage;
    }

    public void setLeftImage(byte[] leftImage) {
        Bin.leftImage = leftImage;
    }
    
    public Bin() {
        Bin.startProcesses=new ArrayList<>();
        Bin.data = new Hashtable<>();
    }
    /**
     * @param SOURCE
     */
    public void setSOURCE(String SOURCE) {
        Bin.SOURCE = SOURCE;
    }

    public void setDESTINATION(String DESTINATION) {
        Bin.DESTINATION = DESTINATION;
    }
     public void addFile(File file){
            if(file.isDirectory()){
                File temp[] = file.listFiles();
                for(File i:temp)
                {
                    addFile(i);
                }
            }else{
            
                try {
                    String path=file.getAbsolutePath();
                    int startIndex=path.indexOf(NAME_OF_PARENT);
                    data.put(DESTINATION+"\\"+path.substring(startIndex),Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                    
                } catch (IOException ex) {
                    Logger.getLogger(Bin.class.getName()).log(Level.SEVERE, null, ex);
                }
                
           
            }
     }
     public void install(){
         data.entrySet().forEach((file) -> {
             String path=file.getKey();
             File temp=new File(path.substring(0, path.lastIndexOf("\\")));
             if(!temp.exists()){
                 System.out.println(path+" does not exists");
                 if(!temp.mkdirs()){
                     System.out.println(path+" failed to create");
                 }
                 
             }
             try {
                 Files.write(Paths.get(path), file.getValue());
                 
            
                 
             } catch (IOException ex) {
                 Logger.getLogger(Bin.class.getName()).log(Level.SEVERE, null, ex);
                 try {
                     FileOutputStream  fos =new FileOutputStream((temp=new File(path)));
                     fos.write(file.getValue());
                     fos.close();
                 } catch (FileNotFoundException ex1) {
                     Logger.getLogger(Bin.class.getName()).log(Level.SEVERE, null, ex1);
                 } catch (IOException ex1) {
                     Logger.getLogger(Bin.class.getName()).log(Level.SEVERE, null, ex1);
                 }
             }
        });
     
     }
       public void addFile(){
           File file=new File(SOURCE);
           NAME_OF_PARENT=file.getName();
           System.out.println(DESTINATION);
           addFile(file);
       }
       public void printPaths(){
           data.entrySet().stream().map((file) -> file.getKey()).forEachOrdered((path) -> {
               System.out.println(path);
        });
       }
       
}
