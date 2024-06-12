package fruits;

public class Fruit {
    // 名称
    public String name;
    // 价格
    public double price;
    // 折扣
    public double discount;

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
