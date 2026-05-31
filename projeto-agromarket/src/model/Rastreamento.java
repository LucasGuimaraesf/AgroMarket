package model;

public class Rastreamento {
    private int idRastreamento;
    private String origem;
    private String destino;
    private String dataTransporte;

    //Criando os construtores
    public Rastreamento(int idRastreamento, String origem, String destino, String dataTransporte) {
        this.idRastreamento = idRastreamento;
        this.origem = origem;
        this.destino = destino;
        this.dataTransporte = dataTransporte;
    }

    // Getters
    public int getIdRastreamento() { return idRastreamento; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public String getDataTransporte() { return dataTransporte; }

    // Setters
    public void setIdRastreamento(int idRastreamento) { this.idRastreamento = idRastreamento; }
    public void setOrigem(String origem) { this.origem = origem; }
    public void setDestino(String destino) { this.destino = destino; }
    public void setDataTransporte(String dataTransporte) { this.dataTransporte = dataTransporte; }
    
        // Mostra de onde veio o produto
    public void rastrearOrigem() {
        System.out.println("Rastreamento #" + idRastreamento + " | Origem: " + origem + " -> Destino: " + destino);
    }

    // Mostra o histórico completo do transporte
    public void emitirHistorico() {
        System.out.println("Historico de transporte:");
        System.out.println("  ID: " + idRastreamento);
        System.out.println("  Origem: " + origem);
        System.out.println("  Destino: " + destino);
        System.out.println("  Data: " + dataTransporte);
    }

    @Override
    public String toString() {
        return "Rastreamento #" + idRastreamento + " | " + origem + " -> " + destino + " | Data: " + dataTransporte;
    }
}
