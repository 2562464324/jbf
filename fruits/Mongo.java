package fruits;

public class Mongo extends Fruit{
    private static Mongo instance = new Mongo();
    private Mongo(){}
    public static Mongo getInstance() {
        return instance;
    }
}
