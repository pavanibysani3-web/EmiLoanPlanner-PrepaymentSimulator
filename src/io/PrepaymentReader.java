package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Prepayment;

public class PrepaymentReader {

    public static List<Prepayment> readPrepayments() throws Exception {

        List<Prepayment> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("prepayments.csv"));
        String line;

        while ((line = br.readLine()) != null) {

            line = line.trim();

            // ✅ Skip empty lines
            if (line.isEmpty()) continue;

            // ✅ Skip header
            if (line.toLowerCase().startsWith("month")) continue;

            String[] p = line.split(",");

            // ✅ Validate row length
            if (p.length < 2) continue;

            int month = Integer.parseInt(p[0].trim());
            double amount = Double.parseDouble(p[1].trim());

            list.add(new Prepayment(month, amount));
        }

        br.close();
        return list;
    }
}