/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.ClienteDao;
import DAO.OrdemDao;
import DAO.OrdemDeServicoDao;
import DAO.PecaDao;
import DOMAIN.Cliente;
import DOMAIN.Ordem;
import DOMAIN.OrdemDeServico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class IncluirOrdemDeServicoVIEW extends javax.swing.JFrame {

    /**
     * Creates new form IncluirAlterarOrdemDeServico
     */
    public IncluirOrdemDeServicoVIEW() {
        initComponents();
    }
        OrdemDao uDao = new OrdemDao();
        Ordem ordem = new Ordem();  
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jbPeca = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbIncluir = new javax.swing.JButton();
        jbCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPeca = new javax.swing.JTable();
        jbAtualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Incluir Ordem de Serviço");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Adicionar Peça: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cliente: ");

        cbCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbPeca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbPeca.setText("+");
        jbPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPecaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Peças Cadastradas Nessa Ordem de Serviço: ");

        jbIncluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbIncluir.setText("Incluir");
        jbIncluir.setEnabled(false);
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });

        jbCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbCliente.setText("Incluir Novo Cliente");
        jbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClienteActionPerformed(evt);
            }
        });

        tbPeca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbPeca.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPeca);

        jbAtualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbAtualizar.setText("Atualizar");
        jbAtualizar.setEnabled(false);
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Data de entrega(dd/mm/aaaa): ");

        txtData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbIncluir)
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbAtualizar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbPeca))
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jbCliente))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel1))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbPeca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jbAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCliente))
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jbIncluir)
                .addGap(52, 52, 52))
        );

        setSize(new java.awt.Dimension(479, 549));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        OrdemDeServico ods= new OrdemDeServico();
        
        
        ods.setCeOrdem(ordem.getId());
        Cliente cli = new Cliente();
        ClienteDao cDao = new ClienteDao();
        cli.setNome(cbCliente.getSelectedItem().toString());
        ResultSet rs = cDao.selecionarClienteNome(cli);
        try {
            while (rs.next()){
                cli.setIdCliente(rs.getInt(1));
                
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarPecaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        ods.setCeCliente(cli.getIdCliente());
        ods.setSituacao("A fazer");
        //
        
        
        //pegando data de entrega
        Date dataE = null;
        try {
            dataE = formatador.parse(txtData.getText());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());;
        }
        java.sql.Date dataESql = new java.sql.Date(dataE.getTime());
        ods.setDtEntrega(dataESql);
        //
        //calculando velorToral
        OrdemDeServicoDao oDao= new OrdemDeServicoDao();
        ResultSet rv = oDao.pegarPrecos(ods);
        float vl = 0;
        float v = 0;
        try {
            while (rv.next()){
                
                v = rv.getFloat(1);
                vl = vl + v;
                ods.setValortotal(vl);
            }
       
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        
        ods.setValortotal(vl);
        //
       
        
        System.out.println("CHAVE PLIMARIA DE ORDEM DE SERVIÇO: "+ods.getId());
        System.out.println("CHAVE ESTRANGEIRA CODIGO CLIENTE: "+ods.getCeCliente());
        System.out.println("SITUAÇÃO: " +ods.getSituacao());
        System.out.println("CHAVE ESTRANGEIRA DE ORDEM: "+ods.getCeOrdem());
        System.out.println("VALOR TOTAL" + ods.getValortotal());
        System.out.println("DATA DE ENTREGRA");
       
        OrdemDeServicoDao iDao = new OrdemDeServicoDao();
        iDao.incluirOrdem(ods);
        
        dispose();
        
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jbPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPecaActionPerformed
        
        AdicionarPecaView tela = new AdicionarPecaView();
        tela.receberOrdem(ordem.getId());
        System.out.println(ordem.getId());
        tela.setVisible(true);
        tela.setResizable(false);
        
        jbAtualizar.setEnabled(true);
        jbIncluir.setEnabled(true);
        
        
        
    }//GEN-LAST:event_jbPecaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //definindo o id da ordem
         ResultSet rs = uDao.obterUltimaOrdem();
        try { 
            while(rs.next()){
                
            int i =    rs.getInt("MAX(idOrdem)");
            int f = i +1;  
            
            ordem.setId(f);
            System.out.println(ordem.getId());
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncluirOrdemDeServicoVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //colocando cliente na combo box
        ClienteDao cDAO = new ClienteDao();
        ResultSet rb = cDAO.consultarCliente();
        
        try{
            cbCliente.removeAllItems();
            while(rb.next()){
                cbCliente.addItem(rb.getString("nome"));
            }
        }catch(Exception e){
            System.out.println("ERRO"+e.getMessage());
        }
         
    }//GEN-LAST:event_formWindowOpened

    private void jbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClienteActionPerformed
        
        IncluirClienteVIEW tela = new IncluirClienteVIEW();
        
        tela.setVisible(true);
        tela.setResizable(false);
        
        jbAtualizar.setEnabled(true);
        jbCliente.setEnabled(false);
        
      
    }//GEN-LAST:event_jbClienteActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        ClienteDao cDAO = new ClienteDao();
        ResultSet rs = cDAO.consultarCliente();
        
        try{
            cbCliente.removeAllItems();
            while(rs.next()){
                cbCliente.addItem(rs.getString("nome"));
            }
        }catch(Exception e){
            System.out.println("ERRO"+e.getMessage());
        }
   
        PecaDao pDao = new PecaDao();
        ResultSet rt = pDao.obterPecasPorOrdem(ordem);
        carregarDadosNaJTable(rt);
        if (tbPeca==null){
            jbIncluir.setEnabled(false);
        }
        jbAtualizar.setEnabled(false);
        
        
        
    }//GEN-LAST:event_jbAtualizarActionPerformed
    
    public void carregarDadosNaJTable(ResultSet rs){
        
        try{
            String colunas []= {"id", "Descrição"};
            DefaultTableModel modelo = new DefaultTableModel(null,colunas);
            tbPeca.setModel (modelo);
            while (rs.next()){
                String linha[]= {rs.getString("idPeca"), rs.getString("descricao")};
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
            java.util.logging.Logger.getLogger(IncluirOrdemDeServicoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IncluirOrdemDeServicoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IncluirOrdemDeServicoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IncluirOrdemDeServicoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncluirOrdemDeServicoVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCliente;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JButton jbPeca;
    private javax.swing.JTable tbPeca;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
