import java.io.File;
import java.util.Scanner;

class ProductSum_NoHM {

    public static void main(String[] args) {

        File salesFile = new File("D:\\data\\sales_data.txt");
        Scanner reader = null;
        String line;

        String[] itemList  = {"Laptop", "Monitor", "Keyboard", "Mouse"};
        double[] itemTotals = {0.0, 0.0, 0.0, 0.0};

        try {
            reader = new Scanner(salesFile);
            reader.nextLine(); // skip header

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] fields = line.split("\t");
                String itemName  = fields[1];
                double unitPrice = Double.parseDouble(fields[2]);
                double quantity  = Double.parseDouble(fields[3]);
                double total     = unitPrice * quantity;

                for (int i = 0; i < itemList.length; i++) {
                    if (itemList[i].equals(itemName)) {
                        itemTotals[i] += total;
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("File Error: " + ex.getMessage());
        }

        System.out.println("*** Item-wise Total Sales [No HashMap] ***");
        for (int i = 0; i < itemList.length; i++) {
            System.out.println(itemList[i] + " => " + itemTotals[i]);
        }
    }
}
