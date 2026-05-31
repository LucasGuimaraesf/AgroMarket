package main;

import exceptions.EncomendaCancelamentoException;
import exceptions.EstoqueInsuficienteException;
import exceptions.FeiraJaAbertaException;
import model.AgroMarket;
import model.Banca;
import model.CertificacaoOrganica;
import model.Consumidor;
import model.Encomenda;
import model.Feira;
import model.Fornecedor;
import model.Produto;
import model.Rastreamento;
import model.RelatorioDesperdicio;
import model.Venda;

public class Main {
    public static void main(String[] args) {

        System.out.println("==================== PRODUTOS ====================");

        //Declarando a variavel chamada tomate do tipo Produto
        Produto tomate = new Produto(1, "Tomate Orgânico", 4.50, 100, "10/04/2026", true);
        
        //new Produto (...) -> Constrói o objeto na memória chamando o construtor que escrevemos no Produto.java
        //Os valores dentro do parênteses precisam estar na mesma ordem que foi definido no construtor:(idProduto, nome, valor, quantidade, sazonal)
        Produto alface = new Produto(2, "Alface Crespa", 3.00, 50, "01/12/2026", false);

        //Aqui o println vai chamer automaticamente o toString() que definimos no Produto. Por isso a saída vai ser legível, não um código estranho.
        System.out.println(tomate);
        System.out.println(alface);

        //Testando getter
        System.out.println("Nome do produto: " + tomate.getNome());
        System.out.println("Valor do produto: R$" + tomate.getValor());

        //Testando setter
        tomate.setValor(5.00);
        System.out.println("Novo valor: R$ " + tomate.getValor());

        System.out.println("\n------------- Testando Estoque -------------");

        //Testando reduzirEstoque - Quantidade possível
        try {
            tomate.reduzirEstoque(10);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("ERRO: " + e.getMessage()); //o e.getMessage vai pegar nossa mensagem definida no @Override da exception EstoqueInsuficienteException
        }

        //Testando reduzirEstoque - Quantidade Impossível
        try {
            tomate.reduzirEstoque(9999);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\n==================== CERTIFICACAO ====================");

        //Criando uma certificacao organica
        CertificacaoOrganica cert1 = new CertificacaoOrganica(1, "Universidade Feira de Almeida", "31/12/2026");

        //Associando a certificacao ao produto
        tomate.setCertificacao(cert1);

        //Verificando a certificacao
        tomate.getCertificacao().validarCertificacao();

        //Imprimindo o produto para ver se a certificacao aparece
        System.out.println("Certificacao do tomate: " + tomate.getCertificacao());

        System.out.println("\n==================== RASTREAMENTO ====================");

        //Criando rastreamentos
        Rastreamento r1 = new Rastreamento(1, "Rua UVA de Almeida, 02, Tijuca", "Avenida Passos, 45, Botafogo", "20/01/2025");
        Rastreamento r2 = new Rastreamento(2, "São Paulo", "Rio de Janeiro", "16/06/2026");

        //Associando rastreamentos ao produto
        tomate.adicionarRastreamento(r1);
        alface.adicionarRastreamento(r2);

        //Testando os métodos do rastreamento
        r1.rastrearOrigem();
        r1.emitirHistorico();

        //Imprimindo o rastreamento
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("\n==================== RELATORIO DE DESPERDICIO ====================");

        //Utilizando RelatorioDesperdicio
        //Criando um relatório de desperdicio
        RelatorioDesperdicio rel1 = new RelatorioDesperdicio(1, 10, "Queda do caminhao em movimento");
        RelatorioDesperdicio rel2 = new RelatorioDesperdicio(2, 100, "roubo de carga");

        //Associando o relatório ao produto
        rel1.setProduto(tomate);
        rel2.setProduto(alface);

        //Gerando o relatório na tela
        rel1.gerarRelatorio();
        rel2.gerarRelatorio();

        System.out.println("\n==================== FORNECEDORES ====================");

        // Criando fornecedores
        Fornecedor fornecedor1 = new Fornecedor(1, "Sitio Verde", "123.456.789-00", "(21) 9000-1111");
        Fornecedor fornecedor2 = new Fornecedor(2, "Fazenda Sol", "987.654.321-00", "(21) 9999-2222");
        
        // Imprimindo os fornecedores
        System.out.println(fornecedor1);
        System.out.println(fornecedor2);
        
        // Testando atualizarDados
        fornecedor1.atualizarDados("Sitio Verde Organicos", "(21) 98888-9999");
        System.out.println(fornecedor1);

        System.out.println("\n==================== BANCAS ====================");

        // Criando bancas
        Banca banca1 = new Banca(1, "Banca do Sitio Verde", "Corredor A - Box 3", "Hortalicas");
        Banca banca2 = new Banca(2, "Banca Fazenda Sol",    "Corredor B - Box 7", "Frutas");
        
        // Associando fornecedores às bancas
        banca1.setFornecedor(fornecedor1);
        banca2.setFornecedor(fornecedor2);
        
        // Adicionando produtos às bancas
        banca1.adicionarProduto(tomate);
        banca1.adicionarProduto(alface);
        
        // Listando produtos da banca
        banca1.listarProdutos();
        
        // Vendendo um produto
        try {
            banca1.venderProduto(tomate, 5);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        // Imprimindo as bancas
        System.out.println(banca1);
        System.out.println(banca2);

        System.out.println("\n==================== VENDA ====================");

        // Criando uma venda
        Venda venda1 = new Venda(1, "30/05/2026");
        
        // Adicionando produtos à venda
        venda1.adicionarProduto(tomate, 3);
        venda1.adicionarProduto(alface, 2);
        
        // Registrando a venda
        venda1.registrarVenda();
        
        // Imprimindo a venda
        System.out.println(venda1);

        System.out.println("\n==================== ENCOMENDA ====================");

        //Criando uma encomenda
        Encomenda enc1 = new Encomenda(1, "03/05/2026");

        //Adicionando produtos à encomenda
        enc1.adicionarProduto(tomate, 10);
        enc1.adicionarProduto(alface, 5);

        //Imprimindo a encomenda - status deve ser PENDENTE
        System.out.println(enc1);

        //Confirmando a encomenda
        enc1.confirmarEncomenda();
        System.out.println(enc1);

        //Testando cancelamento válido - status CONFIRMADA pode ser cancelada
        try {
            enc1.cancelarEncomenda();
            System.out.println(enc1);
        } catch (EncomendaCancelamentoException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        // Testando cancelamento inválido — status CANCELADA não pode cancelar de novo
        try {
            enc1.cancelarEncomenda();
        } catch (EncomendaCancelamentoException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\n==================== CONSUMIDORES ====================");

        // Criando consumidores
        Consumidor consumidor1 = new Consumidor(1, "Maria Aparecida", "111.222.333-44", "Rua das Flores, 10");
        Consumidor consumidor2 = new Consumidor(2, "Carlos Eduardo",  "555.666.777-88", "Av. Brasil, 200");
        
        // Imprimindo os consumidores
        System.out.println(consumidor1);
        System.out.println(consumidor2);
        
        // Testando compra válida
        try {
            consumidor1.comprarProduto(banca1, tomate, 3, "30/05/2026");
        } catch (EstoqueInsuficienteException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        // Testando compra com estoque insuficiente
        try {
            consumidor2.comprarProduto(banca1, alface, 9999, "30/05/2026");
        } catch (EstoqueInsuficienteException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        // Testando encomenda
        consumidor1.realizarEncomenda(tomate, 20, "30/05/2026");
        
        // Imprimindo consumidores após as operações
        System.out.println(consumidor1);
        System.out.println(consumidor2);

        System.out.println("\n==================== FEIRA ====================");

        // Criando a feira
        Feira feira = new Feira(1, "Feira Organica Central", "Praca da Se - RJ", "30/05/2026", "08:00 - 14:00");
        
        // Adicionando bancas à feira
        feira.adicionarBanca(banca1);
        feira.adicionarBanca(banca2);
        
        // Abrindo a feira
        try {
            feira.abrirFeira();
        } catch (FeiraJaAbertaException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        // Tentando abrir de novo - deve lançar exceção
        try {
            feira.abrirFeira();
        } catch (FeiraJaAbertaException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        // Gerando relatório de vendas
        feira.gerarRelatorioVendas();
        
        // Fechando a feira
        feira.fecharFeira();
        
        // Imprimindo a feira
        System.out.println(feira);

        System.out.println("\n==================== AGROMARKET ====================");

        // Criando o AgroMarket
        AgroMarket agroMarket = new AgroMarket("12.345.678/0001-99", "Lucas Guimaraes Fabricio");
        
        // Cadastrando feiras, fornecedores e produtos
        agroMarket.cadastrarFeira(feira);
        agroMarket.cadastrarFornecedor(fornecedor1);
        agroMarket.cadastrarFornecedor(fornecedor2);
        agroMarket.cadastrarProduto(tomate);
        agroMarket.cadastrarProduto(alface);
        
        // Gerando o relatório geral
        agroMarket.gerarRelatorio();
        
        // Imprimindo o AgroMarket
        System.out.println(agroMarket);
    }
}