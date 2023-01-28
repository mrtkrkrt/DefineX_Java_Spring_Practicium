package service;

import data.*;

import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerService {

    public static final List<Customer> customers = new ArrayList<>();

    public static void listAllCustomers() {
        customers.stream().forEach(customer -> System.out.println(customer.toString()));
    }

    public static void createNormalCustomer(String id, String name, Date signDate, List<Order> orders) {
        customers.add(new NormalCustomer(id, name, signDate, orders));
    }

    public static void createNormalCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void createCorporateCustomer(String id, String name, Date signDate, List<Order> orders, String sector) {
        customers.add(new CorporateCustomer(id, name, signDate, orders, sector));
    }

    public static void createCorporateCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void filterCustomersByName(String key) {
        customers.stream().filter(customer -> customer.getName().toLowerCase().contains(key.toLowerCase())).
                forEach(customer -> System.out.println(customer.toString()));
    }

    public static void filterCustomerBySignDate(int month) {
        customers.stream().
                filter(customer -> customer.getSignDate().toInstant().
                        atZone(ZoneId.systemDefault()).toLocalDate().getMonth() == Month.of(month)).collect(Collectors.toList()).
                stream().forEach(customer -> System.out.println(customer.getName() + " total order cost: " +
                        customer.getOrders().stream().mapToInt(Order::getCost).sum()));
    }

    public static void listAllInvoice() {
        customers.stream().forEach(customer -> customer.getOrders().stream().
                forEach(order -> System.out.println(order.toString())));
    }

    public static void filterByInvoiceHigherCost(int cost) {
        customers.stream().forEach(customer -> customer.getOrders().
                stream().filter(order -> order.getInvoice().getCost() > cost).forEach(order -> System.out.println(order.getInvoice().toString())));
    }

    public static void filterByInvoiceLowerCost(int cost) {
        customers.stream().filter(customer -> customer.getOrders().stream().mapToInt(Order::getCost).sum() < cost).
                collect(Collectors.toSet()).stream().forEach(customer -> System.out.println(customer.getName()));
    }

    public static void filterByInvoiceCostAndAverage(int cost) {
        System.out.println(customers.stream().flatMap(customer -> customer.getOrders().stream()).filter(order -> order.getCost() > cost).
                collect(Collectors.toList()).stream().mapToInt(Order::getCost).average().orElse(0));
    }

    public static void filterByCostAndListSector(int month, double average) {
        customers.stream().filter(customer -> customer.getSignDate().toInstant().
                atZone(ZoneId.systemDefault()).toLocalDate().getMonth() == Month.of(month)).
                filter(customer -> customer.getOrders().stream().
                        mapToInt(Order::getCost).average().orElse(0) < average).
                filter(customer -> customer.getClass() == CorporateCustomer.class).
                forEach(customer -> System.out.println(((CorporateCustomer) customer).getSector()));
    }
}
