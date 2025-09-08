package beverages_decorator;

public class Client {

    public static void main(String[] args) {
        // Basic beverages
        Beverage cappuccino = new Cappuccino();
        Beverage latte = new Latte();

        // Decorated beverages
        Beverage cappuccinoWithMilk = new MilkDecorator(new Cappuccino());
        Beverage latteWithSugar = new SugarDecorator(new Latte());
        Beverage cappuccinoWithMilkAndSugar = new SugarDecorator(new MilkDecorator(new Cappuccino()));
        Beverage fancyLatte = new WhippedCreamDecorator(new SugarDecorator(new Latte()));
        Beverage superCappuccino = new WhippedCreamDecorator(new MilkDecorator(new SugarDecorator(new Cappuccino())));

        // Print menu with descriptions and costs
        System.out.println("=== Coffee Shop Menu ===\n");
        
        printBeverage(cappuccino);
        printBeverage(latte);
        printBeverage(cappuccinoWithMilk);
        printBeverage(latteWithSugar);
        printBeverage(cappuccinoWithMilkAndSugar);
        printBeverage(fancyLatte);
        printBeverage(superCappuccino);
    }
    
    private static void printBeverage(Beverage beverage) {
        System.out.println(beverage.getDescription() + ": $" + beverage.cost());
    }
}