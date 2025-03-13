package CustomExceptions;

/**
 * Exceção lançada quando tentamos adicionar mais produtos a um veículo, mas isso excederia o peso máximo permitido.
 * Herda da classe Exception.
 * 
 * @author Asus
 */
public class ExceededWeightVehicleException extends Exception {

    /**
     * Construtor padrão da exceção.
     * Define uma mensagem padrão informando que não é possível adicionar mais produtos porque excederia o peso máximo.
     */
    public ExceededWeightVehicleException() {
        super("Não é possível adicionar mais produtos, pois excederia o peso máximo!");
    }
    
    /**
     * Construtor da exceção com uma mensagem personalizada.
     * Permite definir uma mensagem personalizada para a exceção.
     * 
     * @param message A mensagem de exceção personalizada.
     */
    public ExceededWeightVehicleException(String message) {
        super(message);
    }
}