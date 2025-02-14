public class Room {
    private  int id;
    private String type;
    private int capacity;
    private double price;
    boolean status = false;

    // Método constutor para criar um quarto no sistema do hotel
    Room(int id, String type, int capacity, double price){
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
    }

    // Método para retornar o status do quarto
    public String getStatus() {
        return status ? "Reservado" : "Disponível";
    }

    // Método para retornar informações do quarto criado
    public String roomInfo(){
        return "Id: " + id + " - Tipo: " + type + " - Capacidade: " + capacity + " - Preço: R$" + price + " - Status: " + getStatus();
    }

}
