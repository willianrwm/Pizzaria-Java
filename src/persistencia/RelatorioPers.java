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
import vo.PedidoVO;

/**
 *
 * @author Karpa
 */
public class RelatorioPers {
    Conexao conexao;
    
    public RelatorioPers(){
        
        this.conexao = new Conexao();
    }

    public ArrayList<PedidoVO> buscarPedidos() throws SQLException, Exception {
        
        ArrayList <PedidoVO> pedidos = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from pedido");

            while (consulta.next()) {

                PedidoVO pedidoVO = new PedidoVO();

                pedidoVO.setIdpedido(consulta.getInt("idpedido"));
                pedidoVO.setData(consulta.getString("data"));
                pedidoVO.setCliente(consulta.getString("cliente"));
                pedidoVO.setValor(consulta.getString("valor"));
                
                pedidos.add(pedidoVO);
            }

        } finally {

            conexao.desconectar();
            return pedidos;
        }
    }

    public ArrayList<PedidoVO> filtrarPedidos(String nome) throws SQLException, Exception {
        
        ArrayList <PedidoVO> pedidos = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from pedido where cliente like '%"+nome+"%'");

            while (consulta.next()) {

                PedidoVO pedidoVO = new PedidoVO();

                pedidoVO.setIdpedido(consulta.getInt("idpedido"));
                pedidoVO.setData(consulta.getString("data"));
                pedidoVO.setCliente(consulta.getString("cliente"));
                pedidoVO.setValor(consulta.getString("valor"));
                
                pedidos.add(pedidoVO);
            }

        } finally {

            conexao.desconectar();
            return pedidos;
        }
    }

    public ArrayList<PedidoVO> filtrarPedidosData(String dataInicial, String dataFinal, String nome) throws SQLException, Exception {
        
        ArrayList <PedidoVO> pedidos = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from pedido where data between '"+dataInicial+"' and '"+dataFinal+"' and cliente like '%"+nome+"%'");

            while (consulta.next()) {

                PedidoVO pedidoVO = new PedidoVO();

                pedidoVO.setIdpedido(consulta.getInt("idpedido"));
                pedidoVO.setData(consulta.getString("data"));
                pedidoVO.setCliente(consulta.getString("cliente"));
                pedidoVO.setValor(consulta.getString("valor"));
                
                pedidos.add(pedidoVO);
            }

        } finally {

            conexao.desconectar();
            return pedidos;
        }
    }
    
}
