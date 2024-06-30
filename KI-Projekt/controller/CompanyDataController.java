package controller;

import model.*;
import view.CompanyDataView;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import java.io.File;

public class CompanyDataController {
    private CompanyData model;
    //private CompanyDataView view;
    private CompanyDataView view;

    private ValueChainController valueChainController;

    public ValueChainController getValueChainController() {
        return valueChainController;
    }

    public CompanyData getModel() {

        return model;
    }

    public CompanyDataController(CompanyData model) {

        this.model = model;
        this.view = new CompanyDataView();
        this.valueChainController = new ValueChainController();

    }

    public void saveCompanyData(CompanyData companyData) {

        model = companyData;
        model.save();
        System.out.println("Unternehmensdaten gespeichert.");
    }

    public void loadCompanyData() {

        model = CompanyData.load();
        if (model == null) {
            System.out.println("Keine Unternehmensdaten gefunden. Bitte eingeben.");
        } else {
            System.out.println("Unternehmensdaten geladen.");
        }
    }

    public void run() {

        if (model.getCompanyName() == null || model.getCompanyName().isEmpty()) {
            System.out.println("Unternehmensstammdaten nicht gefunden. Bitte eingeben:");
            model = view.inputCompanyData();
            model.save();
        }
        boolean running = true;

        while (running) {
            view.displayMenu();
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    view.displayCompanyData(model);
                    break;
                case 2:
                    model = view.inputCompanyData();
                    model.save();
                    break;
                case 3:
                    manageArticles();
                    break;
                case 4:
                    manageCustomers();
                    break;
                case 5:
                    manageOffers();
                    break;
                case 6:
                    manageValueChains();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Wahl. Bitte erneut versuchen.");
            }
        }

    }

    Scanner scanner = new Scanner(System.in);

    private void manageOffers() {

        boolean running = true;
        while (running) {
            view.displayOfferMenu();
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    Offer newOffer = view.inputOfferData();
                    newOffer.save();
                    break;
                case 2:
                    int offerNumber = view.getOfferNumber();
                    Offer offer = Offer.load(offerNumber);
                    if (offer != null) {
                        Customer customer = Customer.load(offer.getCustomerNumber());
                        Article article = Article.load(offer.getArticleNumber());
                        double totalPrice = offer.calculateTotalPrice(model, customer, article);
                        view.displayOffer(offer, totalPrice);
                    } else {
                        System.out.println("Angebot nicht gefunden.");
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Wahl. Bitte erneut versuchen.");
            }
        }
    }


    private void manageArticles() {

        boolean running = true;
        Scanner sc = new Scanner(System.in);
        while (running) {
            view.displayArticleMenu();
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    System.out.print("Artikelnummer eingeben: ");
                    int articleNumber = scanner.nextInt();
                    Article article0 = Article.load(articleNumber);

                    view.outputArticleData(article0);

                    // Anzeige von Artikeln implementieren
                    break;
                case 2:
                    Article article = view.inputArticleData();
                    article.save();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Wahl. Bitte erneut versuchen.");
            }
        }
    }

    private void manageCustomers() {

        boolean running = true;
        while (running) {
            view.displayCustomerMenu();
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    int customerNumer = scanner.nextInt();
                    Customer customer0 = Customer.load(customerNumer);// Anzeige von Kunden implementieren
                    break;
                case 2:
                    Customer customer = view.inputCustomerData();
                    customer.save();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Wahl. Bitte erneut versuchen.");
            }
        }
    }

    private void manageValueChains() {

        boolean running = true;
        ValueChainController valueChainController = new ValueChainController();
        while (running) {
            view.displayValueChainMenu();
            int choice = view.getMenuChoice();

            switch (choice) {
                case 1 -> {
                    // Statistik anzeigen
                    valueChainController.calculateMetrics();
                    break;
                }

                case 2 -> {
                    // AB anlegen
                    int offerNumber = view.getOfferNumber();
                    ValueChain valueChain = ValueChain.load(offerNumber);
                    if (valueChain == null) valueChain = new ValueChain(offerNumber);
                    valueChain.setOrderConfirmationNumber(valueChainController.getNextOrderConfirmationNumber());
                    valueChain.setOrderConfirmationDate(LocalDate.now());
                    valueChain.save();
                    System.out.println("Die Auftragsbestätigung wurde vermerkt.");
                    break;
                }

                case 3 -> {
                    // AB anlegen
                    int offerNumber = view.getOfferNumber();
                    ValueChain valueChain = ValueChain.load(offerNumber);
                    if (valueChain == null) valueChain = new ValueChain(offerNumber);
                    valueChain.setDeliveryNoteNumber(valueChainController.getNextDeliveryNoteNumber());
                    valueChain.setDeliveryDate(LocalDate.now());
                    valueChain.save();
                    System.out.println("Die Lieferung wurde vermerkt.");
                    break;
                }

                case 4 -> {
                    // AB anlegen
                    int offerNumber = view.getOfferNumber();
                    ValueChain valueChain = ValueChain.load(offerNumber);
                    if (valueChain == null) valueChain = new ValueChain(offerNumber);
                    valueChain.setInvoiceNumber(valueChainController.getNextInvoiceNumber());
                    valueChain.setInvoiceDate(LocalDate.now());
                    valueChain.save();
                    System.out.println("Die Rechnung wurde vermerkt.");
                    break;
                }

                case 5 -> {
                    int offerNumber = view.getOfferNumber();

                    ValueChain valueChain = ValueChain.load(offerNumber);
                    Offer offer = Offer.load(offerNumber);

                    System.out.println(offerNumber + " offer number");

                }

                case 6 -> {
                    running = false;
                    break;
                }

                default -> {
                    System.out.println("Ungültige Wahl. Bitte erneut versuchen.");
                }

            }
        }
    }


    public static void main(String[] args) {
        mkdirs();
        CompanyData model = CompanyData.load();
        CompanyDataView view = new CompanyDataView();
        CompanyDataController controller = new CompanyDataController(model);
        controller.run();
    }

    private static void mkdirs() {
        new File("kunde").mkdir();
        new File("artikel").mkdir();
    }
}
