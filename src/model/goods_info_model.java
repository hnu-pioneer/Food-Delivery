package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.*;

/**
 *
 * @author ReinoYuki
 */
public class goods_info_model extends AbstractTableModel{

    Vector rowData,columnNames;
            
    //Variable
    Statement stat = null;
    Connection ct = null;
    ResultSet rs = null;
    
    //Init
    public void init(String sql){
        if(sql.equals("")){
            sql = "select * from goods_info";
        }
        //Set column name
        columnNames = new Vector();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Price");
        columnNames.add("Description");
        //rowData存放多行
        rowData = new Vector();
        try
        {
            //Driver
            Class.forName("com.mysql.jdbc.Driver");
            //Connect db
            String url = "jdbc:mysql://localhost:3306/db_Pioneer";
            String user = "root";
            String passwd = "123456";
                        
            ct = DriverManager.getConnection(url,user,passwd);
            stat = ct.createStatement();//Create stat object
            rs = stat.executeQuery(sql);//Search
                        
            while(rs.next())
            {
                Vector hang = new Vector();
                hang.add(rs.getInt(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getDouble(4));
                rowData.add(hang);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
                if(stat != null)
                {
                    stat.close();
                    stat = null;
                }
            if(ct != null)
            {
                ct.close();
                ct = null;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    }
    
    public void addinfo(String sql){
        //根据用户输入的sql语句，完成添加任务
    }
    
    //第二个构造函数，通过传递的sql语句来获得数据模型
    public goods_info_model(String sql){
        this.init(sql);
    }
    
    //构造函数，用于初始化数据模型
    public goods_info_model(){
        this.init("");
    }
    
    //得到共有多少行
    public int getRowCount() {
        return this.rowData.size();
    }

    //得到共有多少列
    public int getColumnCount() {
        return this.columnNames.size();
    }

    //得到某行某列的数据
    public Object getValueAt(int row, int column) {
        return ((Vector)(this.rowData.get(row))).get(column);
    }
    
    //得到属性名字
    public String getColumnName(int column) {
        return (String)this.columnNames.get(column);
    }
}