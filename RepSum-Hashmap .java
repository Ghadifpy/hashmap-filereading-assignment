import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class RepSum_HM {

    public static void main(String[] args) {

        File salesFile = new File("D:\\data\\sales_data.txt");
        Scanner reader = null;
        String line;
        HashMap<String, Double> repMap = new HashMap<>();

        try {
            reader = new Scanner(salesFile);
            reader.nextLine(); // skip header

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] fields  = line.split("\t");
                String empCode   = fields[5];
                double unitPrice = Double.parseDouble(fields[2]);
                double quantity  = Double.parseDouble(fields[3]);
                double total     = unitPrice * quantity;

                if (repMap.containsKey(empCode)) {
                    total += repMap.get(empCode);
                }
                repMap.put(empCode, total);
            }

        } catch (Exception ex) {
            System.out.println("File Error: " + ex.getMessage());
        }

        System.out.println("*** Employee-wise Total Sales [HashMap] ***");
        for (Map.Entry<String, Double> entry : repMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
