public class IndInvestor implements Investor {
    private String name;

    public IndInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(name + " has been notified that " + stockName + " is now priced at $" + price);
    }
}
