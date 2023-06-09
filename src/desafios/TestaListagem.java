package desafios;

import br.com.jbdc.factory.ConnectionFactory;

import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) {
        try {
           ConnectionFactory connectionFactory = new ConnectionFactory();
           Connection connection = connectionFactory.recuperarConexao();

            PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
            stm.execute();
            ResultSet rst = stm.getResultSet();

            while(rst.next()) {
                Integer id = rst.getInt("ID");
                System.out.println(id);
                String nome = rst.getString("NOME");
                System.out.println(nome);
                String descricao = rst.getString("DESCRICAO");
                System.out.println(descricao);
            }


            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
    }
}
