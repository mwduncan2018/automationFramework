
public class CreateWatchListEntryPage extends AbstractPage {

	public static boolean isAt() {
		return isAt("Create Watch List Entry");
	}

	public static CreateWatchListEntryCommand createEntry() {
		isAt();
		return new CreateWatchListEntryCommand();
	}

}
