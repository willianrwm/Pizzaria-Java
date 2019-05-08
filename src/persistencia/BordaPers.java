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
import vo.BordaVO;

/**
 *
 * @author Karpa
 */
public class BordaPers {
    
    Conexao conexao;
    
    public BordaPers(){
        
        this.conexao = new Conexao();
    }
    
    
    public void salvarBorda (BordaVO bordaVO, int editar) throws SQLException, Exception{
        int edt = editar;
        try{
            
            if (edt == 1){
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "update borda "
                    + "set sabor = '" + bordaVO.getSabor() + "', "
                    + "tipo = '" + bordaVO.getTipo() + "', "
                    + "preco = '" + bordaVO.getPreco() + "' "
                    + "where idborda = " + bordaVO.getCodigo();

                stm.executeUpdate(sql);
                
                System.out.println(edt);
                
            }else{
            
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "insert into borda (sabor, tipo, preco, ativo) "
                        + "values('" + bordaVO.getSabor()+"', "
                        + "'" + bordaVO.getTipo() + "', "
                        + "'" + bordaVO.getPreco() + "', "
                        + 1 + ");";

                stm.executeUpdate(sql);
                
                System.out.println(edt);
            }
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirBorda (BordaVO bordaVO) throws SQLException, Exception {
        
        try {
            
            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update borda "
                + "set ativo = " + 0 + " "
                + "where idborda = " + bordaVO.getCodigo();

            stm.executeUpdate(sql);
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public ArrayList <BordaVO> buscarBordas() throws SQLException, Exception {

        ArrayList <BordaVO> bordas = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from borda where ativo = 1");

            while (consulta.next()) {

                BordaVO bordaVO = new BordaVO();

                bordaVO.setCodigo(consulta.getInt("idborda"));
                bordaVO.setPreco(consulta.getString("preco"));
                bordaVO.setSabor(consulta.getString("sabor"));
                bordaVO.setTipo(consulta.getString("tipo"));
                bordaVO.setAtivo(consulta.getInt("ativo"));
                
                bordas.add(bordaVO);
            }

        } finally {

            conexao.desconectar();
            return bordas;
        }
    }
}
