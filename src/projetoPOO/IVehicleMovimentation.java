package projetoPOO;

/**
 * Interface que define a movimentação de um veículo.
 * Contém constantes para as dimensões do armazém e as direções de movimento.
 * Declara métodos para mover o veículo para cima, baixo, esquerda e direita.
 * 
 * @author Asus
 */
public interface IVehicleMovimentation {

    /**
     *
     */
    static final int WAREHOUSEWIDTH = 50;  // Largura do armazém

    /**
     *
     */
    static final int WAREHOUSEHEIGHT = 50; // Altura do armazém

    /**
     *
     */
    static final int UP = -1;              // Direção para cima

    /**
     *
     */
    static final int DOWN = 1;              // Direção para baixo

    /**
     *
     */
    static final int LEFT = -1;             // Direção para a esquerda

    /**
     *
     */
    static final int RIGHT = 1;             // Direção para a direita
    
    /**
     * Move o veículo para cima.
     * Atualiza a posição do veículo para uma posição acima.
     */
    void moveUp();
    
    /**
     * Move o veículo para baixo.
     * Atualiza a posição do veículo para uma posição abaixo.
     */
    void moveDown();
    
    /**
     * Move o veículo para a esquerda.
     * Atualiza a posição do veículo para uma posição à esquerda.
     */
    void moveLeft();
    
    /**
     * Move o veículo para a direita.
     * Atualiza a posição do veículo para uma posição à direita.
     */
    void moveRight();
}
