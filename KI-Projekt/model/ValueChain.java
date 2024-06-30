package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;

public class ValueChain {
    private int offerNumber;
    private int orderConfirmationNumber;
    private LocalDate orderConfirmationDate;
    private int deliveryNoteNumber;
    private LocalDate deliveryDate;
    private int invoiceNumber;
    private LocalDate invoiceDate;

    public ValueChain(int offerNumber) {
        this.offerNumber = offerNumber;
    }

    public int getOrderConfirmationNumber() {
        return orderConfirmationNumber;
    }

    public LocalDate getOrderConfirmationDate() {
        return orderConfirmationDate;
    }

    public int getDeliveryNoteNumber() {
        return deliveryNoteNumber;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    // Getters and Setters
    public int getOfferNumber() {
        return offerNumber;
    }

    public void setOrderConfirmationNumber(int orderConfirmationNumber) {
        this.orderConfirmationNumber = orderConfirmationNumber;
    }

    public void setOrderConfirmationDate(LocalDate orderConfirmationDate) {
        this.orderConfirmationDate = orderConfirmationDate;
    }

    public void setDeliveryNoteNumber(int deliveryNoteNumber) {
        this.deliveryNoteNumber = deliveryNoteNumber;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    // Save to XML
    public void save() {
        try {
            // Create directory if it doesn't exist
            File directory = new File("wskette");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("valueChain");
            doc.appendChild(rootElement);

            addElement(doc, rootElement, "offerNumber", Integer.toString(offerNumber));
            addElement(doc, rootElement, "orderConfirmationNumber", Integer.toString(orderConfirmationNumber));
            addElement(doc, rootElement, "orderConfirmationDate", orderConfirmationDate == null ? "" : orderConfirmationDate.toString());
            addElement(doc, rootElement, "deliveryNoteNumber", Integer.toString(deliveryNoteNumber));
            addElement(doc, rootElement, "deliveryDate", deliveryDate == null ? "" : deliveryDate.toString());
            addElement(doc, rootElement, "invoiceNumber", Integer.toString(invoiceNumber));
            addElement(doc, rootElement, "invoiceDate", invoiceDate == null ? "" : invoiceDate.toString());

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

    private void addElement(Document doc, Element rootElement, String tagName, String value) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(value));
        rootElement.appendChild(element);
    }

    public static ValueChain load(int offerNumber) {
        try {
            File file = new File("wskette/" + offerNumber + ".xml");
            if (!file.exists()) {
                return null;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            Element rootElement = (Element) doc.getDocumentElement();

            ValueChain valueChain = new ValueChain(offerNumber);
            valueChain.setOrderConfirmationNumber(
                    Integer.parseInt(rootElement.getElementsByTagName("orderConfirmationNumber").item(0).getTextContent())
            );
            String orderConfirmationDateText = rootElement.getElementsByTagName("orderConfirmationDate").item(0).getTextContent();
            valueChain.setOrderConfirmationDate(
                    orderConfirmationDateText.isEmpty() ? null : LocalDate.parse(orderConfirmationDateText)
            );
            valueChain.setDeliveryNoteNumber(
                    Integer.parseInt(rootElement.getElementsByTagName("deliveryNoteNumber").item(0).getTextContent())
            );
            String deliveryDateText = rootElement.getElementsByTagName("deliveryDate").item(0).getTextContent();
            valueChain.setDeliveryDate(
                    deliveryDateText.isEmpty() ? null : LocalDate.parse(deliveryDateText)
            );
            valueChain.setInvoiceNumber(
                    Integer.parseInt(rootElement.getElementsByTagName("invoiceNumber").item(0).getTextContent())
            );
            String invoiceDateText = rootElement.getElementsByTagName("invoiceDate").item(0).getTextContent();
            valueChain.setInvoiceDate(
                    invoiceDateText.isEmpty() ? null : LocalDate.parse(invoiceDateText)
            );

            return valueChain;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}