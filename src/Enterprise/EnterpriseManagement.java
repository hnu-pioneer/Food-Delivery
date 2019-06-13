package Enterprise;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import javax.swing.JDialog;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import model.goods_info_model;

/**
 *
 * @author ReinoYuki
 */
public class EnterpriseManagement{
    //生成窗体
    static JFrame window = new JFrame("Enterprise Management");
    //生成组件
    static JLabel L_title = new JLabel("Merchant Management");
    static JLabel L_id = new JLabel("ID:");
    static JLabel L_name = new JLabel("Name:");
    static JLabel L_phone = new JLabel("Phone:");
    static JLabel L_cate = new JLabel("Category:");
    static final JTextField T_id = new JTextField();
    static final JTextField T_name = new JTextField();
    static final JTextField T_phone = new JTextField();
    static final JTextField T_cate = new JTextField();
    static JTable T_Goods;
    static JButton B_add = new JButton("Add");
    static JButton B_update = new JButton("Update");
    static JButton B_delete = new JButton("Delete");
    static JButton B_OK = new JButton("OK");
    static JButton B_Cancel = new JButton("Cancel");
    
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/db_Pioneer";
    static String user = "root";
    static String password = "123456";
    
    static goods_info_model gm = new goods_info_model();
    public EnterpriseManagement(String UserName)
    {
        T_Goods = new JTable(gm);
        
        window.setSize(608, 396);
        window.setLocationRelativeTo(null);

        L_title.setBounds(8, 8, 288, 28);
        
        L_id.setBounds(8, 40, 48, 24);
        T_id.setBounds(56, 40, 240, 24);
        
        L_name.setBounds(300, 40, 48, 24);
        T_name.setBounds(348, 40, 240, 24);
        
        L_phone.setBounds(8, 68, 48, 24);
        T_phone.setBounds(56, 68, 240, 24);
        
        L_cate.setBounds(300, 68, 48, 24);
        T_cate.setBounds(348, 68, 240, 24);
        
        T_Goods.setBounds(8, 96, 580, 200);
        
        B_add.setBounds(8, 300, 190, 24);
        B_update.setBounds(203, 300, 190, 24);
        B_delete.setBounds(398, 300, 190, 24);
        B_OK.setBounds(8, 328, 288, 24);
        B_Cancel.setBounds(300, 328, 288, 24);
        
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                EnterpriseSurface ES = new EnterpriseSurface(UserName);
            }
        });
        B_Cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                EnterpriseSurface ES = new EnterpriseSurface(UserName);
		window.dispose();
            }
        });
        
        window.add(L_title);
        window.add(L_id);
        window.add(L_name);
        window.add(L_phone);
        window.add(L_cate);
        window.add(T_id);
        window.add(T_name);
        window.add(T_phone);
        window.add(T_cate);
        window.add(T_Goods);
        window.add(B_add);
        window.add(B_update);
        window.add(B_delete);
        window.add(B_OK);
        window.add(B_Cancel);

        window.setLayout(null);
        window.setVisible(true);
        
        try
        {
             Class.forName(driver);
             con = DriverManager.getConnection(url,user,password);
             if(!con.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
             Statement statement = con.createStatement();
             String sql = "select * from store_info";
             ResultSet rs = statement.executeQuery(sql);

             String StoreName = null;
             int id = 0;
             String Phone = null;
             String Category= null;
             while(rs.next())
             {
                 id = rs.getInt("ID");
                 StoreName = rs.getString("StoreName");
                 Phone = rs.getString("Phone");
                 Category = rs.getString("Category");
                 T_id.setText(String.valueOf(id));
                 T_name.setText(StoreName);
                 T_phone.setText(Phone);
                 T_cate.setText(Category);
             }
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
        
        B_OK.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
		con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                try{
                    Class.forName("com.mysql.jdbc.Driver");

                    String url = "jdbc:mysql://localhost:3306/db_Pioneer";
                    String user = "root";
                    String passwd = "123456";
                    con = DriverManager.getConnection(url,user,passwd);

                    String strsql = "Update store_info set StoreName=?, Phone=?, Category=? where ID=?";
                    System.out.println(strsql);
                    ps = con.prepareStatement(strsql);

                    ps.setInt(4, Integer.parseInt(T_id.getText()));
                    ps.setString(1, T_name.getText());
                    ps.setString(2, T_phone.getText());
                    ps.setString(3, T_cate.getText());
                    ps.executeUpdate();
                    window.dispose();
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
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
                        if(con != null)
                        {
                            con.close();
                            con = null;
                        }                
                    }
                    catch(Exception e2)
                    {
                        e2.printStackTrace();
                    }
                }
            }
        });
        
        B_add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                GoodsAddDiag gd = new GoodsAddDiag(window,"Add",true);
                gm = new goods_info_model();
                T_Goods.setModel(gm);
            }
        });
        
        B_update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int rowNum = T_Goods.getSelectedRow();
            if(rowNum == -1)
                {
                    return ;
                }
                GoodsUpdateDiag gd = new GoodsUpdateDiag(window,"Update",true,gm,rowNum);
                gm = new goods_info_model();
                T_Goods.setModel(gm);
            }
        });
        B_delete.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int rowNum = T_Goods.getSelectedRow();
                if(rowNum == -1)
                {
                    return;
                }
                int id = (int)gm.getValueAt(rowNum, 0);
                PreparedStatement ps = null;
                ResultSet rs = null;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");    
                    String url = "jdbc:mysql://localhost:3306/db_Pioneer";
                    String user = "root";
                    String passwd = "123456";
                    con = DriverManager.getConnection(url, user, passwd);
                    ps = con.prepareStatement("delete from goods_info where ID = ?");
                    ps.setInt(1,id);
                    ps.executeUpdate();
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
                finally
                {
                    try
                    {
                        if(rs!= null)
                        {
                            rs.close();
                            rs = null;
                        }
                        if(ps!= null)
                        {
                            ps.close();
                            ps = null;
                        }
                        if(con != null)
                        {
                            con.close();
                            con = null;
                        }
                    }
                    catch(Exception e2)
                    {
                        e2.printStackTrace();
                    }
                }
                gm = new goods_info_model();
                T_Goods.setModel(gm); 
            }
        });
    }
}