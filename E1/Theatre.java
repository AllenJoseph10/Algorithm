public class Theatre {
    static int rows;
    static int seatsPerRow;
    static int bookedSeats;
    static double ticketPrice;
    static double expensesPerSeat;

    public static void main (String args[]) {
        /*
        DO NOT CHANGE ANY LINES OF CODE IN main() USE THIS AS A GUIDE
         */
        double calculateMaxProfit = maxProfit(ticketPrice);
        double calculateProfit = profit(bookedSeats, ticketPrice);
        double lostProfit = lostProfit (calculateMaxProfit, calculateProfit);
        System.out.println("The lost profit is " + lostProfit);
    }

    static int capacity(int rows, int seatsPerRow) {
        int capacity = rows * seatsPerRow;
        return capacity;
    }

    static double expenses(double expensesPerSeat, int bookedSeats) {
        double expenses = expensesPerSeat * bookedSeats;
        return expenses;
    }

    static double income(int bookedSeats, double ticketPrice) {
        double income = bookedSeats * ticketPrice;
        return income;
    }

    static double profit(int bookedSeats, double ticketPrice) {
        int a = bookedSeats;
        double b = ticketPrice;
        double inc = income(a,b);
        double exp = expenses(2,a);
        double profit = inc - exp;
        return profit;
    }

    static double maxProfit(double ticketPrice) {
        double maxProfit = income(640, ticketPrice) - expenses(2,640);
        return maxProfit;
    }

    static double lostProfit(double maxProfit, double actualProfit) {
        double loss = maxProfit - actualProfit;
        return loss;
    }

}
