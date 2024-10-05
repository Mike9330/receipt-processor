package michaelmdonato.receipt_processor.service;

import michaelmdonato.receipt_processor.classes.ReceiptReqBody;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class ReceiptService {
    public String processReceipts(ReceiptReqBody reqBody) throws IOException {
        String genId = UUID.randomUUID().toString();
        return reqBody.toString();
    }
}
