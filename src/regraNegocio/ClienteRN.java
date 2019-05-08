/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.ClientePers;
import vo.ClienteVO;

/**
 *
 * @author Karpa
 */
public class ClienteRN {
    
    public void salvarCliente(ClienteVO clienteVO, int editar) throws SQLException, Exception {
        
        ClientePers clientePers = new ClientePers();
        clientePers.salvarCliente(clienteVO, editar);
    }
    
    public void excluirCliente(ClienteVO clienteVO) throws SQLException, Exception {
        
        ClientePers clientePers = new ClientePers();
        clientePers.excluirCliente(clienteVO);
    }
    
    public ArrayList <ClienteVO> buscarClientes() throws SQLException, Exception {
        
        ClientePers clientePers = new ClientePers();
        return clientePers.buscarClientes();
    }
    
    public ArrayList <ClienteVO> filtrarClientes(String telefone) throws SQLException, Exception {
        
        ClientePers clientePers = new ClientePers();
        return clientePers.filtrarClientes(telefone);
    }
}
