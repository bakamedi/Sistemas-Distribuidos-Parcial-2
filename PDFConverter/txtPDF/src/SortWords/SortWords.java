/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Andres1
 */
public class SortWords {
    
    public static void main(String[] args) throws Exception {  
        selectTextFiles();
    }
    
    public static void selectTextFiles(){
        String path = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT","txt");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File[] Files=chooser.getSelectedFiles();
            System.out.println("Please wait...");
                 for( int i=0;i<Files.length;i++){
                     //System.out.println(Files[i].toString());
                     path = path + Files[i].toString();
                  }
            System.out.println(path);
            try{ 
                openFileTxt(path);
             }catch(Exception e){e.printStackTrace();}
            System.out.println("Sort File Complete");
        }
    }
    
    public static void openFileTxt(String pathFile) throws FileNotFoundException, IOException {
        ArrayList wordList = new ArrayList();
        String cadena;
        char ca ='\0';
        FileReader f = new FileReader(pathFile);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            for(int i = 0 ; i < cadena.length() ;i++){
                ca = cadena.charAt(i);
                if(Character.isLetter(ca)){
                    if(Character.isUpperCase(ca)){
                        if(ca == 'z'){
                            //System.out.println(ca);
                        }
                        ca = Character.toLowerCase(ca);
                        wordList.add((char)ca);
                    }if(Character.isLowerCase(ca)){
                        if(ca == 'z'){
                            //System.out.println(ca);
                        }
                        wordList.add((char)ca);
                    }
                    
                    //System.out.println(cadena.charAt(i));
                }
                    
            }
        }
        b.close();
        Collections.sort(wordList);
        //for(int i = 0 ; i < wordList.size() ; i++){
          //  System.out.println(wordList.get(i));
        //}
       wordCount(wordList);
    }
    
    public static void wordCount(ArrayList wl){
        int cont = 0,tam = wl.size() - 1;
        for(int i = 0 ; i < tam ; i++){
            if(wl.get(tam) != null){
                if(wl.get(i)!= wl.get(i+1) ){
                    System.out.println("LETRA: "+wl.get(i)+" - CONTEO: "+cont);
                    cont = 0;
                }else{
                    cont++;
                }
            }
        }
    }

}
