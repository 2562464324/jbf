package fruits;

public class Apple extends Fruit{
    private static Apple instance = new Apple();
    private Apple(){}
    public static Apple getInstance() {
        return instance;
    }
}
