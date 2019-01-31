/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserUI;

import Controller.LexicalController;
import Controller.SemanticController;
import Controller.SintaticController;
import LexicalAnalyzer.LexemePosition;
import LexicalAnalyzer.LexemeTable;
import SemanticAnalyzer.SemanticError;
import SintaticAnalyzer.SintaticError;
import VirtualMachine.VirtualMachine;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class UserUI extends javax.swing.JFrame {
    private final LexicalController lexicalController = new LexicalController();
    private final SintaticController sintaticController = new SintaticController();
    private SemanticController semanticController;
    private VirtualMachine LALGVM;
    private int contLine;
    /**
     * Creates new form UserUI
     */
    public UserUI() {
        this.contLine = 0;
        initComponents();
        this.scrollBars();
    }
    
    private void scrollBars() {
        jScrollPane7.getVerticalScrollBar().setEnabled(false);
        jScrollPane7.getHorizontalScrollBar().setEnabled(false);
        jScrollPane7.getVerticalScrollBar().setModel(jScrollPane2.getVerticalScrollBar().getModel());
        jScrollPane7.getHorizontalScrollBar().setVisible(false);
        jScrollPane7.getVerticalScrollBar().setVisible(false);
    }
    
    private void fillTable() {
        DefaultTableModel model = (DefaultTableModel)LexemeTable.getModel();
        model.setNumRows(0);
        rowRenderer rr = new rowRenderer();       
        LexemeTable.getColumnModel().getColumn(0).setCellRenderer(rr);
        LexemeTable.getColumnModel().getColumn(1).setCellRenderer(rr);
        LexemeTable.getColumnModel().getColumn(2).setCellRenderer(rr);
        LexemeTable.getColumnModel().getColumn(3).setCellRenderer(rr);
        LexemeTable.getColumnModel().getColumn(4).setCellRenderer(rr);        
        Object line[] = new Object[5];
        
        LexemeTable lexemeTable = lexicalController.getTable();       
     
        for(LexemePosition p: lexemeTable.getLexemeTable()) {
            line[0] = p.getLexeme().getLexeme();
            line[1] = p.getLexeme().getToken();
            line[2] = p.getLine();
            line[3] = p.getInitialColumn();
            line[4] = p.getFinalColumn();

            model.addRow(line);             
        }
    } 
    
    private void fillTable2() {
        DefaultTableModel model = (DefaultTableModel)sintaticTable.getModel();
        model.setNumRows(0);
        rowRendererError rr = new rowRendererError();       
        sintaticTable.getColumnModel().getColumn(0).setCellRenderer(rr);     
        Object line[] = new Object[4];
        
        ArrayList<SintaticError> errorsTable = sintaticController.getErrors();       
     
        for(SintaticError error: errorsTable) {
            line[0] = error.getMessage();
            line[1] = error.getError().getLine();
            line[2] = error.getError().getInitialColumn();
            line[3] = error.getError().getFinalColumn();

            model.addRow(line);             
        } 
        
        
        if(sintaticController.getValidGrammar()) {
            line[0] = "ACEITO!";
            line[1] = "";
            line[2] = "";
            line[3] = "";        
        } else {
            line[0] = "NÃO ACEITO!";
            line[1] = "";
            line[2] = "";
            line[3] = "";    
        }
        
        model.addRow(line);        
    }
    
    private void fillTable3() {
        DefaultTableModel model = (DefaultTableModel)semanticTable.getModel();
        model.setNumRows(0);
        //rowRendererError rr = new rowRendererError();       
        //semanticTable.getColumnModel().getColumn(0).setCellRenderer(rr);     
        Object line[] = new Object[4];
        
        ArrayList<SemanticError> errorsTable = semanticController.getErrors();       
     
        for(SemanticError error: errorsTable) {
            line[0] = error.getMessage();
            line[1] = error.getError().getLine();

            model.addRow(line);             
        }         
    } 
    
    private void fillObjectCode(ArrayList<String> ObjectCode) {
        objectText.setText("");
        for(String line: ObjectCode) {
            objectText.append("\n" + line); 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        ObjectCode = new javax.swing.JTabbedPane();
        SourceCode = new javax.swing.JPanel();
        textArea = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textField = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTextArea();
        LOG = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LOGTextField = new javax.swing.JTextArea();
        LexicalAnalyzer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        LexemeTable = new javax.swing.JTable();
        SintaticAnalyzer = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sintaticTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        SemanticAnalyzer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        semanticTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        ObjectPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        objectText = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        compileButton = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        openFile = new javax.swing.JMenuItem();
        saveButton = new javax.swing.JMenuItem();
        leaveButton = new javax.swing.JMenuItem();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto de Compiladores v1.0");

        textArea.setBackground(new java.awt.Color(255, 255, 255));

        textField.setColumns(20);
        textField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textField.setRows(5);
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(textField);

        lineTable.setBackground(new java.awt.Color(240, 240, 240));
        lineTable.setColumns(20);
        lineTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lineTable.setRows(5);
        lineTable.setText("0");
        jScrollPane7.setViewportView(lineTable);

        javax.swing.GroupLayout textAreaLayout = new javax.swing.GroupLayout(textArea);
        textArea.setLayout(textAreaLayout);
        textAreaLayout.setHorizontalGroup(
            textAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textAreaLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        textAreaLayout.setVerticalGroup(
            textAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );

        LOG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        LOGTextField.setEditable(false);
        LOGTextField.setBackground(new java.awt.Color(240, 240, 240));
        LOGTextField.setColumns(20);
        LOGTextField.setRows(5);
        jScrollPane1.setViewportView(LOGTextField);

        javax.swing.GroupLayout LOGLayout = new javax.swing.GroupLayout(LOG);
        LOG.setLayout(LOGLayout);
        LOGLayout.setHorizontalGroup(
            LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        LOGLayout.setVerticalGroup(
            LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout SourceCodeLayout = new javax.swing.GroupLayout(SourceCode);
        SourceCode.setLayout(SourceCodeLayout);
        SourceCodeLayout.setHorizontalGroup(
            SourceCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LOG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SourceCodeLayout.setVerticalGroup(
            SourceCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SourceCodeLayout.createSequentialGroup()
                .addComponent(textArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LOG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ObjectCode.addTab("Código Fonte", SourceCode);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Tabela de Tokens:");

        LexemeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token", "Linha", "Coluna Inicial", "Coluna Final"
            }
        ));
        jScrollPane5.setViewportView(LexemeTable);

        javax.swing.GroupLayout LexicalAnalyzerLayout = new javax.swing.GroupLayout(LexicalAnalyzer);
        LexicalAnalyzer.setLayout(LexicalAnalyzerLayout);
        LexicalAnalyzerLayout.setHorizontalGroup(
            LexicalAnalyzerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LexicalAnalyzerLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        LexicalAnalyzerLayout.setVerticalGroup(
            LexicalAnalyzerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LexicalAnalyzerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );

        ObjectCode.addTab("Analise Léxica", LexicalAnalyzer);

        sintaticTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Linha", "Coluna Inicial", "Coluna Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(sintaticTable);
        if (sintaticTable.getColumnModel().getColumnCount() > 0) {
            sintaticTable.getColumnModel().getColumn(2).setHeaderValue("Coluna Inicial");
            sintaticTable.getColumnModel().getColumn(3).setHeaderValue("Coluna Final");
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tabela de Erros:");

        javax.swing.GroupLayout SintaticAnalyzerLayout = new javax.swing.GroupLayout(SintaticAnalyzer);
        SintaticAnalyzer.setLayout(SintaticAnalyzerLayout);
        SintaticAnalyzerLayout.setHorizontalGroup(
            SintaticAnalyzerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addGroup(SintaticAnalyzerLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SintaticAnalyzerLayout.setVerticalGroup(
            SintaticAnalyzerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SintaticAnalyzerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );

        ObjectCode.addTab("Analise Sintatica", SintaticAnalyzer);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tabela de Erros:");

        semanticTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Erro", "Linha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(semanticTable);

        javax.swing.GroupLayout SemanticAnalyzerLayout = new javax.swing.GroupLayout(SemanticAnalyzer);
        SemanticAnalyzer.setLayout(SemanticAnalyzerLayout);
        SemanticAnalyzerLayout.setHorizontalGroup(
            SemanticAnalyzerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addGroup(SemanticAnalyzerLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SemanticAnalyzerLayout.setVerticalGroup(
            SemanticAnalyzerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SemanticAnalyzerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );

        ObjectCode.addTab("Analise Semântica", SemanticAnalyzer);

        ObjectPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        objectText.setColumns(20);
        objectText.setRows(5);
        jScrollPane3.setViewportView(objectText);

        javax.swing.GroupLayout ObjectPanelLayout = new javax.swing.GroupLayout(ObjectPanel);
        ObjectPanel.setLayout(ObjectPanelLayout);
        ObjectPanelLayout.setHorizontalGroup(
            ObjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );
        ObjectPanelLayout.setVerticalGroup(
            ObjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ObjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ObjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ObjectCode.addTab("Código Objeto", jPanel1);

        optionsMenu.setText("Opções");

        compileButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        compileButton.setText("Compilar");
        compileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileButtonActionPerformed(evt);
            }
        });
        optionsMenu.add(compileButton);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem1.setText("Compilar e Executar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        optionsMenu.add(jMenuItem1);
        optionsMenu.add(jSeparator2);

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Abrir Arquivo");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        optionsMenu.add(openFile);

        saveButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveButton.setText("Salvar Arquivo");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        optionsMenu.add(saveButton);

        leaveButton.setText("Sair");
        leaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveButtonActionPerformed(evt);
            }
        });
        optionsMenu.add(leaveButton);

        jMenuBar1.add(optionsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ObjectCode, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ObjectCode)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileButtonActionPerformed
        LOGTextField.setText("");
        //Analise léxica.
        lexicalController.loadSourceCode(textField.getText());
        lexicalController.analyzeSourceCode();        
        LOGTextField.append(lexicalController.showExecutionTimeAndSucess());
        this.fillTable();
        //Analise sintática.
        sintaticController.loadTokens(lexicalController.getTable().getClone());
        sintaticController.analyzeEntry();
        LOGTextField.append(sintaticController.showExecutionTimeAndSucess());
        this.fillTable2();
        //Analise semantica.
        semanticController = new SemanticController(sintaticController.getSemanticAnalyzer());
        LOGTextField.append(semanticController.showExecutionTimeAndSucess());
        this.fillObjectCode(semanticController.getObjectCode());
        this.fillTable3();        
    }//GEN-LAST:event_compileButtonActionPerformed

    private void leaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_leaveButtonActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        //Este método tem a função de abrir um arquivo do tipo TXT.
        JFileChooser fc = new JFileChooser();
        //Adicionando filtro de busca, para arquivos txt.
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
        fc.addChoosableFileFilter(filter);
        fc.setFileFilter(filter);
        contLine = 0;
        lineTable.setText("");
        
        int result = fc.showOpenDialog(null);
        String buffer = "";
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getAbsolutePath();
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(filename));
                String line;
                while ((line = in.readLine()) != null) {
                    buffer += line + "\n";
                    lineTable.append(contLine + "\n");
                    contLine++;
                }
                
                //Setando o codigo na area de texto.
                this.textField.setText(buffer);
                
                //Limpando info.
                DefaultTableModel model = (DefaultTableModel)LexemeTable.getModel();
                model.setNumRows(0);    //Esvazia a tabela.
                model = (DefaultTableModel)sintaticTable.getModel();
                model.setNumRows(0);    //Esvazia a tabela. 
                LOGTextField.setText("");

            } catch (IOException ex) {
                Logger.getLogger(UserUI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //fechar o arquivo
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        Logger.getLogger(UserUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Esse método salva os resultados em um arquivo de imagem.
	JFileChooser jc = new JFileChooser();
        try { 
            int result = jc.showSaveDialog(null);
            if (result== JFileChooser.APPROVE_OPTION) {
                File file = jc.getSelectedFile();
                PrintWriter writer = new PrintWriter(file);
                String line = "";                
                int i = 0;
                while(i < textField.getText().length()) {
                    if(String.valueOf(textField.getText().charAt(i)).equals("\n")) {                        
                        writer.print(line + "\n");
                        line = "";
                    }
                    line+=String.valueOf(textField.getText().charAt(i)); 
                    i++;
                }                              
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(UserUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void textFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyPressed
        int key = evt.getKeyCode();
        if(key == KeyEvent.VK_ENTER) {
            contLine++;
            lineTable.append("\n"+ contLine);            
        }
    }//GEN-LAST:event_textFieldKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LOGTextField.setText("");
        //Analise léxica.
        lexicalController.loadSourceCode(textField.getText());
        lexicalController.analyzeSourceCode();        
        LOGTextField.append(lexicalController.showExecutionTimeAndSucess());
        this.fillTable();
        //Analise sintática.
        sintaticController.loadTokens(lexicalController.getTable().getClone());
        sintaticController.analyzeEntry();
        LOGTextField.append(sintaticController.showExecutionTimeAndSucess());
        this.fillTable2();
        //Analise semantica.
        semanticController = new SemanticController(sintaticController.getSemanticAnalyzer());
        LOGTextField.append(semanticController.showExecutionTimeAndSucess());
        this.fillObjectCode(semanticController.getObjectCode());
        this.fillTable3();  
        
        //Execução
        if(lexicalController.hasErrors() || sintaticController.hasErrors() || semanticController.hasErrors()) {
            LOGTextField.append("\nFalha na execução!");
   
      } else {            
            LALGVM = new VirtualMachine();
            LALGVM.inicialize(semanticController.getObjectCode());
            LALGVM.process();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LOG;
    private javax.swing.JTextArea LOGTextField;
    private javax.swing.JTable LexemeTable;
    private javax.swing.JPanel LexicalAnalyzer;
    private javax.swing.JTabbedPane ObjectCode;
    private javax.swing.JPanel ObjectPanel;
    private javax.swing.JPanel SemanticAnalyzer;
    private javax.swing.JPanel SintaticAnalyzer;
    private javax.swing.JPanel SourceCode;
    private javax.swing.JMenuItem compileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem leaveButton;
    private javax.swing.JTextArea lineTable;
    private javax.swing.JTextArea objectText;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenuItem saveButton;
    private javax.swing.JTable semanticTable;
    private javax.swing.JTable sintaticTable;
    private javax.swing.JPanel textArea;
    private javax.swing.JTextArea textField;
    // End of variables declaration//GEN-END:variables
}
