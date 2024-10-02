public class StockMarket {
    public static void main(String[] args) {
        Stock googleStock = new Stock("Apple");
        IndInvestor investor1 = new IndInvestor("Hari");
        IndInvestor investor2 = new IndInvestor("Prasath");

        googleStock.registerInvestor(investor1);
        googleStock.registerInvestor(investor2);

        googleStock.setPrice(1500);
        googleStock.setPrice(1550);
    }
}
