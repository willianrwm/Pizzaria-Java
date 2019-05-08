/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import vo.ClienteVO;

/**
 *
 * @author Karpa
 */
public class ClientePers {
    
    Conexao conexao;
    
    public ClientePers(){
        
        this.conexao = new Conexao();
    }
    
    
    public void salvarCliente (ClienteVO clienteVO, int editar) throws SQLException, Exception{
        int edt = editar;
        try{
            
            if (edt == 1){
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "update cliente "
                    + "set nome = '" + clienteVO.getNome() + "', "
                    + "telefone = '" + clienteVO.getTelefone() + "', "
                    + "logradouro = '" + clienteVO.getLogradouro() + "', "
                    + "numero = " + clienteVO.getNumero() + ", "
                    + "complemento = '" + clienteVO.getComplemento() + "', "
                    + "bairro = '" + clienteVO.getBairro() + "', "
                    + "cidade = '" + clienteVO.getCidade() + "', "
                    + "estado = '" + clienteVO.getEstado() + "', "
                    + "CEP = '" + clienteVO.getCEP() + "' "
                    + "where idcliente = '" + clienteVO.getCodigo() + "'";

                stm.executeUpdate(sql);
                
                System.out.println(edt);
                
            }else{
            
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "insert into cliente (nome, telefone, logradouro, numero, complemento, bairro, cidade, estado, CEP, ativo) "
                        + "values('" + clienteVO.getNome()+"', "
                        + "'" + clienteVO.getTelefone() + "', "
                        + "'" + clienteVO.getLogradouro() + "', "
                        + clienteVO.getNumero() + ", "
                        + "'"+clienteVO.getComplemento()+"', "
                        + "'" + clienteVO.getBairro() + "', "
                        + "'" + clienteVO.getCidade() + "', "
                        + "'" + clienteVO.getEstado() + "', "
                        + "'" + clienteVO.getCEP() + "', "
                        + 1 + ");";

                stm.executeUpdate(sql);
                
                System.out.println(edt);
            }
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirCliente (ClienteVO clienteVO) throws SQLException, Exception {
        
        try {
            
            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update cliente "
                + "set ativo = " + 0 + " "
                + "where idcliente = " + clienteVO.getCodigo();

            stm.executeUpdate(sql);
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public ArrayList <ClienteVO> buscarClientes() throws SQLException, Exception {

        ArrayList <ClienteVO> clientes = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from cliente where ativo = 1");

            while (consulta.next()) {

                ClienteVO clienteVO = new ClienteVO();

                clienteVO.setCodigo(consulta.getInt("idcliente"));
                clienteVO.setNome(consulta.getString("nome"));
                clienteVO.setTelefone(consulta.getString("telefone"));
                clienteVO.setLogradouro(consulta.getString("logradouro"));
                clienteVO.setNumero(consulta.getInt("numero"));
                clienteVO.setComplemento(consulta.getString("complemento"));
                clienteVO.setBairro(consulta.getString("bairro"));
                clienteVO.setCidade(consulta.getString("cidade"));
                clienteVO.setEstado(consulta.getString("estado"));
                clienteVO.setCEP(consulta.getString("CEP"));
                clienteVO.setAtivo(consulta.getInt("ativo"));
                
                clientes.add(clienteVO);
            }

        } finally {

            conexao.desconectar();
            return clientes;
        }
    }
    
    
    public ArrayList <ClienteVO> filtrarClientes(String telefone) throws SQLException, Exception {
        
        ArrayList <ClienteVO> clientes = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from cliente where telefone like '%"+ telefone  +"%'");

            while (consulta.next()) {

                ClienteVO clienteVO = new ClienteVO();

                clienteVO.setCodigo(consulta.getInt("idcliente"));
                clienteVO.setNome(consulta.getString("nome"));
                clienteVO.setTelefone(consulta.getString("telefone"));
                clienteVO.setLogradouro(consulta.getString("logradouro"));
                clienteVO.setNumero(consulta.getInt("numero"));
                clienteVO.setComplemento(consulta.getString("complemento"));
                clienteVO.setBairro(consulta.getString("bairro"));
                clienteVO.setCidade(consulta.getString("cidade"));
                clienteVO.setEstado(consulta.getString("estado"));
                clienteVO.setCEP(consulta.getString("CEP"));
                clienteVO.setAtivo(consulta.getInt("ativo"));
                
                clientes.add(clienteVO);
            }

        } finally {

            conexao.desconectar();
            return clientes;
        }
    }
}
