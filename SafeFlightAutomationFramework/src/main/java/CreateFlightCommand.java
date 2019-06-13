import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class CreateFlightCommand {
	private String departureAirport;
	private String arrivalAirport;
	private String departureTime;
	private String arrivalTime;
	private String firstName;
	private String lastName;

	public CreateFlightCommand withDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;

		return this;
	}

	public CreateFlightCommand withArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
		return this;
	}

	public CreateFlightCommand withDepartureTime(String departureTime) {
		this.departureTime = departureTime;
		return this;
	}

	public CreateFlightCommand withArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
		return this;
	}

	public CreateFlightCommand withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CreateFlightCommand withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public void submit() {
		Driver.instance.findElement(By.id("DepartureAirport")).sendKeys(departureAirport);
		Driver.instance.findElement(By.id("ArrivalAirport")).sendKeys(arrivalAirport);
		Driver.instance.findElement(By.id("DepartureTime")).sendKeys(departureTime);
		Driver.instance.findElement(By.id("ArrivalTime")).sendKeys(arrivalTime);
		Driver.instance.findElement(By.id("FirstName")).sendKeys(firstName);
		Driver.instance.findElement(By.id("LastName")).sendKeys(lastName);
		Driver.instance.findElement(By.id("btnCreate")).click();
	}

}
