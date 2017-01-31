/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aqpsoftteam.porter;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileOutputStream; 
import com.itextpdf.text.Document;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author bakke
 */
public class PDFConverter {
    private static String path = "\\home\\bakke\\Documents\\conversionCompleta.pdf";//se debe de cambiar para cada maquina
    private static String pdfName = "conversionCompleta"+".pdf";
    
    public void selectTextFiles(){

    JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT","txt");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File[] Files=chooser.getSelectedFiles();
            System.out.println("Please wait...");
                 for( int i=0;i<Files.length;i++){
                    convertTextToPDF(Files[i].toString(),pdfName);
                  }
            
        }
    }
 
    private void convertTextToPDF(String src,String desc){
  
        try{
            //create file reader to read text from the source file
            FileReader fr=new FileReader(src);
            //create buffered reader to wrap the file reader
            //so you can read text by line
            BufferedReader br=new BufferedReader(fr);
            //create document
            Document doc =  new Document();
            //create pdf writer to write the document to the destination file
            PdfWriter.getInstance(doc, new FileOutputStream(desc));
            //open the document so it is ready to add text
            doc.open();
            //read text  line by line and add it to the document
            String text="";
            while((text=br.readLine())!=null){
             doc.add(new Paragraph(text));   
            }
            //close the document
            doc.close();
            //close the buffered reader
            br.close();
            

            }
        catch(Exception e){e.printStackTrace();}
       }
     
     public void openFilePDF(){
         try {
            Desktop d = java.awt.Desktop.getDesktop ();
            d.open (new java.io.File (pdfName));
            System.out.println("Conversion complete");
            //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+path);
         } catch (Exception e) {
             System.out.println("Error al abrir el archivo");
         }
         
     }
    
    
}
