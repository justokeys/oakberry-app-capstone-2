import com.pluralsight.DrinkCategory;
import com.pluralsight.Size;

public class OakberryApp {
    public static void main(String[] args) {
       // test for drink category enums
        System.out.println("The price for a " +  Size.LARGE.getSizeLabel() + " " + DrinkCategory.REFRESHER.getDisplayName() + " is " + DrinkCategory.REFRESHER.priceFor(Size.LARGE));




    }
}
