package projetoPOO;

import CustomExceptions.UnsupportedPackageException;

/**
 * Classe que representa uma caixa como uma subclasse de Pacote.
 * Uma caixa é usada para armazenar um produto.
 * 
 * @author franc
 */
public class Box extends Package {
   
    private Product prod;
    
    /**
     * Construtor da classe Box.
     * Cria uma nova instância de caixa com base no produto fornecido.
     * 
     * @param prod O produto a ser armazenado na caixa.
     */
    public Box(Product prod) {
        super("Bo");
        try{
            checkProduct(prod);
        } catch (UnsupportedPackageException e){
            System.out.println(e.getMessage());
        }
        this.prod = prod;
    }
    
    /**
     * Verifica se o produto fornecido é adequado para ser armazenado em uma caixa.
     * Lança uma exceção UnsupportedPackageException se o produto não for adequado.
     * 
     * @param prod O produto a ser verificado.
     * @throws UnsupportedPackageException Exceção lançada se o produto não for adequado para uma caixa.
     */
    private void checkProduct(Product prod) throws UnsupportedPackageException{
        if(prod == null || prod.getType().getInformation().equals("Clothing") || prod.getType().getInformation().equals("Large Toys") || prod.getType().getInformation().equals("Large Eletronics"))
            throw new UnsupportedPackageException();
    }
    
    /**
     * Obtém o tipo do pacote, que é "Caixa".
     * 
     * @return O tipo do pacote.
     */
    @Override
    public String getType() {
        return "Box";
    }
    
    /**
     * Obtém o peso da caixa, que é igual ao peso do produto.
     * 
     * @return O peso da caixa.
     */
    @Override
    public double getWeight(){
        return prod.getWeight();
    }
    
    /**
     * Obtém o produto armazenado na caixa.
     * 
     * @return O produto armazenado na caixa.
     */
    public Product getProduct(){
        return prod;
    }
    
    /**
     * Retorna uma representação em string da caixa, incluindo o código e o produto.
     * 
     * @return A representação em string da caixa.
     */
    @Override
    public String toString() {
        return super.toString()+
            this.prod;
    }
}