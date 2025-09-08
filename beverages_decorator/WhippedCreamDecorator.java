package beverages_decorator;

public class WhippedCreamDecorator extends BeverageDecorator {
    private static final int WHIPPED_CREAM_COST = 3;
    
    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + WHIPPED_CREAM_COST;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Whipped Cream";
    }
}
