package michaelmdonato.receipt_processor.classes;
import java.util.List;

public class Receipt {
    public String id;
    public String retailer;
    public String purchaseDate;
    public String purchaseTime;
    public String total;
    public List<ReceiptItems> items;
    public String points;

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
    public void setPoints(String points) {
        this.points = points;
    }

     public String getId() {
        return this.id;
     }
     public String getRetailer() {
        return this.retailer;
     }
     public String getPurchaseDate() {
        return this.purchaseDate;
     }
     public String getPurchaseTime() {
        return this.purchaseTime;
     }
     public String getTotal() {
        return this.total;
     }
     public String getPoints() {
        return this.points;
     }
}
