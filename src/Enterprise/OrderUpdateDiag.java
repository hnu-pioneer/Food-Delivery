package Enterprise;

import model.order_info_model;
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

public class OrderUpdateDiag extends JDialog implements ActionListener {
    JLabel L_id, L_sta;
    JComboBox C_sta;
    JTextField T_id;
    JButton B_OK, B_Cancel;
    public OrderUpdateDiag(Frame owner,String title, boolean modal, order_info_model om, int rowNum){
        super(owner,title,modal);
        
        String[] sta = {"Canceled", "Waiting", "Prepare", "Making", "Take", "Delivering", "Finished"};
        L_sta = new JLabel("Status:");
        L_id = new JLabel("ID:");
        T_id = new JTextField();
        C_sta = new JComboBox();
        
        for(int i = 0; i < 7;i++)
            C_sta.addItem(sta[i]);
	C_sta.setEditable(false);
        T_id.setEditable(false);
        C_sta.setSelectedIndex(Integer.parseInt((om.getValueAt(rowNum, 5)).toString()));
        B_OK = new JButton("Update");
        B_OK.addActionListener(this);
        T_id.setText((om.getValueAt(rowNum, 0)).toString());
        L_id.setBounds(8, 8, 48, 24);
        T_id.setBounds(56, 8, 160, 24);
        L_sta.setBounds(8, 36, 48, 24);
        C_sta.setBounds(56, 36, 160, 24);
        B_OK.setBounds(8, 120, 208, 24);
        
        this.add(L_id);
        this.add(L_sta);
        this.add(T_id);
        this.add(C_sta);
        this.add(B_OK);
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setSize(240,188);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
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
                String strsql = "update order_info set Status=? where ID = ?";
                ps = ct.prepareStatement(strsql);
                
                ps.setInt(1, C_sta.getSelectedIndex());
                ps.setInt(2, Integer.parseInt(T_id.getText()));
                ps.executeUpdate();
                
                this.dispose();
            }catch(Exception arg1){
                arg1.printStackTrace();
            }finally{
                try{
                if(rs!=null){
                rs.close();
                rs = null;
                    }
                if(ps != null){
                ps.close();
                ps = null;
                    }
                if(ct != null){
                ct.close();
                ct = null;
                    }                
                }catch(Exception arg2){
                    arg2.printStackTrace();
                }
            }
        }
    }
    
    
}