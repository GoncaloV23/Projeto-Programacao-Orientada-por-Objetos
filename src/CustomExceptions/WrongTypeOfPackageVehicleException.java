package CustomExceptions;

/**
 * Exceção lançada quando o veículo não suporta o tipo de pacote especificado.
 * 
 * A classe `WrongTypeOfPackageVehicleException` é uma exceção personalizada que estende a classe `Exception`.
 * Ela possui dois construtores, um sem argumentos que define uma mensagem padrão e outro que permite definir uma mensagem personalizada.
 * 
 * A mensagem padrão é "This Vehicle does not support this type of package!".
 * 
 * Essa exceção pode ser lançada quando se tenta adicionar um pacote a um veículo que não suporta esse tipo de pacote.
 * Por exemplo, se um veículo é adequado apenas para pacotes do tipo "Caixa" e tenta-se adicionar um pacote do tipo "Saco".
 * 
 * Espero que isso seja útil para o seu projeto! Se tiver mais dúvidas, estou aqui para ajudar.
 * 
 * @author Asus
 */
public class WrongTypeOfPackageVehicleException extends Exception {

    /**
     * Construtor padrão da exceção `WrongTypeOfPackageVehicleException`.
     * Define a mensagem padrão.
     */
    public WrongTypeOfPackageVehicleException() {
        super("This Vehicle does not support this type of package!");
    }
    
    /**
     * Construtor da exceção `WrongTypeOfPackageVehicleException`.
     * Permite definir uma mensagem personalizada.
     * 
     * @param message a mensagem de exceção personalizada
     */
    public WrongTypeOfPackageVehicleException(String message) {
        super(message);
    }
}
