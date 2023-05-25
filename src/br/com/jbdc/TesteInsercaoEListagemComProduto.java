package br.com.jbdc;

import br.com.jbdc.dao.ProdutoDAO;
import br.com.jbdc.factory.ConnectionFactory;
import br.com.jbdc.modelo.Produto;

import java.sql.*;
import java.util.List;

public class TesteInsercaoEListagemComProduto {

    public static void main(String[] args)  throws SQLException {

        Produto comada = new Produto("Cômanda","Cômada vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comada);

            List<Produto> produtoList = produtoDAO.listar();
            produtoList.stream()
                    .forEach(lp -> System.out.println(lp));
        }
        System.out.println(comada);
    }
}
