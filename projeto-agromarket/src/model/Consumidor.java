package model;

import exceptions.EstoqueInsuficienteException;

public class Consumidor {
    private int idConsumidor;
    private String nome;
    private String cpf;
    private String endereco;
    private Venda[] vendas;
    private int totalVendas;
    private Encomenda[] encomendas;
    private int totalEncomendas;
    private static final int MAX_VENDAS = 50;
    private static final int MAX_ENCOMENDAS = 20;

    public Consumidor(int idConsumidor, String nome, String cpf, String endereco) {
        this.idConsumidor = idConsumidor;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.vendas = new Venda[MAX_VENDAS];
        this.encomendas = new Encomenda[MAX_ENCOMENDAS];
        this.totalVendas = 0;
        this.totalEncomendas = 0;
    }

    // Getters
    public int getIdConsumidor() { return idConsumidor; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }
    public int getTotalVendas() { return totalVendas; }
    public int getTotalEncomendas() { return totalEncomendas; }

    // Setters
    public void setIdConsumidor(int idConsumidor) { this.idConsumidor = idConsumidor; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    // Compra um produto em uma banca e registra a venda
    public void comprarProduto(Banca banca, Produto produto, int quantidade, String data)
            throws EstoqueInsuficienteException {
        banca.venderProduto(produto, quantidade);
        Venda venda = new Venda(totalVendas + 1, data);
        venda.adicionarProduto(produto, quantidade);
        venda.registrarVenda();
        if (totalVendas < MAX_VENDAS) {
            vendas[totalVendas++] = venda;
        }
        System.out.println("Compra realizada por " + nome + " na banca " + banca.getNome());
    }

    // Realiza uma encomenda de um produto
    public void realizarEncomenda(Produto produto, int quantidade, String data) {
        Encomenda encomenda = new Encomenda(totalEncomendas + 1, data);
        encomenda.adicionarProduto(produto, quantidade);
        encomenda.confirmarEncomenda();
        if (totalEncomendas < MAX_ENCOMENDAS) {
            encomendas[totalEncomendas++] = encomenda;
        }
        System.out.println("Encomenda realizada por " + nome + " | Produto: " + produto.getNome());
    }

    @Override
    public String toString() {
        return "Consumidor: " + nome + " | CPF: " + cpf + " | Vendas: " + totalVendas + " | Encomendas: " + totalEncomendas;
    }
}
