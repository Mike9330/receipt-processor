package michaelmdonato.receipt_processor.controllers;

import michaelmdonato.receipt_processor.classes.ReceiptReqBody;
import michaelmdonato.receipt_processor.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/process")
    public String processReciepts(@RequestBody ReceiptReqBody reqBody) throws IOException {

        return this.receiptService.processReceipts(reqBody);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = objectMapper.writeValueAsString(receipt);
//            String genId = UUID.randomUUID().toString();
//            receipt.setId(genId);
//            return json;
//        } catch (IOException e) {
//            return ("Error adding: " + e.getMessage());
//        }
    }

    @GetMapping("/test")
    public String test(){
        return "Hey, this works!";
    }
}
