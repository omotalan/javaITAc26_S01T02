package n03_e01_reservesCinema;

import n03_e01_reservesCinema.services.ReservationService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationService service = new ReservationService(scanner);
        ConsoleUI ui = new ConsoleUI(service, scanner);
        ui.start();
    }
}
