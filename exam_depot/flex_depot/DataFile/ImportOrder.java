package flex_depot.DataFile;

public class ImportOrder extends Order {
    public ImportOrder(long numberOfOrder, String dateOfOrder, String loginOfStorekeeper, String loginOfDeliveryman, String goods, double viewOfGood) {
        super(numberOfOrder, dateOfOrder, loginOfStorekeeper, loginOfDeliveryman, goods, viewOfGood);
    }
}
