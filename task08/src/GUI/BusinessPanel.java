/*
 * Created by JFormDesigner on Tue Oct 08 19:03:13 CST 2019
 */

package GUI;

import Excepton.ATMException;
import model.Account;
import model.CreditAccount;
import service.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Brainrain
 */
public class BusinessPanel extends JFrame {
    public BusinessPanel() {
        initComponents();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel userid;
    private JLabel label2;
    private JLabel username;
    private JLabel label3;
    private JLabel balance;
    private JLabel label4;
    private JLabel over;
    private JLabel label5;
    private JLabel loanmoney;
    private JComboBox<String> type;
    private JTextField getmoney;
    private JButton submit;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private void submitActionPerformed(ActionEvent e) throws ATMException {
        // TODO add your code here
        Bank bank = Bank.getBank();
        double money = Double.parseDouble(getmoney.getText());
        String Strtype = type.getSelectedItem().toString();
        switch (Strtype) {
            case "存款":
                show1(bank.deposit(account.getId(), money));
                break;
            case "取款":
                show1(bank.withdraw(account.getId(), money));
                break;
            case "贷款":
                show1(bank.loanMoney(account.getId(), money));
                break;
            case "还贷":
                show1(bank.payloan(account.getId(), money));
                break;
            default:
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void initComponents() {


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        userid = new JLabel();
        label2 = new JLabel();
        username = new JLabel();
        label3 = new JLabel();
        balance = new JLabel();
        label4 = new JLabel();
        over = new JLabel();
        label5 = new JLabel();
        loanmoney = new JLabel();
        type = new JComboBox<>();
        getmoney = new JTextField();
        submit = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("BAM Client");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u6237\uff1a");
        contentPane.add(label1);
        label1.setBounds(108, 35, 87, label1.getPreferredSize().height);

        //---- userid ----
        userid.setText("text");
        contentPane.add(userid);
        userid.setBounds(229, 35, 135, userid.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(108, 59, 60, label2.getPreferredSize().height);

        //---- username ----
        username.setText("text");
        contentPane.add(username);
        username.setBounds(229, 59, 135, username.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u4f59\u989d\uff1a");
        contentPane.add(label3);
        label3.setBounds(108, 83, 60, label3.getPreferredSize().height);

        //---- balance ----
        balance.setText("text");
        contentPane.add(balance);
        balance.setBounds(229, 83, 135, balance.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u4fe1\u7528\u989d\u5ea6\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(108, 107), label4.getPreferredSize()));

        //---- over ----
        over.setText("text");
        contentPane.add(over);
        over.setBounds(229, 107, 135, over.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u8d37\u6b3e\u989d\uff1a");
        contentPane.add(label5);
        label5.setBounds(108, 131, 60, label5.getPreferredSize().height);

        //---- loanmoney ----
        loanmoney.setText("text");
        contentPane.add(loanmoney);
        loanmoney.setBounds(229, 131, 135, loanmoney.getPreferredSize().height);

        //---- type ----
        type.setModel(new DefaultComboBoxModel<>(new String[]{
                "\u5b58\u6b3e",
                "\u53d6\u6b3e",
                "\u8d37\u6b3e",
                "\u8fd8\u8d37"
        }));
        contentPane.add(type);
        type.setBounds(108, 155, 60, type.getPreferredSize().height);
        contentPane.add(getmoney);
        getmoney.setBounds(229, 156, 135, getmoney.getPreferredSize().height);

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.addActionListener(e -> {
            try {
                submitActionPerformed(e);
            } catch (ATMException e1) {
                e1.printStackTrace();
            }
        });
        contentPane.add(submit);
        submit.setBounds(108, 189, 60, submit.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(229, 189), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(445, 290));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    public void show1(Account account) {

        if (account.isAccountType() == true) {
            CreditAccount creditAccount = new CreditAccount();
            creditAccount = (CreditAccount) account;

            userid.setText(String.valueOf(account.getId()));
            username.setText(creditAccount.getName());
            balance.setText(String.valueOf(account.getBalance()));
            over.setText(String.valueOf(creditAccount.getCeiling()));
            loanmoney.setText(String.valueOf(account.getLoanMoney()));
        } else {
            userid.setText(String.valueOf(account.getId()));
            username.setText(account.getName());
            balance.setText(String.valueOf(account.getBalance()));
            over.setText("0");
            loanmoney.setText(String.valueOf(account.getLoanMoney()));
        }


    }


}
