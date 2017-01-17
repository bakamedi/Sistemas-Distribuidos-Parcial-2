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
            for(int i = 0 ; i < cadena.length() ;i++){
                ca = cadena.charAt(i);
                if(Character.isLetter(ca)){
                    if(Character.isUpperCase(ca)){
                        ca = Character.toLowerCase(ca);
                        wordList.add((char)ca);
                    }else if(Character.isLowerCase(ca)){
                        wordList.add((char)ca);
                    }
                }
                    
            }
        }
        b.close();
        Collections.sort(wordList);
        wordCount(wordList);
    }
    
    public static void wordCount(ArrayList wl){
        for(int i=97;i<123;i++){
            int contar = 0;
            for(int j=0;j<wl.size();j++){
                if ((char)i == (char)(wl.get(j)))
                    contar ++ ;   
            }
            if((char)wl.get(i) == 'w')
                System.out.println(wl.get(i));
            System.out.println("Letra "+(char)i+": " + contar);
        }
    }

}
