import Exceptions.AppSizeTooLargeException;
import Exceptions.DeveloperBannedException;
import Exceptions.InvalidCategoryException;
import Exceptions.PricingException;


import java.util.Arrays;
import java.util.List;

public class AppValidator {

    static List<String> allowedCategories= Arrays.asList("Games", "Utility", "Finance", "Enterprise");
    static List<String> bannedDevelopers= Arrays.asList("RedEye","Kratos");

    public static void validate(App app) throws AppSizeTooLargeException,
            DeveloperBannedException, InvalidCategoryException, PricingException {

        if (bannedDevelopers.contains(app.developerName)) {
            throw new DeveloperBannedException("Developer '" + app.developerName + "' is banned.");
        }

        if (app.appSizeInMB > 500) {
            throw new AppSizeTooLargeException("App size " + app.appSizeInMB
                    + "MB exceeds the 500MB limit.");
        }

        if (!allowedCategories.contains(app.category)) {

            throw new InvalidCategoryException("Invalid category '" + app.category
                    + "'. Allowed: " + allowedCategories);

        }

        if (app.price < 0) {

            throw new PricingException("Price cannot be negative.");

        }
        else if (!app.category.equals("Enterprise") && app.price > 100) {

            throw new PricingException("Price exceeds $100 limit for non-Enterprise apps.");

        }

    }
}
