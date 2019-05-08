/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PedidoPers;
import vo.BebidaVO;
import vo.BordaVO;
import vo.PedidoVO;
import vo.PizzaVO;

/**
 *
 * @author Karpa
 */
public class PedidoRN {
    
    public ArrayList <PizzaVO> popularSabor() throws SQLException, Exception {
        
        PedidoPers pedidoPers = new PedidoPers();
        return pedidoPers.popularSabor();
    }

    public ArrayList<BordaVO> popularBorda() throws SQLException, Exception {
        
        PedidoPers pedidoPers = new PedidoPers();
        return pedidoPers.popularBorda();
    }

    public ArrayList<BebidaVO> popularBebida() throws SQLException, Exception {
        
        PedidoPers pedidoPers = new PedidoPers();
        return pedidoPers.popularBebida();
    }

    public String valorBorda(String borda) throws SQLException, Exception {
        
        PedidoPers pedidoPers = new PedidoPers();
        return pedidoPers.valorBorda(borda);
    }

    public String valorBebida(String bebida, String volume) throws SQLException, Exception {
        
        PedidoPers pedidoPers = new PedidoPers();
        return pedidoPers.valorBebida(bebida, volume);
    }

    public ArrayList<BebidaVO> popularVolume(String marca) throws SQLException, Exception {
        
        PedidoPers pedidoPers = new PedidoPers();
        return pedidoPers.popularVolume(marca);
    }

    public void salvarPedido(PedidoVO pedidoVO) throws SQLException, Exception {
        
        PedidoPers pedidoPers = new PedidoPers();
        pedidoPers.salvarPedido(pedidoVO);
    }
    
}
