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
import vo.BebidaVO;
import vo.BordaVO;
import vo.PedidoVO;
import vo.PizzaVO;

/**
 *
 * @author Karpa
 */
public class PedidoPers {
    
    Conexao conexao;
    
    public PedidoPers(){
        
        this.conexao = new Conexao();
    }
    
    public ArrayList <PizzaVO> popularSabor() throws SQLException, Exception {

        ArrayList <PizzaVO> sabor = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select sabor from pizza");

            while (consulta.next()) {

                PizzaVO pizzaVO = new PizzaVO();

                pizzaVO.setSabor(consulta.getString("sabor"));
                
                sabor.add(pizzaVO);
            }

        } finally {

            conexao.desconectar();
            return sabor;
        }
    }

    public ArrayList<BordaVO> popularBorda() throws SQLException, Exception {
        
        ArrayList <BordaVO> borda = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select sabor from borda");

            while (consulta.next()) {

                BordaVO bordaVO = new BordaVO();

                bordaVO.setSabor(consulta.getString("sabor"));
                
                borda.add(bordaVO);
            }

        } finally {

            conexao.desconectar();
            return borda;
        }
    }

    public ArrayList<BebidaVO> popularBebida() throws SQLException, Exception {
        
        ArrayList <BebidaVO> bebida = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select marca from bebida");

            while (consulta.next()) {

                BebidaVO bebidaVO = new BebidaVO();

                bebidaVO.setMarca(consulta.getString("marca"));
                
                bebida.add(bebidaVO);
            }

        } finally {

            conexao.desconectar();
            return bebida;
        }
    }

    public String valorBorda(String borda) throws SQLException, Exception {
        String valor = null;
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            
            consulta = stm.executeQuery("select preco from borda where sabor like '%"+borda+"%'");
            consulta.next();
            valor = consulta.getString("preco");
            
        } finally {
            
            conexao.desconectar();
            return valor;
        }
    }

    public String valorBebida(String bebida, String volume) throws SQLException, Exception {
        String valor = null;
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            
            consulta = stm.executeQuery("select preco from bebida where marca ='"+bebida+"' and volume ='"+volume+"'");
            consulta.next();
            valor = consulta.getString("preco");
            
        } finally {
            
            conexao.desconectar();
            return valor;
        }
    }

    public ArrayList<BebidaVO> popularVolume(String marca) throws SQLException, Exception {
        
        ArrayList <BebidaVO> volume = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select volume from bebida where marca ='"+marca+"'");

            while (consulta.next()) {

                BebidaVO bebidaVO = new BebidaVO();

                bebidaVO.setVolume(consulta.getInt("volume"));
                
                volume.add(bebidaVO);
            }

        } finally {

            conexao.desconectar();
            return volume;
        }
    }

    public void salvarPedido(PedidoVO pedidoVO) throws SQLException, Exception {
        
        try{
            
            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "insert into pedido (idcliente, data, valor, cliente) "
                  + "values("+ pedidoVO.getIdcliente()+", "
                  + "'" + pedidoVO.getData()+ "', "
                  + "'" + pedidoVO.getValor()+ "', "
                  + "'"+pedidoVO.getCliente()+ "');";

                stm.executeUpdate(sql);
             
        } finally {

            conexao.desconectar();
        }
    }
    
}
