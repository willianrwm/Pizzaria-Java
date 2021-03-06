/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import regraNegocio.BordaRN;
import vo.BordaVO;

/**
 *
 * @author Karpa
 */
public class ModuloBorda extends TemplateBotoes implements ActionListener {

    /**
     * Creates new form ModuloBorda
     */
    int editar;
    TemplatePrincipal templatePrincipal;
    
    public ModuloBorda(TemplatePrincipal templatePrincipal) {
        this.templatePrincipal = templatePrincipal;
        initComponents();
        popularTabela();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPainel = new javax.swing.JPanel();
        lSabor = new javax.swing.JLabel();
        lTipo = new javax.swing.JLabel();
        lPreco = new javax.swing.JLabel();
        tfSabor = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox();
        ftfPreco = new javax.swing.JFormattedTextField();
        spBorda = new javax.swing.JScrollPane();
        tBorda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bordas");
        setMinimumSize(new java.awt.Dimension(600, 450));
        setPreferredSize(new java.awt.Dimension(600, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pPainel.setPreferredSize(new java.awt.Dimension(600, 500));

        lSabor.setText("Sabor:");

        lTipo.setText("Tipo:");

        lPreco.setText("Preço:");

        tfSabor.setEnabled(false);

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Doce", "Salgada" }));
        cbTipo.setEnabled(false);

        ftfPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftfPreco.setEnabled(false);

        tBorda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Sabor", "Tipo", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tBorda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBordaMouseClicked(evt);
            }
        });
        spBorda.setViewportView(tBorda);

        javax.swing.GroupLayout pPainelLayout = new javax.swing.GroupLayout(pPainel);
        pPainel.setLayout(pPainelLayout);
        pPainelLayout.setHorizontalGroup(
            pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPainelLayout.createSequentialGroup()
                        .addComponent(lSabor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSabor))
                    .addGroup(pPainelLayout.createSequentialGroup()
                        .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pPainelLayout.createSequentialGroup()
                                .addComponent(lPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfPreco))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pPainelLayout.createSequentialGroup()
                                .addComponent(lTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spBorda, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
                .addContainerGap())
        );
        pPainelLayout.setVerticalGroup(
            pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSabor)
                    .addComponent(tfSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTipo)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPreco)
                    .addComponent(ftfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spBorda, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pPainel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tBordaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBordaMouseClicked
        
        try{
        popularCampos();
        esconderCampos();
        
        }catch (Exception exc) {

            JOptionPane.showMessageDialog(null, "Tabela está desabilitada", "Cadastro Borda", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tBordaMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        templatePrincipal.setEnabled(true);
        templatePrincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JFormattedTextField ftfPreco;
    private javax.swing.JLabel lPreco;
    private javax.swing.JLabel lSabor;
    private javax.swing.JLabel lTipo;
    private javax.swing.JPanel pPainel;
    private javax.swing.JScrollPane spBorda;
    private javax.swing.JTable tBorda;
    private javax.swing.JTextField tfSabor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bNovoActionPerformed(ActionEvent e) {
        
        editar = 0;
        limpaCampos();
        mostrarCampos();
        
        bNovo.setEnabled(false);
        bSalvar.setEnabled(true);
        bEditar.setEnabled(false);
        bExcluir.setEnabled(false);
        bCancelar.setEnabled(true);
        tBorda.setEnabled(false);
    }

    @Override
    public void bSalvarActionPerformed(ActionEvent e) {
        
        try{
            
            if (tfSabor.getText().trim().equals(null) ||cbTipo.getSelectedIndex()==0 || ftfPreco.getText().trim().equals(null)){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro Borda", JOptionPane.PLAIN_MESSAGE);
            }else{
            BordaVO bordaVO = new BordaVO();
            
            if (editar == 1){
                bordaVO.setCodigo(Integer.parseInt(tfCodigo.getText()));
            }
            
            bordaVO.setSabor(tfSabor.getText());
            bordaVO.setTipo((String) cbTipo.getSelectedItem());
            bordaVO.setPreco(ftfPreco.getText());

            BordaRN bordaRN = new BordaRN();
            bordaRN.salvarBorda(bordaVO, editar);
            
            bNovo.setEnabled(true);
            bSalvar.setEnabled(false);
            bEditar.setEnabled(true);
            bExcluir.setEnabled(true);
            bCancelar.setEnabled(false);
            tBorda.setEnabled(true);
            esconderCampos();
            popularTabela();
            
            JOptionPane.showMessageDialog(null, "Item salvo com sucesso.", "Cadastro de Borda", JOptionPane.INFORMATION_MESSAGE); 
            }
            
        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Cadastro Borda", JOptionPane.ERROR_MESSAGE);
        
        }  catch (Exception exc) {

            JOptionPane.showMessageDialog(null, "Erro: " + exc.getMessage(), "Cadastro Borda", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void bEditarActionPerformed(ActionEvent e) {
        
        if (tfSabor.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(null, "Selecione uma borda.", "Editar Borda", JOptionPane.WARNING_MESSAGE);

        } else{
            editar = 1;
            
            bNovo.setEnabled(false);
            bSalvar.setEnabled(true);
            bEditar.setEnabled(false);
            bExcluir.setEnabled(false);
            bCancelar.setEnabled(true);
            tBorda.setEnabled(false);
            mostrarCampos();
        }
    }

    @Override
    public void bExcluirActionPerformed(ActionEvent e) {
        
        try{
            
            int confirmacao;
            BordaVO bordaVO = new BordaVO();
        
            confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Cadastro de Borda", JOptionPane.YES_NO_OPTION);
                if (confirmacao == 0){

                bordaVO.setCodigo(Integer.parseInt((String) tBorda.getValueAt(tBorda.getSelectedRow(), 0)));

                BordaRN bordaRN = new BordaRN();
                bordaRN.excluirBorda(bordaVO);

                limpaCampos();
                popularTabela();
                JOptionPane.showMessageDialog(null, "Borda excluída com sucesso!", "Cadastro de Borda", JOptionPane.PLAIN_MESSAGE);
                }
                
        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Exclusão Borda", JOptionPane.ERROR_MESSAGE);
            
        } catch (ArrayIndexOutOfBoundsException aiobe) {

            JOptionPane.showMessageDialog(null, "Selecione uma borda.", "Exclusão Borda", JOptionPane.WARNING_MESSAGE);

        } catch (Exception exc) {

            JOptionPane.showMessageDialog(null, "Erro: " + exc.getMessage(), "Exclusão Borda", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void bCancelarActionPerformed(ActionEvent e) {
        
        int confirmacao;
        confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (confirmacao == 0){
            
            bNovo.setEnabled(true);
            bSalvar.setEnabled(false);
            bEditar.setEnabled(true);
            bExcluir.setEnabled(true);
            bCancelar.setEnabled(false);
            tBorda.setEnabled(true);
            limpaCampos();
            esconderCampos();
        }
    }

    
    
    @Override
    public void actionPerformed (ActionEvent e){
        
        switch (e.getActionCommand()){
            
            case "Novo":
                
                bNovoActionPerformed(e);
                break;
                
            case "Salvar":
                
                bSalvarActionPerformed(e);
                break;
                
            case "Editar":
                
                bEditarActionPerformed(e);
                break;
                
            case "Excluir":
                
                bExcluirActionPerformed(e);
                break;
                
            case "Cancelar":
                
                bCancelarActionPerformed(e);
                break;
        }
    }
    
    public void mostrarCampos(){
        
        tfSabor.setEnabled(true);
        cbTipo.setEnabled(true);
        ftfPreco.setEnabled(true);
    }
    
    public void esconderCampos(){
        
        tfSabor.setEnabled(false);
        cbTipo.setEnabled(false);
        ftfPreco.setEnabled(false);
    }
    
    public void limpaCampos(){
        
        tfCodigo.setText("");
        tfSabor.setText("");
        cbTipo.setSelectedIndex(0);
        ftfPreco.setText("");
    }
    
    public void popularCampos() {

        tfCodigo.setText((String) tBorda.getValueAt(tBorda.getSelectedRow(), 0));
        tfSabor.setText((String) tBorda.getValueAt(tBorda.getSelectedRow(), 1));
        cbTipo.getModel().setSelectedItem((String) tBorda.getValueAt(tBorda.getSelectedRow(), 2));
        ftfPreco.setText((String) tBorda.getValueAt(tBorda.getSelectedRow(), 3));
    }
    
    public void popularTabela() {

        try {

            BordaRN bordaRN = new BordaRN();

            ArrayList<BordaVO> bordas = bordaRN.buscarBordas();

            javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) tBorda.getModel();
            dtm.fireTableDataChanged();
            dtm.setRowCount(0);

            for (BordaVO bordaVO : bordas) {

                String[] linha = {"" + bordaVO.getCodigo(), "" + bordaVO.getSabor(), "" + bordaVO.getTipo(), "" + bordaVO.getPreco()};
                dtm.addRow(linha);
            }

        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Bordas", JOptionPane.ERROR_MESSAGE);
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Bordas", JOptionPane.ERROR_MESSAGE);
        }
    }

}
