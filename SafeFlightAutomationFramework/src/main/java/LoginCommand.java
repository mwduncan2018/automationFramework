import org.openqa.selenium.By;

public class LoginCommand {
	private String username;
	private String password;
	public LoginCommand(String username) {
		this.username = username;
	}

	public LoginCommand withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public void login() {
		Driver.instance.findElement(By.id("Username")).sendKeys(username);
		Driver.instance.findElement(By.id("Password")).sendKeys(password);
		Driver.instance.findElement(By.id("btnLogin")).click();
	}
}
