import java.io.File;
import java.util.Scanner;

class RepSum_NoHM {

    public static void main(String[] args) {

        File salesFile = new File("D:\\data\\sales_data.txt");
        Scanner reader = null;
        String line;

        String[] empCodes  = {"S101", "S102", "S103", "S104"};
        double[] empTotals = {0.0, 0.0, 0.0, 0.0};

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

                for (int i = 0; i < empCodes.length; i++) {
                    if (empCodes[i].equals(empCode)) {
                        empTotals[i] += total;
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("File Error: " + ex.getMessage());
        }

        System.out.println("*** Employee-wise Total Sales [No HashMap] ***");
        for (int i = 0; i < empCodes.length; i++) {
            System.out.println(empCodes[i] + " => " + empTotals[i]);
        }
    }
}
