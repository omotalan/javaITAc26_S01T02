package n03_e01_reservesCinema.validators;

import n03_e01_reservesCinema.Seat;
import n03_e01_reservesCinema.exceptions.InvalidPersonNameException;
import n03_e01_reservesCinema.exceptions.InvalidSeatException;
import n03_e01_reservesCinema.services.ReservationService;

public class ValidateInputs {

    public static void validateSeatPosition(Seat seat, ReservationService reservation) {
        if (seat.getRow() < 1 || seat.getRow() > reservation.getTotalRows()) {
            throw new InvalidSeatException("Row " + seat.getRow() + " out of range.");
        }
        if (seat.getSeat() < 1 || seat.getSeat() > reservation.getSeatsPerRow()) {
            throw new InvalidSeatException("Seat " + seat.getSeat() + " out of range.");
        }
    }

    public static void validatePersonName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonNameException("Name cannot be empty.");
        }
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new InvalidPersonNameException("Name cannot contain numbers.");
            }
        }
    }
}
