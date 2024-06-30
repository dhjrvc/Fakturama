package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FilenameFilter;

public class Offer {
    private static int offerCounter = 0;
    private int offerNumber;
    private int customerNumber;
    private int articleNumber;
    private int quantity;

    public Offer(int customerNumber, int articleNumber, int quantity) {
        this.customerNumber = customerNumber;
        this.articleNumber = articleNumber;
        this.quantity = quantity;
    }

    // Getters
    public int getOfferNumber() {
        return offerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    // Save the offer to XML
    public void save() {
        try {
            // Check if the directory exists, if not, create it
            File directory = new File("angebote");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Determine the next offer number
            if (offerCounter == 0) {
                offerCounter = getNextOfferNumber(directory);
            }
            this.offerNumber = ++offerCounter;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("offer");
            doc.appendChild(rootElement);

            addElement(doc, rootElement, "offerNumber", Integer.toString(offerNumber));
            addElement(doc, rootElement, "customerNumber", Integer.toString(customerNumber));
            addElement(doc, rootElement, "articleNumber", Integer.toString(articleNumber));
            addElement(doc, rootElement, "quantity", Integer.toString(quantity));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(directory, offerNumber + ".xml"));

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load the offer from XML
    public static Offer load(int offerNumber) {
        try {
            File file = new File("angebote/" + offerNumber + ".xml");
            if (!file.exists()) {
                return null;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("offer");
            Node node = nList.item(0);
            Element element = (Element) node;

            int customerNumber = Integer.parseInt(element.getElementsByTagName("customerNumber").item(0).getTextContent());
            int articleNumber = Integer.parseInt(element.getElementsByTagName("articleNumber").item(0).getTextContent());
            int quantity = Integer.parseInt(element.getElementsByTagName("quantity").item(0).getTextContent());

            Offer offer = new Offer(customerNumber, articleNumber, quantity);
            offer.offerNumber = offerNumber;  // Set the loaded offer number
            return offer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to calculate total price of the offer
    public double calculateTotalPrice(CompanyData companyData, Customer customer, Article article) {
        double netPrice = article.getNetPrice() * quantity;
        double taxRate = article.getTaxRate();

        if (companyData.isSmallBusiness() || customer.isTaxExempt()) {
            return netPrice;
        } else {
            return netPrice * (1 + taxRate / 100);
        }
    }

    private void addElement(Document doc, Element rootElement, String tagName, String value) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(value));
        rootElement.appendChild(element);
    }

    private int getNextOfferNumber(File directory) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".xml");
            }
        });

        int maxNumber = 0;
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                try {
                    int number = Integer.parseInt(fileName.substring(0, fileName.indexOf('.')));
                    if (number > maxNumber) {
                        maxNumber = number;
                    }
                } catch (NumberFormatException e) {
                    // Ignore files that don't have a number as their name
                }
            }
        }
        return maxNumber;
    }
}
