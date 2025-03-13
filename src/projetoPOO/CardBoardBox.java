package projetoPOO;

import CustomExceptions.NoSpaceAvailablePackageException;
import CustomExceptions.UnsupportedPackageException;
import java.util.HashSet;

/**
 * Classe que representa uma caixa de papelão como uma subclasse de Pacote.
 * Uma caixa de papelão pode armazenar vários produtos.
 * 
 * @author Asus
 */
public class CardBoardBox extends Package {
    
    HashSet<Product> prod;
    
    /**
     * Construtor da classe CardBoardBox.
     * Cria uma nova instância de caixa de papelão vazia.
     */
    public CardBoardBox() {
        super("C");
        this.prod = new HashSet<>();
    }
    
    /**
     * Construtor da classe CardBoardBox.
     * Cria uma nova instância de caixa de papelão com base em um produto fornecido.
     * 
     * @param pro O produto a ser adicionado à caixa de papelão.
     */
    public CardBoardBox(Product pro) {
        super("C");
        this.prod = new HashSet<>();
        try{
            this.addProduct(pro);
        }catch(UnsupportedPackageException | NoSpaceAvailablePackageException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Adiciona um produto à caixa de papelão.
     * Lança uma exceção UnsupportedPackageException se o produto não for adequado para a caixa.
     * Lança uma exceção NoSpaceAvailablePackageException se não houver espaço disponível na caixa para adicionar o produto.
     * 
     * @param pro O produto a ser adicionado à caixa de papelão.
     * @throws UnsupportedPackageException Exceção lançada se o produto não for adequado para a caixa.
     * @throws NoSpaceAvailablePackageException Exceção lançada se não houver espaço disponível na caixa.
     */
    public void addProduct(Product pro) throws UnsupportedPackageException, NoSpaceAvailablePackageException{
        checkProduct(pro);
        prod.add(pro);
    }
    
    /**
     * Verifica se um produto é adequado para ser adicionado à caixa de papelão.
     * Lança uma exceção UnsupportedPackageException se o produto não for adequado.
     * Lança uma exceção NoSpaceAvailablePackageException se não houver espaço disponível na caixa para adicionar o produto.
     * 
     * @param pro O produto a ser verificado.
     * @throws UnsupportedPackageException Exceção lançada se o produto não for adequado para a caixa.
     * @throws NoSpaceAvailablePackageException Exceção lançada se não houver espaço disponível na caixa.
     */
    private void checkProduct(Product pro) throws UnsupportedPackageException, NoSpaceAvailablePackageException {
        if (prod.size() == 0) {
            return;
        }

        boolean isBigProduct = (pro.getType().getInformation().equals("Large Eletronics") || pro.getType().getInformation().equals("Large Toys"));
        if (isBigProduct && prod.size() > 0) {
            throw new UnsupportedPackageException();
        }
        for(Product p : prod){
            if(p.getType().getInformation().equals("Large Eletronics") && prod.contains(p) || p.getType().getInformation().equals("Large Toys") && prod.contains(p)){
                throw new NoSpaceAvailablePackageException();
            }
        }
    }

    /**
     * Obtém o tipo do pacote, que é "CardBoardBox".
     * 
     * @return O tipo do pacote.
     */
    @Override
    public String getType() {
        return "CardBoardBox";
    }
    
    /**
     * Obtém o peso total dos produtos armazenados na caixa de papelão.
     * 
     * @return O peso total dos produtos na caixa de papelão.
     */
    @Override
    public double getWeight(){
        double result = 0;
        for(Product pro : prod){
            result += pro.getWeight();
        }
        
        return result;
    }
    
    /**
     * Obtém a lista de produtos armazenados na caixa de papelão.
     * 
     * @return A lista de produtos na caixa de papelão.
     */
    public HashSet<Product> getProducts(){
        return prod;
    }
    
    /**
     * Retorna uma representação em string da caixa de papelão, incluindo o código e a lista de produtos.
     * 
     * @return A representação em string da caixa de papelão.
     */
    @Override
    public String toString(){
        return super.toString() + prod;
    }
}