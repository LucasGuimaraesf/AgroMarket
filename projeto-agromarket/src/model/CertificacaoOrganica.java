package model;

public class CertificacaoOrganica {
    private int idCertificacao;
    private String orgaoEmissor;
    private String validade;

    //Criando o construtor
    public CertificacaoOrganica( int idCertificacao, String orgaoEmissor, String validade){
        this.idCertificacao = idCertificacao;
        this.orgaoEmissor = orgaoEmissor;
        this.validade = validade;
    }

    //Getteres
    public int getIdCertificacao() { return idCertificacao;}
    public String getOrgaoEmissor() { return orgaoEmissor;}
    public String getValidade() { return validade;}

    //Setteres
    public void setIdCertificacao(int idCertificacao){ this.idCertificacao = idCertificacao;}
    public void setOrgaoEmissor (String orgaoEmissor){ this.orgaoEmissor = orgaoEmissor;}
    public void setValidade(String validade) { this.validade = validade; }

    //Validando a certificação
    public void validarCertificacao(){
        System.out.println("Cetificacao de '" + orgaoEmissor + "' valida até "+ validade);
    }

    @Override
    public String toString() {
        return "Cetificacao: " + orgaoEmissor + " | Validade: " + validade;
    }
}
