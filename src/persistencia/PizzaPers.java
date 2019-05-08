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
import vo.PizzaVO;

/**
 *
 * @author Karpa
 */
public class PizzaPers {
    
    Conexao conexao;
    
    public PizzaPers(){
        
        this.conexao = new Conexao();
    }
    
    
    public void salvarPizza (PizzaVO pizzaVO, int editar) throws SQLException, Exception{
        int edt = editar;
        try{
            
            if (edt == 1){
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "update pizza "
                    + "set sabor = '" + pizzaVO.getSabor() + "', "
                    + "ingredientes = '" + pizzaVO.getIngredientes() + "', "
                    + "tipo = '" + pizzaVO.getTipo() + "', "
                    + "preco = '" + pizzaVO.getPreco() + "' "
                    + "where idpizza = " + pizzaVO.getCodigo();

                stm.executeUpdate(sql);
                
                System.out.println(edt);
                
            }else{
            
                Connection con;
                Statement stm;
                String sql;

                con = conexao.conectar();

                stm = con.createStatement();
                sql = "insert into pizza (sabor, ingredientes, tipo, preco, ativo) "
                        + "values('" + pizzaVO.getSabor()+"', "
                        + "'" + pizzaVO.getIngredientes() + "', "
                        + "'" + pizzaVO.getTipo() + "', "
                        + "'" + pizzaVO.getPreco() + "', "
                        + 1 + ");";

                stm.executeUpdate(sql);
                
                System.out.println(edt);
            }
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirPizza (PizzaVO pizzaVO) throws SQLException, Exception {
        
        try {
            
            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update pizza "
                + "set ativo = " + 0 + " "
                + "where idpizza = " + pizzaVO.getCodigo();

            stm.executeUpdate(sql);
            
        } finally {

            conexao.desconectar();
        }
    }
    
    public ArrayList <PizzaVO> buscarPizzas() throws SQLException, Exception {

        ArrayList <PizzaVO> pizzas = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from pizza where ativo = 1");

            while (consulta.next()) {

                PizzaVO pizzaVO = new PizzaVO();

                pizzaVO.setCodigo(consulta.getInt("idpizza"));
                pizzaVO.setSabor(consulta.getString("sabor"));
                pizzaVO.setIngredientes(consulta.getString("ingredientes"));
                pizzaVO.setTipo(consulta.getString("tipo"));
                pizzaVO.setPreco(consulta.getString("preco"));
                pizzaVO.setAtivo(consulta.getInt("ativo"));
                
                pizzas.add(pizzaVO);
            }

        } finally {

            conexao.desconectar();
            return pizzas;
        }
    }
}
