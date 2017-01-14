package PDFConverter;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileOutputStream; 
import com.itextpdf.text.Document;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.font.LayoutPathImpl;
 
public class TextToPDFConverter {  
    
    private static String path = "C:\\Users\\Andres1\\Documents\\NetBeansProjects\\txtPDF\\conversionCompleta.pdf";//se debe de cambiar para cada maquina
    
    public static void main(String[] args) throws Exception {  
        selectTextFiles();
        openFilePDF();
    }
    
    public static void selectTextFiles(){

    JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT","txt");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File[] Files=chooser.getSelectedFiles();
            System.out.println("Please wait...");
                 for( int i=0;i<Files.length;i++){
                    convertTextToPDF(Files[i].toString(),"conversionCompleta"+".pdf");
                  }
            System.out.println("Conversion complete");
        }
    }
 
    public static void convertTextToPDF(String src,String desc){
  
        try{
            //create file reader to read text from the source file
            FileReader fr=new FileReader(src);
            //create buffered reader to wrap the file reader
            //so you can read text by line
            BufferedReader br=new BufferedReader(fr);
            //create document
            Document doc=new Document();
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
     
     public static void openFilePDF(){
         try {
             Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+path);
         } catch (Exception e) {
             System.out.println("Error al abrir el archivo");
         }
         
     }

}