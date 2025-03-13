package CustomExceptions;

/**
 * Exceção lançada quando um tipo de pacote não suporta determinado tipo de produto.
 * 
 * Essa exceção pode ser usada para lidar com casos em que um tipo de pacote específico não é adequado
 * para armazenar ou transportar um determinado tipo de produto.
 * 
 * Por exemplo, se um pacote do tipo "Box" não suporta produtos do tipo "Clothing", essa exceção pode ser lançada.
 * 
 * A classe `UnsupportedPackageException` estende a classe `Exception` e fornece dois construtores,
 * um sem argumentos que fornece uma mensagem de erro padrão e outro com uma mensagem de erro personalizada.
 * 
 * @author Asus
 */
public class UnsupportedPackageException extends Exception {

    /**
     * Construtor da classe `UnsupportedPackageException`.
     * Cria uma nova exceção com uma mensagem de erro padrão.
     */
    public UnsupportedPackageException() {
        super("This package does not support this type of product!");
    }
    
    /**
     * Construtor da classe `UnsupportedPackageException`.
     * Cria uma nova exceção com a mensagem de erro especificada.
     * 
     * @param message a mensagem de erro personalizada
     */
    public UnsupportedPackageException(String message) {
        super(message);
    }
}
