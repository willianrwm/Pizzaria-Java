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

/**
 *
 * @author Karpa
 */
public class BebidaPers {
    
    Conexao conexao;
    
    public BebidaPers(){
        
        this.conexao = new Conexao();
    }
    
    
    public void salvarBebida (BebidaVO bebidaVO, int editar) throws SQLException, Exception{
        int edt = editar;
        try{
            
            if (edt == 1){
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "update bebida "
                    + "set marca = '" + bebidaVO.getMarca() + "', "
                    + "tipo = '" + bebidaVO.getTipo() + "', "
                    + "volume = '" + bebidaVO.getVolume() + "', "
                    + "preco = '" + bebidaVO.getPreco() + "' "
                    + "where idbebida = " + bebidaVO.getCodigo();

                stm.executeUpdate(sql);
                
                System.out.println(edt);
                
            }else{
            
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "insert into bebida (marca, tipo, volume, preco, ativo) "
                        + "values('" + bebidaVO.getMarca()+"', "
                        + "'" + bebidaVO.getTipo() + "', "
                        + "'" + bebidaVO.getVolume() + "', "
                        + "'" + bebidaVO.getPreco() + "', "
                        + 1 + ");";

                stm.executeUpdate(sql);
                
                System.out.println(edt);
            }
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirBebida (BebidaVO bebidaVO) throws SQLException, Exception {
        
        try {
            
            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update bebida "
                + "set ativo = " + 0 + " "
                + "where idbebida = " + bebidaVO.getCodigo();

            stm.executeUpdate(sql);
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public ArrayList <BebidaVO> buscarBebidas() throws SQLException, Exception {

        ArrayList <BebidaVO> bebidas = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from bebida where ativo = 1");

            while (consulta.next()) {

                BebidaVO bebidaVO = new BebidaVO();

                bebidaVO.setCodigo(consulta.getInt("idbebida"));
                bebidaVO.setMarca(consulta.getString("marca"));
                bebidaVO.setTipo(consulta.getString("tipo"));
                bebidaVO.setVolume(consulta.getInt("volume"));
                bebidaVO.setPreco(consulta.getString("preco"));
                bebidaVO.setAtivo(consulta.getInt("ativo"));
                
                bebidas.add(bebidaVO);
            }

        } finally {

            conexao.desconectar();
            return bebidas;
        }
    }
}