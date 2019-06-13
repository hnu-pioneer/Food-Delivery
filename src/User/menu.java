package User;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import model.goodsorder_info_model;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.TableModel;

/**
 *
 * @author ReinoYuki
 */

/*
------------------------Readme
Sorry, because Ma's computer has broken, his can't 
submit his part. We have no time to repair it so 
that some function could not use.
------------------------End
*/

public class menu{
    static JButton B_buy = new JButton("Order");
    static JTextField T_Address = new JTextField();
    static JTable T_Goods;
    static goodsorder_info_model m = new goodsorder_info_model();
    static JFrame window = new JFrame();
    static JLabel L_title = new JLabel("Menu");
    static JLabel L_Address = new JLabel("Address:");
    public menu (String UserName) {
        T_Goods = new JTable(m);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        L_title.setBounds(8, 8, 384, 40);
        //L_Address.setBounds()
        T_Goods.setBounds(8, 48, 768, 428);
        
        T_Goods.getColumnModel().getColumn(0).setPreferredWidth(5);
        T_Goods.getColumnModel().getColumn(1).setPreferredWidth(120);
        T_Goods.getColumnModel().getColumn(2).setPreferredWidth(588);
        T_Goods.getColumnModel().getColumn(3).setPreferredWidth(50);
        T_Goods.getColumnModel().getColumn(4).setPreferredWidth(5);
        
        L_Address.setBounds(8, 508, 96, 24);
        T_Address.setBounds(104, 508, 320, 24);
        B_buy.setBounds(8, 536, 768, 24);
        window.add(T_Goods);
        window.add(L_title);
        window.add(L_Address);
        window.add(T_Address);
        window.add(B_buy);
        
         L_title.setForeground(Color.blue);
         L_title.setFont(new java.awt.Font("Arial", 1, 24));
        
        //设置窗体可见
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                UserSurface us = new UserSurface(UserName);
            }
        });
        B_buy.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int rowNum = T_Goods.getSelectedRow();
                if(rowNum == -1) {
                    return;
                }
                Connection ct = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/db_Pioneer";
                    String user = "root";
                    String passwd = "123456";
                    ct = DriverManager.getConnection(url,user,passwd);
            
                    String strsql = "insert into order_info (TimeStamp, UserName, Address, OrderThings, Status) values(?,?,?,?,?)";
                    ps = ct.prepareStatement(strsql);
                    
                    Timestamp d = new Timestamp(System.currentTimeMillis()); 
                    ps.setTimestamp(1, d);
                    ps.setString(2, UserName);
                    ps.setString(3, T_Address.getText());
                    ps.setString(4, m.getValueAt(rowNum, 4).toString());
                    ps.setInt(5, 1);
                
                    ps.executeUpdate();
                
                    window.dispose();
                    UserSurface us = new UserSurface(UserName);
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
        }); 
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_Pioneer";
        String user = "root";
         String password = "123456";
        try
        {
             Class.forName(driver);
             con = DriverManager.getConnection(url,user,password);
             if(!con.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
             Statement statement = con.createStatement();
             String sql = "select * from store_info";
             ResultSet rs = statement.executeQuery(sql);
        }
         catch(Exception e){
             System.out.println(e);
         }
    }
}