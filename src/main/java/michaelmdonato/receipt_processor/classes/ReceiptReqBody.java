package michaelmdonato.receipt_processor.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReceiptReqBody {
    @JsonProperty("retailer")
    private String retailer;

    @JsonProperty("purchaseDate")
    private String purchaseDate;

    @JsonProperty("purchaseTime")
    private String purchaseTime;

    @JsonProperty("items")
    private List<ReceiptItems> items;

    @JsonProperty("total")
    private String total;

    public String getRetailer() {
        return retailer;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public String getTotal() {
        return total;
    }

    public List<ReceiptItems> getItems() {
        return items;
    }
}
