import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale locale = new Locale("PT", "BR");
        Hotel hotel = new Hotel(); // Instanciando a classe Hotel para usá-la futuramente

        System.out.println("\t-------GESTÃO DE HOTEL-------");

        // Variável "option" para armazenar opção do menu escolhida pelo usuário
        int option;
        do {
            System.out.println("\nMenu");
            System.out.println("(1) - Adicionar quarto");
            System.out.println("(2) - Lista de quartos");
            System.out.println("(3) - Realizar reserva");
            System.out.println("(4) - Sair do sistema");
            System.out.printf("Opção: ");
            option = scanner.nextInt();

            switch (option){

                // Case 1 para criar e adicionar o quarto criado no hotel
                case 1:
                    // Try catch para tratamento de erros
                    try {
                        System.out.println("\t\n-------ADICIONAR QUARTO-------");
                        System.out.print("Informe o ID do quarto: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Informe o tipo do quarto: ");
                        String type = scanner.nextLine();

                        System.out.print("Informe a capacidade do quarto: ");
                        int capacity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Informe o preço do quarto: R$");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        // Instanciando metodo construtor para criar o quarto
                        Room room = new Room(id, type, capacity, price);

                        // Adcionando o quarto criado na lista de quartos do hotel
                        hotel.rooms.add(room);
                        System.out.println("\t-------QUARTO ADICIONADO-------");

                        // Bloco catch caso o usuário insira um tipo de dado invalido
                    }catch (InputMismatchException e) {
                        System.out.println("Erro inesperado. Certifique-se de inserir o valor valido.");

                        // Bloco catch caso haja algum erro ao cadastrar o produto
                    } catch (Exception e){
                        System.out.println("\t-----Erro ao adicionar o quarto-----");
                        System.err.println("\t" + e.getMessage());
                    }
                    break;

                    // Case 2 para exibir a lista de quartos disponíveis
                case 2:
                    System.out.println("\t-------LISTA DE QUARTOS-------");

                    // Bloco try catch para tratamento de erros inesperados
                    try {
                        // Condição caso não tenha quartos cadastrados no sistema do hotel
                        if(hotel.rooms.isEmpty()){
                            System.out.println("Não temos quartos disponíveis no momento.");

                            // Caso contrário exibe a lista de quartos disponíveis
                        } else {
                            // For each para listar informações dos quartos
                            for(Room list : hotel.rooms){
                                System.out.println(list.roomInfo());
                            }
                        }

                        // Bloco catch para tratar algum erro ao tentar listar os quartos
                    } catch (Exception e){
                        System.out.println("\t-----Erro ao listar os quartos-----");
                        System.err.println("\t" + e.getMessage()); // Exibe menssagem do erro
                    }
                    break;

                // Case 3 para o usuário realizar uma reserva de um quarto
                case 3:
                    System.out.println("\t-------REALIZAR UMA RESERVA-------");

                    // Condição caso não tenha nenhum quarto disponíveis no sistema
                    if(hotel.rooms.isEmpty()) {
                        System.out.println("Não temos quartos disponíveis no momento.");

                        // Caso contrário exibe os quartos disponíveis
                    } else {

                        // Bloco try catch para tratamento de erros
                        try {

                            // Laço for para exibir os quartos disponíveis de acordo com o seu índice
                            for (int i = 0; i < hotel.rooms.size(); i++) {
                                System.out.println("Indice: " + i + " " + hotel.rooms.get(i).roomInfo());
                            }

                            // Solicitando o índice do quarto escolhido pelo usuário
                            System.out.print("Informe o índice do quarto: ");
                            int optionRoom = scanner.nextInt();
                            scanner.nextLine();

                            // Validando se o quarto escolhido pelo usuário já está reservado
                            if(Objects.equals(hotel.rooms.get(optionRoom).getStatus(), "Reservado")){
                                System.out.println("\t------Este quarto já está reservado------");

                                // Caso contrário o usuário procede com a reserva
                            } else {

                                // Validando se o índice do quarto escolhido pelo usuário existe na lista de quartos
                                if (optionRoom >= 0 && optionRoom < hotel.rooms.size()) {
                                    // Exibindo informações do quarto escolhido pelo usuário
                                    System.out.println("\n\t-----Quarto escolhido-----");
                                    System.out.println(hotel.rooms.get(optionRoom).roomInfo());

                                    // Solicitando informações da reserva
                                    System.out.print("\nInforme o ID da reserva: ");
                                    int idReserva = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Informe o nome do ciente: ");
                                    String nameCustomer = scanner.nextLine();

                                    System.out.print("Informe a data de checkin (formato dd/MM/yyyy): ");
                                    String checkinStr = scanner.nextLine();

                                    System.out.print("Informe a data de checkout (formato dd/MM/yyyy): ");
                                    String checkoutStr = scanner.nextLine();

                                    // Instanciando o método construtor da classe Reserva para criar uma nova reserva
                                    Reserva reserva = new Reserva(idReserva, nameCustomer, checkinStr, checkoutStr, hotel.rooms.get(optionRoom));

                                    // Adicionando a reserva na lista de reservas do Hotel
                                    hotel.reservas.add(reserva);

                                    // Exibindo informações da reserva para o usuário
                                    System.out.println("\t-------RESERVA CONCLUÍDA-------");

                                    System.out.println("Informações da reserva: ");
                                    System.out.println(reserva.reservaInfo());

                                    System.out.println("\nInformações do quarto: ");
                                    System.out.println(hotel.rooms.get(optionRoom).roomInfo());

                                    // Caso o índice do quarto escolhido pelo usuário não exista na lista de quartos
                                } else {
                                    System.out.println("Quarto não encontrado");
                                }
                            }

                            // Bloco catch caso ocorra algum erro ao realizar a reserva do quarto
                        } catch (Exception e) {
                            System.out.println("\t-----Erro ao realizar a reserva-----");
                        }
                    }
                    break;

                    // Exibindo menssagem personalizada ao encerrar o programa
                case 4:
                    System.out.println("\t-------Obrigado por utilizar nosso sistema!-------");
                    break;

                    // Caso o usuário insira uma opção de menu que não exista
                default:
                    System.out.println("Selecione uma opção do menu valida!");
                    break;
            }

            // Fim do laço do While até que a opção 4 seja digitada
        } while (option != 4);

        // Fechando o scanner
        scanner.close();
    }
}
