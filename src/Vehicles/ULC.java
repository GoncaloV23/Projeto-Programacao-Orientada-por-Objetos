package Vehicles;

import Vehicles.AGV;
import projetoPOO.Package;
import projetoPOO.Pallet;

/**
 * Classe que representa uma Unidade de Carga Leve (ULC).
 * 
 * Uma Unidade de Carga Leve (ULC) é um tipo específico de AGV (Automated Guided Vehicle).
 * Ela pode transportar um pallet (Pallet).
 * 
 * O construtor da classe recebe as coordenadas iniciais da ULC.
 * 
 * Os métodos getProduct() e setProduct() são fornecidos para obter e definir o pallet transportado pela ULC.
 * 
 * A classe ULC herda os métodos e propriedades da classe AGV e implementa o método toString()
 * para retornar uma representação em string da ULC.
 * 
 * A classe ULC pode ser usada para representar uma Unidade de Carga Leve dentro do contexto do
 * sistema de gestão de embalagens.
 * 
 * @author Asus
 */
public class ULC extends AGV {
    
    private Pallet pallet;

    /**
     * Construtor da classe ULC.
     * Cria uma nova Unidade de Carga Leve com as coordenadas iniciais especificadas.
     * 
     * @param x a coordenada X inicial da ULC
     * @param y a coordenada Y inicial da ULC
     */
    public ULC(int x, int y) {
        super("ULC", x, y);
    }
    
    /**
     * Construtor da classe ULC.
     * Cria uma nova Unidade de Carga Leve com as coordenadas iniciais e o pallet especificados.
     * 
     * @param pallet o pallet a ser transportado pela ULC
     * @param x a coordenada X inicial da ULC
     * @param y a coordenada Y inicial da ULC
     */
    public ULC(Pallet pallet, int x, int y) {
        super("ULC", x, y);
        this.pallet = pallet;
    }
    
    /**
     * Retorna o pallet transportado pela ULC.
     * 
     * @return o pallet transportado pela ULC
     */
    public Pallet getProduct(){
        return pallet;
    }
    
    /**
     * Define o pallet transportado pela ULC.
     * 
     * @param newPackage package a ser definido
     */
    @Override
    public void addPackage(Package newPackage){
        if(newPackage instanceof Pallet){
            this.pallet = pallet;
        }
       
    }
    
    /**
     *
     */
    @Override
    public void removePackage(){
        this.pallet = null;
    }
    
    /**
     * Retorna uma representação em string da ULC.
     * 
     * @return uma representação em string da ULC
     */
    @Override
    public String toString() {
        return super.toString() +
            this.pallet;
    }
}
