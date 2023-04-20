/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.arxml_reorder;
/**
 * @author Eng. Sarah
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

 
public class ARXML_Reorder {

    public static void main(String[] args) {
      try{
      String fileName =args[0];
      if(!fileName.endsWith(".arxml")){
      throw new NotValidExtension("invalid file extension"); 
      }
      File file=new File(fileName);
      FileInputStream inputStream= new FileInputStream(file);
      int x;
      StringBuilder stringBuilder= new StringBuilder();
      while((x=inputStream.read())!= -1){
      stringBuilder.append((char)x);
      }
      String data =stringBuilder.toString();
      Scanner scanner =new Scanner (data);
      ArrayList<Containter> Containers =new ArrayList<>();
      while(scanner.hasNextLine()){
      String line =scanner.nextLine();
      if(line.contains("<CONTAINER")){
      String ContainterUUID =line.substring(line.indexOf("UUID="), line.indexOf(">"));
      String SHORT_NAME=scanner.nextLine();
      String SHORT =SHORT_NAME.substring(SHORT_NAME.indexOf(">")+1, SHORT_NAME.indexOf("</"));
//      System.out.println(SHORT);
      String LONG_NAME =scanner.nextLine();
      String LONG =LONG_NAME.substring(LONG_NAME.indexOf(">")+1, LONG_NAME.indexOf("</"));                                                                   
      Containter container=new Containter();
      container.setContainterUUID(ContainterUUID);
      container.setSHORT_NAME(SHORT);
      container.setLONG_NAME(LONG);
      Containers.add(container);
      }
      }
//      System.out.println(Containers.get(0).getSHORT_NAME());
      Collections.sort(Containers);
//      System.out.println(Containers.get(0).getSHORT_NAME());
      String outName =fileName.substring(0,fileName.indexOf("."))+"_mod.arxml";
      FileOutputStream outputStream =new FileOutputStream(outName);
      outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
      outputStream.write("<AUTOSAR>\n".getBytes()); 
      for(int i=0;i<Containers.size();i++){
      outputStream.write(Containers.get(i).toString().getBytes());
      }
      outputStream.write("<AUTOSAR>\n".getBytes());
      }  
      catch(FileNotFoundException error){
         error =new FileNotFoundException("File is not found !");}
      catch(IOException error){  
         error =new IOException("IO Exception !"); }
       catch(NotValidExtension error){
         error =new NotValidExtension("NotValid !");
    }
    }  
       
    }
class NotValidExtension extends Exception {
    
    public NotValidExtension(String message) {
        System.out.println(message);
    }
    
}
class Containter implements Comparable<Containter>{
        private String ContainterUUID ;
        private String SHORT_NAME ;
        private String LONG_NAME ;
        
            public String getContainterUUID(){
            return ContainterUUID;
            }
            public String getSHORT_NAME(){
            return SHORT_NAME;
            }
            public String getLONG_NAME(){
                return LONG_NAME;
            }
            public void setContainterUUID(String ContainterUUID){
            this.ContainterUUID=ContainterUUID;
            }
            public void setSHORT_NAME(String SHORT_NAME){
            this.SHORT_NAME=SHORT_NAME;
            }
            public void setLONG_NAME(String LONG_NAME){
            this.LONG_NAME=LONG_NAME;
            }
        public Containter(){}
            @Override
            public String toString (){
                return "   <CONTAINER "+this.getContainterUUID()+">\n"
                     + "       <SHORT-NAME>"+this.getSHORT_NAME()+"</SHORT-NAME>\n"
                     + "       <LONG-NAME>"+this.getLONG_NAME()+"</LONG-NAME>\n"
                     + "   </CONTAINER>\n";}
            
          @Override
            public  int  compareTo(Containter C){ 
               if(this.getSHORT_NAME().charAt(9)> C.getSHORT_NAME().charAt(9)){
               return 1;
               }else if (this.getSHORT_NAME().charAt(9)<C.getSHORT_NAME().charAt(9)){
               return -1;
               }
               else{ return 0;}
            }

}

