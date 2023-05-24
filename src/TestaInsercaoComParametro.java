import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args)  throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperarConexao()) {

            connection.setAutoCommit(false);

            try (PreparedStatement stm = connection
                    .prepareStatement("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);) {

                adicionarVariavel("Smart TV", "45 polegadas", stm);
                adicionarVariavel("Radio", "Radio a pilha", stm);

                connection.commit();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                connection.rollback();
            }
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);
        if (nome.equals("Radio")) {

        }
        stm.execute();

        try(ResultSet rst = stm.getGeneratedKeys()) {
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi: " + id);
            }
        }
    }
}
