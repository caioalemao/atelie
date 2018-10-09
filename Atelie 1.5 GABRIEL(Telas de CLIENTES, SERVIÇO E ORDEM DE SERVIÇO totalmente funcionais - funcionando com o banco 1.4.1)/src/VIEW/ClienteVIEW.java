/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.ClienteDao;
import DOMAIN.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;


import javax.swing.table.DefaultTableModel;
 
/**
 *
 * @author Gabriel Torres
 * @since 04/10/2018
 */
public class ClienteVIEW extends javax.swing.JFrame {

    /**
     * Creates new form ClienteVIEW
     */
    public ClienteVIEW() {
        initComponents();
    }

  
    
            
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        eunaosei = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Cadastros de Clientes");

        btIncluir.setText("INCLUIR");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setText("ALTERAR");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("EXCLUIR");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        eunaosei.setText("foto");

        tbCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Pesquisar por nome: ");

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(106, 106, 106)
                        .addComponent(eunaosei)
                        .addGap(288, 288, 288))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jButton1)
                        .addGap(243, 243, 243))))
            .addGroup(layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(btIncluir)
                .addGap(18, 18, 18)
                .addComponent(btAlterar)
                .addGap(18, 18, 18)
                .addComponent(btExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eunaosei))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIncluir)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1065, 814));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        
        IncluirClienteVIEW telaI = new IncluirClienteVIEW();
        telaI.setVisible(true);
        telaI.setResizable(false);
        
    }//GEN-LAST:event_btIncluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        ClienteDao cDAO = new ClienteDao();
        ResultSet rs= cDAO.consultarCliente();
        carregarDadosNaJTable(rs);  
        
    }//GEN-LAST:event_formWindowOpened

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        
        try {
            ClienteDao cDao = new ClienteDao();
            Cliente cliente = new Cliente();
            int linhaSelecionada=tbCliente.getSelectedRow();
            cliente.setIdCliente(Integer.parseInt(tbCliente.getModel().getValueAt(linhaSelecionada, 0).toString()));
            System.out.println(cliente.getIdCliente());
            ResultSet rs = cDao.selecionarCliente(cliente);
            
            
            while (rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String datN = rs.getString(4);
                String rua = rs.getString(5);
                String bairro = rs.getString(6);
                String num = rs.getString(7);
                String cidade = rs.getString(8);
                String estado = rs.getString(9);
                String cep = rs.getString(10);
                String tel = rs.getString(11);
                String rg = rs.getString(12);
                String sexo = rs.getString(13);
                AlterarClienteVIEW telaA = new AlterarClienteVIEW();
                telaA.recebeCliente(id, nome, cpf, datN, rua, bairro, num, cidade, estado, cep, tel, rg, sexo);
                telaA.setVisible(true);
                telaA.setResizable(false);
            }} catch (SQLException ex) {
            Logger.getLogger(ClienteVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }
        btExcluir.setEnabled(false);
        btAlterar.setEnabled(false);
        
        
        
        
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
  
        ClienteDao cDAO = new ClienteDao();
        Cliente cliente = new Cliente();
        
        int linhaSelecionada = tbCliente.getSelectedRow();
        int codigo = Integer.parseInt(tbCliente.getModel().getValueAt(linhaSelecionada, 0).toString());
        
        cliente.setIdCliente(codigo);
        cDAO.excluirCliente(cliente);
        
        btExcluir.setEnabled(false);
        btAlterar.setEnabled(false);
        ResultSet rs= cDAO.consultarCliente();
        carregarDadosNaJTable(rs);

    }//GEN-LAST:event_btExcluirActionPerformed

    private void tbClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMousePressed
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        
    }//GEN-LAST:event_tbClienteMousePressed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
    
        btAlterar.setEnabled(false);  
        btExcluir.setEnabled(false);
        ClienteDao cDAO = new ClienteDao();
        ResultSet rs = cDAO.pesquisarClientePorNome(txtPesquisa.getText());
        carregarDadosNaJTable(rs);     
       
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ClienteDao cDAO = new ClienteDao(); 
        ResultSet rs= cDAO.consultarCliente();
        carregarDadosNaJTable(rs);
        btAlterar.setEnabled(false);  
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    
        public void carregarDadosNaJTable(ResultSet rs){
        
        try{
            String colunas []= {"id", "Nome", "Telefone", "CPF", "RG", "Data Nascimento", "Data Cadastro" };
            DefaultTableModel modelo = new DefaultTableModel(null,colunas);
            tbCliente.setModel (modelo);
            while (rs.next()){
                String linha[]= {rs.getString("idCliente"), rs.getString("nome"), rs.getString("telefone"), rs.getString("CPF"), rs.getString("rg"), rs.getString("dtNasc"), rs.getString("dtcadastro")};
                modelo.addRow(linha);    
            }
        }catch(Exception e){
            System.out.println("Erro ao Carregar JTable");
            System.out.println(e.getMessage());
        }
    }
        
        
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
            java.util.logging.Logger.getLogger(ClienteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btIncluir;
    private javax.swing.JLabel eunaosei;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
