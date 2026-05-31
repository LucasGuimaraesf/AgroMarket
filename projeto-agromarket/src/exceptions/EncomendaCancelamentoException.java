package exceptions;

public class EncomendaCancelamentoException extends Exception{
    public EncomendaCancelamentoException(int idEncomenda, String status) {
        super("Encomenda #" + idEncomenda + " nao pode ser cancelada. Status atual: " + status);
    }
}
