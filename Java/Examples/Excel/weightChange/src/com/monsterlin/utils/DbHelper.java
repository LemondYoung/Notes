package com.monsterlin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author monsterlin
 * @date 2016/11/27
 */
public class DbHelper {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/weightChange?&useUnicode=true&characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    /**
     * 单例模式返回数据库连接对象
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭连接
     *
     * @param con
     */
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭结果集
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭语句
     *
     * @param psmt
     */
    public static void closeStatement(PreparedStatement psmt) {
        try {
            if (psmt != null) {
                psmt.close();
                psmt = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Test Connection
     */
	public static void main(String args[])
	{
		try {
			Connection con=DbHelper.getConnection();
			if(con!=null)
			{
				System.out.println("正常");
			}
			else
			{
				System.out.println("异常");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}