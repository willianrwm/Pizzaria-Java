/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.*;

/**
 *
 * @author Vinicius
 */
public class Conexao {

    public Connection con = null;

    public Connection conectar() throws ClassNotFoundException, SQLException, Exception {

//        String url = "jdbc:postgresql://localhost:5432/dbExemploLPOO";
//        String username = "postgres";
//        String senha = "postgres";
        
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbProjetoFinalLOO", "postgres", "0815");

        return con;
    }

    public Connection desconectar() throws SQLException, Exception {

        con.close();

        return con;
    }
}




