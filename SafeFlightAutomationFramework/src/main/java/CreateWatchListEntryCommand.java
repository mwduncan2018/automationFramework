import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class CreateWatchListEntryCommand {
	private Integer bounty;
	private String firstName;
	private String lastName;

	public CreateWatchListEntryCommand withBounty(Integer bounty) {
		this.bounty = bounty;
		return this;
	}

	public CreateWatchListEntryCommand withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CreateWatchListEntryCommand withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public void submit() {
		Driver.instance.findElement(By.id("Bounty")).sendKeys(bounty.toString());
		Driver.instance.findElement(By.id("FirstName")).sendKeys(firstName);
		Driver.instance.findElement(By.id("LastName")).sendKeys(lastName);
		Driver.instance.findElement(By.id("btnCreate")).click();
	}

}
