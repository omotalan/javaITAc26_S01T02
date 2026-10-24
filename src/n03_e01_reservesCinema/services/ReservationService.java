package n03_e01_reservesCinema.services;

import n03_e01_reservesCinema.Helpers;
import n03_e01_reservesCinema.records.TotalRows;
import n03_e01_reservesCinema.records.TotalSeats;
import n03_e01_reservesCinema.validators.ValidateInputs;
import n03_e01_reservesCinema.exceptions.SeatAlreadyEmptyException;
import n03_e01_reservesCinema.exceptions.SeatAlreadyTakenException;
import n03_e01_reservesCinema.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationService {

    private TotalRows totalRows;
    private TotalSeats seatsPerRow;
    private List<Seat> seats;

    public ReservationService(Scanner scanner) {
        this.totalRows = setTotalRows(scanner);
        this.seatsPerRow = setTotalSeats(scanner);
        this.seats = new ArrayList<Seat>();
    }

    public int getTotalRows() {
        return totalRows.rows();
    }

    public int getSeatsPerRow() {
        return seatsPerRow.seats();
    }

    public TotalRows setTotalRows(Scanner scanner){
        System.out.println("Welcome to Cinema Reservation service. \n");
        int rows = Helpers.readInt("Insert number of total rows: ", scanner);

        return new TotalRows(rows);
    }

    public TotalSeats setTotalSeats(Scanner scanner){
        int seats = Helpers.readInt("Insert number of seats per row: ", scanner);

        return new TotalSeats(seats);
    }

    public void reserveSeat(Scanner scanner) {
        int inputRow = Helpers.readInt("Provide row number: ", scanner);
        int inputSeat = Helpers.readInt("Provide seat number: ", scanner);
        String inputName = Helpers.readLine(scanner);

        Seat newSeat = new Seat(inputRow, inputSeat, inputName);

        ValidateInputs.validateSeatPosition(newSeat, this);
        ValidateInputs.validatePersonName(inputName);

        if (seats.contains(newSeat)) {
            throw new SeatAlreadyTakenException(
                    "Seat at row " + inputRow + ", seat " + inputSeat + " is already taken.");
        }
        seats.add(newSeat);
    }

    public void cancelSeat(Scanner scanner) {
        int inputRow = Helpers.readInt("Provide row number: ", scanner);
        int inputSeat = Helpers.readInt("Provide seat number: ", scanner);

        Seat target = new Seat(inputRow, inputSeat, null);

        ValidateInputs.validateSeatPosition(target, this);

        if (!seats.remove(target)) {
            throw new SeatAlreadyEmptyException(
                    "Seat at row " + inputRow + ", seat " + inputSeat + " is not reserved.");
        }
    }

    public void cancelAllByPerson(Scanner scanner) {
        String inputName = Helpers.readLine(scanner);

        for (int i = seats.size() - 1; i >= 0; i--) {
            if (seats.get(i).getPersonName().equalsIgnoreCase(inputName)) {
                seats.remove(i);
            }
        }
    }

    public List<Seat> getAllSeats() {
        return seats;
    }

    public List<Seat> getSeatsByPerson(String name) {
        List<Seat> result = new ArrayList<Seat>();
        for (Seat seat : seats) {
            if (seat.getPersonName().equalsIgnoreCase(name)) {
                result.add(seat);
            }
        }
        return result;
    }

    public void showAllSeats() {
        List<Seat> seats = getAllSeats();
        if (seats.isEmpty()) {
            System.out.println("No reservations available");
        } else {
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        }
    }

    public void showSeatsByPerson(Scanner scanner) {
        String name = Helpers.readLine(scanner);
        List<Seat> seats = getSeatsByPerson(name);
        if (seats.isEmpty()) {
            System.out.println("No reservations found for " + name + ".");
        } else {
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        }
    }
}
