package com.pluralsight.order;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {

    private Order order;

    public OrderFileManager(Order order) {
        this.order = order;
    }

    public void saveToTXTFile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = format.format(LocalDateTime.now()) + ".txt";
        String dirPath = "Receipts";
        String filePath = dirPath + "/" + fileName;

        // Create the directory if it doesn't exist
        Path dirPathObj = Paths.get(dirPath);
        boolean dirExists = Files.exists(dirPathObj);
        if (!dirExists) {
            try {
                Files.createDirectories(dirPathObj);
                System.out.println("Directory created successfully!");
            } catch (IOException e) {
                System.out.println("Failed to create directory!" + e.getMessage());
            }
        }

        try {
            FileWriter writer = getFileWriter(filePath);
            writer.close();
            System.out.println("Saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error creating receipt: " + fileName);
        }
    }

    private FileWriter getFileWriter(String filePath) throws IOException {
        String orderDetails = order.getStringDetails();
        double priceDetails = order.getPrice();
        FileWriter writer = new FileWriter(filePath);
        writer.write("-------------------------------------------------------------------------------------------\n");
        writer.write(String.format("%50s\n", "Deli Dose Sandwiches"));
        writer.write(String.format("%60s\n", "85 Broad Street, New York, NY 10004"));
        writer.write("-------------------------------------------------------------------------------------------\n");
        writer.write(String.format("%42s\n", "RECEIPT:"));
        writer.write(orderDetails);
        writer.write(String.format("This is the total price: $%.2f\n", priceDetails));
        writer.write("-------------------------------------------------------------------------------------------\n");
        return writer;
    }
}
