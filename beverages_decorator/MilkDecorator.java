package beverages_decorator;

public class MilkDecorator extends BeverageDecorator {
    private static final int MILK_COST = 2;
    
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + MILK_COST;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Milk";
    }
}
