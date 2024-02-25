import javax.swing.*; // Importing all the necessary libraries
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{ // the Main class extends the JFrame for the GUI

    private JTextField totalTermWeightF, finalWeightF, desiredGradeF; // declaring all the components of the GUI application
    private JComboBox<Integer> numberOfTermsB;
    private JTextField[] termsGrade;
    private JLabel[] termL;
    private JLabel resultLabel;


    public Main() // default constructor to intialize the GUI
    {
        initializeOutline();
        setValues();
    }

    private void initializeOutline(){ //outline of the GUI
        setTitle("Final Calculator");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel totalTermWeightL = new JLabel("Total Term Weight:");
        totalTermWeightL.setBounds(20, 20, 150, 20);
        add(totalTermWeightL);

        totalTermWeightF = new JTextField();
        totalTermWeightF.setBounds(180, 20, 50, 20);
        add(totalTermWeightF);

        JLabel finalWeightL = new JLabel("Final Exam Weight:");
        finalWeightL.setBounds(20, 60, 150, 20);
        add(finalWeightL);

        finalWeightF = new JTextField();
        finalWeightF.setBounds(180, 60, 50, 20);
        add(finalWeightF);

        JLabel numberOfTermsL = new JLabel("Number of Terms");
        numberOfTermsL.setBounds(20, 100, 150, 20);
        add(numberOfTermsL);

        resultLabel = new JLabel("Final Grade Required: ");
        resultLabel.setBounds(20, 440, 250, 20);
        add(resultLabel);

        Integer[] numberOfTermsVal = {1,2,3,4,5};
        numberOfTermsB = new JComboBox<>(numberOfTermsVal); //making a combo box for the dropdown, learned about renderer, did NOT use any code from https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/combobox.html
        numberOfTermsB.setBounds(180,100,50,20);
        numberOfTermsB.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value!= null)
                {
                    setText(value.toString());
                }
                return this;
            }
        });

        numberOfTermsB.addActionListener(new ActionListener() { // adding action listener for the combo box's terms
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTermFields();
            }
        });
        add(numberOfTermsB);

        JLabel desiredGradeL = new JLabel("Grade Wanted:"); //label and the text fields for the wanted grade
        desiredGradeL.setBounds(20,140,150,20);
        add(desiredGradeL);

        desiredGradeF = new JTextField();
        desiredGradeF.setBounds(180, 140, 50, 20);
        add(desiredGradeF);

        termsGrade = new JTextField[5]; // initializing label and text fields for the wanted grades
        termL = new JLabel[5];

        for(int i=0;i<5;i++) //loop to create labels and text fields for each of the terms
        {
            termsGrade[i] = new JTextField();
            termL[i] = new JLabel("Term " + (i+1) + " Grade:");
            termL[i].setBounds(20, 180 + 40*i, 150,20);
            add(termL[i]);

            termsGrade[i].setBounds(180,180 + 40*i, 50, 20);
            termsGrade[i].setEnabled(false);
            termsGrade[i].setBackground(Color.LIGHT_GRAY);
            termsGrade[i].setForeground(Color.GRAY);
            add(termsGrade[i]);
        }

        JButton calculateB = new JButton("Calculate"); // button to do the calculation
        calculateB.setBounds(20, 400, 100,30);
        calculateB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(correctWeights())
                {
                    calculateOperation();
                }
                else{
                    JOptionPane.showMessageDialog(Main.this, "Total Weights must add up to 100.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(calculateB);

        JButton clearB = new JButton("Clear"); // button to clear all the fields
        clearB.setBounds(140,400,100,30);

        clearB.setBounds(140,400,100,30);

        clearB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        add(clearB);

        setVisible(true); // setting the JFrame to be visible
    }

    private void setValues(){ // default values as requested by Mr. Tully
        totalTermWeightF.setText("85");
        finalWeightF.setText("15");
        numberOfTermsB.setSelectedItem(1);
        desiredGradeF.setText("90");
        termsGrade[0].setEnabled(true);
        termsGrade[0].setBackground(Color.WHITE);
        termsGrade[0].setForeground(Color.BLACK);
    }

    private void updateTermFields() // method to update the visibility and the background color of the terms
    {
        int selectedT = (Integer) numberOfTermsB.getSelectedItem();

        for(int i=0;i<5;i++)
        {
            termsGrade[i].setEnabled(i<selectedT);
            termsGrade[i].setBackground(i<selectedT ? Color.WHITE : Color.LIGHT_GRAY);
            termsGrade[i].setForeground(i<selectedT ? Color.BLACK : Color.GRAY);

            termL[i].setForeground(i<selectedT ? Color.black : Color.GRAY);

            if(i>= selectedT){
                termsGrade[i].setText("");
            }
        }
    }

    private void clearFields(){ // clearing all the term grade fields
        for(int i=0; i<5; i++)
        {
            termsGrade[i].setText("");
        }
        resultLabel.setText("");
    }

    private boolean correctWeights() // checking if the total weights add up to a 100
    {
        try{
            double termW = Double.parseDouble(totalTermWeightF.getText());
            double finalW = Double.parseDouble(finalWeightF.getText());
            return (termW + finalW) == 100;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private void calculateOperation(){ //method to perform the final grade calculation
        try {
            double finalW = Double.parseDouble(finalWeightF.getText());
            double wantedG = Double.parseDouble(desiredGradeF.getText());

            int selectedT = (Integer) numberOfTermsB.getSelectedItem();
            double totalTermW = Double.parseDouble(totalTermWeightF.getText());
            double termSum = 0;
            //core logic to do the math
            for (int i = 0; i < selectedT; i++) {
                double termG = Double.parseDouble(termsGrade[i].getText());
                termSum += termG;
            }

            double termAvg = termSum / selectedT;
            double termWAvg = termAvg * (totalTermW / 100);

            double finalGradeR = (wantedG - termWAvg) / (finalW / 100);

            resultLabel.setText("Final Grade Required: " + finalGradeR);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid values [numerical].");
        }
    }

    public static void main(String[] args) // Main Method to start the application
    {
        SwingUtilities.invokeLater(() -> new Main());
    }

}