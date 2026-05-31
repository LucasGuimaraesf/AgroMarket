package model;

import exceptions.EncomendaCancelamentoException;

public class Encomenda {

    private int idEncomenda;
    private String dataEncomenda;
    //Status possíveis: "PENDENTE", "CONFIRMADA", "CANCELADA", "ENTREGUE"
    private String status;
    private Produto[] produtos;
    private int[] quantidades;
    private int totalItens;
    private static final int MAX_ITENS = 20;

    public Encomenda(int idEncomenda, String dataEncomenda) {
        this.idEncomenda = idEncomenda;
        this.dataEncomenda = dataEncomenda;
        this.status = "PENDENTE";
        this.produtos = new Produto[MAX_ITENS];
        this.quantidades = new int[MAX_ITENS];
        this.totalItens = 0;
    }

    //Getters
    public int getIdEncomenda() { return idEncomenda; }
    public String getDataEncomenda() { return dataEncomenda; }
    public String getStatus() { return status; }
    public int getTotalItens() { return totalItens; }

    //Setters
    public void setIdEncomenda(int idEncomenda) { this.idEncomenda = idEncomenda; }
    public void setDataEncomenda(String dataEncomenda) { this.dataEncomenda = dataEncomenda; }
    public void setStatus(String status) { this.status = status; }

    //Adiciona um produto à encomenda
    public void adicionarProduto(Produto produto, int qtd) {
        if (totalItens < MAX_ITENS) {
            produtos[totalItens] = produto;
            quantidades[totalItens] = qtd;
            totalItens++;
        } else {
            System.out.println("Limite de itens por encomenda atingido.");
        }
    }

    //Confirma a encomenda se estiver pendente
    public void confirmarEncomenda() {
        if (status.equals("PENDENTE")) {
            this.status = "CONFIRMADA";
            System.out.println("Encomenda #" + idEncomenda + " confirmada!");
        } else {
            System.out.println("Encomenda #" + idEncomenda + " nao pode ser confirmada. Status: " + status);
        }
    }

    //Cancela a encomenda — lança exceção se já entregue ou cancelada
    public void cancelarEncomenda() throws EncomendaCancelamentoException {
        if (status.equals("ENTREGUE") || status.equals("CANCELADA")) {
            throw new EncomendaCancelamentoException(idEncomenda, status);
        }
        this.status = "CANCELADA";
        System.out.println("Encomenda #" + idEncomenda + " cancelada.");
    }

    @Override
    public String toString() {
        return "Encomenda #" + idEncomenda + " | Data: " + dataEncomenda + " | Status: " + status + " | Itens: " + totalItens;
    }
}