/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSyste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 17433
 */
public class Customer_registration_interface extends javax.swing.JFrame {

    /**
     * Creates new form MerchantLoginInterface
     */
    public Customer_registration_interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customer_nickname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        customer_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        custom_address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        customer_gender_male = new javax.swing.JRadioButton();
        customer_gender_female = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        customer_password1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        customer_password2 = new javax.swing.JPasswordField();
        next_c = new javax.swing.JButton();
        return_cli_mi = new javax.swing.JButton();
        custom_mobile1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 250, 248));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(251, 250, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("华文隶书", 0, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, -1));

        jLabel3.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 150, 40));

        customer_nickname.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        customer_nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_nicknameActionPerformed(evt);
            }
        });
        jPanel1.add(customer_nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 410, -1));

        jLabel4.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 40));

        customer_name.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_nameActionPerformed(evt);
            }
        });
        jPanel1.add(customer_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 410, -1));

        jLabel5.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Phone");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 40));

        custom_address.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        custom_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_addressActionPerformed(evt);
            }
        });
        jPanel1.add(custom_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 410, -1));

        jLabel6.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sex");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 40));

        buttonGroup1.add(customer_gender_male);
        customer_gender_male.setFont(new java.awt.Font("幼圆", 1, 25)); // NOI18N
        customer_gender_male.setSelected(true);
        customer_gender_male.setText("Male");
        customer_gender_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_gender_maleActionPerformed(evt);
            }
        });
        jPanel1.add(customer_gender_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 200, -1));

        buttonGroup1.add(customer_gender_female);
        customer_gender_female.setFont(new java.awt.Font("幼圆", 1, 25)); // NOI18N
        customer_gender_female.setText("Female");
        customer_gender_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_gender_femaleActionPerformed(evt);
            }
        });
        jPanel1.add(customer_gender_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 210, -1));

        jLabel7.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, 40));

        jLabel8.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 40));

        customer_password1.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        customer_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_password1ActionPerformed(evt);
            }
        });
        jPanel1.add(customer_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 410, 40));

        jLabel9.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Confirm");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 150, 40));

        customer_password2.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        customer_password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_password2ActionPerformed(evt);
            }
        });
        jPanel1.add(customer_password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 410, 40));

        next_c.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        next_c.setText("OK");
        next_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next_cMouseClicked(evt);
            }
        });
        next_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_cActionPerformed(evt);
            }
        });
        jPanel1.add(next_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        return_cli_mi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginSyste/back.png"))); // NOI18N
        return_cli_mi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                return_cli_miMouseClicked(evt);
            }
        });
        jPanel1.add(return_cli_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 50, 50));

        custom_mobile1.setFont(new java.awt.Font("幼圆", 1, 30)); // NOI18N
        custom_mobile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_mobile1ActionPerformed(evt);
            }
        });
        jPanel1.add(custom_mobile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 410, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custom_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custom_addressActionPerformed

    private void customer_password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_password2ActionPerformed

    private void customer_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_password1ActionPerformed

    private void next_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_next_cActionPerformed

    private void customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_nameActionPerformed

    private void customer_gender_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_gender_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_gender_maleActionPerformed

    private void customer_gender_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_gender_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_gender_femaleActionPerformed

    private void next_cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_cMouseClicked
        // TODO add your handling code here:
        Connection con;
        PreparedStatement ps = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_Pioneer";
        String user = "root";
        String password = "123456";
        if(customer_nickname.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "You have to have a user name!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("No username");
            return;
        } else if(customer_name.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "You have to have a name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(custom_mobile1.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "You have to have a phone number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(custom_address.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "You have to have a address!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(customer_password1.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "You have to have a password!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(customer_password2.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "You have to confirm your password!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(customer_password1.getText().trim().equals(customer_password2.getText()) == false) {
            JOptionPane.showMessageDialog(this, "The two password you enter are not same!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else
        {
            try
            {
                Class.forName(driver);
                con = DriverManager.getConnection(url,user,password);
                if(!con.isClosed())
                    System.out.println("Succeeded connecting to the Database!");
                Statement statement = con.createStatement();
                String sql = "select * from user_info";
                ResultSet rs = statement.executeQuery(sql);
            
                String UserName = null;
                while(rs.next())
                {
                    UserName = rs.getString("UserName");
                    if(UserName.equals(customer_nickname.getText()))
                    {
                        JOptionPane.showConfirmDialog(this, "This user name has already existed!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                sql = "insert into user_info (UserName, Password, Sex, Phone, Address) values(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                
                ps.setString(1, customer_nickname.getText());
                ps.setString(2, customer_password1.getText());
                if(customer_gender_female.isSelected()) ps.setInt(3, 1);
                else ps.setInt(3, 0);
                ps.setString(4, custom_mobile1.getText());
                ps.setString(5, custom_address.getText());
                
                ps.executeUpdate();
                rs.close();
                con.close();
            }
            catch(ClassNotFoundException e)
            {   
                e.printStackTrace();   
            }
            catch(SQLException e)
            {
                e.printStackTrace();  
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally{ }
            JOptionPane.showMessageDialog(this, "You have finished registration!", "Finished", JOptionPane.DEFAULT_OPTION);
        }
        
    }//GEN-LAST:event_next_cMouseClicked

    private void return_cli_miMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_return_cli_miMouseClicked
        // TODO add your handling code here:
        Customer_Login_Interface cli = new Customer_Login_Interface();
        cli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_return_cli_miMouseClicked

    private void customer_nicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_nicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_nicknameActionPerformed

    private void custom_mobile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_mobile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custom_mobile1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static final String URL = "jdbc:mysql://localhost/Poineer_Food_Delivery;user=root;password=NIIT122525";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.Driver");
            Connection con = DriverManager.getConnection(URL);
            if (!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer_registration_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_registration_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_registration_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_registration_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_registration_interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField custom_address;
    private javax.swing.JTextField custom_mobile1;
    private javax.swing.JRadioButton customer_gender_female;
    private javax.swing.JRadioButton customer_gender_male;
    private javax.swing.JTextField customer_name;
    private javax.swing.JTextField customer_nickname;
    private javax.swing.JPasswordField customer_password1;
    private javax.swing.JPasswordField customer_password2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton next_c;
    private javax.swing.JButton return_cli_mi;
    // End of variables declaration//GEN-END:variables
}