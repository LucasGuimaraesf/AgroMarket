package model;

public class Fornecedor {

    private int idFornecedor;
    private String nome;
    private String cpfCnpj;
    private String telefone;

    public Fornecedor(int idFornecedor, String nome, String cpfCnpj, String telefone) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
    }

    // Getters
    public int getIdFornecedor() { return idFornecedor; }
    public String getNome() { return nome; }
    public String getCpfCnpj() { return cpfCnpj; }
    public String getTelefone() { return telefone; }

    // Setters
    public void setIdFornecedor(int idFornecedor) { this.idFornecedor = idFornecedor; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Atualiza os dados do fornecedor
    public void atualizarDados(String novoNome, String novoTelefone) {
        this.nome = novoNome;
        this.telefone = novoTelefone;
        System.out.println("Dados atualizados: " + novoNome + " | Tel: " + novoTelefone);
    }

    @Override
    public String toString() {
        return "Fornecedor: " + nome + " | CPF/CNPJ: " + cpfCnpj + " | Tel: " + telefone;
    }
}