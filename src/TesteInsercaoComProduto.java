import java.sql.*;

public class TesteInsercaoComProduto {

    public static void main(String[] args)  throws SQLException {

        Produto comada = new Produto("Cômanda","Cômada vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ) {

                pstm.setString(1,comada.getNome());
                pstm.setString(2, comada.getDescricao());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while(rst.next()) {
                        comada.setId(rst.getInt(1));
                    }
                }
            }
        }
        System.out.println(comada);
    }
}
