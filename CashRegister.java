import java.util.Map;

import fruits.Fruit;
import fruits.FruitFactory;

public class CashRegister {

    private static CashRegister instance = new CashRegister();
    private CashRegister(){}
    public static CashRegister getInstance() {
        return instance;
    }
    
    FruitFactory fruitFactory = new FruitFactory();
    double discountPrice = 0.0f; // 折扣价格
    double discount = 0.0f; // 折扣
    boolean sale = false; // 是否开启折扣

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
    
    public double clculate(Map<String, Double> fruitMap) {
        double count = 0.0f;

        for (String fruit : fruitMap.keySet()) {
            double num = fruitMap.get(fruit);
            System.out.println("您买了" + fruit + "共" + num + "斤");
            Fruit target = fruitFactory.getFruit(fruit);
            count += target.getPrice() * num * target.getDiscount();
        }

        if (sale) {
            return count - ((Math.floor(count / discountPrice)) * 10);
        } else {
            return count;
        }
    }
}
