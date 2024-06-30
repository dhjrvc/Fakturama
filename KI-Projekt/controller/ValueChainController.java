package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Properties;
import model.ValueChain;

public class ValueChainController {
    private static final String COUNTERS_FILE = "counters.xml";
    private Properties counters;

    public ValueChainController() {
        loadCounters();
    }

    public void calculateMetrics() {
        File offerDir = new File("angebote");
        File[] offerFiles = offerDir.listFiles((dir, name) -> name.endsWith(".xml"));

        if (offerFiles == null) {
            System.out.println("Keine Angebote gefunden.");
            return;
        }

        int totalOffers = 0;
        int confirmedOffers = 0;
        int deliveredOffers = 0;
        int invoicedOffers = 0;

        for (File offerFile : offerFiles) {
            totalOffers++;
            int offerNumber = Integer.parseInt(offerFile.getName().replace(".xml", ""));
            File valueChainFile = new File("wskette/" + offerNumber + ".xml");
            if (valueChainFile.exists()) {
                ValueChain valueChain = ValueChain.load(offerNumber);
                if (valueChain != null) {
                    if (valueChain.getOrderConfirmationNumber() > 0) {
                        confirmedOffers++;
                    }
                    if (valueChain.getDeliveryNoteNumber() > 0) {
                        deliveredOffers++;
                    }
                    if (valueChain.getInvoiceNumber() > 0) {
                        invoicedOffers++;
                    }
                }
            }
        }

        System.out.println("Angebote insgesamt: " + totalOffers);
        System.out.println("Davon Angebote bestätigt: " + confirmedOffers);
        System.out.println("Davon geliefert: " + deliveredOffers);
        System.out.println("Davon berechnet: " + invoicedOffers);
    }

    private void loadCounters() {
        counters = new Properties();
        try {
            File file = new File(COUNTERS_FILE);
            if (file.exists()) {
                FileInputStream in = new FileInputStream(file);
                counters.loadFromXML(in);
                in.close();
            } else {
                counters.setProperty("orderConfirmationNumber", "0");
                counters.setProperty("deliveryNoteNumber", "0");
                counters.setProperty("invoiceNumber", "0");
                saveCounters();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveCounters() {
        try {
            FileOutputStream out = new FileOutputStream(COUNTERS_FILE);
            counters.storeToXML(out, null);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNextOrderConfirmationNumber() {
        int number = Integer.parseInt(counters.getProperty("orderConfirmationNumber")) + 1;
        counters.setProperty("orderConfirmationNumber", Integer.toString(number));
        saveCounters();
        return number;
    }

    public int getNextDeliveryNoteNumber() {
        int number = Integer.parseInt(counters.getProperty("deliveryNoteNumber")) + 1;
        counters.setProperty("deliveryNoteNumber", Integer.toString(number));
        saveCounters();
        return number;
    }

    public int getNextInvoiceNumber() {
        int number = Integer.parseInt(counters.getProperty("invoiceNumber")) + 1;
        counters.setProperty("invoiceNumber", Integer.toString(number));
        saveCounters();
        return number;
    }

}