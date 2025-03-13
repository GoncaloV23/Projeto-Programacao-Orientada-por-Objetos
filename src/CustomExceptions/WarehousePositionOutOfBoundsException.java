package CustomExceptions;

/**
 * Exceção lançada quando a posição definida está fora dos limites do armazém.
 * 
 * A classe `WarehousePositionOutOfBoundsException` é uma exceção personalizada
 * que estende a classe `Exception`. Ela possui dois construtores, um sem argumentos
 * que define uma mensagem padrão e outro que permite definir uma mensagem personalizada.
 * 
 * A mensagem padrão é "The position that you set is out of bounds!".
 * 
 * Essa exceção pode ser lançada quando se tenta acessar uma posição inválida dentro do armazém.
 * Por exemplo, se as coordenadas (x, y) estão fora do intervalo permitido para a matriz de slots.
 * 
 * Espero que isso seja útil para o seu projeto! Se tiver mais dúvidas, estou aqui para ajudar.
 * 
 * @author Asus
 */
public class WarehousePositionOutOfBoundsException extends Exception {

    /**
     * Construtor padrão da exceção `WarehousePositionOutOfBoundsException`.
     * Define a mensagem padrão.
     */
    public WarehousePositionOutOfBoundsException() {
        super("The position that you set is out of bounds!");
    }
    
    /**
     * Construtor da exceção `WarehousePositionOutOfBoundsException`.
     * Permite definir uma mensagem personalizada.
     * 
     * @param message a mensagem de exceção personalizada
     */
    public WarehousePositionOutOfBoundsException(String message) {
        super(message);
    }
}
