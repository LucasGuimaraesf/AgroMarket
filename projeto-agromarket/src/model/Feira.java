package model;

import exceptions.FeiraJaAbertaException;

public class Feira {

    private int idFeira;
    private String nome;
    private String local;
    private String data;
    private String horario;
    private boolean aberta;
    private Banca[] bancas;
    private int totalBancas;
    private static final int MAX_BANCAS = 50;

    public Feira(int idFeira, String nome, String local, String data, String horario) {
        this.idFeira = idFeira;
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.aberta = false;
        this.bancas = new Banca[MAX_BANCAS];
        this.totalBancas = 0;
    }

    // Getters
    public int getIdFeira() { return idFeira; }
    public String getNome() { return nome; }
    public String getLocal() { return local; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
    public boolean isAberta() { return aberta; }
    public int getTotalBancas() { return totalBancas; }

    // Setters
    public void setIdFeira(int idFeira) { this.idFeira = idFeira; }
    public void setNome(String nome) { this.nome = nome; }
    public void setLocal(String local) { this.local = local; }
    public void setData(String data) { this.data = data; }
    public void setHorario(String horario) { this.horario = horario; }

    // Abre a feira — lança exceção se já estiver aberta
    public void abrirFeira() throws FeiraJaAbertaException {
        if (aberta) {
            throw new FeiraJaAbertaException(nome);
        }
        this.aberta = true;
        System.out.println("Feira '" + nome + "' aberta em " + local + " as " + horario);
    }

    // Fecha a feira
    public void fecharFeira() {
        if (!aberta) {
            System.out.println("A feira '" + nome + "' ja esta fechada.");
            return;
        }
        this.aberta = false;
        System.out.println("Feira '" + nome + "' encerrada.");
    }

    // Adiciona uma banca à feira
    public void adicionarBanca(Banca banca) {
        if (totalBancas < MAX_BANCAS) {
            bancas[totalBancas++] = banca;
            System.out.println("Banca '" + banca.getNome() + "' adicionada a feira " + nome);
        } else {
            System.out.println("Limite de bancas da feira atingido.");
        }
    }

    // Gera relatório de vendas da feira
    public void gerarRelatorioVendas() {
        System.out.println("===== RELATORIO DE VENDAS - FEIRA: " + nome + " =====");
        System.out.println("Local   : " + local);
        System.out.println("Data    : " + data);
        System.out.println("Horario : " + horario);
        System.out.println("Bancas  : " + totalBancas);
        for (int i = 0; i < totalBancas; i++) {
            System.out.println("  Banca: " + bancas[i].getNome() + " | Produtos: " + bancas[i].getTotalProdutos());
        }
        System.out.println("=================================================");
    }

    @Override
    public String toString() {
        return "Feira: " + nome + " | Local: " + local + " | Aberta: " + aberta + " | Bancas: " + totalBancas;
    }
}