/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import regraNegocio.ClienteRN;
import vo.ClienteVO;
import vo.PedidoVO;

/**
 *
 * @author Karpa
 */
public class ModuloCliente extends TemplateBotoes implements ActionListener {

    /**
     * Creates new form ModuloCliente
     */
    int editar;
    
    public ModuloCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
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
        lNome = new javax.swing.JLabel();
        lTelefone = new javax.swing.JLabel();
        lLogradouro = new javax.swing.JLabel();
        lNumero = new javax.swing.JLabel();
        lComplemento = new javax.swing.JLabel();
        lBairro = new javax.swing.JLabel();
        lCidade = new javax.swing.JLabel();
        lEstado = new javax.swing.JLabel();
        lCEP = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        ftfTelefone = new javax.swing.JFormattedTextField();
        tfLogradouro = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        tfComplemento = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        ftfCEP = new javax.swing.JFormattedTextField();
        sSeparador1 = new javax.swing.JSeparator();
        bConsultar = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setMinimumSize(new java.awt.Dimension(550, 500));

        pPainel.setMinimumSize(new java.awt.Dimension(0, 0));
        pPainel.setName("painel1"); // NOI18N
        pPainel.setPreferredSize(new java.awt.Dimension(550, 500));

        lNome.setText("Nome:");

        lTelefone.setText("Telefone:");

        lLogradouro.setText("Logradouro:");

        lNumero.setText("Número:");

        lComplemento.setText("Complemento:");

        lBairro.setText("Bairro:");

        lCidade.setText("Cidade:");

        lEstado.setText("Estado:");

        lCEP.setText("CEP:");

        tfNome.setEnabled(false);

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelefone.setEnabled(false);

        tfLogradouro.setEnabled(false);

        tfNumero.setEnabled(false);

        tfComplemento.setEnabled(false);

        tfBairro.setEnabled(false);

        tfCidade.setEnabled(false);

        try {
            ftfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCEP.setEnabled(false);

        bConsultar.setText("Consultar Clientes");
        bConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        cbEstado.setEnabled(false);

        javax.swing.GroupLayout pPainelLayout = new javax.swing.GroupLayout(pPainel);
        pPainel.setLayout(pPainelLayout);
        pPainelLayout.setHorizontalGroup(
            pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPainelLayout.createSequentialGroup()
                        .addComponent(lNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome))
                    .addComponent(sSeparador1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pPainelLayout.createSequentialGroup()
                        .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLogradouro)
                            .addGroup(pPainelLayout.createSequentialGroup()
                                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lLogradouro)
                                    .addComponent(lComplemento))
                                .addGap(268, 268, 268)
                                .addComponent(lBairro)
                                .addGap(0, 158, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNumero)))
                    .addGroup(pPainelLayout.createSequentialGroup()
                        .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(lCidade)
                                .addComponent(tfCidade))
                            .addComponent(lCEP))
                        .addGap(18, 18, 18)
                        .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBairro)
                            .addGroup(pPainelLayout.createSequentialGroup()
                                .addComponent(lEstado)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pPainelLayout.createSequentialGroup()
                        .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPainelLayout.createSequentialGroup()
                                .addComponent(lTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ftfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pPainelLayout.setVerticalGroup(
            pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTelefone)
                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bConsultar))
                .addGap(18, 18, 18)
                .addComponent(sSeparador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLogradouro)
                    .addComponent(lNumero))
                .addGap(9, 9, 9)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lComplemento)
                    .addComponent(lBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lEstado)
                    .addComponent(lCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lCEP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        getContentPane().add(pPainel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarActionPerformed
        ModuloConsultaClientes moduloConsultaClientes = new ModuloConsultaClientes(this);
        moduloConsultaClientes.setVisible(true);
    }//GEN-LAST:event_bConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConsultar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JFormattedTextField ftfCEP;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JLabel lBairro;
    private javax.swing.JLabel lCEP;
    private javax.swing.JLabel lCidade;
    private javax.swing.JLabel lComplemento;
    private javax.swing.JLabel lEstado;
    private javax.swing.JLabel lLogradouro;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lNumero;
    private javax.swing.JLabel lTelefone;
    private javax.swing.JPanel pPainel;
    private javax.swing.JSeparator sSeparador1;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
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
    }

    @Override
    public void bSalvarActionPerformed(ActionEvent e) {
        
        try{
            
            if (tfNome.getText().trim().equals(null) || ftfTelefone.getText().trim().equals(null)|| tfLogradouro.getText().trim().equals(null) || tfNumero.getText().trim().equals(null) || tfComplemento.getText().trim().equals(null) || tfBairro.getText().trim().equals(null) || tfCidade.getText().trim().equals(null) || cbEstado.getSelectedIndex()==0 || ftfCEP.getText().trim().equals(null)){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro Cliente", JOptionPane.PLAIN_MESSAGE);
            }else{
            ClienteVO clienteVO = new ClienteVO();
            
            if (editar == 1){
                clienteVO.setCodigo(Integer.parseInt(tfCodigo.getText()));
            }
            
            clienteVO.setNome(tfNome.getText());
            clienteVO.setTelefone(ftfTelefone.getText());
            clienteVO.setLogradouro(tfLogradouro.getText());
            clienteVO.setNumero(Integer.parseInt(tfNumero.getText()));
            clienteVO.setComplemento(tfComplemento.getText());
            clienteVO.setBairro(tfBairro.getText());
            clienteVO.setCidade(tfCidade.getText());
            clienteVO.setEstado((String) cbEstado.getSelectedItem());
            clienteVO.setCEP(ftfCEP.getText());

            ClienteRN clienteRN = new ClienteRN();
            clienteRN.salvarCliente(clienteVO, editar);
            
            bNovo.setEnabled(true);
            bSalvar.setEnabled(false);
            bEditar.setEnabled(true);
            bExcluir.setEnabled(true);
            bCancelar.setEnabled(false);
            esconderCampos();
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso.", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE); 
            }
        
        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Cadastro Cliente", JOptionPane.ERROR_MESSAGE);
        
        }  catch (Exception exc) {

            JOptionPane.showMessageDialog(null, "Erro: " + exc.getMessage(), "Cadastro Cliente", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void bEditarActionPerformed(ActionEvent e) {
        
        if (tfNome.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(null, "Selecione um cliente.", "Editar Cliente", JOptionPane.WARNING_MESSAGE);

        } else{
            editar = 1;
            
            bNovo.setEnabled(false);
            bSalvar.setEnabled(true);
            bEditar.setEnabled(false);
            bExcluir.setEnabled(false);
            bCancelar.setEnabled(true);
            mostrarCampos();
        }
    }

    @Override
    public void bExcluirActionPerformed(ActionEvent e) {
        
        try{
            
            int confirmacao;
            ClienteVO clienteVO = new ClienteVO();
        
            confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Cadastro de Cliente", JOptionPane.YES_NO_OPTION);
                if (confirmacao == 0){
                
                clienteVO.setCodigo(Integer.parseInt((String) tfCodigo.getText()));

                ClienteRN clienteRN = new ClienteRN();
                clienteRN.excluirCliente(clienteVO);

                limpaCampos();
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Cadastro de Cliente", JOptionPane.PLAIN_MESSAGE);
                }
                
        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Exclusão Cliente", JOptionPane.ERROR_MESSAGE);
            
        } catch (ArrayIndexOutOfBoundsException aiobe) {

            JOptionPane.showMessageDialog(null, "Selecione um cliente.", "Exclusão Cliente", JOptionPane.WARNING_MESSAGE);

        } catch (Exception exc) {

            JOptionPane.showMessageDialog(null, "Erro: " + exc.getMessage(), "Exclusão Cliente", JOptionPane.ERROR_MESSAGE);
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
            limpaCampos();
            esconderCampos();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        
        tfNome.setEnabled(true);
        ftfTelefone.setEnabled(true);
        tfLogradouro.setEnabled(true);
        tfNumero.setEnabled(true);
        tfComplemento.setEnabled(true);
        tfBairro.setEnabled(true);
        tfCidade.setEnabled(true);
        cbEstado.setEnabled(true);
        ftfCEP.setEnabled(true);
    }
    
    public void esconderCampos(){
        
        tfNome.setEnabled(false);
        ftfTelefone.setEnabled(false);
        tfLogradouro.setEnabled(false);
        tfNumero.setEnabled(false);
        tfComplemento.setEnabled(false);
        tfBairro.setEnabled(false);
        tfCidade.setEnabled(false);
        cbEstado.setEnabled(false);
        ftfCEP.setEnabled(false);
    }
    
    public void limpaCampos(){
        
        tfCodigo.setText("");
        tfNome.setText("");
        ftfTelefone.setText("");
        tfLogradouro.setText("");
        tfNumero.setText("");
        tfComplemento.setText("");
        tfBairro.setText("");
        tfCidade.setText("");
        cbEstado.setSelectedIndex(0);
        ftfCEP.setText("");
    }

    public void popularCampos(ClienteVO clienteVO) {
        
        tfCodigo.setText(String.valueOf(clienteVO.getCodigo()));
        tfNome.setText(clienteVO.getNome());
        ftfTelefone.setText(clienteVO.getTelefone());
        tfLogradouro.setText(clienteVO.getLogradouro());
        tfNumero.setText(String.valueOf(clienteVO.getNumero()));
        tfComplemento.setText(clienteVO.getComplemento());
        tfBairro.setText(clienteVO.getBairro());
        tfCidade.setText(clienteVO.getCidade());
        cbEstado.getModel().setSelectedItem(clienteVO.getEstado());
        ftfCEP.setText(clienteVO.getCEP());
        
        PedidoVO pedidoVO = new PedidoVO();
        pedidoVO.setIdcliente(Integer.parseInt((String) tfCodigo.getText()));
        pedidoVO.setCliente(tfNome.getText());
        ModuloPedido.pegarCliente(pedidoVO);
    }
}
