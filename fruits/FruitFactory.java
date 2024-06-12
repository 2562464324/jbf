package fruits;

public class FruitFactory {
    public Fruit getFruit(String fruitType) {
        if (fruitType == null) {
            return null;
        }
        if (fruitType.equalsIgnoreCase("APPLE")) {
            return Apple.getInstance();
        }
        if (fruitType.equalsIgnoreCase("STRAWBERRY")) {
            return Strawberry.getInstance();
        }
        if (fruitType.equalsIgnoreCase("MONGO")) {
            return Mongo.getInstance();
        }
        return null;
    }
}
