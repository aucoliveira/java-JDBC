package br.com.jbdc.controller;

import br.com.jbdc.dao.CategoriaDAO;
import br.com.jbdc.factory.ConnectionFactory;
import br.com.jbdc.modelo.Categoria;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        Connection connection =
                new ConnectionFactory().recuperarConexao();
        this.categoriaDAO = new CategoriaDAO(connection);
    }
    public List<Categoria> listar() {
        return this.categoriaDAO.listar();
    }
}
