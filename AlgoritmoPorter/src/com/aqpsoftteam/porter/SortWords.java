/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aqpsoftteam.porter;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bakke
 */
public class SortWords {
    private String letra;
    private String ruta = "\\home\\stalyn\\Documents\\conteoDeLetras.txt";
    
    
    public void selectTextFiles(JTextArea area){
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
                openFileTxt(path, area);
             }catch(Exception e){e.printStackTrace();}
            System.out.println("Sort File Complete");
        }
    }
    
    public void openFileTxt(String pathFile, JTextArea area) throws FileNotFoundException, IOException {
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
        wordCount(wordList, area);
    }
    
    public void wordCount(ArrayList wl, JTextArea area) throws IOException{
        for(int i=97;i<123;i++){
            int contar = 0;
            for(int j=0;j<wl.size();j++){
                if ((char)i == (char)(wl.get(j)))
                    contar ++ ;   
            }
            if((char)wl.get(i) == 'w')
                area.append(wl.get(i) + "\n");
            letra = "Letra "+(char)i+": " + contar;
            area.append(letra + "\n");
            newFileTXT(letra);
        }
    }
    
    
    public void newFileTXT(String letra) throws IOException{
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(ruta,true);

            // Escribimos linea a linea en el fichero
            fichero.append(letra + "\n");
            fichero.close();

        } catch (Exception ex) {
                System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
        //File archivo = new File(ruta);
        //BufferedWriter bw;
        //bw = new BufferedWriter(new FileWriter(archivo));
        //bw.write(letra);
        //bw.close();
    }
    
    
    public void openFileTXT(){
         try {
            Desktop d = java.awt.Desktop.getDesktop ();
            d.open (new java.io.File (ruta));
            System.out.println("Conversion complete");
            //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+path);
         } catch (Exception e) {
             System.out.println("Error al abrir el archivo");
         }
         
     }
    
    
}
