package exceptions;

public class ProdutoVencidoException extends Exception {
    public ProdutoVencidoException (String nomeProduto) {
        super("Produto vencido: " + nomeProduto + " não pode ser comercializado.");
    }
}
