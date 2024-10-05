package michaelmdonato.receipt_processor.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReceiptReqBody {

//    public String id;
//
//    public Receipt(String id) {
//        this.id = id;
//    }
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

    // public void setId(String id) {this.id = id;}

    // public String getId() {return this.id;}
}
