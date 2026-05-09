import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ProductSum_HM {

    public static void main(String[] args) {

        File salesFile = new File("D:\\data\\sales_data.txt");
        Scanner reader = null;
        String line;
        HashMap<String, Double> salesMap = new HashMap<>();

        try {
            reader = new Scanner(salesFile);
            reader.nextLine(); // skip header

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] fields = line.split("\t");
                String itemName = fields[1];
                double unitPrice = Double.parseDouble(fields[2]);
                double quantity  = Double.parseDouble(fields[3]);
                double total     = unitPrice * quantity;

                if (salesMap.containsKey(itemName)) {
                    total += salesMap.get(itemName);
                }
                salesMap.put(itemName, total);
            }

        } catch (Exception ex) {
            System.out.println("File Error: " + ex.getMessage());
        }

        System.out.println("*** Item-wise Total Sales [HashMap] ***");
        for (Map.Entry<String, Double> entry : salesMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
