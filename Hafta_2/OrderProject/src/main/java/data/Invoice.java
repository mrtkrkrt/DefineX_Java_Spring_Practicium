package data;

import java.util.Date;
import java.util.Objects;

public class Invoice {
    private String id;
    private int cost;
    private Date createDate;

    public Invoice(String id, int cost, Date createDate) {
        this.id = id;
        this.cost = cost;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", cost=" + cost +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (cost != invoice.cost) return false;
        if (!Objects.equals(id, invoice.id)) return false;
        return Objects.equals(createDate, invoice.createDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + cost;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
