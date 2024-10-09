package michaelmdonato.receipt_processor.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseId {

    @JsonProperty
    String id;
    public ResponseId(String id) {
        this.id = id;
    }
}
