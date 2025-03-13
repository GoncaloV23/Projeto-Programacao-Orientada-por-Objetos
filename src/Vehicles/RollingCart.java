package Vehicles;

import Vehicles.AGV;
import CustomExceptions.ExceededWeightVehicleException;
import CustomExceptions.WrongTypeOfPackageVehicleException;
import java.util.ArrayList;
import java.util.List;
import projetoPOO.Package;

/**
 * Classe que representa um carrinho de transporte.
 * 
 * Um carrinho de transporte possui um ID único, um código, coordenadas (x, y) e uma lista
 * de embalagens (packages).
 * 
 * A classe possui um construtor que inicializa as propriedades do carrinho de transporte.
 * 
 * O método validatePackage() é um método privado que valida se uma nova embalagem pode ser
 * adicionada ao carrinho de transporte. Ele verifica se o tipo da embalagem é "Box" ou "Bag"
 * e se o peso total das embalagens existentes no carrinho não excede 200.
 * 
 * O método addPackage() adiciona uma nova embalagem ao carrinho de transporte, chamando o método
 * validatePackage(). Caso ocorra uma exceção do tipo WrongTypeOfPackageVehicleException ou
 * ExceededWeightVehicleException, uma mensagem de erro é exibida.
 * 
 * O método removePackage() remove uma embalagem do carrinho de transporte.
 * 
 * Os métodos getters são fornecidos para acessar as propriedades do carrinho de transporte.
 * 
 * Os métodos equals(), hashCode() e toString() são sobrescritos para comparar e representar
 * o carrinho de transporte de forma adequada.
 * 
 * A classe RollingCart pode ser usada para representar um carrinho de transporte dentro do
 * contexto do sistema de gestão de embalagens.
 * 
 * @author Asus
 */
public class RollingCart {
    private static int idCounter = 1;
    private int id;
    private String code;
    private int x;
    private int y;
    private List<Package> packages;
    
    /**
     * Construtor da classe RollingCart.
     * Cria um novo carrinho de transporte com as coordenadas fornecidas.
     * 
     * @param x a coordenada x do carrinho de transporte
     * @param y a coordenada y do carrinho de transporte
     */
    public RollingCart(int x, int y) {
        this.id = idCounter++;
        this.code = "RC-" + id;
        this.x = x;
        this.y = y;
        packages = new ArrayList<>();
    }
    
    /**
     * Valida se uma nova embalagem pode ser adicionada ao carrinho de transporte.
     * Verifica se o tipo da embalagem é "Box" ou "Bag" e se o peso total das embalagens
     * existentes no carrinho não excede 200.
     * 
     * @param newPackage a nova embalagem a ser validada
     * @throws WrongTypeOfPackageVehicleException se o tipo da embalagem não for "Box" ou "Bag"
     * @throws ExceededWeightVehicleException se o peso total das embalagens excede 200
     */
    private void validatePackage(Package newPackage) throws WrongTypeOfPackageVehicleException, ExceededWeightVehicleException {
        if (!newPackage.getType().equals("Box") && !newPackage.getType().equals("Bag")) {
            throw new WrongTypeOfPackageVehicleException();
        }
        double weight = getTotalWeight();
        if(weight >= 200){
            throw new ExceededWeightVehicleException();
        }
        this.packages.add(newPackage);
    }
    
    /**
     * Adiciona uma nova embalagem ao carrinho de transporte.
     * Verifica se a embalagem é válida chamando o método validatePackage().
     * Caso ocorra uma exceção do tipo WrongTypeOfPackageVehicleException ou
     * ExceededWeightVehicleException, uma mensagem de erro é exibida.
     * 
     * @param newPackage a nova embalagem a ser adicionada
     */
    public void addPackage(Package newPackage){
        try{
            validatePackage(newPackage);
        } catch(WrongTypeOfPackageVehicleException | ExceededWeightVehicleException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     * @return
     */
    public double getTotalWeight(){
        double weight = 0.0;
            for (Package p : packages) {
                weight += p.getWeight();
        }
            return weight;
    }
    
    /**
     * Remove uma embalagem do carrinho de transporte.
     * 
     * @param removePackage a embalagem a ser removida
     */
    public void removeOnePackage(Package removePackage) {
        if (packages.contains(removePackage)) {
            packages.remove(removePackage);
        }
    }
    
    /**
     *
     */
    public void removePackage() {
        packages.clear();
    }
    
    /**
     * Obtém a lista de embalagens presentes no carrinho de transporte.
     * 
     * @return a lista de embalagens armazenadas no carrinho
     */
    public List<Package> getPackages(){
        return packages;
    }
    
    /**
     * Obtém o código do carrinho de transporte.
     * 
     * @return o código do carrinho de transporte
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Obtém a coordenada x do carrinho de transporte.
     * 
     * @return a coordenada x do carrinho de transporte
     */
    public int getX() {
        return x;
    }

    /**
     * Obtém a coordenada y do carrinho de transporte.
     * 
     * @return a coordenada y do carrinho de transporte
     */
    public int getY() {
        return y;
    }
    
    /**
     * Sobrescreve o método hashCode().
     * Retorna um valor hash único para o carrinho de transporte com base no seu ID.
     * 
     * @return o valor hash do carrinho de transporte
     */
    @Override
    public int hashCode() {
        return id * 31;
    }

    /**
     * Sobrescreve o método equals().
     * Verifica se o objeto fornecido é igual ao carrinho de transporte com base no seu código.
     * 
     * @param obj o objeto a ser comparado
     * @return true se o objeto fornecido for igual ao carrinho de transporte, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AGV)) {
            return false;
        }
        AGV other = (AGV) obj;
        return this.code.equals(other.code);
    }
    
    /**
     * Sobrescreve o método toString().
     * Retorna uma representação em string do carrinho de transporte, incluindo o código e as embalagens.
     * 
     * @return a representação em string do carrinho de transporte
     */
    @Override
    public String toString() {
        return "RC code = "+this.getCode()+", "
                +this.packages;
    }
}
