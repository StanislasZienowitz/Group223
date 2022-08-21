package flex_depot.DataFile;

public class Order {
    private long numberOfOrder;
    private String dateOfOrder;
    private String loginOfStorekeeper;
    private String loginOfDeliveryman;
    private String goods;
    private double viewOfGood;

    public Order(long numberOfOrder, String dateOfOrder, String loginOfStorekeeper, String loginOfDeliveryman, String goods, double viewOfGood) {
        this.numberOfOrder = numberOfOrder;
        this.dateOfOrder = dateOfOrder;
        this.loginOfStorekeeper = loginOfStorekeeper;
        this.loginOfDeliveryman = loginOfDeliveryman;
        this.goods = goods;
        this.viewOfGood = viewOfGood;
    }

    public long getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(long numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getLoginOfStorekeeper() {
        return loginOfStorekeeper;
    }

    public void setLoginOfStorekeeper(String loginOfStorekeeper) {
        this.loginOfStorekeeper = loginOfStorekeeper;
    }

    public String getLoginOfDeliveryman() {
        return loginOfDeliveryman;
    }

    public void setLoginOfDeliveryman(String loginOfDeliveryman) {
        this.loginOfDeliveryman = loginOfDeliveryman;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public double getViewOfGood() {
        return viewOfGood;
    }

    public void setViewOfGood(double viewOfGood) {
        this.viewOfGood = viewOfGood;
    }
}
