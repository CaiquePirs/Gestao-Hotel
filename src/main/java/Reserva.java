import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private int id;
    private String nameCustomer;
    private LocalDate checkin;
    private LocalDate checkout;

    // Método construtor para criar a reserva do quarto
    Reserva(int id, String nameCustomer, String checkinStr, String checkoutStr, Room room){
        this.id = id;
        this.nameCustomer = nameCustomer;
        room.status = true; // Marca o quarto como reservado

        // Recebendo a data no formato string e formatando para o tipo LocalDate
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.checkin = LocalDate.parse(checkinStr, dateFormat);
        this.checkout = LocalDate.parse(checkoutStr, dateFormat);
    }

    // Métodos para formatar e exibir as datas
    public String getCheckinFormatted() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return checkin.format(dateFormat);
    }

    public String getCheckoutFormatted() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return checkout.format(dateFormat);
    }

    // Método para exibir informações da reserva
    public String reservaInfo(){
        return "Id: " + id + " - Nome do cliente: " + nameCustomer + " - Data do Checkin: " + getCheckinFormatted() + " - Data Checkout: " + getCheckoutFormatted();
    }

}


