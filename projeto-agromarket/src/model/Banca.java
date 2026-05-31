package model;

import exceptions.EstoqueInsuficienteException;

public class Banca {
     private int idBanca;
    private String nome;
    private String localizacao;
    private String tipoProduto;
    private Fornecedor fornecedor;
    private Produto[] produtos;
    private int totalProdutos;
    private static final int MAX_PRODUTOS = 30;

    public Banca(int idBanca, String nome, String localizacao, String tipoProduto) {
        this.idBanca = idBanca;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoProduto = tipoProduto;
        this.produtos = new Produto[MAX_PRODUTOS];
        this.totalProdutos = 0;
    }

    // Getters
    public int getIdBanca() { return idBanca; }
    public String getNome() { return nome; }
    public String getLocalizacao() { return localizacao; }
    public String getTipoProduto() { return tipoProduto; }
    public Fornecedor getFornecedor() { return fornecedor; }
    public int getTotalProdutos() { return totalProdutos; }

    // Setters
    public void setIdBanca(int idBanca) { this.idBanca = idBanca; }
    public void setNome(String nome) { this.nome = nome; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    public void setTipoProduto(String tipoProduto) { this.tipoProduto = tipoProduto; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    // Adiciona um produto à banca
    public void adicionarProduto(Produto produto) {
        if (totalProdutos < MAX_PRODUTOS) {
            produtos[totalProdutos] = produto;
            totalProdutos++;
            System.out.println("Produto '" + produto.getNome() + "' adicionado a banca " + nome);
        } else {
            System.out.println("Banca " + nome + " atingiu o limite de produtos.");
        }
    }

    // Lista todos os produtos da banca
    public void listarProdutos() {
        System.out.println("--- Produtos da Banca: " + nome + " ---");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.println("  " + produtos[i]);
        }
    }

    // Vende um produto da banca
    public void venderProduto(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        produto.reduzirEstoque(quantidade);
        System.out.println("Venda realizada na banca " + nome);
    }

    // Atualiza o estoque de um produto da banca
    public void atualizarEstoque(Produto produto, int quantidade) {
        produto.atualizaEstoque(quantidade);
        System.out.println("Estoque atualizado na banca " + nome);
    }

    @Override
    public String toString() {
        return "Banca: " + nome + " | Local: " + localizacao + " | Tipo: " + tipoProduto + " | Produtos: " + totalProdutos;
    }
}
