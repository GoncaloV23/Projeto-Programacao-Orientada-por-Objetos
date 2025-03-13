package projetoPOO;

import projetoPOO.SlotInformation.Role;

/**
 * Classe que representa um armazém com informações sobre os slots disponíveis.
 * 
 * A classe `WareHouse` possui uma matriz de `SlotInformation` que representa os slots do armazém.
 * Ela também possui métodos para criar o armazém e imprimir a matriz de slots.
 * 
 * O tamanho padrão do armazém é definido pelas constantes `HEIGTH` (altura) e `WIDTH` (largura).
 * 
 * Cada slot é inicializado com o papel "Floor" e marcado como desocupado e vazio.
 * Além disso, alguns slots são atribuídos aos papéis "Pick Up", "Storage" e "Deliver".
 * 
 * Os slots podem ser acessados individualmente por meio do método `getSlot`.
 * 
 * A classe `WareHouse` também possui métodos para obter e definir a matriz de slots.
 * 
 * Por fim, a classe possui um método para imprimir a matriz de slots no console.
 * 
 * @author franc
 */
public class WareHouse {
    
    private SlotInformation[][] slot;
    private int height;
    private int width;
    
    /**
     * Construtor da classe `WareHouse`.
     * Cria um novo armazém e inicializa a matriz de slots com tamanho predefinido.
     * Em seguida, chama o método `createWareHouse` para configurar os slots do armazém.
     * @param height altura do armazem
     * @param width largura do armazem
     */
    public WareHouse(int height, int width) {
        this.height = height;
        this.width = width;
        this.slot = new SlotInformation[height][width];
        createWareHouse();
    }

    /**
     * Método para criar o armazém e configurar os slots.
     */
    public void createWareHouse() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                slot[i][j] = new SlotInformation(Role.FLOOR, i + 1, j + 1, false, true);
            }
        }
        
        for (int i = 11; i < 37; i++) {
            slot[i][0] = new SlotInformation(Role.PICKUP, i + 1, 1, false, true);
        }
        
        for (int i = 11; i < 37; i++) {
            slot[i][49] = new SlotInformation(Role.DELIVER, i + 1, 50, false, true);
        }
        
        for (int i = 4; i < 45; i++) {
            slot[0][i] = new SlotInformation(Role.STORAGE, 1, i + 1, false, true);
        }
    }
    
    /**
     * Método para imprimir a matriz de slots no console.
     */
    public void imprimirMatriz() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(slot[i][j].toString() + "\n");
            }
            System.out.println();
        }
    }
    
    /**
     * Método para obter a matriz de slots.
     * 
     * @return a matriz de slots
     */
    public SlotInformation[][] getSlotInformation() {
        return slot;
    }
    
    /**
     * Método para definir a matriz de slots.
     * 
     * @param slot a matriz de slots a ser definida
     */
    public void setSlotInformation(SlotInformation[][] slot) {
        this.slot = slot;
    }
    
    /**
     * Método para obter um slot específico na posição (x, y).
     * 
     * @param x a coordenada x do slot
     * @param y a coordenada y do slot
     * @return o slot na posição (x, y)
     */
    public SlotInformation getSlot(int x, int y) {
        return slot[x][y];
    }
    
    /**
     *
     * @return
     */
    public int getHeight(){
        return height;
    }

    /**
     *
     * @return
     */
    public int getWidth(){
        return width;
    }
    
}
