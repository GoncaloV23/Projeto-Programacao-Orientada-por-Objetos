package projetoPOO;

/**
 * Classe abstrata que representa uma embalagem.
 * 
 * Uma embalagem possui um código único, um tipo e um peso.
 * 
 * Esta classe é abstrata, o que significa que não pode ser instanciada diretamente.
 * As subclasses devem estender esta classe e implementar os métodos abstratos getType()
 * e getWeight().
 * 
 * Esta classe também possui métodos equals(), hashCode() e toString() sobrescritos para
 * comparar e representar a embalagem de forma adequada.
 * 
 * A classe também possui um contador estático para gerar IDs únicos para cada embalagem criada.
 * 
 * @author Asus
 */
public abstract class Package {
    private static int idCounter = 1;

    /**
     *
     */
    protected int id;

    /**
     *
     */
    protected String code;

    /**
     * Construtor da classe Package.
     * Cria uma nova embalagem com base no tipo fornecido e gera um código único para ela.
     * O código é no formato "P-tipoID", onde tipo é o tipo da embalagem e ID é o ID único.
     * 
     * @param type o tipo da embalagem
     */
    public Package(String type) {
        this.id = idCounter++;
        this.code = "P-" + type + id;
    }

    /**
     * Obtém o código da embalagem.
     * 
     * @return o código da embalagem
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Obtém o tipo da embalagem.
     * 
     * @return o tipo da embalagem
     */
    public abstract String getType(); 
    
    /**
     * Obtém o peso da embalagem.
     * 
     * @return o peso da embalagem
     */
    public abstract double getWeight();
    
    /**
     * Sobrescreve o método hashCode().
     * Retorna um valor de hash único com base no ID da embalagem.
     * 
     * @return o valor de hash da embalagem
     */
    @Override
    public int hashCode() {
        return id * 31;
    }
    
    /**
     * Sobrescreve o método equals().
     * Compara se duas embalagens são iguais com base no código.
     * 
     * @param obj o objeto a ser comparado
     * @return true se as embalagens são iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Package)) {
            return false;
        }
        Package other = (Package) obj;
        return this.code.equals(other.code);
    }
    
    /**
     * Sobrescreve o método toString().
     * Retorna uma representação em string da embalagem, contendo o código.
     * 
     * @return a representação em string da embalagem
     */
    @Override
    public String toString() {
        return "Código da Embalagem: " + this.getCode() + ", ";
    }
}
