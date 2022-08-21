package flex_depot.DataFile;

public class ExportOrder extends Order {
    public ExportOrder(long numberOfOrder, String dateOfOrder, String loginOfStorekeeper, String loginOfDeliveryman, String goods, double viewOfGood) {
        super(numberOfOrder, dateOfOrder, loginOfStorekeeper, loginOfDeliveryman, goods, viewOfGood);
    }
}
