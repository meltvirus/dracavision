package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class bestellingmenu {
    public JPanel bestellingpane;
    public JTextField textField1;
    public JTextField textField2;
    public JButton inWinkelwagenPlaatsenButton;
    public JLabel imagebloem;
    public JLabel imagepasta;
    public JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton terugbutton1;
    private JPanel bestellingpane2;
    public static int product1;
    public static int product2;


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }



    public bestellingmenu() {

        if (instellingen.darkmode == true){
            bestellingpane2.setBackground(new Color(0x24242B));

        } else {
            bestellingpane2.setBackground(new Color(-1));
        }
        bestellingpane.repaint();
        bestellingpane.revalidate();







        comboBox1.addItem("0");
        comboBox1.addItem("1");
        comboBox1.addItem("2");
        comboBox1.addItem("3");
        comboBox1.addItem("4");

        comboBox2.addItem("0");
        comboBox2.addItem("1");
        comboBox2.addItem("2");
        comboBox2.addItem("3");
        comboBox2.addItem("4");

        comboBox3.addItem("0");
        comboBox3.addItem("1");
        comboBox3.addItem("2");
        comboBox3.addItem("3");
        comboBox3.addItem("4");

        comboBox4.addItem("0");
        comboBox4.addItem("1");
        comboBox4.addItem("2");
        comboBox4.addItem("3");
        comboBox4.addItem("4");
        inWinkelwagenPlaatsenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //geef pop up

             //   bestelnummer = bestellingcombobox.getSelectedItem();
             //   bestelnr = (String) bestelnummer;
             //   bestelint = Integer.parseInt(bestelnr);

                product1 = Integer.parseInt((String) comboBox1.getSelectedItem()); //deze manier is korter!!!
                product2 = Integer.parseInt((String) comboBox2.getSelectedItem());
                if (product1 != 0 || product2 != 0) {

                    try {
                        SQLDatabaseConnection.checkbestelling(SQLDatabaseConnection.klantnummer);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (SQLDatabaseConnection.albestellingonderweg == false) {


                        try {
                            SQLDatabaseConnection.plaatsbestelling(SQLDatabaseConnection.klantnummer, product1, product2);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }



                        inlogmenu.naarhoofdmenu();
                    } else {
                        System.out.println("Al bestelling onderweg!!! maak hier een pop up van"); //!!!!
                    }
                }

            }
        });
        terugbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarhoofdmenu();
            }
        });


    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        bestellingpane = new JPanel();
        bestellingpane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        bestellingpane.setBackground(new Color(-1));
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setVerticalScrollBarPolicy(22);
        bestellingpane.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 100), new Dimension(30, 200), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 5, new Insets(0, 0, 0, 0), -1, -1));
        scrollPane1.setViewportView(panel1);
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        Font label1Font = this.getFon("Dubai", -1, 15, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-54151));
        label1.setHorizontalAlignment(2);
        label1.setHorizontalTextPosition(11);
        label1.setText("Pasta");
        label1.setVerticalAlignment(0);
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(100, 28), new Dimension(-1, 40), 3, false));
        final JLabel label2 = new JLabel();
        label2.setEnabled(true);
        Font label2Font = this.getFon("Dubai", -1, 15, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-54151));
        label2.setHorizontalAlignment(2);
        label2.setHorizontalTextPosition(11);
        label2.setText("Bloemkool");
        label2.setVerticalAlignment(0);
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(100, 28), new Dimension(-1, 40), 3, false));
        final JLabel label3 = new JLabel();
        label3.setEnabled(true);
        Font label3Font = this.getFon("Dubai", -1, 15, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-54151));
        label3.setHorizontalAlignment(2);
        label3.setHorizontalTextPosition(11);
        label3.setText("product 3");
        label3.setVerticalAlignment(0);
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(100, 28), new Dimension(-1, 40), 3, false));
        final JLabel label4 = new JLabel();
        label4.setEnabled(true);
        Font label4Font = this.getFon("Dubai", -1, 15, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-54151));
        label4.setHorizontalAlignment(2);
        label4.setHorizontalTextPosition(11);
        label4.setText("product 4");
        label4.setVerticalAlignment(0);
        panel1.add(label4, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(100, 28), new Dimension(-1, 40), 3, false));
        final JLabel label5 = new JLabel();
        label5.setEnabled(true);
        Font label5Font = this.getFon("Dubai", -1, 15, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-54151));
        label5.setHorizontalAlignment(2);
        label5.setHorizontalTextPosition(11);
        label5.setText("product 5");
        label5.setVerticalAlignment(0);
        panel1.add(label5, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(100, 28), new Dimension(-1, 40), 3, false));
        final JLabel label6 = new JLabel();
        label6.setEnabled(true);
        Font label6Font = this.getFon("Dubai", -1, 15, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-54151));
        label6.setHorizontalAlignment(2);
        label6.setHorizontalTextPosition(11);
        label6.setText("product 6");
        label6.setVerticalAlignment(0);
        panel1.add(label6, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(100, 28), new Dimension(-1, 40), 3, false));
        final JLabel label7 = new JLabel();
        label7.setText("");
        panel1.add(label7, new com.intellij.uiDesigner.core.GridConstraints(8, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(20, -1), new Dimension(20, -1), new Dimension(20, -1), 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("");
        panel1.add(label8, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 40), new Dimension(-1, 400), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("");
        panel1.add(label9, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(20, -1), new Dimension(20, -1), new Dimension(20, -1), 0, false));
        final JComboBox comboBox2 = new JComboBox();
        panel1.add(comboBox2, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, -1), null, new Dimension(60, -1), 0, false));
        final JComboBox comboBox3 = new JComboBox();
        panel1.add(comboBox3, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, -1), null, new Dimension(60, -1), 0, false));
        final JComboBox comboBox4 = new JComboBox();
        panel1.add(comboBox4, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, -1), null, new Dimension(60, -1), 0, false));
        comboBox1 = new JComboBox();
        comboBox1.setEditable(false);
        panel1.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, -1), null, new Dimension(60, -1), 0, false));
        textField1 = new JTextField();
        panel1.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        textField2 = new JTextField();
        panel1.add(textField2, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        inWinkelwagenPlaatsenButton = new JButton();
        inWinkelwagenPlaatsenButton.setBackground(new Color(-54151));
        inWinkelwagenPlaatsenButton.setEnabled(true);
        Font inWinkelwagenPlaatsenButtonFont = this.getFon("Dubai", -1, 17, inWinkelwagenPlaatsenButton.getFont());
        if (inWinkelwagenPlaatsenButtonFont != null)
            inWinkelwagenPlaatsenButton.setFont(inWinkelwagenPlaatsenButtonFont);
        inWinkelwagenPlaatsenButton.setForeground(new Color(-1));
        inWinkelwagenPlaatsenButton.setHideActionText(false);
        inWinkelwagenPlaatsenButton.setText("In winkelwagen plaatsen");
        panel1.add(inWinkelwagenPlaatsenButton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 5), new Dimension(240, 40), new Dimension(-1, 100), 0, false));
        imagebloem.setText("");
        panel1.add(imagebloem, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        imagepasta.setText("");
        panel1.add(imagepasta, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font getFon(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return bestellingpane;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        imagebloem = new JLabel(new ImageIcon("bloemkool.jpg"));
        imagepasta = new JLabel(new ImageIcon("pasta.jpg"));

    }

    public JPanel getBestellingpane() {
        return bestellingpane;
    }


}
