
import java.time.LocalDate;

public class DateLapse {
	LocalDate from;
	LocalDate to;
	
	// Esta clase deriva de una que implementaron en el cuadernillo
	// de ejercicios, tambien utilizada en el ejercicio de alquileres
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}

	public LocalDate getTo() {
		return this.to;
	}

	public int sizeInDays() {
		return from.until(to).getDays();
	}
	
	public boolean overlaps(LocalDate from, LocalDate to) {
		return !(this.from.isBefore(from) && this.to.isAfter(to));
	}
	
	public boolean overlaps(DateLapse dateLapse) {
		return this.overlaps(dateLapse.getFrom(), dateLapse.getTo());
	}

	public boolean includesDate(LocalDate other) {
		return this.overlaps(other, other);
	}
	
	public int daysThatOverlaps(DateLapse dateLapse) {
		if (this.overlaps(dateLapse)) {
			return this.from.until(dateLapse.getTo()).getDays();
		}
		return 0;
	}
}
