package CustomExceptions;

/**
 * Exceção lançada quando o veículo não pode se mover na direção especificada porque está voltado para outra direção.
 * 
 * A classe `WrongMovementDirectionException` é uma exceção personalizada que estende a classe `Exception`.
 * Ela possui dois construtores, um sem argumentos que define uma mensagem padrão e outro que permite definir uma mensagem personalizada.
 * 
 * A mensagem padrão é "This vehicle can not move in this direction, because it is facing another direction!".
 * 
 * Essa exceção pode ser lançada quando se tenta mover um veículo na direção errada devido à sua orientação atual.
 * Por exemplo, se um veículo está voltado para o norte e se tenta movê-lo para o sul.
 * 
 * Espero que isso seja útil para o seu projeto! Se tiver mais dúvidas, estou aqui para ajudar.
 * 
 * @author Asus
 */
public class WrongMovementDirectionException extends Exception {

    /**
     * Construtor padrão da exceção `WrongMovementDirectionException`.
     * Define a mensagem padrão.
     */
    public WrongMovementDirectionException() {
        super("This vehicle can not move in this direction, because it is facing another direction!");
    }
    
    /**
     * Construtor da exceção `WrongMovementDirectionException`.
     * Permite definir uma mensagem personalizada.
     * 
     * @param message a mensagem de exceção personalizada
     */
    public WrongMovementDirectionException(String message) {
        super(message);
    }
}
