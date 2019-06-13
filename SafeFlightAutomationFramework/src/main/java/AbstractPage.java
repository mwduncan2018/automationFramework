import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {

	protected static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	protected static boolean isAt(String pageName) {
		if (Driver.instance.findElement(By.id("pageName")).getText().equals(pageName)) {
			logger.log(Level.ALL, "Page successfully found: " + pageName);
			return true;
		}
		else {
			logger.log(Level.ALL, "WARNING! Not on expected page: " + pageName);
			return false;			
		}
	}
}
