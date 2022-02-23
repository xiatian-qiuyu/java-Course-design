
import until.JDBC;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

    public class Main {
        public static void main (String[] args){
            //新建容器
            JFrame frame=new JFrame("通讯录管理系统");
            //设置大小
            frame.setSize(500,600);
            frame.setLocation(300,100);

            JTabbedPane jTabbedPane = new JTabbedPane();
            //通讯录表格
            JDBC con = new JDBC();
            final String[] Address_book={"名字","性别","生日","电话","分组","ID"};
            ResultSet resultSet = con.query("select FName,FSex,FBirthday,FPhone,GName,ID from flist");

            final Vector<Vector<Comparable>> vect = new Vector();//初始化向量

            //表格模型
            AbstractTableModel tm = new AbstractTableModel() {// 实现AbstractTableModel的抽象方法
                private static final long serialVersionUID = 1L;

                public int getColumnCount() {
                    return Address_book.length;
                }

                public int getRowCount() {
                    // TODO 自动生成的方法存根
                    return vect.size();
                }

                public Object getValueAt(int row, int column) {
                    // TODO 自动生成的方法存根
                    if (!vect.isEmpty())
                        return (((Vector<?>) vect.elementAt(row)).elementAt(column));
                    else
                        return null;
                }

                public String getColumnName(int column) {
                    return Address_book[column];// 设置表格列名
                }

                public void setValueAt(Object value, int row, int column) {
                }

                public Class<? extends Object> getColumnClass(int c) {
                    return getValueAt(0, c).getClass();
                }// 取得所属对象类

                public boolean isCellEditable(int row, int column) {

                    return false;
                }// 设置单元格不可编辑
            };

            JPanel tonxunlu = new JPanel();
            //新建基本信息表格类
            JTable Address_bookTable = new JTable(tm);//
            Address_bookTable.setToolTipText("显示通讯录信息");

            //信息表的表头
            //信息表自动调整
            Address_bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            //设置单元格分割线
            Address_bookTable.setShowHorizontalLines(true);

            Address_bookTable.setShowVerticalLines(true);

            //滚轮,将滚轮绑定表格
            JScrollPane scrollPane = new JScrollPane(Address_bookTable);

            //将获取到的数据加进表格中
            vect.removeAllElements();// 初始化向量对象

            tm.fireTableStructureChanged();// 更新表格内容

            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                @SuppressWarnings("rawtypes")
                Vector<Comparable> v = new Vector<Comparable>();
                try {
                    v.add(resultSet.getString(1));//
                    v.add(resultSet.getString(2));//
                    v.add(resultSet.getString(3));//
                    v.add(resultSet.getString(4));//
                    v.add(resultSet.getString(5));
                    v.add(resultSet.getString(6));
                    vect.add(v);
                    tm.fireTableStructureChanged();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            JTextField jTextField = new JTextField(8);
            //查找
            JButton jButton = new JButton("查找");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //con.query();
                    String text = jTextField.getText();
                    ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone,GName,Id from flist");
                    if(!text.equals("")){
                        query4 = con.query("select FName,FSex,FBirthday,FPhone,GName,Id from flist where FName=?", text);
                    }
                    //ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName from flist where FName=?", text);
                    //刷新页面
                    vect.removeAllElements();// 初始化向量对象
                    tm.fireTableStructureChanged();// 更新表格内容
                    while (true) {
                        try {
                            if (!query4.next()) break;
                        } catch (SQLException ec) {
                            ec.printStackTrace();
                        }
                        @SuppressWarnings("rawtypes")
                        Vector<Comparable> v = new Vector<Comparable>();
                        try {
                            v.add(query4.getString(1));
                            v.add(query4.getString(2));
                            v.add(query4.getDate(3));
                            v.add(query4.getString(4));
                            v.add(query4.getString(5));
                            v.add(query4.getString(6));
                            vect.add(v);
                            tm.fireTableStructureChanged();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            });

            tonxunlu.add(jTextField);
            tonxunlu.add(jButton);
            scrollPane.setPreferredSize(new Dimension(480,250));
            tonxunlu.add(scrollPane);
            JTextField jTextField1 = new JTextField(8);
            JTextField jTextField2 = new JTextField(12);
            JTextField jTextField3 = new JTextField(8);
            JTextField jTextField4 = new JTextField(12);
            JTextField jTextField5 = new JTextField(12);
            JTextField jTextField6 = new JTextField(12);

//            String valueAt;
//            String valueAt1;
//            String valueAt2;
//            String valueAt3;
//            String valueAt4;
            Address_bookTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getClickCount()==2){
                        int row = Address_bookTable.getSelectedRow();
                        String valueAt = String.valueOf(Address_bookTable.getValueAt(row, 0));
                        String valueAt1 = String.valueOf(Address_bookTable.getValueAt(row, 1));
                        String valueAt2 = String.valueOf(Address_bookTable.getValueAt(row, 2));
                        String valueAt3 = String.valueOf(Address_bookTable.getValueAt(row, 3));
                        String valueAt4 = String.valueOf(Address_bookTable.getValueAt(row, 4));
                        String valueAt5 = String.valueOf(Address_bookTable.getValueAt(row, 5));

                        jTextField1.setText(valueAt);
                        jTextField2.setText(valueAt1);
                        jTextField3.setText(valueAt2);
                        jTextField4.setText(valueAt3);
                        jTextField5.setText(valueAt4);
                        jTextField6.setText(valueAt5);

                    }
                }
            });

            //修改信息
            JButton update = new JButton("修改信息");
            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //con.query();
                    String text1= jTextField1.getText();
                    String text2= jTextField2.getText();
                    String text3= jTextField3.getText();
                    String text4= jTextField4.getText();
                    String text5= jTextField5.getText();
                    String text6= jTextField6.getText();
                    con.update("update flist set FName=? where id=? ",text6,text1);
                    con.update("update flist set Fsex=? where id=?",text6,text2);
                    con.update("update flist set FBirthday=? where id=?",text6,text3);
                    con.update("update flist set FPhone=? where id=?",text6,text4);
                    con.update("update flist set GName=? where id=?",text6,text5);
                    ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName,ID from flist" );
                    //ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName from flist where FName=?", text);
                    //刷新页面
                    vect.removeAllElements();// 初始化向量对象
                    tm.fireTableStructureChanged();// 更新表格内容
                    while (true) {
                        try {
                            if (!query4.next()) break;
                        } catch (SQLException ec) {
                            ec.printStackTrace();
                        }
                        @SuppressWarnings("rawtypes")
                        Vector<Comparable> v = new Vector<Comparable>();
                        try {
                            v.add(query4.getString(1));
                            v.add(query4.getString(2));
                            v.add(query4.getDate(3));
                            v.add(query4.getString(4));
                            v.add(query4.getString(5));
                            v.add(query4.getString(6));
                            vect.add(v);
                            tm.fireTableStructureChanged();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            });
           //删除
            JButton delete = new JButton("删除好友");
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //con.query();
                    String text = jTextField1.getText();
                    con.delete("delete from flist where FName=?",text);
                    ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName,ID from flist" );
                    //ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName from flist where FName=?", text);
                    //刷新页面
                    vect.removeAllElements();// 初始化向量对象
                    tm.fireTableStructureChanged();// 更新表格内容
                    while (true) {
                        try {
                            if (!query4.next()) break;
                        } catch (SQLException ec) {
                            ec.printStackTrace();
                        }
                        @SuppressWarnings("rawtypes")
                        Vector<Comparable> v = new Vector<Comparable>();
                        try {
                            v.add(query4.getString(1));
                            v.add(query4.getString(2));
                            v.add(query4.getDate(3));
                            v.add(query4.getString(4));
                            v.add(query4.getString(5));
                            v.add(query4.getString(6));
                            vect.add(v);
                            tm.fireTableStructureChanged();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            });



            tonxunlu.add(jTextField1);
            tonxunlu.add(jTextField2);
            tonxunlu.add(jTextField3);
            tonxunlu.add(jTextField4);
            tonxunlu.add(jTextField5);
            tonxunlu.add(jTextField6);
            tonxunlu.add(update);
            tonxunlu.add(delete);

            jTabbedPane.addTab("联系人",tonxunlu);



            //分组块
            final String[] Address_book1={"名字","性别","生日","电话","分组"};
            ResultSet resultSet1 = con.query("select FName,FSex,FBirthday,FPhone,GName from flist");

            final Vector<Vector<Comparable>> vect1 = new Vector();//初始化向量

            //表格模型
            AbstractTableModel tm1 = new AbstractTableModel() {// 实现AbstractTableModel的抽象方法
                private static final long serialVersionUID = 1L;

                public int getColumnCount() {
                    return Address_book1.length;
                }

                public int getRowCount() {
                    // TODO 自动生成的方法存根
                    return vect1.size();
                }

                public Object getValueAt(int row, int column) {
                    // TODO 自动生成的方法存根
                    if (!vect1.isEmpty())
                        return (((Vector<?>) vect1.elementAt(row)).elementAt(column));
                    else
                        return null;
                }

                public String getColumnName(int column) {
                    return Address_book1[column];// 设置表格列名
                }

                public void setValueAt(Object value, int row, int column) {
                }

                public Class<? extends Object> getColumnClass(int c) {
                    return getValueAt(0, c).getClass();
                }// 取得所属对象类

                public boolean isCellEditable(int row, int column) {

                    return false;
                }// 设置单元格不可编辑
            };
            JPanel fz = new JPanel();

            //新建基本信息表格类
            JTable Address_bookTable1 = new JTable(tm1);//
            Address_bookTable1.setToolTipText("显示通讯录信息");

            //信息表的表头
            //信息表自动调整
            Address_bookTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            //设置单元格分割线
            Address_bookTable1.setShowHorizontalLines(true);

            Address_bookTable1.setShowVerticalLines(true);

            //滚轮,将滚轮绑定表格
            JScrollPane scrollPane1 = new JScrollPane(Address_bookTable1);

            //将获取到的数据加进表格中
            vect1.removeAllElements();// 初始化向量对象

            tm1.fireTableStructureChanged();// 更新表格内容

            while (true) {
                try {
                    if (!resultSet1.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                @SuppressWarnings("rawtypes")
                Vector<Comparable> v = new Vector<Comparable>();
                try {
                    v.add(resultSet1.getString(1));//
                    v.add(resultSet1.getString(2));//
                    v.add(resultSet1.getDate(3));//
                    v.add(resultSet1.getString(4));//
                    v.add(resultSet1.getString(5));
                    vect1.add(v);
                    tm1.fireTableStructureChanged();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            JComboBox<String> stringJComboBox = new JComboBox<>();

            stringJComboBox.addItem("特别关心");
            stringJComboBox.addItem("同学");
            stringJComboBox.addItem("朋友");
            stringJComboBox.addItem("家人");
            stringJComboBox.addItem("工作");
            stringJComboBox.addItem("其他");
            stringJComboBox.setSelectedItem("特别关心");

            JButton search = new JButton("查询");
            JTextField content =new JTextField(8);
            JButton delete1 =new JButton("删除");
            Address_bookTable1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getClickCount()==2){
                        int row = Address_bookTable1.getSelectedRow();
                        String valueAt = String.valueOf(Address_bookTable1.getValueAt(row, 0));
                        content.setText(valueAt);
                    }
                }
            });
            delete1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //con.query();
                    String text = content.getText();
                    con.delete("delete from flist where FName=?",text);
                    ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName from flist" );
                    //ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName from flist where FName=?", text);
                    //刷新页面
                    vect1.removeAllElements();// 初始化向量对象
                    tm1.fireTableStructureChanged();// 更新表格内容
                    while (true) {
                        try {
                            if (!query4.next()) break;
                        } catch (SQLException ec) {
                            ec.printStackTrace();
                        }
                        @SuppressWarnings("rawtypes")
                        Vector<Comparable> v = new Vector<Comparable>();
                        try {
                            v.add(query4.getString(1));
                            v.add(query4.getString(2));
                            v.add(query4.getDate(3));
                            v.add(query4.getString(4));
                            v.add(query4.getString(5));
                            vect1.add(v);
                            tm1.fireTableStructureChanged();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            });
            search.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //con.query();
                    String text = stringJComboBox.getItemAt(stringJComboBox.getSelectedIndex());
                    ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone,GName from flist where GName=?",text);
                    //ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone,GName from flist where FName=?", text);
                    //刷新页面
                    vect1.removeAllElements();// 初始化向量对象
                    tm1.fireTableStructureChanged();// 更新表格内容
                    while (true) {
                        try {
                            if (!query4.next()) break;
                        } catch (SQLException ec) {
                            ec.printStackTrace();
                        }
                        @SuppressWarnings("rawtypes")
                        Vector<Comparable> v = new Vector<Comparable>();
                        try {
                            v.add(query4.getString(1));
                            v.add(query4.getString(2));
                            v.add(query4.getDate(3));
                            v.add(query4.getString(4));
                            v.add(query4.getString(5));
                            vect1.add(v);
                            tm1.fireTableStructureChanged();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            });
            fz.add(scrollPane1);
            scrollPane1.setPreferredSize(new Dimension(480,250));
            fz.add(stringJComboBox);
            fz.add(search);
            fz.add(content);
            fz.add(delete1);
            jTabbedPane.addTab("分组",fz);

            /*添加好友模块*/
            JPanel tianjai = new JPanel();
            JPanel tianjai1 = new JPanel();
            JPanel tianjai2= new JPanel();
            jTabbedPane.addTab("添加好友", tianjai);
            tianjai1.setLayout(new GridLayout(8,3,5,5));

            JLabel idLable = new JLabel("ID:");
            idLable.setPreferredSize(new Dimension(4,4));
            JTextField idContent = new JTextField(15);

            JLabel userId = new JLabel("UserId:");
            JTextField udContent = new JTextField(15);

            JLabel fidLable= new JLabel("Fid:");
            JTextField fidContent= new JTextField(15);

            JLabel gNameLable= new JLabel("组名:");
            JTextField gNameContent= new JTextField(15);

            JLabel fSexLable= new JLabel("性别:");
            JTextField fSexContent= new JTextField(15);

            JLabel fNameLable= new JLabel("姓名:");
            JTextField fNameContent= new JTextField(15);

            JLabel fBitLable= new JLabel("生日:");
            JTextField fBitContent= new JTextField(15);

            JLabel fPhoneidLable= new JLabel("电话:");
            JTextField fPhoneContent= new JTextField(15);

            JButton add = new JButton("添加好友");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //con.query();
                    int text2=0;
                    int text3=0;
                    if(!udContent.getText().equals("")){
                        text2 = Integer.parseInt(udContent.getText());
                        text3 = Integer.parseInt(fidContent.getText());
                    }
                    String text4 =gNameContent.getText();
                    String text5 =fSexContent.getText();
                    String text6 =fNameContent.getText();
                    String text7 ="2000-12-12";
                    if(!fBitContent.getText().equals("")){
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            text7=fBitContent.getText();
                            format.parse(text7);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                    String text8 =fPhoneContent.getText();
                    con.add("insert into flist(UserId, Fid, GName, FSex, FName, FBirthday, FPhone) values(?,?,?,?,?,?,?)",text2,text3,text4,text5,text6,text7,text8);
                    ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone,GName,ID from flist" );

                    //ResultSet query4 = con.query("select FName,FSex,FBirthday,FPhone ,GName from flist where FName=?", text);
                    //刷新页面
                    vect.removeAllElements();// 初始化向量对象
                    tm.fireTableStructureChanged();// 更新表格内容
                    while (true) {
                        try {
                            if (!query4.next()) break;
                        } catch (SQLException ec) {
                            ec.printStackTrace();
                        }
                        @SuppressWarnings("rawtypes")
                        Vector<Comparable> v = new Vector<Comparable>();
                        try {
                            v.add(query4.getString(1));
                            v.add(query4.getString(2));
                            v.add(query4.getDate(3));
                            v.add(query4.getString(4));
                            v.add(query4.getString(5));
                            v.add(query4.getString(6));
                            vect.add(v);
                            tm.fireTableStructureChanged();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            });
            tianjai1.add(userId);
            tianjai1.add(udContent);
            tianjai1.add(fidLable);
            tianjai1.add(fidContent);
            tianjai1.add(gNameLable);
            tianjai1.add(gNameContent);
            tianjai1.add(fSexLable);
            tianjai1.add(fSexContent);
            tianjai1.add(fNameLable);
            tianjai1.add(fNameContent);
            tianjai1.add(fBitLable);
            tianjai1.add(fBitContent);
            tianjai1.add(fPhoneidLable);
            tianjai1.add(fPhoneContent);
            tianjai2.add(add);
            tianjai.add(tianjai1);
            tianjai.add(tianjai2);

            /*统计模块*/
            final String[] Address_book3={"组名","人数"};
            ResultSet resultSet3 = con.query("select GName,count(GName) from flist group by GName");

            final Vector<Vector<Comparable>> vect3 = new Vector();//初始化向量

            //表格模型
            AbstractTableModel tm3 = new AbstractTableModel() {// 实现AbstractTableModel的抽象方法
                private static final long serialVersionUID = 1L;

                public int getColumnCount() {
                    return Address_book3.length;
                }

                public int getRowCount() {
                    // TODO 自动生成的方法存根
                    return vect3.size();
                }

                public Object getValueAt(int row, int column) {
                    // TODO 自动生成的方法存根
                    if (!vect3.isEmpty())
                        return (((Vector<?>) vect3.elementAt(row)).elementAt(column));
                    else
                        return null;
                }

                public String getColumnName(int column) {
                    return Address_book3[column];// 设置表格列名
                }

                public void setValueAt(Object value, int row, int column) {
                }

                public Class<? extends Object> getColumnClass(int c) {
                    return getValueAt(0, c).getClass();
                }// 取得所属对象类

                public boolean isCellEditable(int row, int column) {

                    return false;
                }// 设置单元格不可编辑
            };
            JPanel tj = new JPanel();

            //新建基本信息表格类
            JTable Address_bookTable3 = new JTable(tm3);//
            Address_bookTable3.setToolTipText("显示分组人员信息");

            //信息表的表头
            //信息表自动调整
            Address_bookTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            //设置单元格分割线
            Address_bookTable3.setShowHorizontalLines(true);

            Address_bookTable3.setShowVerticalLines(true);

            //滚轮,将滚轮绑定表格
            JScrollPane scrollPane3 = new JScrollPane(Address_bookTable3);

            //将获取到的数据加进表格中
            vect3.removeAllElements();// 初始化向量对象

            tm3.fireTableStructureChanged();// 更新表格内容

            while (true) {
                try {
                    if (!resultSet3.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                @SuppressWarnings("rawtypes")
                Vector<Comparable> v = new Vector<Comparable>();
                try {
                    v.add(resultSet3.getString(1));//
                    v.add(resultSet3.getString(2));//
                    vect3.add(v);
                    tm3.fireTableStructureChanged();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            tj.add(scrollPane3);
            scrollPane3.setPreferredSize(new Dimension(480,150));
            JLabel allLable = new JLabel("总人数");
            JTextField allTextField = new JTextField(8);
            JButton count= new JButton("统计");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                }
            });

            jTabbedPane.addTab("统计",tj);



            //消息
            /*统计模块*/
            final String[] Address_book4={"姓名","内容","时间"};
            ResultSet resultSet4 = con.query("select FName,MContent,MTime from message");

            final Vector<Vector<Comparable>> vect4 = new Vector();//初始化向量

            //表格模型
            AbstractTableModel tm4 = new AbstractTableModel() {// 实现AbstractTableModel的抽象方法
                private static final long serialVersionUID = 1L;

                public int getColumnCount() {
                    return Address_book4.length;
                }

                public int getRowCount() {
                    // TODO 自动生成的方法存根
                    return vect4.size();
                }

                public Object getValueAt(int row, int column) {
                    // TODO 自动生成的方法存根
                    if (!vect4.isEmpty())
                        return (((Vector<?>) vect4.elementAt(row)).elementAt(column));
                    else
                        return null;
                }

                public String getColumnName(int column) {
                    return Address_book4[column];// 设置表格列名
                }

                public void setValueAt(Object value, int row, int column) {
                }

                public Class<? extends Object> getColumnClass(int c) {
                    return getValueAt(0, c).getClass();
                }// 取得所属对象类

                public boolean isCellEditable(int row, int column) {

                    return false;
                }// 设置单元格不可编辑
            };
            JPanel ms = new JPanel();

            //新建基本信息表格类
            JTable Address_bookTable4 = new JTable(tm4);//
            Address_bookTable4.setToolTipText("显示消息");

            //信息表的表头
            //信息表自动调整
            Address_bookTable4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            //设置单元格分割线
            Address_bookTable4.setShowHorizontalLines(true);

            Address_bookTable4.setShowVerticalLines(true);

            //滚轮,将滚轮绑定表格
            JScrollPane scrollPane4 = new JScrollPane(Address_bookTable4);

            //将获取到的数据加进表格中
            vect4.removeAllElements();// 初始化向量对象

            tm4.fireTableStructureChanged();// 更新表格内容

            while (true) {
                try{
                    if (!resultSet4.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                @SuppressWarnings("rawtypes")
                Vector<Comparable> v = new Vector<Comparable>();
                try {
                    v.add(resultSet4.getString(1));//
                    v.add(resultSet4.getString(2));//
                    v.add(resultSet4.getString(3));//
                    vect4.add(v);
                    tm4.fireTableStructureChanged();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ms.add(scrollPane4);
            scrollPane4.setPreferredSize(new Dimension(480,150));
            jTabbedPane.addTab("消息",ms);



            frame.add(jTabbedPane);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
