package fruits;

public class Strawberry extends Fruit{
    private static Strawberry instance = new Strawberry();
    private Strawberry(){}
    public static Strawberry getInstance() {
        return instance;
    }
}
