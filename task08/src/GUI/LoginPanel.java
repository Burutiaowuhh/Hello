/*
 * Created by JFormDesigner on Tue Oct 08 19:00:05 CST 2019
 */

package GUI;

import Excepton.ATMException;
import Excepton.LoginException;
import service.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Brainrain
 */
public class LoginPanel extends JFrame{

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField userId;
    private JPasswordField userpassword;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public LoginPanel() throws ATMException {
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }



    private void initComponents() throws ATMException{
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        userId = new JTextField();
        userpassword = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("BAM Client");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u8d26\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(100, 65, 65, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7528\u6237\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(100, 110, 65, label2.getPreferredSize().height);
        contentPane.add(userId);
        userId.setBounds(170, 60, 125, userId.getPreferredSize().height);
        contentPane.add(userpassword);
        userpassword.setBounds(170, 105, 125, userpassword.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (ATMException e1) {
                e1.printStackTrace();
            }
        });
        contentPane.add(button1);
        button1.setBounds(105, 165, 70, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(200, 165, 75, button2.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(415, 310));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



    private void button1ActionPerformed(ActionEvent e) throws ATMException{
        // TODO add your code here

        long userid= Long.parseLong(userId.getText());
        String password= String.valueOf(userpassword.getPassword());
        System.out.println(password);
        Bank bank=Bank.getBank();
        if(bank.login(userid,password)==null){
            throw new LoginException("用户名或密码错误");
        }else {

            BusinessPanel businessPanel=new BusinessPanel();
            businessPanel.setAccount(bank.login(userid,password));
            businessPanel.show1(bank.login(userid,password));
            businessPanel.setVisible(true);
            this.dispose();
        }

    }
}
