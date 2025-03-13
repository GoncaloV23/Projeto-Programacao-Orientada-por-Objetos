package projetoPOO;

/**
 * Classe que representa um produto.
 * 
 * Um produto possui um ID único, um nome, um peso e um tipo.
 * O tipo do produto é representado por uma enumeração Type, que contém diferentes
 * categorias de produtos.
 * 
 * A classe possui um construtor que inicializa as propriedades do produto.
 * 
 * Os métodos getters e setters são fornecidos para acessar e modificar as propriedades
 * do produto.
 * 
 * Os métodos equals(), hashCode() e toString() são sobrescritos para comparar e representar
 * o produto de forma adequada.
 * 
 * A enumeração Type contém os diferentes tipos de produtos, cada um associado a uma
 * informação específica.
 * 
 * A enumeração possui um construtor privado que associa uma informação ao tipo de produto
 * e um método getInformation() para obter a informação associada a cada tipo.
 * 
 * Os tipos de produto disponíveis na enumeração são:
 * - CLOTHING: Vestuário
 * - ACCESSORIES: Acessórios
 * - SMALL_TOYS: Brinquedos Pequenos
 * - LARGE_TOYS: Brinquedos Grandes
 * - SMALL_ELECTRONICS: Eletrônicos Pequenos
 * - LARGE_ELECTRONICS: Eletrônicos Grandes
 * - BOOKS: Livros
 * 
 * Cada tipo de produto é representado como uma string com a informação correspondente.
 * 
 * Os tipos de produto são utilizados para verificar restrições ao criar embalagens,
 * como a incompatibilidade de certos produtos com determinados tipos de embalagem.
 * 
 * A classe Product pode ser usada para representar diferentes produtos dentro do contexto
 * do sistema de gestão de embalagens.
 * 
 * @author Asus
 */
public class Product {
    private static int idCounter = 1;
    private int id;
    private String name;
    private double weight;
    private Type type;

    /**
     * Enumeração que representa os tipos de produtos.
     * Cada tipo de produto é associado a uma informação específica.
     */
    public enum Type {

        /**
         *
         */
        CLOTHING("Clothing"),

        /**
         *
         */
        ACCESSORIES("Acessories"),

        /**
         *
         */
        SMALL_TOYS("Small Toys"),

        /**
         *
         */
        LARGE_TOYS("Large Toys"),

        /**
         *
         */
        SMALL_ELECTRONICS("Small Eletronics"),

        /**
         *
         */
        LARGE_ELECTRONICS("Large Eletronics"),

        /**
         *
         */
        BOOKS("Books");
        
        private String information;
        
        private Type(String information){
            this.information = information;
        }
        
        /**
         * Obtém a informação associada ao tipo de produto.
         * 
         * @return a informação do tipo de produto
         */
        public String getInformation() { return information; }
    }


    /**
     * Construtor da classe Product.
     * Cria um novo produto com o nome, peso e tipo fornecidos.
     * 
     * @param name o nome do produto
     * @param weight o peso do produto
     * @param type o tipo do produto
     */
    public Product(String name, double weight, Type type) {
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    /**
     * Obtém o ID do produto.
     * 
     * @return o ID do produto
     */
    public int getId(){ return id; }
    
    /**
     * Obtém o nome do produto.
     * 
     * @return o nome do produto
     */
    public String getName() { return name; }

    /**
     * Define o nome do produto.
     * 
     * @param name o novo nome do produto
     */
    public void setName(String name) { this.name = name; }

    /**
     * Obtém o peso do produto.
     * 
     * @return o peso do produto
     */
    public double getWeight() { return weight; }

    /**
     * Define o peso do produto.
     * 
     * @param weight o novo peso do produto
     */
    public void setWeight(double weight) { this.weight = weight; }
    
    /**
     * Obtém o tipo do produto.
     * 
     * @return o tipo do produto
     */
    public Type getType() { return type; }

    /**
     * Define o tipo do produto.
     * 
     * @param type o novo tipo do produto
     */
    public void setType(Type type) { this.type = type; }
    
    /**
     * Sobrescreve o método hashCode().
     * Retorna um valor hash único para o produto com base no seu ID.
     * 
     * @return o valor hash do produto
     */
    @Override
    public int hashCode() {
        return id * 31;
    }
    
    /**
     * Sobrescreve o método equals().
     * Verifica se o objeto fornecido é igual ao produto com base no seu ID.
     * 
     * @param obj o objeto a ser comparado
     * @return true se o objeto fornecido for igual ao produto, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return id == other.id;
    }

    /**
     * Sobrescreve o método toString().
     * Retorna uma representação em string do produto, incluindo o ID, nome, peso e tipo.
     * 
     * @return a representação em string do produto
     */
    @Override
    public String toString() {
        return "Product ID = "+this.getId()+
                ", Name = "+this.getName()+
                ", Weight = " +this.getWeight()+" Kg"+
                ", Type = "+this.getType()+"\n";
    }
}
