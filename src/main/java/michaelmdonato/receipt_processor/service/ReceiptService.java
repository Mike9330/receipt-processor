package michaelmdonato.receipt_processor.service;

import michaelmdonato.receipt_processor.classes.Points;
import michaelmdonato.receipt_processor.classes.Receipt;
import michaelmdonato.receipt_processor.classes.ReceiptItems;
import michaelmdonato.receipt_processor.classes.ReceiptReqBody;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Service
public class ReceiptService {
    private final String fileName = "receipts.csv";

    public Receipt processReceipts(ReceiptReqBody reqBody) throws IOException {
        String genId = UUID.randomUUID().toString();

        Receipt newReceipt = new Receipt(genId);
        newReceipt.setRetailer(reqBody.getRetailer());
        newReceipt.setPurchaseDate(reqBody.getPurchaseDate());
        newReceipt.setPurchaseTime(reqBody.getPurchaseTime());
        newReceipt.setTotal(reqBody.getTotal());
        newReceipt.setItems(reqBody.getItems());

        int points = pointsPerItem(reqBody) + pointsRetailerName(reqBody) + pointsTotal(reqBody) + pointsDate(reqBody);
        newReceipt.setPoints(String.valueOf(points));

        saveNewReceipt(newReceipt);

        return newReceipt;
    }

    public Points getPoints(String idFind) throws IOException {
        String id; String points; String date; String time; String total;

        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter(("[,\n]"));

            while (scanner.hasNext()) {
                id = scanner.next();
                points = scanner.next();
                date = scanner.next();
                time = scanner.next();
                total = scanner.next();

                if (id.equals(idFind)) {
                    Points p  = new Points();
                    p.setPoints(Integer.parseInt(points.trim()));
                    return p;
                }
            }


            scanner.close();
            // return "Receipt not found";
        } catch (IOException e) {
            throw  e;
        }
        return null;
    }


    public void saveNewReceipt(Receipt receipt) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName, true));

        out.printf("%s, %s, %s, %s, %s\n", receipt.getId(), receipt.getPoints(), receipt.getPurchaseDate(), receipt.getPurchaseTime(), receipt.getTotal());

        out.close();
    }

    //calculates two points for every item on the receipt (5 points every two items,
    public int pointsPerItem(ReceiptReqBody reqBody) {
        int points = 0, count = 0;
        List<ReceiptItems> items = reqBody.getItems();
        for (int i = 0; i < items.size(); i++) {
            count++;
            if (count % 2 == 0) {
                points += 5;
            }
            if (items.get(i).shortDescription.trim().length() % 3 == 0) {
                double price = Math.ceil(Float.parseFloat(items.get(i).price) * 0.2);
                points += (int) price;

            }
        }
        return points;
    }

    // calculates points based on retailer name
    public int pointsRetailerName(ReceiptReqBody reqBody) {
        int points = 0;
        String s  = reqBody.getRetailer();
        for (int i = 0; i < s.length(); i++) {
            char c  = s.charAt(i);
            if (isAplhaNum(c)) {
                points++;
            }
        }
        return points;
    }

    //calculates points based on total (No cents or multiple of 0.25)
    public int pointsTotal(ReceiptReqBody reqBody) {
        int points = 0;
        float total = Float.parseFloat(reqBody.getTotal());
        if (total % 1 == 0) {
            points = points + 50;
        }
        double divFour = total / 0.25;
        if (divFour % 1 == 0) {
            points = points + 25;
        }
        return points;
    }

    //calculates points based on date and time
    public int pointsDate(ReceiptReqBody reqBody) {
        int points = 0;
        String purDate = reqBody.getPurchaseDate();
        int dayNum = Integer.parseInt(purDate.substring(5,7));

        String purTime = reqBody.getPurchaseTime();
        int timeNum = Integer.parseInt(purTime.substring(0,2));

        if (dayNum % 2 != 0) {
            points += 6;
        }

        if (14 <= timeNum && timeNum <= 16) {
            points += 10;
        }
        return points;
    }

    public boolean isAplhaNum(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
}
