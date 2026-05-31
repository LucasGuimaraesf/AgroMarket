package model;

import exceptions.EstoqueInsuficienteException;


public class Produto {
    private int idProduto;
    private String nome;
    private double valor;
    private int quantidade;
    private String validade;
    private boolean sazonal;
    private CertificacaoOrganica certificacao;
    private Rastreamento[] rastreamentos;
    private int totalRastreamentos;
    private static final int MAX_RASTREAMENTOS = 10;
    private RelatorioDesperdicio[] relatorios;
    private int totalRelatorios;
    private static final int MAX_RELATORIOS = 10;

    //Construtor: é chamado quando utilizamos "new Produto(...). Cada "this.x = x" pega o valor que veio de fora e guarda dentro do objeto
    public Produto(int idProduto, String nome, double valor, int quantidade, String validade, boolean sazonal){
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.validade = validade;
        this.sazonal = sazonal;
        this.rastreamentos = new Rastreamento[MAX_RASTREAMENTOS];
        this.totalRastreamentos = 0;
        this.relatorios = new RelatorioDesperdicio[MAX_RELATORIOS];
        this.totalRelatorios = 0;
    }

    //Getters: métodos para LER os atributos privados de fora da classe
    public int getIdProduto() { return idProduto; }
    public String getNome() { return nome; }
    public double getValor() { return valor; }
    public int getQuantidade() { return quantidade; }
    public String getValidade() { return validade; }
    public boolean isSazonal() { return sazonal; } //para booleanos o GET é substituido pelo IS. "is it seasonal?"
    public CertificacaoOrganica getCertificacao() {return certificacao; }

    
    //Setteres: métodos para ALTERAR os atributos privados de fora da classe
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public void setNome(String nome) { this.nome = nome; }
    public void setValor(double valor) { this.valor = valor; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setValidade(String validade) { this.validade = validade; }
    public void setSazonal(boolean sazonal) { this.sazonal = sazonal; }
    public void setCertificacao(CertificacaoOrganica certificacao) {this.certificacao = certificacao; }

    //Adiciona unidades ao estoque do produto
    public void atualizaEstoque(int quantidadeAdicional) {
        //Pega o valor desse + a quantidade adicional informada pelo usuário
        this.quantidade += quantidadeAdicional;
        System.out.println("Estoque de '" + nome + "' atualizado. Novo total: " + this.quantidade );
    }
    
    //Verifica se o produto está dentro do prazo. Lança exceção se estiver vencido.
    // public void verificarValidade() throws ProdutoVencidoException { // throws ProdutoVencidoException -> avisa que esse método pode lançar essa exceção
    //     String hoje = new String(); //armazena a data de hoje

    //         //validade != null -> verifica se a validade foi informada antes de tentar usar ela. Evita erro caso esteja vazia
    //         //validade.before(hoje) -> pergunta: "a validade é antes de hoje? Se sim, está vencido!"
    //     if (validade != null && validade.before(hoje)){
            
    //         throw new ProdutoVencidoException(nome);
    //     }
    //     System.out.println("Produto '" + nome + "' está dentro do prazo de validade");
    // }

    //Reduz o estoque ao vender. Lança exceção se não houver quantidade suficiente.
    public void reduzirEstoque(int qtd) throws EstoqueInsuficienteException{
        if (qtd > this.quantidade) { //se tentou vender mais do que tem disponível
            throw new EstoqueInsuficienteException(nome, quantidade); //lança o erro informando o nome e quanto tem disponível
        }
        this.quantidade -= qtd; //só executa se não lançou exceção, ou seja, tem estoque suficiente
        System.out.println("Vendidas "+ qtd + " unidades de '" + nome + "'. Restam: " + this.quantidade);
    }
    
    //Adiciona um rastreamento ao produto
    public void adicionarRastreamento(Rastreamento r){
        if (totalRastreamentos < MAX_RASTREAMENTOS){
            rastreamentos[totalRastreamentos] = r;
            totalRastreamentos++;
        } else {
            System.out.println("Limite de rastreamentos atingido para " + nome);
        }
    }

    //Adicionando um relatórios de desperdício ao produto
    public void adicionarRelatorio(RelatorioDesperdicio rd) {
        if (totalRelatorios < MAX_RELATORIOS){
            relatorios[totalRelatorios] = rd;
            totalRelatorios++;
        } else {
            System.out.println("Limite de relatorios atingido para " + nome);
        }
    }

    //Configurando a saída padrão
    //O @Override diz: "Estou reescrevendo um método que já existe na classe pai de todas as classes do Java(Object)". Todo objeto em Java tem um toString, mas o padrão é horrivel, estamos substituindo pelo nosso.
    @Override
    public String toString() {
        return "Produto: " + nome + " | Valor: R$" + valor + " | Qtd: " + quantidade + " | Validade: " + validade;
    }

}