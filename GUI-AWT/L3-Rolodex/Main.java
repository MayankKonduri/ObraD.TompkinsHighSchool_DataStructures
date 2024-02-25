import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


public class Main extends JFrame {
    private final String CONTACTS_FILE = "unique_contacts.txt";

    private JLabel firstLbl, lastLbl, phoneLbl, addressLbl;
    private JTextField firstTxt, lastTxt, phoneTxt, addressTxt;
    private JButton saveBtn, newBtn, deleteBtn, saveChangesBtn;
    private JScrollPane contactScrollPane;
    private JList<Contact> contactList;

    private ArrayList<Contact> contacts = new ArrayList<>();

    public Main() {
        super("Contact Manager");
        initComponents();
        setupWindow();
        setupLayout();
        addEventListeners();
        setVisibility();
    }

    private void initComponents() {
        firstLbl = new JLabel("First Name: ");
        lastLbl = new JLabel("Last Name: ");
        phoneLbl = new JLabel("Phone Number: ");
        addressLbl = new JLabel("Address: ");

        firstTxt = new JTextField("");
        lastTxt = new JTextField("");
        phoneTxt = new JTextField("");
        addressTxt = new JTextField("");

        saveBtn = new JButton("Save");
        newBtn = new JButton("New");
        deleteBtn = new JButton("Delete Contact");
        saveChangesBtn = new JButton("Save Changes");

        contactScrollPane = new JScrollPane();
        contactList = new JList<>();
    }

    private void setupWindow() {
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupLayout() {
        setLayout(null);

        firstLbl.setBounds(50, 30, 100, 20);
        lastLbl.setBounds(50, 70, 100, 20);
        phoneLbl.setBounds(50, 110, 100, 20);
        addressLbl.setBounds(50, 150, 100, 20);

        firstTxt.setBounds(170, 30, 150, 20);
        lastTxt.setBounds(170, 70, 150, 20);
        phoneTxt.setBounds(170, 110, 150, 20);
        addressTxt.setBounds(170, 150, 150, 20);

        saveBtn.setBounds(120, 200, 100, 20);
        newBtn.setBounds(240, 200, 100, 20);

        contactScrollPane.setBounds(400, 20, 300, 320);

        saveChangesBtn.setBounds(130, 230, 130, 20);
        deleteBtn.setBounds(130, 260, 130, 20);

        add(firstLbl);
        add(lastLbl);
        add(phoneLbl);
        add(addressLbl);
        add(firstTxt);
        add(lastTxt);
        add(phoneTxt);
        add(addressTxt);
        add(newBtn);
        add(saveBtn);
        add(contactScrollPane);
        add(deleteBtn);
        add(saveChangesBtn);

        contactScrollPane.setViewportView(contactList);
    }

    private void addEventListeners() {
        saveBtn.addActionListener(e -> saveContact());
        newBtn.addActionListener(e -> clearFields());
        deleteBtn.addActionListener(e -> deleteContact());
        saveChangesBtn.addActionListener(e -> saveChanges());

        contactList.addListSelectionListener(e -> handleContactSelection());
    }

    private void setVisibility() {
        saveChangesBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        saveChangesBtn.setVisible(false);
        deleteBtn.setVisible(false);
        setVisible(true);
    }

    private void saveContact() {
        String firstName = firstTxt.getText();
        String lastName = lastTxt.getText();
        String phoneNumber = phoneTxt.getText();
        String address = addressTxt.getText();

        if (firstName.isBlank() || lastName.isBlank()) {
            JOptionPane.showMessageDialog(this, "Enter First Name and Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Contact contact = new Contact(firstName, lastName, phoneNumber, address);
        contacts.add(contact);
        Collections.sort(contacts);
        updateContactPanel();
        clearFields();
    }


    private void clearFields() {
        firstTxt.setText("");
        lastTxt.setText("");
        phoneTxt.setText("");
        addressTxt.setText("");
    }

    private void deleteContact() {
        int selectedIndex = contactList.getSelectedIndex();

        if (selectedIndex != -1) {
            contacts.remove(selectedIndex);
            updateContactPanel();
            clearFields();
        }

        updateButtonVisibility(false, false, false, false, true, true);
        updateSaveChangesVisibility();
    }

    private void saveChanges() {
        int selectedIndex = contactList.getSelectedIndex();

        if (selectedIndex != -1) {
            Contact selectedContact = contactList.getSelectedValue();

            String firstName = firstTxt.getText().trim();
            String lastName = lastTxt.getText().trim();

            if (isInvalidName(firstName, lastName)) {
                showError("Enter both First Name and Last Name");
                return;
            }

            updateContact(selectedContact, firstName, lastName, phoneTxt.getText(), addressTxt.getText());

            Collections.sort(contacts);
            updateContactPanel();
            clearFields();
            contactList.clearSelection();
        }

        updateButtonVisibility(true, false, false, false, true, true);
        updateSaveChangesVisibility();
    }

    private void updateSaveChangesVisibility() {
        saveChangesBtn.setVisible(false);
        saveChangesBtn.setEnabled(false);
    }


    private boolean isInvalidName(String firstName, String lastName) {
        return (firstName.isEmpty() && !lastName.isEmpty()) || (!firstName.isEmpty() && lastName.isEmpty());
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void updateContact(Contact contact, String firstName, String lastName, String phoneNumber, String address) {
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setAddress(address);
    }

    private void updateButtonVisibility(boolean saveChangesVisible, boolean saveChangesEnabled, boolean deleteVisible,
                                        boolean deleteEnabled, boolean saveVisible, boolean saveEnabled) {
        saveChangesBtn.setVisible(saveChangesVisible);
        saveChangesBtn.setEnabled(saveChangesEnabled);
        deleteBtn.setVisible(deleteVisible);
        deleteBtn.setEnabled(deleteEnabled);
        saveBtn.setVisible(saveVisible);
        saveBtn.setEnabled(saveEnabled);
        newBtn.setVisible(true);
        newBtn.setEnabled(true);
    }


    private void handleContactSelection() {
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
            Contact selectedContact = contactList.getSelectedValue();
            firstTxt.setText(selectedContact.getFirstName());
            lastTxt.setText(selectedContact.getLastName());
            phoneTxt.setText(selectedContact.getPhoneNumber());
            addressTxt.setText(selectedContact.getAddress());

            saveChangesBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
            saveChangesBtn.setVisible(true);
            deleteBtn.setVisible(true);

            saveBtn.setEnabled(false);
            newBtn.setEnabled(false);
            saveBtn.setVisible(false);
            newBtn.setVisible(false);
        }
    }

    private void loadContactsFromFile() {
        try { // brainstormed way to use .trim() with Nischal Konduri, but did NOT COPY A SINGLE LINE OF CODE
            List<String> lines = Files.readAllLines(Paths.get(CONTACTS_FILE));
            for (String line : lines) {
                String[] slice = line.split(",");
                if (slice.length == 4) {
                    String firstName = slice[0].trim();
                    String lastName = slice[1].trim();
                    String phoneNumber = slice[2].trim();
                    String address = slice[3].trim();
                    Contact contact = new Contact(firstName, lastName, phoneNumber, address);
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: Reading File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveContactsToFile() {
        try {
            List<String> lines = new ArrayList<>();
            for (Contact contact : contacts) {
                lines.add(contact.getFirstName() + ", " + contact.getLastName() + ", " + contact.getPhoneNumber() + ", " + contact.getAddress());
            }
            Files.write(Paths.get(CONTACTS_FILE), lines);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: Saving Files", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void setupWindowListener() {
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                saveContactsToFile();
            }

            public void windowOpened(WindowEvent e) {
                loadContactsFromFile();
                updateContactPanel();
            }
        });
    }
    private void updateContactPanel() {
        DefaultListModel<Contact> model = new DefaultListModel<>();
        contacts.sort((c1, c2) -> {
            String name1 = c1.getLastName() + c1.getFirstName();
            String name2 = c2.getLastName() + c2.getFirstName();
            return name1.compareToIgnoreCase(name2);
        });
        model.addAll(contacts);
        contactList.setModel(model);

        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setupWindowListener();
        });
    }

    private static class Contact implements Comparable<Contact> {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String address;

        public Contact(String firstName, String lastName, String phoneNumber, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int compareTo(Contact o) {
            return this.lastName.compareToIgnoreCase(o.lastName);
        }

        public String toString() {
            return lastName + ", " + firstName;
        }
    }
}