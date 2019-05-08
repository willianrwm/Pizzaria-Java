/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BordaPers;
import vo.BordaVO;

/**
 *
 * @author Karpa
 */
public class BordaRN {
    
    public void salvarBorda(BordaVO bordaVO, int editar) throws SQLException, Exception {
        
        BordaPers bordaPers = new BordaPers();
        bordaPers.salvarBorda(bordaVO, editar);
    }
    
    public void excluirBorda(BordaVO bordaVO) throws SQLException, Exception {
        
        BordaPers bordaPers = new BordaPers();
        bordaPers.excluirBorda(bordaVO);
    }
    
    public ArrayList <BordaVO> buscarBordas() throws SQLException, Exception {
        
        BordaPers bordaPers = new BordaPers();
        return bordaPers.buscarBordas();
    }
}
