package io;
import model.*;
import java.io.*;
import java.util.*;

public class AmortizationWriter {
public void write(List<Installment> list) throws Exception {
PrintWriter pw = new PrintWriter("amortization.csv");
pw.println("Month,EMI,Interest,Principal,Balance");
for (Installment i : list) {
pw.println(i.month + "," + i.emi + "," + i.interest + "," + i.principal + "," + i.balance);
}
pw.close();
}
}