import java.util.ArrayList;
import java.util.List;

public class Stock implements StockSubject {
    private List<Investor> investors = new ArrayList<>();
    private String stockName;
    private double price;

    public Stock(String stockName) {
        this.stockName = stockName;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    public void registerInvestor(Investor observer) {
        investors.add(observer);
    }

    public void removeInvestor(Investor observer) {
        investors.remove(observer);
    }

    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(stockName, price);
        }
    }
}
