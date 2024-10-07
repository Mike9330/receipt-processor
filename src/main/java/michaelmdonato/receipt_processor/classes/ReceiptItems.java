package michaelmdonato.receipt_processor.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptItems<T> {
    @JsonProperty("shortDescription")
    public String shortDescription;

    @JsonProperty("price")
    public String price;
}
