package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class mainmenu {
    private JPanel mainmenu;
    private JButton button1;
    private JCheckBox checkBox1;
    private JComboBox comboBox1;
    private JLabel labeltext1;
    public JLabel testlabel;
    String[] producten = { "Bloemkool", "Melk", "Kaas"};
    public String selectie;

     /*public static void main(String[] args) {
         JFrame frame = new JFrame("DRACA Vision");
        frame.setContentPane(new mainmenu().mainmenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }*/

    public mainmenu(){
        mainmenu = new JPanel();
        labeltext1 = new JLabel();
        labeltext1.setText("Voorraad:");
        checkBox1 = new JCheckBox();
        testlabel = new JLabel();
        comboBox1 = new JComboBox(producten);
        mainmenu.add(labeltext1);
        mainmenu.add(checkBox1);
        mainmenu.add(testlabel);
        mainmenu.add(comboBox1);



        checkBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                    //do something...
                    testlabel.setText("aangevinkt");
                } else {
                    testlabel.setText("uitgevinkt");
                    //checkbox has been deselected
                }



            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                 selectie  = (String)cb.getSelectedItem();
                 System.out.println(selectie);

                 }


            }
        );

    }

    public JPanel getMainmenu(){
        return mainmenu;
    }
}
