// u2510164 AMIR PULATOV - Lab 8: User Contact Form
import javax.swing.*;          // JFrame, JButton, JTextField
import java.awt.*;             // FlowLayout
import java.awt.event.*;       // the listeners

public class ContactForm_U2510164 extends JFrame {

    //  the components (fields)
    private JTextField txtName = new JTextField(15);
    private JTextField txtEmail = new JTextField(15);
    private JRadioButton rbMale = new JRadioButton("Male");
    private JRadioButton rbFemale = new JRadioButton("Female");
    private String[] countries = {"Uzbekistan", "USA", "Korea", "India"};
    private JComboBox<String> cbCountry = new JComboBox<>(countries);
    private JCheckBox chkNewsletter = new JCheckBox("Subscribe to Newsletter");
    private JButton btnSubmit = new JButton("Submit");

    //  constructor: build the window
    public ContactForm_U2510164() {
        setLayout(new FlowLayout());

        // only one gender can be selected
        ButtonGroup gender = new ButtonGroup();
        gender.add(rbMale);
        gender.add(rbFemale);

        // labels and components, left to right
        add(new JLabel("Name:"));
        add(txtName);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Gender:"));
        add(rbMale);
        add(rbFemale);
        add(new JLabel("Country:"));
        add(cbCountry);
        add(chkNewsletter);
        add(btnSubmit);

        // register listeners (connect each component to its listener)
        btnSubmit.addActionListener(new SubmitListener());
        cbCountry.addActionListener(new CountryListener());
        rbMale.addItemListener(new GenderListener());
        rbFemale.addItemListener(new GenderListener());
        chkNewsletter.addItemListener(new NewsletterListener());
    }

    //  listener 1: Submit button
    class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button Clicked");

            String gender;
            if (rbMale.isSelected()) {
                gender = "Male";
            } else if (rbFemale.isSelected()) {
                gender = "Female";
            } else {
                gender = "Not selected";
            }

            String newsletter;
            if (chkNewsletter.isSelected()) {
                newsletter = "Yes";
            } else {
                newsletter = "No";
            }

            System.out.println("Name: " + txtName.getText());
            System.out.println("Email: " + txtEmail.getText());
            System.out.println("Gender: " + gender);
            System.out.println("Country: " + cbCountry.getSelectedItem());
            System.out.println("Subscribed to Newsletter: " + newsletter);
        }
    }

    // ---------- listener 2: country dropdown ----------
    class CountryListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Country selected: " + cbCountry.getSelectedItem());
        }
    }

    // listener 3: gender radio buttons ----------
    class GenderListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (rbMale.isSelected()) {
                    System.out.println("Gender selected: Male");
                } else {
                    System.out.println("Gender selected: Female");
                }
            }
        }
    }

    // listener 4: newsletter checkbox
    class NewsletterListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (chkNewsletter.isSelected()) {
                System.out.println("Subscribed to Newsletter: Yes");
            } else {
                System.out.println("Subscribed to Newsletter: No");
            }
        }
    }

    // main: create and show the window
    public static void main(String[] args) {
        ContactForm_U2510164 frame = new ContactForm_U2510164();
        frame.setTitle("User Contact Form");
        frame.setSize(1150, 130);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}