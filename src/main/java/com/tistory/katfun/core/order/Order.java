package com.tistory.katfun.core.order;

public class Order {

    private Long memgberId;
    private String itenName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memgberId, String itenName, int itemPrice, int discountPrice) {
        this.memgberId = memgberId;
        this.itenName = itenName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    public Long getMemgberId() {
        return memgberId;
    }

    public void setMemgberId(Long memgberId) {
        this.memgberId = memgberId;
    }

    public String getItenName() {
        return itenName;
    }

    public void setItenName(String itenName) {
        this.itenName = itenName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memgberId=" + memgberId +
                ", itenName='" + itenName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
