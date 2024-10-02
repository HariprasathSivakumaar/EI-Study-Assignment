public interface StockSubject {
    void registerInvestor(Investor observer);
    void removeInvestor(Investor observer);
    void notifyInvestors();
}
