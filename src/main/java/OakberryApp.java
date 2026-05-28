import com.pluralsight.*;
import ui.UI;

public class OakberryApp {
    public static void main(String[] args) {
       // test for drink category enums
//        System.out.println("The price for a " +  Size.LARGE.getSizeLabel() + " " + DrinkCategory.REFRESHER.getDisplayName() + " is " + DrinkCategory.REFRESHER.priceFor(Size.LARGE));
//
//        AcaiBowl bowl = new AcaiBowl(Size.MEDIUM, BaseType.STANDARD);
//        bowl.addTopping(new RegularTopping("Strawberry"));
//        bowl.addTopping(new RegularTopping("Honey"));
//        bowl.addTopping(new PremiumTopping("I*M*8",PremiumCategory.SUPERFOOD));
//        bowl.setHempBoost(true);
//
//        System.out.println(bowl.getDescription());
//        System.out.println("Total: $" + bowl.getPrice());
//        Drink d1 = new Drink(Size.MEDIUM, DrinkFlavor.MANGO_TANGO);
//        Drink d2 = new Drink(Size.LARGE, DrinkFlavor.VANILLA_LATTE);
//
//        System.out.println(d1.getDescription() + " — $" + d1.getPrice());
//        System.out.println(d2.getDescription() + " — $" + d2.getPrice());
//
//        Side s1 = new Side(SideType.OAK_BAR);
//        Side s2 = new Side(SideType.GRANOLA);
//        Side s3 = new Side(SideType.PEANUT_BUTTER_BITES);
//
//        System.out.println(s1.getDescription() + " — $" + s1.getPrice());
//        System.out.println(s2.getDescription() + " — $" + s2.getPrice());
//        System.out.println(s3.getDescription() + " — $" + s3.getPrice());
//        System.out.println();
//        System.out.println();
//        Order order = new Order();
//
//        AcaiBowl bowl2 = new AcaiBowl(Size.MEDIUM, BaseType.STANDARD);
//        bowl2.addTopping(new RegularTopping("Strawberry"));
//        bowl2.addTopping(new PremiumTopping("I*M*8", PremiumCategory.SUPERFOOD));
//        bowl2.setHempBoost(true);
//
//       order.addItem(bowl2);
//        order.addItem(new Drink(Size.MEDIUM, DrinkFlavor.MANGO_TANGO));
//        order.addItem(new Side(SideType.OAK_BAR));
//
//        System.out.println("=== ORDER ===");
//        for (OrderItem item : order.getItems()) {
//            System.out.println(item.getDescription() + " — $" + item.getPrice());
//        }
//        System.out.println();
//        System.out.println("Created: " + order.getOrderTime());
//        System.out.println("TOTAL: $" + order.getTotal());


        UI menu = new UI();

        menu.start();

    }
}
