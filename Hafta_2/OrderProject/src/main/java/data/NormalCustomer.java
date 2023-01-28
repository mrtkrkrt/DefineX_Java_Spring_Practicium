package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NormalCustomer extends Customer{


    public NormalCustomer(String id, String name, Date signDate, List<Order> orders) {
        super(id, name, signDate, orders);
    }

    @Override
    public void createOrder(Order order) {
        super.getOrders().add(order);
    }

    @Override
    public void createOrder(String id, String content, int cost) {
        super.getOrders().add(new Order(id, content, cost));
    }

    @Override
    public List<Order> getOrders() {
        return super.getOrders();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", signDate= " + super.getSignDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!Objects.equals(super.getId(), super.getId())) return false;
        if (!Objects.equals(super.getName(), super.getName())) return false;
        return Objects.equals(super.getSignDate(), super.getSignDate());
    }

    @Override
    public int hashCode() {
        int result = super.getId() != null ? super.getId().hashCode() : 0;
        result = 31 * result + (super.getName() != null ? super.getName().hashCode() : 0);
        result = 31 * result + (super.getSignDate() != null ? super.getSignDate().hashCode() : 0);
        return result;
    }
}
