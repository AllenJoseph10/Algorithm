import java.time.LocalDate;

public class BookStoreMain {
    public static void main(String[] args) {
        //create a bookStore object and instantiate
        BookStore bookStore = new BookStore();

        //create a customer who can then buy books
        Customer customer1 =
                new Customer("Jane Words", "+4472394586971", "wordsj@gmail.com");

        //customer1 places an order to purchase a book
        Stock book1 = new Stock("Death in the afternoon","Hemingway E.", 15.45);

        //placing the order ****
        Order order1 = new Order(customer1, book1);

        //determine the shipping date
        int year1 = 2022;
        int month1 = 12;
        int day1 = 25;

        LocalDate shipDate1 = LocalDate.of(year1,month1,day1);
        Shipping shippingOrder1 = new Shipping(order1,shipDate1);
        System.out.println(shippingOrder1.getShipDate());

        //calculate the shipping cost to send the order
        double shippingCost1 = shippingOrder1.calcShipCost(true);

        //create an invoice ****
        Invoice invoice1 = new Invoice("DIT001", book1 ,shippingOrder1);

        //add the invoices to a list so that we can search for an invoice ****
        bookStore.getInvoices().add(invoice1);
        bookStore.pilingUpOfOrders();

        //a repeat with another customer, order, etc...
        Customer customer2 = new Customer("Safwa Woods", "+447981234582", "woodss@gmail.com");
        Stock book2 = new Stock("Lord of the rings","Tolkien J.R.R.", 12.95);
        Order order2 = new Order(customer2, book2);

        //determine the shipping date
        int year2 = 2022;
        int month2 = 12;
        int day2 = 25;

        LocalDate shipDate2 = LocalDate.of(year2,month2,day2);
        Shipping shippingOrder2 = new Shipping(order2,shipDate2);
        System.out.println(shippingOrder2.getShipDate());

        //calculate the shipping cost to send the order
        double shippingCost2 = shippingOrder2.calcShipCost(true);

        //create an invoice
        Invoice invoice2 = new Invoice("LOT111", book2 ,shippingOrder2);

        //add the invoices to a list so that we can search for an invoice
        bookStore.getInvoices().add(invoice2);
        bookStore.pilingUpOfOrders();

        //search for order
        Invoice foundInvoice = new Invoice(bookStore.searchOrder("DIT001").getInvoiceNbr(),book1,shippingOrder1);
        Invoice foundinvoice = new Invoice(bookStore.searchOrder("LOT111").getInvoiceNbr(),book1,shippingOrder2);

    }
}

