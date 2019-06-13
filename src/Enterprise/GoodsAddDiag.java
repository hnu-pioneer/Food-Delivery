package Enterprise;

import javax.swing.JDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class GoodsAddDiag extends JDialog implements ActionListener {
    JLabel L_id, L_name, L_price, L_desc;
    JTextField T_id, T_name, T_price, T_desc;
    JButton B_OK, B_Cancel;

    public GoodsAddDiag(Frame owner,String title, boolean modal){
        super(owner,title,modal);
        
        L_id = new JLabel("ID:");
        L_name = new JLabel("Name:");
        L_price = new JLabel("Price");    
        L_desc = new JLabel("Description");
        
        T_id = new JTextField();
        T_id.setText("Auto");
        T_id.setEditable(false);
        T_name = new JTextField();
        T_price = new JTextField();
        T_desc = new JTextField();
        
        B_OK = new JButton("Add");
        B_OK.addActionListener(this);
        
        L_id.setBounds(8, 8, 48, 24);
        L_name.setBounds(8, 36, 48, 24);
        L_price.setBounds(8, 92, 48, 24);
        L_desc.setBounds(8, 64, 48, 24);
        T_id.setBounds(56, 8, 160, 24);
        T_name.setBounds(56, 36, 160, 24);
        T_price.setBounds(56, 92, 160, 24);
        T_desc.setBounds(56, 64, 160, 24);
        B_OK.setBounds(8, 120, 208, 24);
        
        this.add(L_id);
        this.add(L_name);
        this.add(L_price);
        this.add(L_desc);
        this.add(T_id);
        this.add(T_name);
        this.add(T_price);
        this.add(T_desc);
        this.add(B_OK);
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setSize(240,188);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == B_OK){
            Connection ct = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/db_Pioneer";
                String user = "root";
                String passwd = "123456";
                ct = DriverManager.getConnection(url,user,passwd);
            
                String strsql = "insert into goods_info (StoreName, Desc, Price) values(?,?,?)";
                ps = ct.prepareStatement(strsql);
                
                ps.setString(1, T_name.getText());
                ps.setString(2, T_desc.getText());
                ps.setDouble(3, Double.parseDouble(T_price.getText()));
                
                ps.executeUpdate();
                
                this.dispose();
            }
            catch(Exception arg1)
            {
                arg1.printStackTrace();
            }
            finally
            {
                try
                {
                    if(rs!=null)
                    {
                        rs.close();
                        rs = null;
                    }
                    if(ps != null)
                    {
                        ps.close();
                        ps = null;
                    }
                    if(ct != null)
                    {
                        ct.close();
                        ct = null;
                        }                
                    }
                catch(Exception arg2)
                {
                    arg2.printStackTrace();
                }
            }
        }
    }
    
    
}