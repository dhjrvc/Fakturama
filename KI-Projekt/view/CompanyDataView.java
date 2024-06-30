package view;

import java.text.DecimalFormat;
import java.util.Scanner;

import model.*;

public class CompanyDataView {
    private Scanner scanner = new Scanner(System.in);

    public void displayOfferMenu() {
        System.out.println("1. Neues Angebot erstellen");
        System.out.println("2. Angebot anzeigen");
        System.out.println("3. Zurück zum Hauptmenü");
    }

    public Offer inputOfferData() {
        System.out.print("Kundennummer: ");
        int customerNumber = scanner.nextInt();
        System.out.print("Artikelnummer: ");
        int articleNumber = scanner.nextInt();
        System.out.print("Menge: ");
        int quantity = scanner.nextInt();
        return new Offer(customerNumber, articleNumber, quantity);
    }

    public int getOfferNumber() {
        System.out.print("Angebotsnummer: ");
        return scanner.nextInt();
    }

    public void displayOffer(Offer offer, double totalPrice) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        if (offer == null) {
            System.out.println("Angebot nicht gefunden.");
        } else {
            System.out.println("Angebotsnummer: " + offer.getOfferNumber());
            System.out.println("Kundennummer: " + offer.getCustomerNumber());
            System.out.println("Artikelnummer: " + offer.getArticleNumber());
            System.out.println("Menge: " + offer.getQuantity());
            System.out.println("Gesamtpreis: " + decimalFormat.format(totalPrice) + " €");
        }
    }


    public void displayArticleMenu() {
        System.out.println("1. Artikel ansehen");
        System.out.println("2. Artikel hinzufügen");
        System.out.println("3. Zurück zum Hauptmenü");
    }

    public void displayCustomerMenu() {
        System.out.println("1. Kunden ansehen");
        System.out.println("2. Kunden hinzufügen");
        System.out.println("3. Zurück zum Hauptmenü");
    }

    public Article inputArticleData() {
        scanner.nextLine(); // consume newline

        System.out.print("Einheit: ");
        String unit = scanner.nextLine();

        System.out.print("Bezeichnung: ");
        String description = scanner.nextLine();

        System.out.print("Nettopreis: ");
        double netPrice = scanner.nextDouble();

        System.out.print("Mehrwertsteuersatz: ");
        double taxRate = scanner.nextDouble();

        return new Article(unit, description, netPrice, taxRate);
    }

    public Customer inputCustomerData() {
        scanner.nextLine(); // consume newline

        System.out.print("Anschrift: ");
        String address = scanner.nextLine();

        System.out.print("Ansprechpartner: ");
        String contactPerson = scanner.nextLine();

        System.out.print("Unter § 4 Umsatzsteuergesetz fallend (true/false): ");
        boolean taxExempt = scanner.nextBoolean();

        return new Customer(address, contactPerson, taxExempt);
    }

    public void displayMenu() {
        System.out.println("1. Unternehmensstammdaten ansehen");
        System.out.println("2. Unternehmensstammdaten ändern");
        System.out.println("3. Artikelverwaltung");
        System.out.println("4. Kundenverwaltung");
        System.out.println("5. Angebotsverwaltung");
        System.out.println("6. Bestellstati verwalten");
        System.out.println("7. Programm beenden");
    }

    public int getMenuChoice() {
        System.out.print("Ihre Wahl: ");
        return scanner.nextInt();
    }


    public void displayCompanyData(CompanyData companyData) {
        System.out.println("Firmenname: " + companyData.getCompanyName());
        System.out.println("Inhaber: " + companyData.getOwner());
        System.out.println("Straße: " + companyData.getStreet());
        System.out.println("PLZ: " + companyData.getPostalCode());
        System.out.println("Stadt: " + companyData.getCity());
        System.out.println("Land: " + companyData.getCountry());
        System.out.println("Telefon: " + companyData.getPhone());
        System.out.println("Mobilnummer: " + companyData.getMobile());
        System.out.println("Telefax: " + companyData.getFax());
        System.out.println("Email: " + companyData.getEmail());
        System.out.println("Webseite: " + companyData.getWebsite());
        System.out.println("USt-IdNr: " + companyData.getVatId());
        System.out.println("Steuernummer: " + companyData.getTaxNumber());
        System.out.println("Finanzamt: " + companyData.getTaxOffice());
        System.out.println("Bankname: " + companyData.getBankName());
        System.out.println("IBAN: " + companyData.getIban());
        System.out.println("BIC: " + companyData.getBic());
        System.out.println("Gläubiger-ID: " + companyData.getCreditorId());
    }

    public void outputArticleData(Article article) {

        if (article == null) {
            System.out.println("Diesen Artikel gibt es nicht.");
            return;
        }

        System.out.println("Artikelnr.: " + article.getNumber());
        System.out.println("Einheit: " + article.getUnit());
        System.out.println("Beschreibung:" + article.getDescription());
        System.out.println("Nettopreis: " + article.getNetPrice());
        System.out.println("Steuersatz: " + article.getTaxRate());
    }

    public void outputCustomerData(Customer customer) {
        if (customer == null) {
            System.out.println("Diesen Kunden gibt es nicht");
            return;
        }

        System.out.println("Kundennummer: " + customer.getNumber());
        System.out.println("Adresse: " + customer.getAddress());
        System.out.println("Kontaktperson: " + customer.getContactPerson());
        System.out.println("Steuerbefreiung: " + customer.isTaxExempt());
    }

    public CompanyData inputCompanyData() {
        CompanyData companyData = new CompanyData();
        System.out.println();

        scanner = new Scanner(System.in);

        System.out.print("Firmenname: ");
        companyData.setCompanyName(scanner.nextLine());

        System.out.print("Inhaber: ");
        companyData.setOwner(scanner.nextLine());

        System.out.print("Straße: ");
        companyData.setStreet(scanner.nextLine());

        System.out.print("PLZ: ");
        companyData.setPostalCode(scanner.nextLine());

        System.out.print("Stadt: ");
        companyData.setCity(scanner.nextLine());

        System.out.print("Land: ");
        companyData.setCountry(scanner.nextLine());

        System.out.print("Telefon: ");
        companyData.setPhone(scanner.nextLine());

        System.out.print("Mobilnummer: ");
        companyData.setMobile(scanner.nextLine());

        System.out.print("Telefax: ");
        companyData.setFax(scanner.nextLine());

        System.out.print("Email: ");
        companyData.setEmail(scanner.nextLine());

        System.out.print("Webseite: ");
        companyData.setWebsite(scanner.nextLine());

        System.out.print("USt-IdNr: ");
        companyData.setVatId(scanner.nextLine());

        System.out.print("Steuernummer: ");
        companyData.setTaxNumber(scanner.nextLine());

        System.out.print("Finanzamt: ");
        companyData.setTaxOffice(scanner.nextLine());

        System.out.print("Bankname: ");
        companyData.setBankName(scanner.nextLine());

        System.out.print("IBAN: ");
        companyData.setIban(scanner.nextLine());

        System.out.print("BIC: ");
        companyData.setBic(scanner.nextLine());

        System.out.print("Gläubiger-ID: ");
        companyData.setCreditorId(scanner.nextLine());

        System.out.println("Die Daten werden gespeichert, vielen Dank.");

        return companyData;
    }

    public void displayValueChainMenu() {
       System.out.println("1. Statistiken anzeigen");
       System.out.println("2. Auftragsbestätigung versenden");
       System.out.println("3. Lieferschein erstellen");
        System.out.println("4. Rechnung erstellen");
        System.out.println("5. Zurück zum Hauptmenü");
    }

    public void displayValueChain(ValueChain valueChain) {
        System.out.println("Angebotsnummer: " + valueChain.getOfferNumber());
        System.out.println("Auftragsbestätigungsnummer: " + valueChain.getOrderConfirmationNumber());
        System.out.println("Datum der Auftragsbestätigung: " + valueChain.getOrderConfirmationDate());
        System.out.println("Lieferscheinnummer: " + valueChain.getDeliveryNoteNumber());
        System.out.println("Datum der Lieferung: " + valueChain.getDeliveryDate());
        System.out.println("Rechnungsnummer: " + valueChain.getInvoiceNumber());
        System.out.println("Datum der Rechnung: " + valueChain.getInvoiceDate());
    }
}



