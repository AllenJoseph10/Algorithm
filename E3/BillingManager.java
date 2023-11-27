public class BillingManager
{
    double vat;
    public BillingManager ()
    {
        //complete default constructor
        vat = 0.2;

    }
    public BillingManager (double vat)
    {
        //complete constructor
        this.vat = vat;
    }
    public double getVAT()
    {
        //complete this method
        return vat;
    }

    public double computeBill(double amount)
    {
        //complete this method
        return amount + (vat*amount);
    }

    public double computeBill(double amount, int quantity)
    {
        //complete this method
        return amount * quantity + (vat*(amount * quantity));
    }
    public double computeBill(double amt, int quantity, double coupon)
    {
        //complete this method
        double bill = ((amt * quantity) - coupon);
        double valueAddedTax = (vat * bill);
        return bill +  valueAddedTax;
    }

}