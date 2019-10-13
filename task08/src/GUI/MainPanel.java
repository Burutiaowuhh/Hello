package GUI;

import Excepton.ATMException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/*
 * Created by JFormDesigner on Tue Oct 08 13:06:07 CST 2019
 */



/**
 * @author unknown
 */
public class MainPanel extends JFrame {
    public MainPanel() {
        initComponents();
    }

    private void registerActionPerformed(ActionEvent e) {
        // TODO add your code here
        RegisterPanel registerPanel=new RegisterPanel();
        registerPanel.setVisible(true);

    }

    private void loginActionPerformed(ActionEvent e) throws ATMException {
        // TODO add your code here
        LoginPanel loginPanel=new LoginPanel();
        loginPanel.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        title = new JLabel();
        register = new JButton();
        login = new JButton();

        //======== this ========
        setTitle("BAM Client");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- title ----
            title.setText("\u6a21\u62df  ICBC  ATM  \u7ec8\u7aef");
            title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 9f));
            panel1.add(title);
            title.setBounds(145, 40, 240, 120);

            //---- register ----
            register.setText("\u6ce8\u518c");
            register.addActionListener(e -> {
			registerActionPerformed(e);
		});
            panel1.add(register);
            register.setBounds(125, 210, 90, 63);

            //---- login ----
            login.setText("\u767b\u5f55");
            login.addActionListener(e -> {
                try {
                    loginActionPerformed(e);
                } catch (ATMException e1) {
                    e1.printStackTrace();
                }
            });
            panel1.add(login);
            login.setBounds(280, 210, 95, 65);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 528, 383);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel title;
    private JButton register;
    private JButton login;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
