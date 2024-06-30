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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Customer {
    private static int customerCounter = 0;

    private int number;
    private String address;
    private String contactPerson;
    private boolean taxExempt;

    public Customer(String address, String contactPerson, boolean taxExempt) {
        this.number = ++customerCounter;
        this.address = address;
        this.contactPerson = contactPerson;
        this.taxExempt = taxExempt;
    }

    public Customer(int number, String address, String contactPerson, boolean taxExempt) {
        this.number = number;
        this.address = address;
        this.contactPerson = contactPerson;
        this.taxExempt = taxExempt;
    }

    public int getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public boolean isTaxExempt() {
        return taxExempt;
    }

    public void setTaxExempt(boolean taxExempt) {
        this.taxExempt = taxExempt;
    }

    public void save() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("customer");
            doc.appendChild(rootElement);

            addElement(doc, rootElement, "number", Integer.toString(number));
            addElement(doc, rootElement, "address", address);
            addElement(doc, rootElement, "contactPerson", contactPerson);
            addElement(doc, rootElement, "taxExempt", Boolean.toString(taxExempt));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("kunde/" + number + ".xml"));

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Customer load(int number) {
        try {
            File file = new File("kunde/" + number + ".xml");
            if (!file.exists()) {
                return null;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("customer");
            Node node = nList.item(0);
            Element element = (Element) node;

            String address = element.getElementsByTagName("address").item(0).getTextContent();
            String contactPerson = element.getElementsByTagName("contactPerson").item(0).getTextContent();
            boolean taxExempt = Boolean.parseBoolean(element.getElementsByTagName("taxExempt").item(0).getTextContent());

            return new Customer(number, address, contactPerson, taxExempt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void addElement(Document doc, Element rootElement, String tagName, String value) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(value));
        rootElement.appendChild(element);
    }
}

