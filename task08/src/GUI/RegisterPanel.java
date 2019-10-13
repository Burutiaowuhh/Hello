/*
 * Created by JFormDesigner on Tue Oct 08 14:06:36 CST 2019
 */

package GUI;

import Excepton.ATMException;
import net.miginfocom.swing.MigLayout;
import service.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Brainrain
 */
public class RegisterPanel extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label7;
    private JComboBox<String> accounttype;
    private JTextField username;
    private JPasswordField userpassword;
    private JPasswordField passwordagain;
    private JTextField personId;
    private JTextField email;
    private JButton submit;
    private JButton back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public RegisterPanel() {
        initComponents();
    }

    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        accounttype = new JComboBox<>();
        username = new JTextField();
        userpassword = new JPasswordField();
        passwordagain = new JPasswordField();
        personId = new JTextField();
        email = new JTextField();
        submit = new JButton();
        back = new JButton();

        //======== this ========
        setTitle("BAM Client");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[fill]",
                // rows
                "[fill]" +
                "[]" +
                "[]" +
                "[]"));
        }
        contentPane.add(panel1);
        panel1.setBounds(new Rectangle(new Point(215, 115), panel1.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u8d26\u6237\u7c7b\u578b\uff1a");
        contentPane.add(label1);
        label1.setBounds(125, 30, label1.getPreferredSize().width, 18);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d:");
        contentPane.add(label2);
        label2.setBounds(125, 65, 60, 18);

        //---- label3 ----
        label3.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label3);
        label3.setBounds(125, 100, 60, 18);

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(125, 135), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        contentPane.add(label5);
        label5.setBounds(125, 170, 60, 17);

        //---- label7 ----
        label7.setText("E-mail:");
        contentPane.add(label7);
        label7.setBounds(125, 210, 60, 17);

        //---- accounttype ----
        accounttype.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u50a8\u84c4\u8d26\u6237",
            "\u4fe1\u7528\u8d26\u6237"
        }));
        contentPane.add(accounttype);
        accounttype.setBounds(240, 30, 125, accounttype.getPreferredSize().height);
        contentPane.add(username);
        username.setBounds(240, 65, 125, username.getPreferredSize().height);
        contentPane.add(userpassword);
        userpassword.setBounds(240, 100, 125, userpassword.getPreferredSize().height);
        contentPane.add(passwordagain);
        passwordagain.setBounds(240, 135, 125, passwordagain.getPreferredSize().height);
        contentPane.add(personId);
        personId.setBounds(240, 170, 125, personId.getPreferredSize().height);
        contentPane.add(email);
        email.setBounds(240, 205, 125, email.getPreferredSize().height);

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.addActionListener(e -> submitActionPerformed(e));
        contentPane.add(submit);
        submit.setBounds(140, 255, 75, submit.getPreferredSize().height);

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.addActionListener(e -> backActionPerformed(e));
        contentPane.add(back);
        back.setBounds(250, 255, 80, back.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(535, 370));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    private void submitActionPerformed(ActionEvent e) throws ATMException {
        // TODO add your code here
//        String password,String name,String personId,String email,boolean accounttpye
        boolean act;
        String acty=accounttype.getSelectedItem().toString();
        if(acty.equals("储蓄账户")){
            act=false;
        }else{
            act=true;
        }
        String name=username.getText().toString();
        String password= String.valueOf(userpassword.getPassword());
        System.out.println(password);
        String password2=passwordagain.getPassword().toString();
        String perId=personId.getText().toString();
        String emailid=email.getText().toString();
        if(password.equals(password2)){
            System.out.println(password+"    "+password2);
            System.out.println("两次密码输入不一致，请重新输入!");
        }else{
            Bank bank=Bank.getBank();
            bank.register(password,name,perId,emailid,act);
            LoginPanel loginPanel=new LoginPanel();
            loginPanel.setVisible(true);
            this.dispose();
        }

    }


}
