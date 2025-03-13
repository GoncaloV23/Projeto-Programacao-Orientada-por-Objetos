package projetoPOO;

import CustomExceptions.UnsupportedPackageException;

/**
 * Classe que representa um saco como um tipo de embalagem para produtos.
 * Estende a classe Package.
 * 
 * Um saco não suporta produtos do tipo "Books", "Large Toys" e "Large Eletronics".
 * 
 * @author franc
 */
public class Bag extends Package {

    private Product prod;
    
    /**
     * Construtor da classe Bag.
     * 
     * @param prod o produto a ser colocado no saco
     */
    public Bag(Product prod) {
        super("Ba");
        try{
            checkProduct(prod);
        } catch (UnsupportedPackageException e){
            System.out.println(e.getMessage());
        }
        this.prod = prod;
    }
    
    /**
     * Verifica se o produto é suportado pelo saco.
     * Lança uma exceção UnsupportedPackageException se o produto for nulo ou se pertencer às categorias não suportadas.
     * 
     * @param prod o produto a ser verificado
     * @throws UnsupportedPackageException se o produto não for suportado pelo saco
     */
    public void checkProduct(Product prod) throws UnsupportedPackageException{
        if(prod == null || prod.getType().getInformation().equals("Books") || prod.getType().getInformation().equals("Large Toys") || prod.getType().getInformation().equals("Large Eletronics"))
            throw new UnsupportedPackageException("O saco não suporta esse produto");
    }
     
    @Override
    public String getType() {
        return "Bag";
    }
    
    @Override
    public double getWeight(){
        return prod.getWeight();
    }
    
    /**
     * Retorna o produto contido no saco.
     * 
     * @return o produto contido no saco
     */
    public Product getProduct(){
        return prod;
    }
    
    @Override
    public String toString() {
        return super.toString() +
            this.prod;
    }
}