
package codigo;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

public class FrmPrincipal extends javax.swing.JFrame {
    
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        //Encabezado para la entrega del análisis.
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado ="Linea"+"\tsimbolos" + "\tIdentificador" + "\tpalabra Reservadas" + "\tOperador" +"\ttipo de dato\n" +"Linea->"+cont +"\n" ;
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            
            //Validación del tipo de dato utilizado, es utilizado para entregar la información a la vista.
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "" + cont + "\n";
                    break;
                    
                case Comillas:
                    resultado += "\t<Comillas>\t\t\t\t         " + "X" + "\n";
                    break;
                    
                case Cadena:
                    resultado += "\t      " + lexer.lexeme +"\t\t          " +"X"+ "\t\t\t    " + "Cadena" +"\n";
                    break;
                    
                case T_dato:
                    resultado += "\t      " + lexer.lexeme + "\t\t\t\t\t          " + "X" +"\n";
                    break;
                    
                case If:
                    resultado += "\t      " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case Else:
                    resultado += "\t      " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                 case P_commit:
                    resultado += "\t      " + lexer.lexeme + "\t\t             " + "X" +"\n";
                 break;
                 case P_public:
                    resultado += "\t      " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case Do:
                   resultado +=  "\t      " + lexer.lexeme + "\t\t             " + "X" +"\n";  
                    break;
                case P_create:
                   resultado +=  "\t      " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case While:
                    resultado += "\t      " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_roolback:
                    resultado += "\t    " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_return:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_static:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_pause:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_void:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_null:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;                    
                case P_user:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_systemctl:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_date:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case P_clear:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;                   
                case For:
                    resultado += "\t     " + lexer.lexeme + "\t\t             " + "X" +"\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;                    
                     
                case Igual:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Suma:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Resta:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Multiplicacion:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Division:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Op_logico:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Op_incremento:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Op_relacional:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Op_atribucion:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Op_booleano:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Parentesis_a:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Parentesis_c:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Llave_a:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Llave_c:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Corchete_a:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case Corchete_c:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                case P_coma:
                    resultado += " \t   " + lexer.lexeme +"\t\t\t\t      "+"X"+ "\n";
                    break;
                    
                case Identificador:
                    resultado += "\t" + lexer.lexeme + "\tX"+ "\t\t\t\t"+"decimal"+ "\n";
                    break;
                    
                case Numero:
                    resultado += "\t" + lexer.lexeme +"\t\t\t\t\t" +"números" + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Lexico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnArchivo.setText("Abrir");
        btnArchivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        txtAnalizarLex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnAnalizarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiarLex)
                        .addGap(44, 44, 44)
                        .addComponent(btnAnalizarLex)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                        .addGap(101, 101, 101))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarLex)
                    .addComponent(btnArchivo)
                    .addComponent(btnLimpiarLex))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        btnArchivo.getAccessibleContext().setAccessibleName("Abrir archivo plano .txt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        // TODO add your handling code here:
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
      
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed


    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
