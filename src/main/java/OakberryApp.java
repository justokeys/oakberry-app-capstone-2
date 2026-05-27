import com.pluralsight.*;

public class OakberryApp {
    public static void main(String[] args) {
       // test for drink category enums
        System.out.println("The price for a " +  Size.LARGE.getSizeLabel() + " " + DrinkCategory.REFRESHER.getDisplayName() + " is " + DrinkCategory.REFRESHER.priceFor(Size.LARGE));

        AcaiBowl bowl = new AcaiBowl(Size.MEDIUM, BaseType.STANDARD);
        bowl.addTopping(new RegularTopping("Strawberry"));
        bowl.addTopping(new Condiment("Honey"));
        bowl.setHempBoost(true);

        System.out.println(bowl.getDescription());
        System.out.println("Total: $" + bowl.getPrice());
        Drink d1 = new Drink(Size.MEDIUM, DrinkFlavor.MANGO_TANGO);
        Drink d2 = new Drink(Size.LARGE, DrinkFlavor.VANILLA_LATTE);

        System.out.println(d1.getDescription() + " — $" + d1.getPrice());
        System.out.println(d2.getDescription() + " — $" + d2.getPrice());




    }
}
