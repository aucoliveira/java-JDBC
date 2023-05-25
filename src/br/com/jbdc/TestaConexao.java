package br.com.jbdc;

import br.com.jbdc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexao {

    public static void main(String[] args) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();
    }
}
