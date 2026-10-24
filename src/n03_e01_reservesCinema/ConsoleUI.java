package n03_e01_reservesCinema;

import n03_e01_reservesCinema.services.ReservationService;
import java.util.Scanner;

public class ConsoleUI {

    private ReservationService service;
    private Scanner scanner;

    public ConsoleUI(ReservationService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        boolean running = true;
        while (running) {
            showMenu();
            int option = Helpers.readInt("Option: ", this.scanner);

            if (option == 0) {
                System.out.println("Bye!");
                running = false;
            } else if (option == 1) {
                service.showAllSeats();
            } else if (option == 2) {
                service.showSeatsByPerson(this.scanner);
            } else if (option == 3) {
                service.reserveSeat(this.scanner);
            } else if (option == 4) {
                service.cancelSeat(this.scanner);
            } else if (option == 5) {
                service.cancelAllByPerson(this.scanner);
            } else {
                System.out.println("Invalid option, try again");
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("1.- Show all reserved seats");
        System.out.println("2.- Show seats reserved by someone");
        System.out.println("3.- Reserve seat");
        System.out.println("4.- Cancel seat reservation");
        System.out.println("5.- Cancel all reservations from someone");
        System.out.println("0.- Quit");
    }



}
