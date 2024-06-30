package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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

public class CompanyData {

    private boolean smallBusiness;
    private String companyName;
    private String owner;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private String phone;
    private String mobile;
    private String fax;
    private String email;
    private String website;
    private String vatId;
    private String taxNumber;
    private String taxOffice;
    private String bankName;
    private String iban;
    private String bic;
    private String creditorId;

    private static final String FILE_PATH = "companyData.xml";

    // Getters and Setters for all fields

    public boolean isSmallBusiness() {
        return smallBusiness;
    }

    public void setSmallBusiness(boolean smallBusiness) {
        this.smallBusiness = smallBusiness;
    }

    public static CompanyData load() {
        CompanyData companyData = new CompanyData();
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();

                companyData.setCompanyName(doc.getElementsByTagName("companyName").item(0).getTextContent());
                companyData.setOwner(doc.getElementsByTagName("owner").item(0).getTextContent());
                companyData.setStreet(doc.getElementsByTagName("street").item(0).getTextContent());
                companyData.setPostalCode(doc.getElementsByTagName("postalCode").item(0).getTextContent());
                companyData.setCity(doc.getElementsByTagName("city").item(0).getTextContent());
                companyData.setCountry(doc.getElementsByTagName("country").item(0).getTextContent());
                companyData.setPhone(doc.getElementsByTagName("phone").item(0).getTextContent());
                companyData.setMobile(doc.getElementsByTagName("mobile").item(0).getTextContent());
                companyData.setFax(doc.getElementsByTagName("fax").item(0).getTextContent());
                companyData.setEmail(doc.getElementsByTagName("email").item(0).getTextContent());
                companyData.setWebsite(doc.getElementsByTagName("website").item(0).getTextContent());
                companyData.setVatId(doc.getElementsByTagName("vatId").item(0).getTextContent());
                companyData.setTaxNumber(doc.getElementsByTagName("taxNumber").item(0).getTextContent());
                companyData.setTaxOffice(doc.getElementsByTagName("taxOffice").item(0).getTextContent());
                companyData.setBankName(doc.getElementsByTagName("bankName").item(0).getTextContent());
                companyData.setIban(doc.getElementsByTagName("iban").item(0).getTextContent());
                companyData.setBic(doc.getElementsByTagName("bic").item(0).getTextContent());
                companyData.setCreditorId(doc.getElementsByTagName("creditorId").item(0).getTextContent());

                Node smallBusinessNode = doc.getElementsByTagName("smallBusiness").item(0);
                if (smallBusinessNode != null) {
                    companyData.setSmallBusiness(Boolean.parseBoolean(smallBusinessNode.getTextContent()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return companyData;
    }

    public void save() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("companyData");
            doc.appendChild(rootElement);

            addElement(doc, rootElement, "companyName", companyName);
            addElement(doc, rootElement, "owner", owner);
            addElement(doc, rootElement, "street", street);
            addElement(doc, rootElement, "postalCode", postalCode);
            addElement(doc, rootElement, "city", city);
            addElement(doc, rootElement, "country", country);
            addElement(doc, rootElement, "phone", phone);
            addElement(doc, rootElement, "mobile", mobile);
            addElement(doc, rootElement, "fax", fax);
            addElement(doc, rootElement, "email", email);
            addElement(doc, rootElement, "website", website);
            addElement(doc, rootElement, "vatId", vatId);
            addElement(doc, rootElement, "taxNumber", taxNumber);
            addElement(doc, rootElement, "taxOffice", taxOffice);
            addElement(doc, rootElement, "bankName", bankName);
            addElement(doc, rootElement, "iban", iban);
            addElement(doc, rootElement, "bic", bic);
            addElement(doc, rootElement, "creditorId", creditorId);
            addElement(doc, rootElement, "smallBusiness", Boolean.toString(smallBusiness));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_PATH));

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

    // Getters and Setters

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVatId() {
        return vatId;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(String creditorId) {
        this.creditorId = creditorId;
    }
}
