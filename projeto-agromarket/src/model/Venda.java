package model;

public class Venda {
    private int idVenda;
    private String dataVenda;
    private double valorTotal;
    private Produto[] produtos;
    private int[] quantidades;
    private int totalItens;
    private static final int MAX_ITENS = 20;

    public Venda(int idVenda, String dataVenda) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valorTotal = 0.0;
        this.produtos = new Produto[MAX_ITENS];
        this.quantidades = new int[MAX_ITENS];
        this.totalItens = 0;
    }

    // Getters
    public int getIdVenda() { return idVenda; }
    public String getDataVenda() { return dataVenda; }
    public double getValorTotal() { return valorTotal; }
    public int getTotalItens() { return totalItens; }

    // Setters
    public void setIdVenda(int idVenda) { this.idVenda = idVenda; }
    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; }

    // Adiciona um produto à venda
    public void adicionarProduto(Produto produto, int qtd) {
        if (totalItens < MAX_ITENS) {
            produtos[totalItens] = produto;
            quantidades[totalItens] = qtd;
            totalItens++;
        } else {
            System.out.println("Limite de itens por venda atingido.");
        }
    }

    // Calcula o valor total somando todos os itens
    public double calcularTotal() {
        valorTotal = 0.0;
        for (int i = 0; i < totalItens; i++) {
            valorTotal += produtos[i].getValor() * quantidades[i];
        }
        return valorTotal;
    }

    // Registra e imprime a venda completa
    public void registrarVenda() {
        calcularTotal();
        System.out.println("===== VENDA REGISTRADA =====");
        System.out.println("ID Venda  : " + idVenda);
        System.out.println("Data      : " + dataVenda);
        for (int i = 0; i < totalItens; i++) {
            System.out.println("  - " + produtos[i].getNome() + " x" + quantidades[i] + " = R$" + (produtos[i].getValor() * quantidades[i]));
        }
        System.out.println("Total     : R$" + valorTotal);
        System.out.println("============================");
    }

    @Override
    public String toString() {
        return "Venda #" + idVenda + " | Data: " + dataVenda + " | Total: R$" + valorTotal;
    }
}
