import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fruits.Apple;
import fruits.Fruit;
import fruits.FruitFactory;
import fruits.Mongo;
import fruits.Strawberry;

public class Supermarket {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();

        // 初始化苹果的价格和折扣
        Apple apple = Apple.getInstance();
        apple.setPrice(8.0f);
        apple.setDiscount(1.0f);

        // 初始化草莓的价格和折扣
        Strawberry strawberry = Strawberry.getInstance();
        strawberry.setPrice(13.0f);
        strawberry.setDiscount(1.0f);

        // 初始化芒果的价格
        Mongo mongo = Mongo.getInstance();
        mongo.setPrice(20.0f);
        mongo.setDiscount(0.8f);

        // 使用一个map存放顾客购买的水果
        Map<String, Double> fruitMap = new HashMap<>();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("请选择您要购买的商品(输入end结账)");
            String fruit = null;

            if (scan.hasNext()) {
                String str = scan.next();
                if ("end".equals(str)) {
                    break;
                } else {
                    fruit = str;

                    // 从工厂中获取水果
                    Fruit target = fruitFactory.getFruit(fruit);
                    // 水果不存在
                    if (target == null) {
                        System.out.println("抱歉，没有该商品");
                        continue;
                    }
                    System.out.println("您选择购买：" + fruit);
                }
            }

            System.out.println("请选择您要购买的数量(输入end结账)");

            if (scan.hasNextFloat()) {
                Double num = scan.nextDouble();
                if(num < 0) {
                    continue;
                }
                System.out.println("您选择购买：" + num + "斤");
                // 判断是否买过
                if (fruitMap.containsKey(fruit)) {
                    double count = fruitMap.get(fruit);
                    fruitMap.put(fruit, count + num);
                } else {
                    fruitMap.put(fruit, num);
                }
            }

        }
        scan.close();

        CashRegister cashRegister = CashRegister.getInstance();
        cashRegister.setDiscountPrice(100.0f);
        cashRegister.setDiscount(10.0f);
        cashRegister.setSale(true);

        double count = cashRegister.clculate(fruitMap);

        System.out.println("共花费" + count + "元");
        System.out.println("欢迎下次光临");
    }
}