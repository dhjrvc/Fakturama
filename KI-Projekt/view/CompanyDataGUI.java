/*package view;

import controller.CompanyDataController;
import model.CompanyData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyDataGUI extends JFrame {

    private CompanyDataController controller;

    private JTextField txtCompanyName;
    private JTextField txtOwner;
    private JTextField txtStreet;
    private JTextField txtPostalCode;
    private JTextField txtCity;
    private JTextField txtCountry;
    private JTextField txtPhone;
    private JTextField txtMobile;
    private JTextField txtFax;
    private JTextField txtEmail;
    private JTextField txtWebsite;
    private JTextField txtVatId;
    private JTextField txtTaxNumber;
    private JTextField txtTaxOffice;
    private JTextField txtBankName;
    private JTextField txtIban;
    private JTextField txtBic;
    private JTextField txtCreditorId;

    public CompanyDataGUI() {
        super("Company Data Management");

        controller = new CompanyDataController(new CompanyData(), this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("Firmenname:"));
        txtCompanyName = new JTextField();
        panel.add(txtCompanyName);

        panel.add(new JLabel("Inhaber:"));
        txtOwner = new JTextField();
        panel.add(txtOwner);

        panel.add(new JLabel("Straße:"));
        txtStreet = new JTextField();
        panel.add(txtStreet);

        panel.add(new JLabel("PLZ:"));
        txtPostalCode = new JTextField();
        panel.add(txtPostalCode);

        panel.add(new JLabel("Stadt:"));
        txtCity = new JTextField();
        panel.add(txtCity);

        panel.add(new JLabel("Land:"));
        txtCountry = new JTextField();
        panel.add(txtCountry);

        panel.add(new JLabel("Telefon:"));
        txtPhone = new JTextField();
        panel.add(txtPhone);

        panel.add(new JLabel("Mobilnummer:"));
        txtMobile = new JTextField();
        panel.add(txtMobile);

        panel.add(new JLabel("Telefax:"));
        txtFax = new JTextField();
        panel.add(txtFax);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Webseite:"));
        txtWebsite = new JTextField();
        panel.add(txtWebsite);

        panel.add(new JLabel("USt-IdNr:"));
        txtVatId = new JTextField();
        panel.add(txtVatId);

        panel.add(new JLabel("Steuernummer:"));
        txtTaxNumber = new JTextField();
        panel.add(txtTaxNumber);

        panel.add(new JLabel("Finanzamt:"));
        txtTaxOffice = new JTextField();
        panel.add(txtTaxOffice);

        panel.add(new JLabel("Bankname:"));
        txtBankName = new JTextField();
        panel.add(txtBankName);

        panel.add(new JLabel("IBAN:"));
        txtIban = new JTextField();
        panel.add(txtIban);

        panel.add(new JLabel("BIC:"));
        txtBic = new JTextField();
        panel.add(txtBic);

        panel.add(new JLabel("Gläubiger-ID:"));
        txtCreditorId = new JTextField();
        panel.add(txtCreditorId);

        JButton btnSave = new JButton("Speichern");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCompanyData();
            }
        });
        panel.add(btnSave);

        add(panel);
    }

    private void saveCompanyData() {
        CompanyData companyData = new CompanyData();
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

        controller.saveCompanyData(companyData);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CompanyDataGUI();
            }
        });
    }
}*/