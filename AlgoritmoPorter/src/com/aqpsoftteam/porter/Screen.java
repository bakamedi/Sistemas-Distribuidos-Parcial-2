/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Screen.java
 *
 */
package com.aqpsoftteam.porter;


import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roque E. Lopez
 */
public class Screen extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    private SortWords sw;
    private PDFConverter pdf;
    private MyModel model;
    private Stemm_es es;
    
    private ArrayList<Raiz> raices = new ArrayList<Raiz>();
    
    public Raiz existeRaiz(String raiz){
        int i; Raiz raizNodo;
        for(i = 0; i < raices.size(); i++){
            raizNodo = raices.get(i);
            if(raizNodo.getPalabra().equals(raiz)){
                return raizNodo;
            }
        }
        return null;
    }
    
    public void imprimirArray(){
        int i; Raiz raizNodo;
        for(i = 0; i < raices.size(); i++){
            raizNodo = raices.get(i);
            AreaStemming.append(raizNodo.toString() + "\n");
        }
    }
    
    public boolean esStopWord(String palabra){
        String stopwords = "a\n" +
"acá\n" +
"ahí\n" +
"ajena\n" +
"ajenas\n" +
"ajeno\n" +
"ajenos\n" +
"al\n" +
"algo\n" +
"algún\n" +
"alguna\n" +
"algunas\n" +
"alguno\n" +
"algunos\n" +
"allá\n" +
"alli\n" +
"allí\n" +
"ambos\n" +
"ampleamos\n" +
"ante\n" +
"antes\n" +
"aquel\n" +
"aquella\n" +
"aquellas\n" +
"aquello\n" +
"aquellos\n" +
"aqui\n" +
"aquí\n" +
"arriba\n" +
"asi\n" +
"atras\n" +
"aun\n" +
"aunque\n" +
"bajo\n" +
"bastante\n" +
"bien\n" +
"cabe\n" +
"cada\n" +
"casi\n" +
"cierta\n" +
"ciertas\n" +
"cierto\n" +
"ciertos\n" +
"como\n" +
"cómo\n" +
"con\n" +
"conmigo\n" +
"conseguimos\n" +
"conseguir\n" +
"consigo\n" +
"consigue\n" +
"consiguen\n" +
"consigues\n" +
"contigo\n" +
"contra\n" +
"cual\n" +
"cuales\n" +
"cualquier\n" +
"cualquiera\n" +
"cualquieras\n" +
"cuan\n" +
"cuán\n" +
"cuando\n" +
"cuanta\n" +
"cuánta\n" +
"cuantas\n" +
"cuántas\n" +
"cuanto\n" +
"cuánto\n" +
"cuantos\n" +
"cuántos\n" +
"de\n" +
"dejar\n" +
"del\n" +
"demás\n" +
"demas\n" +
"demasiada\n" +
"demasiadas\n" +
"demasiado\n" +
"demasiados\n" +
"dentro\n" +
"desde\n" +
"donde\n" +
"dos\n" +
"el\n" +
"él\n" +
"ella\n" +
"ellas\n" +
"ello\n" +
"ellos\n" +
"empleais\n" +
"emplean\n" +
"emplear\n" +
"empleas\n" +
"empleo\n" +
"en\n" +
"encima\n" +
"entonces\n" +
"entre\n" +
"era\n" +
"eramos\n" +
"eran\n" +
"eras\n" +
"eres\n" +
"es\n" +
"esa\n" +
"esas\n" +
"ese\n" +
"eso\n" +
"esos\n" +
"esta\n" +
"estaba\n" +
"estado\n" +
"estais\n" +
"estamos\n" +
"estan\n" +
"estar\n" +
"estas\n" +
"este\n" +
"esto\n" +
"estos\n" +
"estoy\n" +
"etc\n" +
"fin\n" +
"fue\n" +
"fueron\n" +
"fui\n" +
"fuimos\n" +
"gueno\n" +
"ha\n" +
"hace\n" +
"haceis\n" +
"hacemos\n" +
"hacen\n" +
"hacer\n" +
"haces\n" +
"hacia\n" +
"hago\n" +
"hasta\n" +
"incluso\n" +
"intenta\n" +
"intentais\n" +
"intentamos\n" +
"intentan\n" +
"intentar\n" +
"intentas\n" +
"intento\n" +
"ir\n" +
"jamás\n" +
"junto\n" +
"juntos\n" +
"la\n" +
"largo\n" +
"las\n" +
"lo\n" +
"los\n" +
"mas\n" +
"más\n" +
"me\n" +
"menos\n" +
"mi\n" +
"mía\n" +
"mia\n" +
"mias\n" +
"mientras\n" +
"mio\n" +
"mío\n" +
"mios\n" +
"mis\n" +
"misma\n" +
"mismas\n" +
"mismo\n" +
"mismos\n" +
"modo\n" +
"mucha\n" +
"muchas\n" +
"muchísima\n" +
"muchísimas\n" +
"muchísimo\n" +
"muchísimos\n" +
"mucho\n" +
"muchos\n" +
"muy\n" +
"nada\n" +
"ni\n" +
"ningun\n" +
"ninguna\n" +
"ningunas\n" +
"ninguno\n" +
"ningunos\n" +
"no\n" +
"nos\n" +
"nosotras\n" +
"nosotros\n" +
"nuestra\n" +
"nuestras\n" +
"nuestro\n" +
"nuestros\n" +
"nunca\n" +
"os\n" +
"otra\n" +
"otras\n" +
"otro\n" +
"otros\n" +
"para\n" +
"parecer\n" +
"pero\n" +
"poca\n" +
"pocas\n" +
"poco\n" +
"pocos\n" +
"podeis\n" +
"podemos\n" +
"poder\n" +
"podria\n" +
"podriais\n" +
"podriamos\n" +
"podrian\n" +
"podrias\n" +
"por\n" +
"por qué\n" +
"porque\n" +
"primero\n" +
"primero desde\n" +
"puede\n" +
"pueden\n" +
"puedo\n" +
"pues\n" +
"que\n" +
"qué\n" +
"querer\n" +
"quien\n" +
"quién\n" +
"quienes\n" +
"quienesquiera\n" +
"quienquiera\n" +
"quiza\n" +
"quizas\n" +
"sabe\n" +
"sabeis\n" +
"sabemos\n" +
"saben\n" +
"saber\n" +
"sabes\n" +
"se\n" +
"segun\n" +
"ser\n" +
"si\n" +
"sí\n" +
"siempre\n" +
"siendo\n" +
"sin\n" +
"sín\n" +
"sino\n" +
"so\n" +
"sobre\n" +
"sois\n" +
"solamente\n" +
"solo\n" +
"somos\n" +
"soy\n" +
"sr\n" +
"sra\n" +
"sres\n" +
"sta\n" +
"su\n" +
"sus\n" +
"suya\n" +
"suyas\n" +
"suyo\n" +
"suyos\n" +
"tal\n" +
"tales\n" +
"también\n" +
"tambien\n" +
"tampoco\n" +
"tan\n" +
"tanta\n" +
"tantas\n" +
"tanto\n" +
"tantos\n" +
"te\n" +
"teneis\n" +
"tenemos\n" +
"tener\n" +
"tengo\n" +
"ti\n" +
"tiempo\n" +
"tiene\n" +
"tienen\n" +
"toda\n" +
"todas\n" +
"todo\n" +
"todos\n" +
"tomar\n" +
"trabaja\n" +
"trabajais\n" +
"trabajamos\n" +
"trabajan\n" +
"trabajar\n" +
"trabajas\n" +
"trabajo\n" +
"tras\n" +
"tú\n" +
"tu\n" +
"tus\n" +
"tuya\n" +
"tuyo\n" +
"tuyos\n" +
"ultimo\n" +
"un\n" +
"una\n" +
"unas\n" +
"uno\n" +
"unos\n" +
"usa\n" +
"usais\n" +
"usamos\n" +
"usan\n" +
"usar\n" +
"usas\n" +
"uso\n" +
"usted\n" +
"ustedes\n" +
"va\n" +
"vais\n" +
"valor\n" +
"vamos\n" +
"van\n" +
"varias\n" +
"varios\n" +
"vaya\n" +
"verdad\n" +
"verdadera\n" +
"vosotras\n" +
"vosotros\n" +
"voy\n" +
"vuestra\n" +
"vuestras\n" +
"vuestro\n" +
"vuestros\n" +
"y\n" +
"ya\n" +
"yo";
        if(stopwords.indexOf(palabra) == -1){
            return false;
        } else {
            return true;
        }
    }

    public Screen() {
        setTitle("Algoritmo de Porter");
        model = new MyModel();
        es = new Stemm_es();
        initComponents();
        model.addColumn("Nro");
        model.addColumn("Palabras");
        model.addColumn("Raices");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_Analizar = new javax.swing.JPanel();
        jLabel_Result = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaStemming = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaOrganizacion = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton_Exit = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu_File = new javax.swing.JMenu();
        jMenuItem_Exit = new javax.swing.JMenuItem();
        jMenu_Help = new javax.swing.JMenu();
        jMenuItem_About = new javax.swing.JMenuItem();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Analizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_Result.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel_Result.setForeground(new java.awt.Color(51, 51, 255));

        jLabel6.setText("Buscar Archivo");

        jButton3.setText("Abrir Archivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        AreaStemming.setColumns(20);
        AreaStemming.setRows(5);
        jScrollPane2.setViewportView(AreaStemming);

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_AnalizarLayout = new javax.swing.GroupLayout(jPanel_Analizar);
        jPanel_Analizar.setLayout(jPanel_AnalizarLayout);
        jPanel_AnalizarLayout.setHorizontalGroup(
            jPanel_AnalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AnalizarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel_AnalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_AnalizarLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(40, 40, 40)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_AnalizarLayout.createSequentialGroup()
                        .addGroup(jPanel_AnalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_AnalizarLayout.setVerticalGroup(
            jPanel_AnalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AnalizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_AnalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel6))
                .addGroup(jPanel_AnalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_AnalizarLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_AnalizarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Analizador", jPanel_Analizar);

        jButton1.setText("Abrir Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar Archivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Convertidor de PDF", jPanel1);

        jLabel5.setText("Ordena letras alfabeticamente desde A-Z y cuenta cunatas h");

        jButton2.setText("Abrir Archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        AreaOrganizacion.setColumns(20);
        AreaOrganizacion.setRows(5);
        jScrollPane1.setViewportView(AreaOrganizacion);

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Ordenamiento de Letras", jPanel2);

        jButton_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jButton_Exit.setText("Salir");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        jMenu_File.setText("File");

        jMenuItem_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jMenuItem_Exit.setText("Exit");
        jMenuItem_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ExitActionPerformed(evt);
            }
        });
        jMenu_File.add(jMenuItem_Exit);

        jMenuBar.add(jMenu_File);

        jMenu_Help.setText("Help");

        jMenuItem_About.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        jMenuItem_About.setText("About");
        jMenuItem_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AboutActionPerformed(evt);
            }
        });
        jMenu_Help.add(jMenuItem_About);

        jMenuBar.add(jMenu_Help);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_Exit)
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Exit)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ExitActionPerformed
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_jMenuItem_ExitActionPerformed

    private void jMenuItem_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AboutActionPerformed
        // TODO add your handling code here:
        about();
    }//GEN-LAST:event_jMenuItem_AboutActionPerformed

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        sw = new SortWords();
        sw.selectTextFiles(AreaOrganizacion);
        sw.openFileTXT();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pdf = new PDFConverter();
        pdf.selectTextFiles();
        pdf.openFilePDF();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        AreaStemming.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Stemm_es steam = new Stemm_es();
        String path = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT","txt");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
        int returnVal = chooser.showOpenDialog(null);
        AreaStemming.setText("Por favor espere...\n");
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File[] Files=chooser.getSelectedFiles();
            for( int i=0;i<Files.length;i++){
                path = path + Files[i].toString();
            }
            System.out.println(path);
            try{
                Raiz raizNodo;
                int i;
                String cadena;
                FileReader f = new FileReader(path);
                BufferedReader b = new BufferedReader(f);
                while((cadena = b.readLine())!=null) {
                    String palabras[] = cadena.split(" ");
                    for(i = 0; i < palabras.length; i++){
                        palabras[i] = palabras[i].replaceAll("\\p{Punct}","");
                        palabras[i] = palabras[i].replaceAll("\\p{Digit}","");
                        palabras[i] = palabras[i].toLowerCase();
                        if(palabras[i] != "" && !esStopWord(palabras[i])){
                            palabras[i] = steam.stemm(palabras[i]);
                            raizNodo = existeRaiz(palabras[i]);
                            if(raizNodo == null){
                                raices.add(new Raiz(palabras[i]));
                            } else {
                                raizNodo.incrementar(raizNodo);
                            }
                        }

                    }
                }
                Collections.sort(raices, new Comparator<Raiz>(){

                    @Override
                    public int compare(Raiz o1, Raiz o2) {
                        return Integer.compare(o2.getCant(), o1.getCant());
                    }

                });

                imprimirArray();
                b.close();
            }catch(Exception e){e.printStackTrace();}
            System.out.println("Sort File Complete");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AreaOrganizacion.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaOrganizacion;
    private javax.swing.JTextArea AreaStemming;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Result;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem_About;
    private javax.swing.JMenuItem jMenuItem_Exit;
    private javax.swing.JMenu jMenu_File;
    private javax.swing.JMenu jMenu_Help;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Analizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        this.dispose();
    }

    private void about() {
        
    }

    

    

    public class MyModel extends DefaultTableModel {

        public boolean isCellEditable(int row, int column) {
            if (column == 0 || column == 1) {
                return false;
            }
            return true;
        }
    }
}
