/*
 * Created by JFormDesigner on Tue Oct 08 19:03:13 CST 2019
 */

package GUI;

import Excepton.ATMException;
import model.Account;
import model.CreditAccount;
import net.miginfocom.swing.MigLayout;
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
        contentPane.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[fill]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        //---- label1 ----
        label1.setText("\u8d26\u6237\uff1a");
        contentPane.add(label1, "cell 4 5 2 1");

        //---- userid ----
        userid.setText("text");
        contentPane.add(userid, "cell 7 5 4 1");

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        contentPane.add(label2, "cell 4 6");

        //---- username ----
        username.setText("text");
        contentPane.add(username, "cell 7 6 4 1");

        //---- label3 ----
        label3.setText("\u4f59\u989d\uff1a");
        contentPane.add(label3, "cell 4 7");

        //---- balance ----
        balance.setText("text");
        contentPane.add(balance, "cell 7 7 4 1");

        //---- label4 ----
        label4.setText("\u4fe1\u7528\u989d\u5ea6\uff1a");
        contentPane.add(label4, "cell 4 8");

        //---- over ----
        over.setText("text");
        contentPane.add(over, "cell 7 8 4 1");

        //---- label5 ----
        label5.setText("\u8d37\u6b3e\u989d\uff1a");
        contentPane.add(label5, "cell 4 9");

        //---- loanmoney ----
        loanmoney.setText("text");
        contentPane.add(loanmoney, "cell 7 9 4 1");

        //---- type ----
        type.setModel(new DefaultComboBoxModel<>(new String[]{
                "\u5b58\u6b3e",
                "\u53d6\u6b3e",
                "\u8d37\u6b3e",
                "\u8fd8\u8d37"
        }));
        contentPane.add(type, "cell 4 10");
        contentPane.add(getmoney, "cell 7 10 4 1");

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.addActionListener(e -> {
            try {
                submitActionPerformed(e);
            } catch (ATMException e1) {
                e1.printStackTrace();
            }
        });
        contentPane.add(submit, "cell 4 11");

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, "cell 7 11");
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
