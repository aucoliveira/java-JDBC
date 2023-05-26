package br.com.jbdc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Integer  id;
    private String nome;
    private List<Produto> produtos = new ArrayList<Produto>();

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
