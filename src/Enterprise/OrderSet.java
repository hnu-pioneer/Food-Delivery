package Enterprise;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import model.order_info_model;
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
/**
 *
 * @author ReinoYuki
 */
public class OrderSet{
    //生成窗体
    static JFrame window = new JFrame("Order Management");
    //生成组件
    static JLabel L_title = new JLabel("Merchant Order");
    static JTable T_Goods;
    static JButton B_update = new JButton("Update");
    static JButton B_Cancel = new JButton("Cancel");
    
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/db_Pioneer";
    static String user = "root";
    static String password = "123456";
    
    static order_info_model om = new order_info_model();
    public OrderSet(String UserName) {
        T_Goods = new JTable(om);
        
        window.setSize(608, 396);
        window.setLocationRelativeTo(null);
        //设置组件位置
        L_title.setBounds(8, 8, 288, 28);
        
        T_Goods.setBounds(8, 40, 580, 284);
        T_Goods.getColumnModel().getColumn(0).setPreferredWidth(10);
        T_Goods.getColumnModel().getColumn(1).setPreferredWidth(120);
        T_Goods.getColumnModel().getColumn(2).setPreferredWidth(10);
        T_Goods.getColumnModel().getColumn(4).setPreferredWidth(60);
        T_Goods.getColumnModel().getColumn(5).setPreferredWidth(10);
        
        B_update.setBounds(8, 328, 288, 24);
        B_Cancel.setBounds(302, 328, 288, 24);
        
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                EnterpriseSurface ES = new EnterpriseSurface(UserName);
            }
        });
        //添加组件事件
        B_Cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                EnterpriseSurface ES = new EnterpriseSurface(UserName);
		window.dispose();
            }
        });
        //组件塞入窗口
        window.add(L_title);
        window.add(T_Goods);
        window.add(B_update);
        window.add(B_Cancel);
        //设置窗体可见
        window.setLayout(null);
        window.setVisible(true);
        
       
        B_update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int rowNum = T_Goods.getSelectedRow();
            if(rowNum == -1)
                {
                    return ;
                }
                OrderUpdateDiag od = new OrderUpdateDiag(window,"Update Order",true,om,rowNum);
                om = new order_info_model();
                T_Goods.setModel(om);
            }
        });
    }
}