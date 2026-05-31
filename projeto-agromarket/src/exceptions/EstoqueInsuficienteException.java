package exceptions;

public class EstoqueInsuficienteException extends Exception { // "extends Exception" -> transforma essa classe numa exceção real do Java
    public EstoqueInsuficienteException(String nomeProduto, int quantidadeDisponivel) {
        //Quando da erro o super(...) mostrará a mensagem na tela
        super("Estoque insuficiente para '" + nomeProduto + "'. Disponível: " + quantidadeDisponivel);
    } 
}