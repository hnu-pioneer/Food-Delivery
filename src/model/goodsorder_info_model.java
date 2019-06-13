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
public class goodsorder_info_model extends AbstractTableModel{

    //rowData存放行数据，columnNames存放列名
    Vector rowData,columnNames;
            
    //定义连接数据库的变量
    Statement stat = null;
    Connection ct = null;
    ResultSet rs = null;
    
    //初始化
    public void init(String sql){
        if(sql.equals("")){
            sql = "select * from goods_info";
        }
        //中间
        //设置列名
        columnNames = new Vector();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Price");
        columnNames.add("Description");
        columnNames.add("Quantity");
        //rowData存放多行
        rowData = new Vector();
        try
        {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.连接数据库
            //定义几个常量
            String url = "jdbc:mysql://localhost:3306/db_Pioneer";
            String user = "root";
            String passwd = "123456";
                        
            ct = DriverManager.getConnection(url,user,passwd);
            stat = ct.createStatement();//创建stat对象
            rs = stat.executeQuery(sql);//查询结果
                        
            while(rs.next())
            {
                Vector hang = new Vector();
                hang.add(rs.getInt(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getDouble(4));
                hang.add(0);
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
    
    //增加学生函数
    public void addinfo(String sql){
        //根据用户输入的sql语句，完成添加任务
    }
    
    //第二个构造函数，通过传递的sql语句来获得数据模型
    public goodsorder_info_model(String sql){
        this.init(sql);
    }
    
    //构造函数，用于初始化数据模型
    public goodsorder_info_model(){
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) { }
}