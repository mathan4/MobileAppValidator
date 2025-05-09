import Exceptions.AppSizeTooLargeException;
import Exceptions.DeveloperBannedException;
import Exceptions.InvalidCategoryException;
import Exceptions.PricingException;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<App> apps = Arrays.asList(
                new App("FunGame", "Alice", 300, "Games", 9),
                new App("HugeEditor", "Bob", 550, "Utility", 150),
                new App("SecureBank", "Charlie", 250, "Finance", -10),
                new App("ProSuite", "Derek", 1000, "Enterprise", 15),
                new App("CoolApp", "BadDev1", 500, "Games", 0),
                new App("MysteryTool", "Eve", 100, "Hacking", 20)
        );
        for (App app : apps) {
            try {
                AppValidator.validate(app);
                System.out.println("App '" + app.appName + "' by " + app.developerName
                        + " is approved for publishing.");

            } catch (Exception exception) {
                System.out.println("Validation failed for '" + app.appName + "': " + exception.getMessage());
            }finally {
                System.out.println("Validation completed for '" + app.appName + "'.\n");
            }
        }
    }
}
