import br.com.jbdc.dao.CategoriaDAO;
import br.com.jbdc.factory.ConnectionFactory;
import br.com.jbdc.modelo.Categoria;
import br.com.jbdc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

            List<Categoria> listaDeCategoria = categoriaDAO.listarComProdutos();
            listaDeCategoria.stream()
                    .forEach(ca -> {
                        System.out.println( ca.getNome()+":");

                            for( Produto produto : ca.getProdutos() ) {
                                System.out.println(ca.getNome()+ " - "+ produto.getNome());
                            }

                        });

        }

    }
}
