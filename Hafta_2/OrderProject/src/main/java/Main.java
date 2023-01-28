import data.*;
import service.CustomerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Order> normalOrders1 = new ArrayList<>();
        normalOrders1.add(new Order("orderId1", "Candy", 150));
        normalOrders1.add(new Order("orderId2", "Office Stuff", 2050));
        normalOrders1.add(new Order("OrderId3", "Computer", 725));

        List<Order> normalOrders2 = new ArrayList<>();
        normalOrders1.add(new Order("orderId4", "Snacks", 150));
        normalOrders1.add(new Order("orderId5", "bureu", 200));
        normalOrders1.add(new Order("OrderId6", "computer", 1250));

        List<Order> corporateOrders1 = new ArrayList<>();
        corporateOrders1.add(new Order("orderId1", "Mobile Phones", 2025));
        corporateOrders1.add(new Order("orderId2", "Office Stuff", 2500));
        corporateOrders1.add(new Order("orderId3", "Coffee Machine", 350));

        List<Order> corporateOrders2 = new ArrayList<>();
        corporateOrders1.add(new Order("orderId4", "Snacks", 225));
        corporateOrders1.add(new Order("orderId5", "Tissue", 25));
        corporateOrders1.add(new Order("orderId6", "mousepad", 159));

        Customer normalCustomer = new NormalCustomer("id3", "Christopher", new Date(2019, 5, 12), normalOrders1);
        Customer normalCustomer2 = new NormalCustomer("id2", "Emma", new Date(2021, 11, 5), normalOrders2);
        Customer corporateCustomer = new CorporateCustomer("id6", "Microsoft", new Date(2018, 5, 1), corporateOrders1, "Tech");
        Customer corporateCustomer2 = new CorporateCustomer("id5", "Biontech", new Date(2020, 3, 21), corporateOrders2, "Medical");


        CustomerService.createNormalCustomer("id1", "John", new Date(), new ArrayList<>());
        CustomerService.createNormalCustomer(normalCustomer2);
        CustomerService.createNormalCustomer(normalCustomer);

        CustomerService.createCorporateCustomer("id4", "Tesla", new Date(), new ArrayList<>(), "Tech");
        CustomerService.createCorporateCustomer(corporateCustomer2);
        CustomerService.createCorporateCustomer(corporateCustomer);

        System.out.println("List All Customers");
        System.out.println("---------------------------------------");
        CustomerService.listAllCustomers();
        System.out.println("\n");

        System.out.println("List customers with the constains letter 'C'");
        System.out.println("---------------------------------------");
        CustomerService.filterCustomersByName("C");
        System.out.println("\n");

        System.out.println("List the total amount of invoices for customers who signed up in june");
        System.out.println("---------------------------------------");
        CustomerService.filterCustomerBySignDate(6);
        System.out.println("\n");

        System.out.println("List all invoices in the system");
        System.out.println("---------------------------------------");
        CustomerService.listAllInvoice();
        System.out.println("\n");

        System.out.println("List invoices over 1500TL in the system");
        System.out.println("---------------------------------------");
        CustomerService.filterByInvoiceHigherCost(1500);
        System.out.println("\n");

        System.out.println("List the names of customers with invoices under 500TL in the prompt");
        System.out.println("---------------------------------------");
        CustomerService.filterByInvoiceLowerCost(500);
        System.out.println("\n");

        System.out.println("Calculate the average of invoices over 1500TL in the system");
        System.out.println("---------------------------------------");
        CustomerService.filterByInvoiceCostAndAverage(1500);
        System.out.println("\n");

        System.out.println("List the companies in which the average invoices for the month of June are below 750.");
        System.out.println("---------------------------------------");
        CustomerService.filterByCostAndListSector(6, 750);
    }
}