package michaelmdonato.receipt_processor.controllers;

import michaelmdonato.receipt_processor.classes.Points;
import michaelmdonato.receipt_processor.classes.Receipt;
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
    public Receipt processReciepts(@RequestBody ReceiptReqBody reqBody) throws IOException {
        return this.receiptService.processReceipts(reqBody);
    }

    @GetMapping("/{id}/process")
    public Points getPoints(@PathVariable String id) throws IOException {
        return this.receiptService.getPoints(String.valueOf(id));
    }
}
