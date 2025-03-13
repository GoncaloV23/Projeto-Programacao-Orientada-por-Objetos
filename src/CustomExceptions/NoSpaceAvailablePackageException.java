package CustomExceptions;

/**
 * Exceção lançada quando não há mais espaço disponível para adicionar produtos a uma embalagem.
 * Indica que a embalagem já possui um produto grande e não é possível adicionar mais produtos.
 * 
 * Esta exceção é lançada quando se tenta adicionar um produto grande a uma embalagem que já contém
 * um produto grande.
 * 
 * Esta exceção herda da classe Exception.
 * 
 * @author Asus
 */
public class NoSpaceAvailablePackageException extends Exception {

    /**
     * Construtor padrão.
     * Cria uma instância da exceção com uma mensagem padrão.
     */
    public NoSpaceAvailablePackageException() {
        super("Esta embalagem já possui um produto grande, não é possível adicionar mais produtos!");
    }

    /**
     * Construtor com mensagem personalizada.
     * Cria uma instância da exceção com a mensagem especificada.
     * 
     * @param message a mensagem de erro personalizada
     */
    public NoSpaceAvailablePackageException(String message) {
        super(message);
    }
}
