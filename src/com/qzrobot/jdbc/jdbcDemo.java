/*
 * @Author: snake qzrobot_snake@outlook.com
 * @Date: 2022-12-31 12:15:15
 * @LastEditors: snake qzrobot_snake@outlook.com
 * @LastEditTime: 2022-12-31 14:03:29
 * @FilePath: \jdbcDemo\src\com\qzrobot\jdbc\jdbcDemo.java
 */
package com.qzrobot.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo {

    public static void main(String[] args) throws Exception {
        // 登录
        Connection conn = DriverManager.getConnection(GetDriverMangerParameter(0), GetDriverMangerParameter(1),
                GetDriverMangerParameter(2));
        // 执行sql命令
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO tel(id,name,phone) VALUES(1,\"张三\",\"13999999999\");";
        int count = stmt.executeUpdate(sql);
        // 检验正确
        System.out.println(count);
    }

    public static int key = 2;

    public static String[] open(String filepath) {
        String[] str = new String[3];
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            str[0] = br.readLine();
            str[1] = br.readLine();
            str[2] = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String to_original(String password) {
        char[] chars = password.toCharArray();
        StringBuilder stringbuilder = new StringBuilder();
        for (char aChar : chars) {
            int asciiCode = aChar;
            asciiCode -= key;
            char result = (char) asciiCode;
            stringbuilder.append(result);
        }
        return stringbuilder.toString();
    }

    public static String GetDriverMangerParameter(int id) {
        return to_original(open("C:\\Users\\snake\\jdbcDemo\\data\\password.txt")[id]);
    }
}
