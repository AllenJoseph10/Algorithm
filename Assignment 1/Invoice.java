public class Invoice {
    //attributes
    String invoiceNbr;
    Stock stock;
    Shipping shipOrder;
    double totalCost;


    //complete the constructor
    public Invoice(String invoiceNbr, Stock stock, Shipping shipOrder){
        this.invoiceNbr = invoiceNbr;
        this.stock = stock;
        this.shipOrder = shipOrder;
    }

    //complete the getter()

    public String getInvoiceNbr() {
        return invoiceNbr;
    }

    //complete the totalCost for a shipping order
    public double invoice(){
        totalCost = stock.price + shipOrder.shipCost;
        return totalCost;
    }
}
