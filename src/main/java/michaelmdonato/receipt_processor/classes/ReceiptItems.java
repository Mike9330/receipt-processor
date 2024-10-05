package michaelmdonato.receipt_processor.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptItems<T> {
    @JsonProperty("shortDescription")
    private String shortDescription;

    @JsonProperty("price")
    private String price;
}
