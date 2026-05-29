# Oakberry POS — Custom Açaí Bowl Shop

A console-based point-of-sale application for a custom açaí bowl shop, built in Java. Customers can build fully customized açaí bowls, order sized drinks across multiple categories, add sides, review their order, and check out with an itemized receipt saved to disk.

This project was built as a capstone to demonstrate object-oriented design, clean architecture, and professional development practices.

---

## About

Oakberry POS automates the in-store ordering process for an açaí bowl shop. The application walks a customer through building their order one item at a time — choosing bowl sizes, açaí bases, toppings (regular and premium), and a hemp seed superfood boost — then totals the order and saves a timestamped receipt.

The menu and pricing are modeled on a real Oakberry açaí shop, including authentic base blends, premium topping tiers, and drink categories.

---

## Features

- **Build-a-Bowl flow** — choose size, açaí base, regular toppings, premium toppings, and an optional hemp seed boost
- **Multi-category drinks** — smoothies, refreshers, coffee, and bottled water, each with their own flavors and price tiers
- **Sides** — flat-priced add-on items
- **Live order summary** — running subtotal as items are added
- **Checkout** — itemized order review with confirm/cancel
- **Receipt persistence** — each completed order saves to a timestamped `.txt` file (`yyyyMMdd-HHmmss.txt`)
- **Input validation** — invalid input (letters where numbers are expected, out-of-range choices) is handled gracefully without crashing

---

## Architecture

The project follows a layered architecture with a strict one-way dependency flow: **UI -> Service -> Domain**. Domain classes contain no input/output logic, which keeps the business rules testable and independent of the console.

```
src/main/java/
├── com/pluralsight/        Domain layer (pure business objects)
│   ├── OrderItem.java          (interface — the orderable contract)
│   ├── Item.java               (abstract base — name + size)
│   ├── AcaiBowl.java           (customizable bowl)
│   ├── Drink.java              (sized drink)
│   ├── Side.java               (flat-priced side)
│   ├── Topping.java            (abstract topping)
│   ├── RegularTopping.java     (free toppings)
│   ├── PremiumTopping.java     (paid toppings, priced by category)
│   ├── Order.java              (the cart — holds OrderItems, computes total)
│   ├── Size.java               (enum)
│   ├── BaseType.java           (enum)
│   ├── DrinkCategory.java      (enum)
│   ├── DrinkFlavor.java        (enum)
│   ├── SideType.java           (enum)
│   ├── PremiumCategory.java    (enum)
│   └── PremiumToppingMenu.java (enum — premium topping catalog)
├── service/                Service layer
│   ├── ReceiptService.java     (saves orders to disk)
│   └── PromptHelper.java       (input validation + money formatting)
├── ui/                     UI layer (the only place Scanner/System.out live)
│   └── UI.java                 (all screens and menus)
└── OakberryApp.java        Entry point
```

### Design highlights

- **Polymorphism** — `Order` holds a `List<OrderItem>` and totals it with one loop. Bowls, drinks, and sides each compute their own price. Adding a new product type requires no changes to `Order`.
- **`BigDecimal` for money** — all currency uses `BigDecimal` (constructed from String literals) to avoid floating-point rounding errors, the standard for financial applications.
- **Enums carry their own data** — sizes, bases, categories, and flavors each store their pricing and display information, keeping data with the concept it belongs to.
- **Type-safe pricing tiers** — premium toppings reference a `PremiumCategory` enum that holds per-size price maps, so a price change updates everywhere automatically (DRY).
- **Input validation** — a reusable `PromptHelper.readInt()` method loops until valid input is received, making the application crash-proof against bad user input.

A full UML class diagram is available at [`docs/class-diagram.svg`](docs/class-diagram.svg).

---

## Tech Stack

- **Java 17** (Amazon Corretto)
- **Maven** (build & project structure)
- **No external dependencies** — pure Java standard library

---

## How to Run

**Prerequisites:** Java 17+ and Maven installed.

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/oakberry-app-capstone-2.git
   cd oakberry-app-capstone-2
   ```

2. Run from your IDE (IntelliJ recommended):
   - Open the project
   - Run `OakberryApp.java`

   Or compile and run from the command line:
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="OakberryApp"
   ```

3. Follow the on-screen menus to build an order.

Completed orders are saved as receipts in `src/main/resources/receipts/`.

---

## Usage

```
== Welcome to Oakberry ==
1- Add a Bowl
2- Add a Drink
3- Add a Side
4- View Current Order
5- Checkout
6- Exit
```

- **Add a Bowl** walks you through size -> base -> regular toppings -> premium toppings -> hemp boost
- **Add a Drink** prompts for category -> size -> flavor
- **Add a Side** offers flat-priced items
- **Checkout** displays the full itemized order and saves a receipt on confirmation

---

## Menu & Pricing

### Bowl sizes
| Size | Name | Volume | Base Price |
|------|------|--------|-----------|
| Small | Classic | 12 oz | $9.00 |
| Medium | Works | 16 oz | $10.00 |
| Large | The Oak | 20 oz | $12.00 |

### Açaí bases
| Base | Upcharge |
|------|----------|
| Açaí (standard) | +$0.00 |
| Açaí + Green Superfood Blend | +$1.50 |
| Açaí + I*M*8 Berry Blend | +$1.50 |

### Premium topping tiers (per scoop, by size)
| Tier | Small | Medium | Large |
|------|-------|--------|-------|
| Nut Butter | $1.00 | $1.50 | $2.00 |
| Protein | $2.00 | $2.50 | $3.50 |
| Superfood | $1.50 | $2.00 | $3.00 |

Regular toppings (fruits, granola, drizzles) are included free.
Hemp Seed Boost: +$1.00 / $1.50 / $2.00 by size.

---

## Screenshots

*(Add screenshots of the running app here — main menu, bowl-building flow, checkout, and a saved receipt.)*

---

## Design Decisions & Lessons Learned

- **Merged `Condiment` into `RegularTopping`** — both represented free, customer-selected toppings with identical behavior, so maintaining two classes added complexity without value.
- **Used `BigDecimal` from the String constructor** — `new BigDecimal("1.50")` avoids the floating-point error introduced by `new BigDecimal(1.50)`.
- **Scoped out an inventory-tracking feature** — based on real Oakberry operations, this was captured as a future enhancement to keep v1 focused and on schedule.
- **Feature-branch Git workflow** — used branches and pull requests rather than committing directly to `main`, mirroring a production team's process.

---

## Future Enhancements

- Inventory tracking with restock alerts (decrement stock per order)
- Admin CLI for viewing sales and managing inventory
- Signature Bowls — pre-built templates the customer can customize
- Externalized pricing/config so prices can change without recompiling

---

## Author

Built by **Justin K.** as Capstone 2 for the Year Up United / Pluralsight Java development track.
