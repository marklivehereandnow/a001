/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mark
 */
public class AgesGameServerJDBC {

    static Connection conn;
    static Statement st;
    Set effectSet;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        new AgesGameServerJDBC().queryAndInsert();
        new AgesGameServerJDBC().query();

    }

    public AgesGameServerJDBC() {
        effectSet = new HashSet();
    }

    void parseEffect(String str) {
        String[] tokens = str.split(";");
        for (String token : tokens) {
            if (token.trim().length() == 0) {
                continue;
            }
//            System.out.println(""+token);
            String[] pair = token.split(":");
            String key = pair[0];
            int val = Integer.parseInt(pair[1]);
//            System.out.println(key+" "+val);
            effectSet.add(key);
        }
    }
//UPDATE `AGES`.`GAME_LIVE` SET `CARD_ROW` = '1014,1003,1024,1013,1029,1026,1004,1027,1009,1017,1028,1023,1013,' WHERE `GAME_LIVE`.`ID` =1;

    public void updateGameLiveCardRow(String idx13) {
        String sql = "UPDATE `AGES`.`GAME_LIVE` SET `CARD_ROW` = "
                + "'"+idx13+ "'"
                + " WHERE `GAME_LIVE`.`ID` =1;";
        System.out.println(" going to ...");
        System.out.println(sql);
        runQuery(sql);

    }

    public void runQuery(String sql) {
        conn = getConnection();
        try {
            st = (Statement) conn.createStatement();
            int rec = st.executeUpdate(sql);
            conn.close();
            System.out.println(rec + "records affected, done," + sql);
        } catch (Exception ex) {
            System.out.println("fail to runQuery...");
            System.out.println(ex.toString());
        } finally {
        }

    }

    public void query() {

        conn = getConnection();
        try {
            String sql = "SELECT * FROM AGES_CARD ORDER BY SEQ";
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("checking result...");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            while (rs.next()) {
            }

            conn.close();

        } catch (Exception ex) {
            System.out.println("fail to query...");
            System.out.println(ex.toString());
            ex.printStackTrace();
        } finally {
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

    public void insert(String sql) {

        conn = getConnection(); // 首先要获取连接，即连接到数据库  

        try {
//            String sql = "INSERT INTO staff(name, age, sex,address, depart, worklen,wage)"  
//                    + " VALUES ('Tom1', 32, 'M', 'china','Personnel','3','3000')";  // 插入数据的sql语句  

            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  

            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  

            System.out.println("向staff表中插入 " + count + " 条数据"); //输出插入操作的处理结果  

            conn.close();   //关闭数据库连接  

        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  

            conn = DriverManager.getConnection(
                    "jdbc:mysql://2nd2go.org:3306/AGES", "max", "Taipei2014");// 创建数据连接  

        } catch (Exception e) {
            System.out.println("getConnection()==> 数据库连接失败" + e.getMessage());
        }
        return conn; //返回所建立的数据库连接  
    }

}
