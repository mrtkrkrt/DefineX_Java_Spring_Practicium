package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Customer {
    private String id;
    private String name;
    private Date signDate;
    private List<Order> orders;

    public Customer(String id, String name, Date signDate, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.signDate = signDate;
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public abstract void createOrder(Order order);

    public abstract void createOrder(String id, String content, int cost);

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", signDate=" + signDate +
                '}';
    }
}
