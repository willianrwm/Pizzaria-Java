/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PizzaPers;
import vo.PizzaVO;

/**
 *
 * @author Karpa
 */
public class PizzaRN {
    
    public void salvarPizza(PizzaVO pizzaVO, int editar) throws SQLException, Exception {
        
        PizzaPers pizzaPers = new PizzaPers();
        pizzaPers.salvarPizza(pizzaVO, editar);
    }
    
    public void excluirPizza(PizzaVO pizzaVO) throws SQLException, Exception {
        
        PizzaPers pizzaPers = new PizzaPers();
        pizzaPers.excluirPizza(pizzaVO);
    }
    
    public ArrayList <PizzaVO> buscarPizzas() throws SQLException, Exception {
        
        PizzaPers pizzaPers = new PizzaPers();
        return pizzaPers.buscarPizzas();
    }
}
