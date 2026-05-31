package model;

public class AgroMarket {

    private String cnpj;
    private String administrador;
    private Feira[] feiras;
    private int totalFeiras;
    private Fornecedor[] fornecedores;
    private int totalFornecedores;
    private Produto[] produtos;
    private int totalProdutos;
    private static final int MAX_FEIRAS = 20;
    private static final int MAX_FORNECEDORES = 100;
    private static final int MAX_PRODUTOS = 200;

    public AgroMarket(String cnpj, String administrador) {
        this.cnpj = cnpj;
        this.administrador = administrador;
        this.feiras = new Feira[MAX_FEIRAS];
        this.fornecedores = new Fornecedor[MAX_FORNECEDORES];
        this.produtos = new Produto[MAX_PRODUTOS];
        this.totalFeiras = 0;
        this.totalFornecedores = 0;
        this.totalProdutos = 0;
    }

    // Getters
    public String getCnpj() { return cnpj; }
    public String getAdministrador() { return administrador; }
    public int getTotalFeiras() { return totalFeiras; }
    public int getTotalFornecedores() { return totalFornecedores; }
    public int getTotalProdutos() { return totalProdutos; }

    // Setters
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public void setAdministrador(String administrador) { this.administrador = administrador; }

    // Cadastra uma feira
    public void cadastrarFeira(Feira feira) {
        if (totalFeiras < MAX_FEIRAS) {
            feiras[totalFeiras++] = feira;
            System.out.println("Feira '" + feira.getNome() + "' cadastrada no AgroMarket.");
        } else {
            System.out.println("Limite de feiras atingido.");
        }
    }

    // Cadastra um fornecedor
    public void cadastrarFornecedor(Fornecedor fornecedor) {
        if (totalFornecedores < MAX_FORNECEDORES) {
            fornecedores[totalFornecedores++] = fornecedor;
            System.out.println("Fornecedor '" + fornecedor.getNome() + "' cadastrado no AgroMarket.");
        } else {
            System.out.println("Limite de fornecedores atingido.");
        }
    }

    // Cadastra um produto
    public void cadastrarProduto(Produto produto) {
        if (totalProdutos < MAX_PRODUTOS) {
            produtos[totalProdutos++] = produto;
            System.out.println("Produto '" + produto.getNome() + "' cadastrado no AgroMarket.");
        } else {
            System.out.println("Limite de produtos atingido.");
        }
    }

    // Gera relatório geral do sistema
    public void gerarRelatorio() {
        System.out.println("========== RELATORIO GERAL - AGROMARKET ==========");
        System.out.println("CNPJ          : " + cnpj);
        System.out.println("Administrador : " + administrador);
        System.out.println("--------------------------------------------------");
        System.out.println("Total de Feiras      : " + totalFeiras);
        System.out.println("Total de Fornecedores: " + totalFornecedores);
        System.out.println("Total de Produtos    : " + totalProdutos);
        System.out.println("--------------------------------------------------");
        System.out.println("FEIRAS:");
        for (int i = 0; i < totalFeiras; i++) {
            System.out.println("  " + feiras[i]);
        }
        System.out.println("FORNECEDORES:");
        for (int i = 0; i < totalFornecedores; i++) {
            System.out.println("  " + fornecedores[i]);
        }
        System.out.println("PRODUTOS:");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.println("  " + produtos[i]);
        }
        System.out.println("==================================================");
    }

    @Override
    public String toString() {
        return "AgroMarket | CNPJ: " + cnpj + " | Admin: " + administrador + " | Feiras: " + totalFeiras;
    }
}