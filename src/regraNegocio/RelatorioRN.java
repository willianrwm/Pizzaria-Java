/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import persistencia.RelatorioPers;
import vo.PedidoVO;

/**
 *
 * @author Karpa
 */
public class RelatorioRN {

    public ArrayList<PedidoVO> buscarPedidos() throws SQLException, Exception {
        
        RelatorioPers relatorioPers = new RelatorioPers();
        return relatorioPers.buscarPedidos();
    }

    public ArrayList<PedidoVO> filtrarPedidos(String nome) throws SQLException, Exception {

        RelatorioPers relatorioPers = new RelatorioPers();
        return relatorioPers.filtrarPedidos(nome);
    }

    public ArrayList<PedidoVO> filtrarPedidosData(String dataInicial, String dataFinal, String nome) throws SQLException, Exception {
        
        RelatorioPers relatorioPers = new RelatorioPers();
        return relatorioPers.filtrarPedidosData(dataInicial, dataFinal, nome);
    }
    
}
