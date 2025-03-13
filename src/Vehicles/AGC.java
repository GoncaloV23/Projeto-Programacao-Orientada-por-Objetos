package Vehicles;

import CustomExceptions.ExceededWeightVehicleException;
import CustomExceptions.WrongTypeOfPackageVehicleException;
import java.util.ArrayList;
import java.util.List;
import projetoPOO.Package;

/**
 * Classe AGC (Automated Guided Cart) que estende a classe AGV (Automated Guided Vehicle).
 */
public class AGC extends AGV {
    
    private List<Package> packages; // Lista de pacotes transportados pelo AGC

    /**
     * Construtor da classe AGC.
     * @param x coordenada x inicial do AGC
     * @param y coordenada y inicial do AGC
     */
    public AGC(int x, int y) {
        super("AGC", x, y);
        packages = new ArrayList<>(); // Inicializa a lista de pacotes
    }
    
    /**
     * Construtor da classe AGC com um pacote inicial.
     * @param initPackage pacote inicial a ser transportado pelo AGC
     * @param x coordenada x inicial do AGC
     * @param y coordenada y inicial do AGC
     */
    public AGC(Package initPackage, int x, int y) {
        super("AGC", x, y);
        packages = new ArrayList<>(); // Inicializa a lista de pacotes
        try {
            validatePackage(initPackage); // Valida o pacote inicial
        } catch (WrongTypeOfPackageVehicleException | ExceededWeightVehicleException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Valida um pacote a ser adicionado ao AGC.
     * @param newPackage pacote a ser validado
     * @throws WrongTypeOfPackageVehicleException exceção lançada se o tipo do pacote for inválido
     * @throws ExceededWeightVehicleException exceção lançada se o peso total exceder o limite do AGC
     */
    private void validatePackage(Package newPackage) throws WrongTypeOfPackageVehicleException, ExceededWeightVehicleException {
        // Verifica se o tipo do pacote é "Box" ou "Bag"
        if (!newPackage.getType().equals("Box") && !newPackage.getType().equals("Bag")) {
            throw new WrongTypeOfPackageVehicleException();
        }
        double weight = 0.0;
        // Calcula o peso total dos pacotes já transportados
        for (Package p : packages) {
            weight += p.getWeight();
        }
        // Verifica se o peso total excede o limite de 100 unidades
        if (weight >= 100) {
            throw new ExceededWeightVehicleException();
        }
        this.packages.add(newPackage); // Adiciona o pacote à lista
    }
    
    /**
     * Adiciona um pacote ao AGC.
     * @param newPackage pacote a ser adicionado
     */
    public void addPackage(Package newPackage) {
        try {
            validatePackage(newPackage); // Valida o pacote a ser adicionado
        } catch (WrongTypeOfPackageVehicleException | ExceededWeightVehicleException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Remove um pacote do AGC.
     * @param removePackage pacote a ser removido
     */
    public void removeOnePackage(Package removePackage) {
        if (packages.contains(removePackage)) {
            packages.remove(removePackage); // Remove o pacote da lista
        }
    }
    
    /**
     *
     */
    @Override
    public void removePackage() {
        packages.clear();
    }
    
    /**
     *
     * @return
     */
    public List<Package> getPackages(){
        return packages;
    }
    
    /**
     * Retorna uma representação em string do AGC.
     * @return representação em string do AGC
     */
    @Override
    public String toString() {
        return super.toString() +
            this.packages;
    }
}

