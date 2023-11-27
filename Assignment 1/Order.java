public class Order {
    //attributes
    Customer customer;
    Stock stock;

    public Order(Customer customer, Stock stock) {
        //complete the constructor
        this.customer = customer;
        this.stock = stock;
    }

    //complete the getters()
    public Customer getCustomer() {
        return customer;
    }

    public Stock getStock() {
        return stock;
    }
}
