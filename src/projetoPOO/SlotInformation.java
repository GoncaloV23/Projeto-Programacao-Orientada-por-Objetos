package projetoPOO;

/**
 * Classe que representa as informações de um slot.
 * 
 * Uma informação de slot possui um papel (role), altura, largura, estado de ocupação (isOccupied)
 * e estado de vazio (isEmpty).
 * 
 * A classe possui um enum Role que define os possíveis papéis de um slot: FLOOR, PICKUP, STORAGE e DELIVER.
 * 
 * O construtor da classe inicializa as propriedades do slot.
 * 
 * Os métodos getters e setters são fornecidos para acessar e modificar as propriedades do slot.
 * 
 * O método toString() retorna uma representação em string das informações do slot.
 * 
 * A classe SlotInformation pode ser usada para representar as informações de um slot dentro do
 * contexto do sistema de gestão de embalagens.
 * 
 * @author franc
 */
public class SlotInformation {
    private Role role;
    private int height, width;
    private boolean isOccupied;
    private boolean isEmpty;
    
    /**
     * Enum que define os possíveis papéis de um slot.
     */
    public enum Role {

        /**
         *
         */
        FLOOR("Floor"),

        /**
         *
         */
        PICKUP("Pick Up"),

        /**
         *
         */
        STORAGE("Storage"),

        /**
         *
         */
        DELIVER("Deliver");
        
        private String information;
        
        private Role(String information){
            this.information = information;
        }
        
        /**
         *
         * @return
         */
        public String getInformation() { return information; }
    }
    
    /**
     * Construtor da classe SlotInformation.
     * Cria uma nova instância de SlotInformation com as informações fornecidas.
     * 
     * @param role o papel do slot
     * @param height a altura do slot
     * @param width a largura do slot
     * @param isOccupied o estado de ocupação do slot
     * @param isEmpty o estado de vazio do slot
     */
    public SlotInformation(Role role, int height, int width, boolean isOccupied, boolean isEmpty){
        this.role = role;
        this.height = height;
        this.width = width;
        this.isOccupied = isOccupied;
        this.isEmpty = isEmpty;
    }

    /**
     * Obtém o papel do slot.
     * 
     * @return o papel do slot
     */
    public Role getRole(){ 
        return role; 
    }
    
    /**
     * Obtém a altura do slot.
     * 
     * @return a altura do slot
     */
    public int getHeight() {
        return height;
    }

    /**
     * Obtém a largura do slot.
     * 
     * @return a largura do slot
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Define a altura do slot.
     * 
     * @param height a altura do slot a ser definida
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Define a largura do slot.
     * 
     * @param width a largura do slot a ser definida
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Verifica se o slot está ocupado.
     * 
     * @return true se o slot está ocupado, false caso contrário
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Define o estado de ocupação do slot.
     * 
     * @param isOccupied o estado de ocupação do slot a ser definido
     */
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * Verifica se o slot está vazio.
     * 
     * @return true se o slot está vazio, false caso contrário
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Define o estado de vazio do slot.
     * 
     * @param isEmpty o estado de vazio do slot a ser definido
     */
    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
    
    /**
     * Retorna uma representação em string das informações do slot.
     * 
     * @return uma representação em string das informações do slot
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Role: ").append(getRole()).append("\n");
        sb.append("Dimensions: ").append(getHeight()).append(", ").append(getWidth()).append("\n");
        sb.append("Is Occupied: ").append(isOccupied()).append("\n");
        sb.append("Is Empty: ").append(isEmpty()).append("\n");
        
        return sb.toString();
    }
}
