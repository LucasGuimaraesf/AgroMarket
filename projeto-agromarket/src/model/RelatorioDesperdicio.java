package model;

public class RelatorioDesperdicio {
    
    private int idRelatorio;
    private int quantidadePerdida;
    private String motivo;
    private Produto produto;

    //Construtor
    public RelatorioDesperdicio(int idRelatorio, int quantidadePerdida, String motivo) {
        this.idRelatorio = idRelatorio;
        this.quantidadePerdida = quantidadePerdida;
        this.motivo = motivo;
    }

    // Getters
    public int getIdRelatorio() { return idRelatorio; }
    public int getQuantidadePerdida() { return quantidadePerdida; }
    public String getMotivo() { return motivo; }
    public Produto getProduto() { return produto; }

    // Setters
    public void setIdRelatorio(int idRelatorio) { this.idRelatorio = idRelatorio; }
    public void setQuantidadePerdida(int quantidadePerdida) { this.quantidadePerdida = quantidadePerdida; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setProduto(Produto produto) { this.produto = produto; }

    // Gera o relatório na tela
    public void gerarRelatorio() {
        System.out.println("===== RELATORIO DE DESPERDICIO =====");
        System.out.println("ID Relatorio  : " + idRelatorio);
        System.out.println("Produto       : " + (produto != null ? produto.getNome() : "nao informado"));
        System.out.println("Qtd. Perdida  : " + quantidadePerdida + " unidade(s)");
        System.out.println("Motivo        : " + motivo);
        System.out.println("====================================");
    }

    @Override
    public String toString() {
        return "Relatorio #" + idRelatorio + " | Perdidas: " + quantidadePerdida + " | Motivo: " + motivo;
    }
}
