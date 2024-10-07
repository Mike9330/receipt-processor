package michaelmdonato.receipt_processor.classes;
import java.util.List;

public class Receipt {
    public String id;
    public String retailer;
    public String purchaseDate;
    public String purchaseTime;
    public String total;
    public List<ReceiptItems> items;

    public Receipt(String id) {this.id = id;}

    public void setId(String id) {
        this.id = id;
    }
    public void setRetailer (String retailer) {
        this.retailer = retailer;
    }
    public void setPurchaseDate(String timestamp) {
        this.purchaseDate = timestamp;
    }
    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public void setItems(List<ReceiptItems> items) {
        this.items = items;
    }


}
