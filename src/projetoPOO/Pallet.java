package projetoPOO;

import java.util.HashSet;

/**
 * Classe que representa um pallet.
 * 
 * Um pallet é uma embalagem que contém várias caixas de papelão.
 * Ele possui um código único, um tipo e um conjunto de caixas de papelão.
 * 
 * Um pallet pode adicionar caixas de papelão a ele e também pode calcular o peso total
 * com base no peso das caixas contidas nele.
 * 
 * A classe estende a classe abstrata Package e implementa os métodos abstratos getType()
 * e getWeight().
 * 
 * A classe também possui um construtor padrão que inicializa o conjunto de caixas vazio,
 * um construtor que adiciona uma caixa ao pallet, um método para adicionar caixas e
 * métodos para obter o conjunto de caixas e o peso total do pallet.
 * 
 * Os métodos equals(), hashCode() e toString() são sobrescritos para comparar e representar
 * o pallet de forma adequada.
 * 
 * @author Asus
 */
public class Pallet extends Package {

    private HashSet<CardBoardBox> prod;

    /**
     * Construtor padrão da classe Pallet.
     * Cria um novo pallet com o tipo "Pa" e inicializa o conjunto de caixas vazio.
     */
    public Pallet() {
        super("Pa");
        this.prod = new HashSet<>();
    }

    /**
     * Construtor da classe Pallet.
     * Cria um novo pallet com o tipo "Pa" e adiciona a caixa fornecida a ele.
     * 
     * @param box a caixa de papelão a ser adicionada ao pallet
     */
    public Pallet(CardBoardBox box) {
        super("Pa");
        this.prod = new HashSet<>();
        this.addProduct(box);
    }
    
    /**
     * Adiciona uma caixa de papelão ao pallet.
     * 
     * @param box a caixa de papelão a ser adicionada
     */
    public void addProduct(CardBoardBox box){
        prod.add(box);
    }
    
    /**
     * Obtém o tipo do pallet.
     * 
     * @return o tipo do pallet
     */
    @Override
    public String getType() {
        return "Pallet";
    }
    
    /**
     * Calcula o peso total do pallet.
     * Percorre todas as caixas de papelão do pallet e soma o peso delas.
     * 
     * @return o peso total do pallet
     */
    @Override
    public double getWeight(){
        double result = 0;
        for(CardBoardBox box : prod){
            result += box.getWeight();
        }

        return result;
    }

    /**
     * Obtém o conjunto de caixas de papelão do pallet.
     * 
     * @return o conjunto de caixas de papelão do pallet
     */
    public HashSet<CardBoardBox> getProduct(){
        return prod;
    }

    /**
     * Sobrescreve o método toString().
     * Retorna uma representação em string do pallet, incluindo o código e as caixas de papelão.
     * 
     * @return a representação em string do pallet
     */
    @Override
    public String toString() {
        return super.toString() + prod;
    }
}
