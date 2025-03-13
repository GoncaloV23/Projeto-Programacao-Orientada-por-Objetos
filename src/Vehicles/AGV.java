package Vehicles;

import CustomExceptions.WarehousePositionOutOfBoundsException;
import CustomExceptions.WrongMovementDirectionException;
import IO.LogWriter;
import projetoPOO.IVehicleMovimentation;
import projetoPOO.Package;
import projetoPOO.SlotInformation;
import projetoPOO.SlotInformation.Role;
import projetoPOO.WareHouse;

/**
 * Classe abstrata AGV (Automated Guided Vehicle) que implementa a interface IVehicleMovimentation.
 */
public abstract class AGV implements IVehicleMovimentation {
    private static int idCounter = 1;
    protected int id; // ID do AGV
    protected String code; // Código do AGV
    protected int initX, initY; // Coordenadas iniciais do AGV
    protected int x, y; // Coordenadas atuais do AGV
    protected int destX, destY;
    protected int direction; // Direção do AGV
    private LogWriter writer;

    /**
     * Construtor da classe AGV.
     * @param type tipo do AGV
     * @param x coordenada x inicial do AGV
     * @param y coordenada y inicial do AGV
     */
    public AGV(String type, int x, int y) {
        this.id = idCounter++;
        this.code = "AGV-" + type + id;
        writer = new LogWriter();
        try {
            isValidPositionX(x);
            isValidPositionY(y);
        } catch (WarehousePositionOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        this.initX = x;
        this.initY = y;
        this.x = x;
        this.y = y;
        this.direction = 1; // Direção inicial do AGV
    }
    
    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }
    
    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return 
     */
    public int getY() {
        return y;
    }
    
    /**
     *
     * @return
     */
    public int getDestX() {
        return destX;
    }

    /**
     *
     * @return
     */
    public int getDestY() {
        return destY;
    }
    
    /**
     * Valida se a nova posição X está dentro dos limites do armazém.
     * @param x novo valor de X
     * @throws WarehousePositionOutOfBoundsException exceção lançada se a posição X estiver fora dos limites do armazém
     */
    private void isValidPositionX(int x) throws WarehousePositionOutOfBoundsException {
        int newX = this.x + x;
        if (!(newX >= 0 && newX < WAREHOUSEWIDTH)) {
            throw new WarehousePositionOutOfBoundsException();
        }
    }
    
    /**
     * Valida se a nova posição Y está dentro dos limites do armazém.
     * @param y novo valor de Y
     * @throws WarehousePositionOutOfBoundsException exceção lançada se a posição Y estiver fora dos limites do armazém
     */
    private void isValidPositionY(int y) throws WarehousePositionOutOfBoundsException {
        int newY = this.y + y;
        if (!(newY >= 0 && newY < WAREHOUSEHEIGHT)) {
            throw new WarehousePositionOutOfBoundsException();
        }
    }
    
    @Override
    public void moveUp() {
        try {
            if (direction != 1) throw new WrongMovementDirectionException();
        } catch (WrongMovementDirectionException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            isValidPositionX(UP);
        } catch (WarehousePositionOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        this.x += UP;
    }

    @Override
    public void moveDown() {
        try {
            if (direction != 3) throw new WrongMovementDirectionException();
        } catch (WrongMovementDirectionException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            isValidPositionX(DOWN);
        } catch (WarehousePositionOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        this.x += DOWN;
    }
    
    @Override
    public void moveLeft() {
        try {
            if (direction != 4) throw new WrongMovementDirectionException();
        } catch (WrongMovementDirectionException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            isValidPositionY(LEFT);
        } catch (WarehousePositionOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        this.y += LEFT;
    }

    @Override
    public void moveRight() {
        try {
            if (direction != 2) throw new WrongMovementDirectionException();
        } catch (WrongMovementDirectionException e) {
            System.out.println(e.getMessage());
        }
         
        try {
            isValidPositionY(RIGHT);
        } catch (WarehousePositionOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        this.y += RIGHT;
    }
    
    /**
     * Gira o AGV para a esquerda.
     */
    public void turnLeft(){
        direction = direction - 1; 
        if (direction == 0) direction = 4;
    }
    
    /**
     * Gira o AGV para a direita.
     */
    public void turnRight(){
        direction = direction + 1; 
        if (direction == 5) direction = 1;
    }
    
    /**
     * Constrói uma rota para o AGV se mover até uma determinada coordenada no armazém.
     * @param wareHouse armazém
     * @param destX coordenada x de destino
     * @param destY coordenada y de destino
     * @param pickup
     * @param newPackage
     */
    public void buildRoute(WareHouse wareHouse, int destX, int destY, boolean pickup, Package newPackage){
        int pastX = x, pastY = y;
        this.destX = destX;
        this.destY = destY;
        
        if(x == destX && y == destY) return;
        
        if (this instanceof ULC) {
            if(x < destX){
                    while(direction != 3){
                        turnRight();
                    }
                    while(x != destX){                        
                            moveDown();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);                        
                    }
                }else if(x > destX){
                    while(direction != 1){
                        turnRight();
                    }
                    while(x != destX){                        
                            
                            moveUp();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);
                    }    
                }

                if(y < destY){
                    while(direction != 2){
                        turnRight();
                    }
                    while(y != destY){                        
                            
                            moveRight();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);                       
                    }
                }else if(y > destY){
                    while(direction != 4){
                        turnRight();
                    }
                    while(y != destY){                        
                            
                            moveLeft();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);                       
                    }
                } 
        } else {
            int totalMoves = 0;
            
            while (totalMoves < 2 && (x != destX || y != destY)) {
                if(x < destX){
                    while(direction != 3){
                        turnRight();
                    }
                    while(x != destX){
                        if(totalMoves >= 2) break;                        
                           
                            moveDown();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            totalMoves++;
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);                      
                    }
                }else if(x > destX){
                    while(direction != 1){
                        turnRight();
                    }
                    while(x != destX){
                        if(totalMoves >= 2) break;                       
                            
                            moveUp();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            totalMoves++;
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);                       
                    }    
                }

                if(y < destY){
                    while(direction != 2){
                        turnRight();
                    }
                    while(y != destY){
                        if(totalMoves >= 2) break;                        
                            
                            moveRight();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            totalMoves++;
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);                       
                    }
                }else if(y > destY){
                    while(direction != 4){
                        turnRight();
                    }
                    while(y != destY){
                        if(totalMoves >= 2) break;                     
                            
                            moveLeft();
                            wareHouse.getSlot(x, y).setOccupied(true);
                            totalMoves++;
                            wareHouse.getSlot(pastX, pastY).setOccupied(false);
                            pastX = x;
                            pastY = y;
                            writer.writeText(this.getCode()+" - "+this.x+" - "+this.y);                        
                    }
                }
            } 
        }
        if(x == destX && y == destY){
            if(pickup == true){
                if(wareHouse.getSlot(x, y).getRole() == Role.PICKUP || wareHouse.getSlot(x, y).getRole() == Role.STORAGE){
                    wareHouse.getSlot(destX, destY).setEmpty(!wareHouse.getSlot(destX, destY).isEmpty());
                    this.addPackage(newPackage);
                    pickup = false;
                    System.out.println(this.code+" chegou com sucesso às coordenadas "+this.destX+" - "+this.destY+"!");
                } 
            } else {
                if(wareHouse.getSlot(x, y).getRole() == Role.STORAGE || wareHouse.getSlot(x, y).getRole() == Role.DELIVER){
                    wareHouse.getSlot(destX, destY).setEmpty(!wareHouse.getSlot(destX, destY).isEmpty());
                    this.removePackage();
                    System.out.println(this.code+" chegou com sucesso às coordenadas "+this.destX+" - "+this.destY+"!");
                }   
            }
        }
    }
        
    /**
     *
     * @param wareHouse
     * @param destX
     * @param destY
     * @param pickup
     * @param newPackage
     */
    public void buildRouteTillEnd(WareHouse wareHouse, int destX, int destY, boolean pickup, Package newPackage){
        while (x != destX || y != destY) {
            buildRoute(wareHouse, destX, destY, pickup, newPackage);
        }
    }
   
    
    /**
     * Sensor de ultrassom do AGV.
     * Verifica se há obstáculos no caminho do AGV em uma determinada direção.
     * @param wareHouse armazém
     * @return true se não houver obstáculos, false caso contrário
     */
    public boolean ultraSonicSensor(WareHouse wareHouse) {
        int sensorRange = 4;
        
        switch (direction) {
            case 1:
                for (int i = y - sensorRange; i < y + sensorRange; i++) {
                    for (int j = x - sensorRange; j <= x; j++) {
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if (viewArea == null) {
                            continue;
                        }
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if (viewArea.isOccupied()) {
                            return false;
                        }
                    }
                }
                break;
            case 2:
                for (int i = x - sensorRange; i < x + sensorRange; i++) {
                    for (int j = y; j <= y; j++) { 
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if (viewArea == null) {
                            continue;
                        }
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if (viewArea.isOccupied()) {
                            return false;
                        }
                    }
                }
                break;
            case 3:
                for (int i = y - sensorRange; i < y + sensorRange; i++) {
                    for (int j = x + sensorRange; j <= x; j--) {
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if (viewArea == null) {
                            continue;
                        }
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if (viewArea.isOccupied()) {
                            return false;
                        }
                    }
                }
                break;
            case 4:
                for (int i = x - sensorRange; i < x + sensorRange; i++) {
                    for (int j = y - sensorRange; j <= y; j++) {
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if (viewArea == null) {
                            continue;
                        }
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if (viewArea.isOccupied()) {
                            return false;
                        }
                    }
                }
                break;
        }
    return true;
}
    
    /**
     * Sensor de luminosidade (LDR) do AGV.
     * Verifica se há objetos próximos ao AGV em uma determinada direção com base na luminosidade.
     * @param wareHouse armazém
     * @return true se não houver objetos próximos, false caso contrário
     */
    public boolean ldrSensor(WareHouse wareHouse){
        int sensorShortRange = 1;
        int sensorLongRange = 10;
        
        switch(direction){
            case 1 : 
                for(int i = y-sensorShortRange; i <= y+sensorShortRange; i++){
                    for(int j = x; j <= x+sensorLongRange; j++){
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if(viewArea == null) continue;
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if(viewArea.isOccupied()){
                            return false;
                        }
                    }
                }
                break;
            case 2 : 
                for(int i = x-sensorShortRange; i <= x+sensorShortRange; i++){
                    for(int j = y; j <= y+sensorLongRange; j++){
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if(viewArea == null) continue;
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if(viewArea.isOccupied()){
                            return false;
                        }
                    }
                }
            case 3 : 
                for(int i = y-sensorShortRange; i < y+sensorShortRange; i++){
                    for(int j = x; j >= x-sensorLongRange; j--){
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if(viewArea == null) continue;
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if(viewArea.isOccupied()){
                            return false;
                        }
                    }
                }
            case 4: 
                for(int i = x-sensorShortRange; i < x+sensorShortRange; i++){
                    for(int j = y-sensorLongRange; j <= y; j++){
                        SlotInformation viewArea = wareHouse.getSlotInformation()[x][y];
                        if(viewArea == null) continue;
                        if(viewArea.getHeight() == x && viewArea.getWidth() == y){
                            continue;
                        }
                        if(viewArea.isOccupied()){
                            return false;
                        }
                    }
                }
        }
        return true;
    }
    
    /**
     *
     * @param newPackage
     */
    public abstract void addPackage(Package newPackage);

    /**
     *
     */
    public abstract void removePackage();
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return id * 31;
    }

    /**
     *
     * @param obj
     * @return
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "AGV [id=" + id + ", code=" + code + ", x=" + x + ", y=" + y + ", direction=" + direction + "]";
    }
}

