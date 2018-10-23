/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.OrdemDao;
import DAO.PecaDao;
import DAO.ServicoDao;
import DOMAIN.Ordem;
import DOMAIN.Peca;
import DOMAIN.Servico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class AdicionarPecaView extends javax.swing.JFrame {

    /**
     * Creates new form AdicionarPecaView
     */
    public AdicionarPecaView() {
        initComponents();
    }

    Ordem orda = new Ordem();
    public void receberOrdem(int id){
        
        orda.setId(id);
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbServico = new javax.swing.JComboBox<>();
        jbAdicionar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Adicionar Peça");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Descrição da peça*: ");

        txtDesc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Serviço: ");

        cbServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbServico.setEnabled(false);
        cbServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbServicoMousePressed(evt);
            }
        });

        jbAdicionar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbAdicionar.setText("Adicionar");
        jbAdicionar.setEnabled(false);
        jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar Serviço");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Atualizar");
        jbAtualizar.setEnabled(false);
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1)
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesc)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbAtualizar)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jbAdicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAdicionar)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(442, 390));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed

        if(txtDesc.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo de descrição VAZIO por favor preencha-o");
        }else{
            
        //Incluindo uma peça 
        Peca peca = new Peca();
        PecaDao pDao = new PecaDao();
        peca.setDescricao(txtDesc.getText());
        pDao.incluirPeca(peca);
        
        Ordem ordem = new Ordem();
        OrdemDao oDao = new OrdemDao();
        
        //Criando um objeto do tipo servico para pegar o ID dele
        Servico servico = new Servico();
        ServicoDao sDao = new ServicoDao();
        servico.setNome(cbServico.getSelectedItem().toString());
        ResultSet rs = sDao.selecionarServicoNome(servico);
        
        try {
            while (rs.next()){
                servico.setId(rs.getInt(1));
                
            }
     
            ordem.setCeServico(servico.getId());
            System.out.println(ordem.getCeServico());
            System.out.println(peca.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarPecaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rp = pDao.selecionarPecaNome(peca);
        
        try {
            while (rp.next()){
               peca.setId(rp.getInt(1)); 
            } 
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarPecaView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ordem.setCeServico(servico.getId());
            ordem.setCePeca(peca.getId());
            ordem.setId(orda.getId());
            System.out.println("Chave estrangeira SERVIÇO: " +ordem.getCeServico());
            System.out.println("Chave estrangeira PECA: " +ordem.getCePeca());
            System.out.println("Chave primaria ORDEM " +ordem.getId());
            
            oDao.incluirOrdem(ordem);
            dispose();
        }
            
    }//GEN-LAST:event_jbAdicionarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        IncluirServicoVIEW telaI = new IncluirServicoVIEW();
        telaI.setVisible(true);
        telaI.setResizable(false);
        jbAtualizar.setEnabled(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //colocando os servicos no combo box
        ServicoDao sDAO = new ServicoDao();
        ResultSet rs = sDAO.consultarServico();
        
        try{
            cbServico.removeAllItems();
            while(rs.next()){
                cbServico.addItem(rs.getString("nome"));
            }
        }catch(Exception e){
            System.out.println("ERRO"+e.getMessage());
        }
        //colocando os servicos no combo box
        
             
    }//GEN-LAST:event_formWindowOpened

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        
        ServicoDao sDAO = new ServicoDao();
        ResultSet rs = sDAO.consultarServico();
        
        try{
            cbServico.removeAllItems();
            while(rs.next()){
                cbServico.addItem(rs.getString("nome"));
            }
        }catch(Exception e){
            System.out.println("ERRO"+e.getMessage());
        }
        
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void txtDescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyReleased

        cbServico.setEnabled(true);
       
    }//GEN-LAST:event_txtDescKeyReleased

    private void cbServicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbServicoMousePressed
        jbAdicionar.setEnabled(true);
    }//GEN-LAST:event_cbServicoMousePressed

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
            java.util.logging.Logger.getLogger(AdicionarPecaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarPecaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarPecaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarPecaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarPecaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbServico;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbAdicionar;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
}
