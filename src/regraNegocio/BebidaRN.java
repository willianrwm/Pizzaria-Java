/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BebidaPers;
import vo.BebidaVO;

/**
 *
 * @author Karpa
 */
public class BebidaRN {
    
    public void salvarBebida(BebidaVO bebidaVO, int editar) throws SQLException, Exception {
        
        BebidaPers bebidaPers = new BebidaPers();
        bebidaPers.salvarBebida(bebidaVO, editar);
    }
    
    public void excluirBebida(BebidaVO bebidaVO) throws SQLException, Exception {
        
        BebidaPers bebidaPers = new BebidaPers();
        bebidaPers.excluirBebida(bebidaVO);
    }
    
    public ArrayList <BebidaVO> buscarBebidas() throws SQLException, Exception {
        
        BebidaPers bebidaPers = new BebidaPers();
        return bebidaPers.buscarBebidas();
    }
}
