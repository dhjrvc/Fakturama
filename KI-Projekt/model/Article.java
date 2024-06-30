package model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Article {
    private static int articleCounter = 0;

    private int number;
    private String unit;
    private String description;
    private double netPrice;
    private double taxRate;

    public Article(String unit, String description,  double netPrice, double taxRate) {
        this.number = ++articleCounter;
        this.unit = unit;
        this.description = description;
        this.netPrice = netPrice;
        this.taxRate = taxRate;
    }

    public Article(int number, String unit, String description, double netPrice, double taxRate) {
        this.number = number;
        this.unit = unit;
        this.description = description;
        this.netPrice = netPrice;
        this.taxRate = taxRate;
    }

    public int getNumber() {
        return number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public void save() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("article");
            doc.appendChild(rootElement);

            addElement(doc, rootElement, "number", Integer.toString(number));
            addElement(doc, rootElement, "unit", unit);
            addElement(doc, rootElement, "description", description);
            addElement(doc, rootElement, "netPrice", Double.toString(netPrice));
            addElement(doc, rootElement, "taxRate", Double.toString(taxRate));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("artikel/" + number + ".xml"));

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Article load(int articleNumber) {
        Article article = null;
        try {
            File file = new File("artikel/" + articleNumber + ".xml");
            if (!file.exists()) {
                System.out.println("Artikel mit der Nummer " + articleNumber + " nicht gefunden.");
                return null;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            Element rootElement = (Element) doc.getElementsByTagName("article").item(0);

            int number = Integer.parseInt(rootElement.getElementsByTagName("number").item(0).getTextContent());
            String unit = rootElement.getElementsByTagName("unit").item(0).getTextContent();
            String description = rootElement.getElementsByTagName("description").item(0).getTextContent();
            double netPrice = Double.parseDouble(rootElement.getElementsByTagName("netPrice").item(0).getTextContent());
            double taxRate = Double.parseDouble(rootElement.getElementsByTagName("taxRate").item(0).getTextContent());

            article = new Article(number, unit, description, netPrice, taxRate);
            article.number = number;  // Override the auto-generated number
        } catch (Exception e) {
            e.printStackTrace();
        }
        return article;
    }

    private void addElement(Document doc, Element rootElement, String tagName, String value) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(value));
        rootElement.appendChild(element);
    }
}

