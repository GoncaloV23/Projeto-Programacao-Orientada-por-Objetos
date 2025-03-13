package Vehicles;

import Vehicles.RollingCart;
import Vehicles.AGV;
import projetoPOO.Package;

/**
 * Classe que representa um veículo de reboque.
 * 
 * Um veículo de reboque (TowingVehicle) é um tipo específico de AGV (Automated Guided Vehicle).
 * Ele pode transportar um carrinho de rolagem (RollingCart).
 * 
 * O construtor da classe recebe as coordenadas iniciais do veículo de reboque.
 * 
 * Os métodos addTransportCart() e removeTransportCart() são fornecidos para adicionar e remover
 * um carrinho de rolagem.
 * 
 * A classe TowingVehicle herda os métodos e propriedades da classe AGV e implementa o método toString()
 * para retornar uma representação em string do veículo de reboque.
 * 
 * A classe TowingVehicle pode ser usada para representar um veículo de reboque dentro do contexto do
 * sistema de gestão de embalagens.
 * 
 * @author Asus
 */
public class TowingVehicle extends AGV {
    
    private RollingCart rollingCart;

    /**
     * Construtor da classe TowingVehicle.
     * Cria um novo veículo de reboque com as coordenadas iniciais especificadas.
     * 
     * @param x a coordenada X inicial do veículo de reboque
     * @param y a coordenada Y inicial do veículo de reboque
     */
    public TowingVehicle(int x, int y) {
        super("TWV", x, y);
    }
    
    /**
     * Construtor da classe TowingVehicle.
     * Cria um novo veículo de reboque com as coordenadas iniciais e o carrinho de rolagem especificados.
     * 
     * @param rollingCart o carrinho de rolagem a ser transportado pelo veículo de reboque
     * @param x a coordenada X inicial do veículo de reboque
     * @param y a coordenada Y inicial do veículo de reboque
     */
    public TowingVehicle(RollingCart rollingCart, int x, int y) {
        super("TWV", x, y);
        this.rollingCart = rollingCart;
    }
    
    /**
     *
     * @param newPackage
     */
    @Override
    public void addPackage(Package newPackage){
        if(rollingCart != null){
            rollingCart.addPackage(newPackage);
        }
    }
    
    /**
     *
     */
    @Override
    public void removePackage(){
        if(rollingCart != null){
            rollingCart.removePackage();
        }
    }
    
    /**
     * Adiciona um carrinho de rolagem ao veículo de reboque.
     * 
     * @param rollingCart o carrinho de rolagem a ser adicionado
     */
    public void addTransportCart(RollingCart rollingCart) {
        if (this.rollingCart != null) {
            this.rollingCart = rollingCart;
        }
    }
    
    /**
     * Remove o carrinho de rolagem do veículo de reboque.
     */
    public void removeTransportCart() {
        this.rollingCart = null;
    }
    
    /**
     * Obtém o carrinho de rolagem associado ao veículo de reboque.
     *
     * @return o carrinho de rolagem associado ao veículo de reboque
     */
    public RollingCart getRollingCart(){
        return rollingCart;
    }
    
    /**
     * Retorna uma representação em string do veículo de reboque.
     * 
     * @return uma representação em string do veículo de reboque
     */
    @Override
    public String toString() {
        return super.toString() +
            this.rollingCart;
    }
}
