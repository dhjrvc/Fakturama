package view;

import controller.CompanyDataController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CompanyDataMainGUI extends JFrame {

    private JPanel mainMenuPanel;

    private CompanyDataController controller;

    public CompanyDataMainGUI(boolean isFirstTime, CompanyDataController companyDataController) {
        super("Company Data Management");

        this.controller = companyDataController;

        if (isFirstTime) {
            showCompanyDataEntryForm();
        } else {
            initializeComponents();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showCompanyDataEntryForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JTextField txtCompanyName = new JTextField(20);
        JTextField txtOwner = new JTextField(20);
        JTextField txtStreet = new JTextField(20);
        JTextField txtPostalCode = new JTextField(20);
        JTextField txtCity = new JTextField(20);
        JTextField txtCountry = new JTextField(20);
        JTextField txtPhone = new JTextField(20);
        JTextField txtMobile = new JTextField(20);
        JTextField txtFax = new JTextField(20);
        JTextField txtEmail = new JTextField(20);
        JTextField txtWebsite = new JTextField(20);
        JTextField txtVatId = new JTextField(20);
        JTextField txtTaxNumber = new JTextField(20);
        JTextField txtTaxOffice = new JTextField(20);
        JTextField txtBankName = new JTextField(20);
        JTextField txtIban = new JTextField(20);
        JTextField txtBic = new JTextField(20);
        JTextField txtCreditorId = new JTextField(20);
        JCheckBox chkSmallBusiness = new JCheckBox("Kleinunternehmen");

        panel.add(new JLabel("Unternehmensname:"), gbc);
        gbc.gridx++;
        panel.add(txtCompanyName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Inhaber:"), gbc);
        gbc.gridx++;
        panel.add(txtOwner, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Straße:"), gbc);
        gbc.gridx++;
        panel.add(txtStreet, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Postleitzahl:"), gbc);
        gbc.gridx++;
        panel.add(txtPostalCode, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Stadt:"), gbc);
        gbc.gridx++;
        panel.add(txtCity, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Land:"), gbc);
        gbc.gridx++;
        panel.add(txtCountry, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Telefon:"), gbc);
        gbc.gridx++;
        panel.add(txtPhone, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Mobiltelefon:"), gbc);
        gbc.gridx++;
        panel.add(txtMobile, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Fax:"), gbc);
        gbc.gridx++;
        panel.add(txtFax, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("E-Mail:"), gbc);
        gbc.gridx++;
        panel.add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Website:"), gbc);
        gbc.gridx++;
        panel.add(txtWebsite, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("USt-IdNr.:"), gbc);
        gbc.gridx++;
        panel.add(txtVatId, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Steuernummer:"), gbc);
        gbc.gridx++;
        panel.add(txtTaxNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Finanzamt:"), gbc);
        gbc.gridx++;
        panel.add(txtTaxOffice, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Bankname:"), gbc);
        gbc.gridx++;
        panel.add(txtBankName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("IBAN:"), gbc);
        gbc.gridx++;
        panel.add(txtIban, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("BIC:"), gbc);
        gbc.gridx++;
        panel.add(txtBic, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Gläubiger-ID:"), gbc);
        gbc.gridx++;
        panel.add(txtCreditorId, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(chkSmallBusiness, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnSave = new JButton("Speichern");
        panel.add(btnSave, gbc);

        setContentPane(panel);
        revalidate();
        repaint();

        btnSave.addActionListener(e -> {
            CompanyData companyData = this.controller.getModel();

            companyData.setCompanyName(txtCompanyName.getText());
            companyData.setOwner(txtOwner.getText());
            companyData.setStreet(txtStreet.getText());
            companyData.setPostalCode(txtPostalCode.getText());
            companyData.setCity(txtCity.getText());
            companyData.setCountry(txtCountry.getText());
            companyData.setPhone(txtPhone.getText());
            companyData.setMobile(txtMobile.getText());
            companyData.setFax(txtFax.getText());
            companyData.setEmail(txtEmail.getText());
            companyData.setWebsite(txtWebsite.getText());
            companyData.setVatId(txtVatId.getText());
            companyData.setTaxNumber(txtTaxNumber.getText());
            companyData.setTaxOffice(txtTaxOffice.getText());
            companyData.setBankName(txtBankName.getText());
            companyData.setIban(txtIban.getText());
            companyData.setBic(txtBic.getText());
            companyData.setCreditorId(txtCreditorId.getText());
            companyData.setSmallBusiness(chkSmallBusiness.isSelected());

            companyData.save();

            initializeComponents();
        });
    }

    /*private void initializeComponents() {
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridBagLayout());
        mainMenuPanel.setBackground(new Color(60, 63, 65));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JButton btnCompanyData = createMenuButton("Unternehmensstammdaten verwalten");
        JButton btnArticles = createMenuButton("Artikel verwalten");
        JButton btnCustomers = createMenuButton("Kunden verwalten");
        JButton btnOffers = createMenuButton("Angebote verwalten");
        JButton btnValueChain = createMenuButton("Rechnungen, Lieferscheine und Auftragsbestätigungen");
        JButton btnExit = createMenuButton("Programm beenden");

        btnCompanyData.addActionListener(e -> showSubMenu(createCompanyDataMenu()));
        btnArticles.addActionListener(e -> showSubMenu(createArticlesMenu()));
        btnCustomers.addActionListener(e -> showSubMenu(createCustomersMenu()));
        btnOffers.addActionListener(e -> showSubMenu(createOffersMenu()));
        btnValueChain.addActionListener(e -> showSubMenu(createValueChainMenu()));
        btnExit.addActionListener(e -> System.exit(0));

        mainMenuPanel.add(btnCompanyData, gbc);
        mainMenuPanel.add(btnArticles, gbc);
        mainMenuPanel.add(btnCustomers, gbc);
        mainMenuPanel.add(btnOffers, gbc);
        mainMenuPanel.add(btnValueChain, gbc);
        mainMenuPanel.add(btnExit, gbc);

        add(mainMenuPanel, BorderLayout.CENTER);
    }*/

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBackground(new Color(75, 110, 175));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(45, 85, 145), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        return button;
    }

    private JPanel createCompanyDataMenu() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JButton btnViewCompanyData = createMenuButton("Unternehmensstammdaten ansehen");
        JButton btnEditCompanyData = createMenuButton("Unternehmensstammdaten ändern");
        JButton btnBack = createMenuButton("Zurück zum Hauptmenü");

        btnViewCompanyData.addActionListener(e -> {
            CompanyData companyData = this.controller.getModel();

            JFrame viewFrame = new JFrame("Unternehmensstammdaten ansehen");
            viewFrame.setSize(400, 600);
            viewFrame.setLocationRelativeTo(null);

            JPanel panel1 = new JPanel(new GridBagLayout());
            GridBagConstraints gbc1 = new GridBagConstraints();
            gbc1.insets = new Insets(5, 5, 5, 5);
            gbc1.gridx = 0;
            gbc1.gridy = 0;
            gbc1.anchor = GridBagConstraints.WEST;

            panel1.add(new JLabel("Unternehmensname:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getCompanyName()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Inhaber:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getOwner()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Straße:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getStreet()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Postleitzahl:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getPostalCode()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Stadt:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getCity()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Land:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getCountry()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Telefon:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getPhone()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Mobiltelefon:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getMobile()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Fax:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getFax()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("E-Mail:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getEmail()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Website:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getWebsite()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("USt-IdNr.:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getVatId()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Steuernummer:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getTaxNumber()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Finanzamt:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getTaxOffice()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Bankname:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getBankName()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("IBAN:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getIban()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("BIC:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getBic()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Gläubiger-ID:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.getCreditorId()), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            panel1.add(new JLabel("Kleinunternehmen:"), gbc1);
            gbc1.gridx++;
            panel1.add(new JLabel(companyData.isSmallBusiness() ? "Ja" : "Nein"), gbc1);

            gbc1.gridx = 0;
            gbc1.gridy++;
            gbc1.gridwidth = 2;
            gbc1.anchor = GridBagConstraints.CENTER;
            JButton btnClose = new JButton("Schließen");
            panel1.add(btnClose, gbc1);

            viewFrame.add(panel1);
            viewFrame.setVisible(true);

            btnClose.addActionListener(e1 -> viewFrame.dispose());
        });

        btnEditCompanyData.addActionListener(e -> {
            // Implement editing company data
        });
        btnBack.addActionListener(e -> showMainMenu());

        panel.add(btnViewCompanyData, gbc);
        panel.add(btnEditCompanyData, gbc);
        panel.add(btnBack, gbc);

        return panel;
    }

    private JPanel createArticlesMenu() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JButton btnAddArticle = createMenuButton("Artikel anlegen");
        JButton btnViewArticle = createMenuButton("Artikel ansehen");
        JButton btnBack = createMenuButton("Zurück zum Hauptmenü");

        btnAddArticle.addActionListener(e -> {
            JPanel panel3 = new JPanel(new GridBagLayout());
            GridBagConstraints gbc3 = new GridBagConstraints();
            gbc3.insets = new Insets(5, 5, 5, 5);
            gbc3.gridx = 0;
            gbc3.gridy = 0;
            gbc3.anchor = GridBagConstraints.WEST;

            panel3.add(new JLabel("Einheit:"), gbc3);
            JTextField unitField = new JTextField(20);
            gbc3.gridx++;
            panel3.add(unitField, gbc3);

            gbc3.gridx = 0;
            gbc3.gridy++;
            panel3.add(new JLabel("Beschreibung:"), gbc3);
            JTextField descriptionField = new JTextField(20);
            gbc3.gridx++;
            panel3.add(descriptionField, gbc3);

            gbc3.gridx = 0;
            gbc3.gridy++;
            panel3.add(new JLabel("Netto-Preis:"), gbc3);
            JTextField netPriceField = new JTextField(10);
            gbc3.gridx++;
            panel3.add(netPriceField, gbc3);

            gbc3.gridx = 0;
            gbc3.gridy++;
            panel3.add(new JLabel("Steuersatz (%):"), gbc3);
            JTextField taxRateField = new JTextField(5);
            gbc3.gridx++;
            panel3.add(taxRateField, gbc3);

            int result = JOptionPane.showConfirmDialog(null, panel3, "Artikel anlegen", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String unit = unitField.getText();
                    String description = descriptionField.getText();
                    double netPrice = Double.parseDouble(netPriceField.getText());
                    double taxRate = Double.parseDouble(taxRateField.getText());

                    Article article = new Article(unit, description, netPrice, taxRate);
                    article.save();

                    JOptionPane.showMessageDialog(null, "Artikel erfolgreich angelegt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie gültige Werte für Netto-Preis und Steuersatz ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler beim Anlegen des Artikels: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnViewArticle.addActionListener(e -> {
            JTextField articleNumberField = new JTextField(10);
            JPanel panel2 = new JPanel(new GridBagLayout());
            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.insets = new Insets(5, 5, 5, 5);
            gbc2.gridx = 0;
            gbc2.gridy = 0;
            panel2.add(new JLabel("Artikel-Nr. eingeben:"), gbc2);
            gbc2.gridx++;
            panel2.add(articleNumberField, gbc2);

            int result = JOptionPane.showConfirmDialog(null, panel2, "Artikel ansehen", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    int articleNumber = Integer.parseInt(articleNumberField.getText());
                    Article article = Article.load(articleNumber);

                    if (article == null) {
                        JOptionPane.showMessageDialog(null, "Artikel mit der Nummer " + articleNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    JFrame articleFrame = new JFrame("Artikelinformationen");
                    articleFrame.setSize(400, 300);
                    articleFrame.setLocationRelativeTo(null);

                    JPanel articlepanel2 = new JPanel(new GridBagLayout());
                    GridBagConstraints articlegbc2 = new GridBagConstraints();
                    articlegbc2.insets = new Insets(5, 5, 5, 5);
                    articlegbc2.gridx = 0;
                    articlegbc2.gridy = 0;
                    articlegbc2.anchor = GridBagConstraints.WEST;

                    articlepanel2.add(new JLabel("Artikel-Nr:"), articlegbc2);
                    articlegbc2.gridx++;
                    articlepanel2.add(new JLabel(String.valueOf(article.getNumber())), articlegbc2);

                    articlegbc2.gridx = 0;
                    articlegbc2.gridy++;
                    articlepanel2.add(new JLabel("Einheit:"), articlegbc2);
                    articlegbc2.gridx++;
                    articlepanel2.add(new JLabel(article.getUnit()), articlegbc2);

                    articlegbc2.gridx = 0;
                    articlegbc2.gridy++;
                    articlepanel2.add(new JLabel("Beschreibung:"), articlegbc2);
                    articlegbc2.gridx++;
                    articlepanel2.add(new JLabel(article.getDescription()), articlegbc2);

                    articlegbc2.gridx = 0;
                    articlegbc2.gridy++;
                    articlepanel2.add(new JLabel("Netto-Preis:"), articlegbc2);
                    articlegbc2.gridx++;
                    articlepanel2.add(new JLabel(String.format("%.2f", article.getNetPrice())), articlegbc2);

                    articlegbc2.gridx = 0;
                    articlegbc2.gridy++;
                    articlepanel2.add(new JLabel("Steuersatz:"), articlegbc2);
                    articlegbc2.gridx++;
                    articlepanel2.add(new JLabel(String.format("%.2f%%", article.getTaxRate())), articlegbc2);

                    articlegbc2.gridx = 0;
                    articlegbc2.gridy++;
                    articlegbc2.gridwidth = 2;
                    articlegbc2.anchor = GridBagConstraints.CENTER;
                    JButton btnClose = new JButton("Schließen");
                    articlepanel2.add(btnClose, articlegbc2);

                    articleFrame.add(articlepanel2);
                    articleFrame.setVisible(true);

                    btnClose.addActionListener(e1 -> articleFrame.dispose());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Artikelnummer ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBack.addActionListener(e -> showMainMenu());

        panel.add(btnAddArticle, gbc);
        panel.add(btnViewArticle, gbc);
        panel.add(btnBack, gbc);

        return panel;
    }

    private JPanel createCustomersMenu() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JButton btnAddCustomer = createMenuButton("Kunden anlegen");
        JButton btnViewCustomer = createMenuButton("Kunden ansehen");
        JButton btnBack = createMenuButton("Zurück zum Hauptmenü");

        btnAddCustomer.addActionListener(e -> {
            // Erstellen des Dialogfensters für die Eingabe der Kundendaten
            JDialog dialog = new JDialog((Frame) null, "Kunden anlegen", true);
            JPanel panel9 = new JPanel(new GridBagLayout());
            GridBagConstraints gbc9 = new GridBagConstraints();
            gbc9.insets = new Insets(5, 5, 5, 5);
            gbc9.fill = GridBagConstraints.HORIZONTAL;

            // Adresseingabe
            JLabel lblAddress = new JLabel("Adresse:");
            gbc9.gridx = 0;
            gbc9.gridy = 0;
            panel9.add(lblAddress, gbc9);

            JTextField txtAddress = new JTextField(20);
            gbc9.gridx = 1;
            gbc9.gridy = 0;
            panel9.add(txtAddress, gbc9);

            // Kontaktperson
            JLabel lblContactPerson = new JLabel("Kontaktperson:");
            gbc9.gridx = 0;
            gbc9.gridy = 1;
            panel9.add(lblContactPerson, gbc9);

            JTextField txtContactPerson = new JTextField(20);
            gbc9.gridx = 1;
            gbc9.gridy = 1;
            panel9.add(txtContactPerson, gbc9);

            // Steuerbefreit
            JLabel lblTaxExempt = new JLabel("Steuerbefreit:");
            gbc9.gridx = 0;
            gbc9.gridy = 2;
            panel9.add(lblTaxExempt, gbc9);

            JCheckBox chkTaxExempt = new JCheckBox();
            gbc9.gridx = 1;
            gbc9.gridy = 2;
            panel9.add(chkTaxExempt, gbc9);

            // Button zum Hinzufügen des Kunden
            JButton btnSave = new JButton("Speichern");
            gbc9.gridx = 0;
            gbc9.gridy = 3;
            gbc9.gridwidth = 2;
            panel9.add(btnSave, gbc9);

            dialog.add(panel9);
            dialog.pack();
            dialog.setLocationRelativeTo(null);

            // Event-Listener für den Speichern-Button
            btnSave.addActionListener(saveEvent -> {
                String address = txtAddress.getText();
                String contactPerson = txtContactPerson.getText();
                boolean taxExempt = chkTaxExempt.isSelected();

                try {
                    // Kunde erstellen und speichern
                    Customer customer = new Customer(address, contactPerson, taxExempt);
                    customer.save();

                    // Erfolgsbestätigung anzeigen
                    JOptionPane.showMessageDialog(dialog, "Kunde erfolgreich angelegt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);

                    dialog.dispose();
                } catch (Exception ex) {
                    // Fehler anzeigen
                    JOptionPane.showMessageDialog(dialog, "Fehler beim Anlegen des Kunden: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            });

            dialog.setVisible(true);
        });

        btnViewCustomer.addActionListener(e -> {
            // Dialogfenster für die Eingabe der Kunden-Nr
            String input = JOptionPane.showInputDialog(null, "Geben Sie die Kunden-Nr ein:", "Kunden-Nr eingeben", JOptionPane.PLAIN_MESSAGE);

            if (input != null) {
                try {
                    int customerNumber = Integer.parseInt(input);
                    Customer customer = Customer.load(customerNumber);

                    if (customer == null) {
                        // Fehlermeldung anzeigen, wenn der Kunde nicht existiert
                        JOptionPane.showMessageDialog(null, "Kunde mit der Nummer " + customerNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Kundeninformationen in einem neuen Fenster anzeigen
                        JDialog dialog = new JDialog((Frame) null, "Kundeninformationen", true);
                        JPanel panel10 = new JPanel(new GridBagLayout());
                        GridBagConstraints gbc10 = new GridBagConstraints();
                        gbc10.insets = new Insets(5, 5, 5, 5);
                        gbc10.fill = GridBagConstraints.HORIZONTAL;

                        // Kunden-Nr anzeigen
                        JLabel lblNumber = new JLabel("Kunden-Nr:");
                        gbc10.gridx = 0;
                        gbc10.gridy = 0;
                        panel10.add(lblNumber, gbc10);

                        JTextField txtNumber = new JTextField(String.valueOf(customer.getNumber()), 20);
                        txtNumber.setEditable(false);
                        gbc10.gridx = 1;
                        gbc10.gridy = 0;
                        panel10.add(txtNumber, gbc10);

                        // Adresse anzeigen
                        JLabel lblAddress = new JLabel("Adresse:");
                        gbc10.gridx = 0;
                        gbc10.gridy = 1;
                        panel10.add(lblAddress, gbc10);

                        JTextField txtAddress = new JTextField(customer.getAddress(), 20);
                        txtAddress.setEditable(false);
                        gbc10.gridx = 1;
                        gbc10.gridy = 1;
                        panel10.add(txtAddress, gbc10);

                        // Kontaktperson anzeigen
                        JLabel lblContactPerson = new JLabel("Kontaktperson:");
                        gbc10.gridx = 0;
                        gbc10.gridy = 2;
                        panel10.add(lblContactPerson, gbc10);

                        JTextField txtContactPerson = new JTextField(customer.getContactPerson(), 20);
                        txtContactPerson.setEditable(false);
                        gbc10.gridx = 1;
                        gbc10.gridy = 2;
                        panel10.add(txtContactPerson, gbc10);

                        // Steuerbefreit anzeigen
                        JLabel lblTaxExempt = new JLabel("Steuerbefreit:");
                        gbc10.gridx = 0;
                        gbc10.gridy = 3;
                        panel10.add(lblTaxExempt, gbc10);

                        JCheckBox chkTaxExempt = new JCheckBox();
                        chkTaxExempt.setSelected(customer.isTaxExempt());
                        chkTaxExempt.setEnabled(false);
                        gbc10.gridx = 1;
                        gbc10.gridy = 3;
                        panel10.add(chkTaxExempt, gbc10);

                        // Button zum Schließen des Fensters
                        JButton btnClose = new JButton("Schließen");
                        gbc10.gridx = 0;
                        gbc10.gridy = 4;
                        gbc10.gridwidth = 2;
                        btnClose.addActionListener(closeEvent -> dialog.dispose());
                        panel10.add(btnClose, gbc10);

                        dialog.add(panel10);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    }
                } catch (NumberFormatException ex) {
                    // Fehlermeldung anzeigen, wenn die Eingabe keine gültige Zahl ist
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Kunden-Nr ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBack.addActionListener(e -> showMainMenu());

        panel.add(btnAddCustomer, gbc);
        panel.add(btnViewCustomer, gbc);
        panel.add(btnBack, gbc);

        return panel;
    }

    private JPanel createOffersMenu() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JButton btnCreateOffer = createMenuButton("Angebot erstellen");
        JButton btnViewOffer = createMenuButton("Angebot ansehen");
        JButton btnBack = createMenuButton("Zurück zum Hauptmenü");

        btnCreateOffer.addActionListener(e -> {
            // Erster Schritt: Erfassen der Kundennummer und Artikelnummer
            JPanel initialPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc5 = new GridBagConstraints();
            gbc5.insets = new Insets(5, 5, 5, 5);
            gbc5.gridx = 0;
            gbc5.gridy = 0;
            gbc5.anchor = GridBagConstraints.WEST;

            initialPanel.add(new JLabel("Kundennummer:"), gbc5);
            JTextField customerNumberField = new JTextField(10);
            gbc5.gridx++;
            initialPanel.add(customerNumberField, gbc5);

            gbc5.gridx = 0;
            gbc5.gridy++;
            initialPanel.add(new JLabel("Artikelnummer:"), gbc5);
            JTextField articleNumberField = new JTextField(10);
            gbc5.gridx++;
            initialPanel.add(articleNumberField, gbc5);

            int initialResult = JOptionPane.showConfirmDialog(null, initialPanel, "Angebot erstellen - Kundennummer und Artikelnummer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (initialResult == JOptionPane.OK_OPTION) {
                try {
                    int customerNumber = Integer.parseInt(customerNumberField.getText());
                    int articleNumber = Integer.parseInt(articleNumberField.getText());

                    Customer customer = Customer.load(customerNumber);
                    Article article = Article.load(articleNumber);

                    if (customer == null) {
                        JOptionPane.showMessageDialog(null, "Kunde mit der Nummer " + customerNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (article == null) {
                        JOptionPane.showMessageDialog(null, "Artikel mit der Nummer " + articleNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Zweiter Schritt: Erfassen der Menge
                    JPanel offerPanel = new JPanel(new GridBagLayout());
                    GridBagConstraints gbc3 = new GridBagConstraints();
                    gbc3.insets = new Insets(5, 5, 5, 5);
                    gbc3.gridx = 0;
                    gbc3.gridy = 0;
                    gbc3.anchor = GridBagConstraints.WEST;

                    offerPanel.add(new JLabel("Kunde: " + customer.getContactPerson()), gbc3);

                    gbc3.gridy++;
                    offerPanel.add(new JLabel("Artikel: " + article.getDescription()), gbc3);

                    gbc3.gridy++;
                    offerPanel.add(new JLabel("Menge:"), gbc3);
                    JTextField quantityField = new JTextField(10);
                    gbc3.gridx++;
                    offerPanel.add(quantityField, gbc3);

                    int offerResult = JOptionPane.showConfirmDialog(null, offerPanel, "Angebot erstellen - Menge eingeben", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (offerResult == JOptionPane.OK_OPTION) {
                        try {
                            int quantity = Integer.parseInt(quantityField.getText());

                            Offer offer = new Offer(customerNumber, articleNumber, quantity);
                            offer.save();

                            JOptionPane.showMessageDialog(null, "Angebot erfolgreich erstellt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Zahl für die Menge ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Fehler beim Erstellen des Angebots: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie gültige Zahlen für Kundennummer und Artikelnummer ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnViewOffer.addActionListener(e -> {
            // Öffnet das Eingabefenster für die Angebotsnummer
            String input = JOptionPane.showInputDialog(null, "Bitte geben Sie die Angebotsnummer ein:", "Angebot ansehen", JOptionPane.PLAIN_MESSAGE);

            if (input != null && !input.isEmpty()) {
                try {
                    int offerNumber = Integer.parseInt(input);
                    Offer offer = Offer.load(offerNumber);

                    if (offer == null) {
                        JOptionPane.showMessageDialog(null, "Angebot mit der Nummer " + offerNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int articleNumber = offer.getArticleNumber();
                    int customerNumber = offer.getCustomerNumber();

                    Article article = Article.load(articleNumber);
                    Customer customer = Customer.load(customerNumber);

                    if (article == null) {
                        JOptionPane.showMessageDialog(null, "Artikel mit der Nummer " + articleNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (customer == null) {
                        JOptionPane.showMessageDialog(null, "Kunde mit der Nummer " + customerNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Fenster zur Anzeige der Angebotsdetails
                    JPanel offerPanel = new JPanel(new GridBagLayout());
                    GridBagConstraints gbc7 = new GridBagConstraints();
                    gbc7.insets = new Insets(5, 5, 5, 5);
                    gbc7.gridx = 0;
                    gbc7.gridy = 0;
                    gbc7.anchor = GridBagConstraints.WEST;

                    offerPanel.add(new JLabel("Angebotsnummer: " + offerNumber), gbc7);

                    gbc7.gridy++;
                    offerPanel.add(new JLabel("Kundennummer: " + customerNumber), gbc7);

                    gbc7.gridy++;
                    offerPanel.add(new JLabel("Kontaktperson: " + customer.getContactPerson()), gbc7);

                    gbc7.gridy++;
                    offerPanel.add(new JLabel("Artikelnummer: " + articleNumber), gbc7);

                    gbc7.gridy++;
                    offerPanel.add(new JLabel("Artikelbeschreibung: " + article.getDescription()), gbc7);

                    gbc7.gridy++;
                    offerPanel.add(new JLabel("Bestellte Menge: " + offer.getQuantity()), gbc7);

                    // Dialog zur Anzeige der Angebotsdetails
                    JOptionPane.showMessageDialog(null, offerPanel, "Angebot ansehen", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Zahl für die Angebotsnummer ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler beim Laden des Angebots: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBack.addActionListener(e -> showMainMenu());

        panel.add(btnCreateOffer, gbc);
        panel.add(btnViewOffer, gbc);
        panel.add(btnBack, gbc);

        return panel;
    }

    private JPanel createValueChainMenu() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JButton btnCreateOrderConfirmation = createMenuButton("Auftragsbestätigung erstellen");
        JButton btnRecordDelivery = createMenuButton("Lieferung erfassen");
        JButton btnCreateInvoice = createMenuButton("Rechnung schreiben");
        JButton btnBack = createMenuButton("Zurück zum Hauptmenü");

        btnCreateOrderConfirmation.addActionListener(e -> {
            // Dialogfenster zur Eingabe der Angebotsnummer
            String input = JOptionPane.showInputDialog(null, "Bitte geben Sie die Angebotsnummer ein:", "Auftragsbestätigung erstellen", JOptionPane.PLAIN_MESSAGE);

            if (input != null && !input.isEmpty()) {
                try {
                    int offerNumber = Integer.parseInt(input);
                    Offer offer = Offer.load(offerNumber);

                    if (offer == null) {
                        JOptionPane.showMessageDialog(null, "Angebot mit der Nummer " + offerNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // ValueChain laden oder neu erstellen
                    ValueChain valueChain = ValueChain.load(offerNumber);
                    if (valueChain == null) {
                        valueChain = new ValueChain(offerNumber);
                    }

                    valueChain.setOrderConfirmationNumber(this.controller.getValueChainController().getNextOrderConfirmationNumber());
                    valueChain.setOrderConfirmationDate(LocalDate.now());
                    valueChain.save();

                    // Bestätigung anzeigen
                    JOptionPane.showMessageDialog(null, "Auftragsbestätigung wurde erfolgreich erstellt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Zahl für die Angebotsnummer ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler beim Erstellen der Auftragsbestätigung: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnRecordDelivery.addActionListener(e -> {
            // Dialogfenster zur Eingabe der Angebotsnummer
            String input = JOptionPane.showInputDialog(null, "Bitte geben Sie die Angebotsnummer ein:", "Auftragsbestätigung erstellen", JOptionPane.PLAIN_MESSAGE);

            if (input != null && !input.isEmpty()) {
                try {
                    int offerNumber = Integer.parseInt(input);
                    Offer offer = Offer.load(offerNumber);

                    if (offer == null) {
                        JOptionPane.showMessageDialog(null, "Angebot mit der Nummer " + offerNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // ValueChain laden oder neu erstellen
                    ValueChain valueChain = ValueChain.load(offerNumber);
                    if (valueChain == null) {
                        valueChain = new ValueChain(offerNumber);
                    }

                    valueChain.setDeliveryNoteNumber(this.controller.getValueChainController().getNextDeliveryNoteNumber());
                    valueChain.setDeliveryDate(LocalDate.now());
                    valueChain.save();

                    // Bestätigung anzeigen
                    JOptionPane.showMessageDialog(null, "Lieferschein wurde erfolgreich erstellt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Zahl für die Angebotsnummer ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler beim Erstellen der Auftragsbestätigung: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCreateInvoice.addActionListener(e -> {
            // Dialogfenster zur Eingabe der Angebotsnummer
            String input = JOptionPane.showInputDialog(null, "Bitte geben Sie die Angebotsnummer ein:", "Auftragsbestätigung erstellen", JOptionPane.PLAIN_MESSAGE);

            if (input != null && !input.isEmpty()) {
                try {
                    int offerNumber = Integer.parseInt(input);
                    Offer offer = Offer.load(offerNumber);

                    if (offer == null) {
                        JOptionPane.showMessageDialog(null, "Angebot mit der Nummer " + offerNumber + " existiert nicht.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // ValueChain laden oder neu erstellen
                    ValueChain valueChain = ValueChain.load(offerNumber);
                    if (valueChain == null) {
                        valueChain = new ValueChain(offerNumber);
                    }

                    valueChain.setInvoiceNumber(this.controller.getValueChainController().getNextInvoiceNumber());
                    valueChain.setInvoiceDate(LocalDate.now());
                    valueChain.save();

                    // Bestätigung anzeigen
                    JOptionPane.showMessageDialog(null, "Rechnung wurde erfolgreich erstellt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Zahl für die Angebotsnummer ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler beim Erstellen der Auftragsbestätigung: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBack.addActionListener(e -> showMainMenu());

        panel.add(btnCreateOrderConfirmation, gbc);
        panel.add(btnRecordDelivery, gbc);
        panel.add(btnCreateInvoice, gbc);
        panel.add(btnBack, gbc);

        return panel;
    }

    private void showSubMenu(JPanel subMenuPanel) {
        setContentPane(subMenuPanel);
        revalidate();
        repaint();
    }

    private void showMainMenu() {
        setContentPane(mainMenuPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {

        CompanyData companyData = CompanyData.load();

        SwingUtilities.invokeLater(() -> new CompanyDataMainGUI(companyData.getCompanyName() == null || companyData.getCompanyName().isEmpty(), new CompanyDataController(companyData)));
    }

    private void initializeComponents() {
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridBagLayout());
        mainMenuPanel.setBackground(new Color(60, 63, 65));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JButton btnCompanyData = createMenuButton("Unternehmensstammdaten verwalten");
        JButton btnArticles = createMenuButton("Artikel verwalten");
        JButton btnCustomers = createMenuButton("Kunden verwalten");
        JButton btnOffers = createMenuButton("Angebote verwalten");
        JButton btnValueChain = createMenuButton("Rechnungen, Lieferscheine und Auftragsbestätigungen");
        JButton btnExit = createMenuButton("Programm beenden");

        btnCompanyData.addActionListener(e -> showSubMenu(createCompanyDataMenu()));
        btnArticles.addActionListener(e -> showSubMenu(createArticlesMenu()));
        btnCustomers.addActionListener(e -> showSubMenu(createCustomersMenu()));
        btnOffers.addActionListener(e -> showSubMenu(createOffersMenu()));
        btnValueChain.addActionListener(e -> showSubMenu(createValueChainMenu()));
        btnExit.addActionListener(e -> System.exit(0));

        mainMenuPanel.add(btnCompanyData, gbc);
        mainMenuPanel.add(btnArticles, gbc);
        mainMenuPanel.add(btnCustomers, gbc);
        mainMenuPanel.add(btnOffers, gbc);
        mainMenuPanel.add(btnValueChain, gbc);
        mainMenuPanel.add(btnExit, gbc);

        setContentPane(mainMenuPanel);
        revalidate();
        repaint();
    }
}
