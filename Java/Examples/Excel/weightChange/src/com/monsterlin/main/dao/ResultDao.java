package com.monsterlin.main.dao;

import com.monsterlin.main.DataBean;
import com.monsterlin.utils.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * _            _ _
 * _ __ ___   ___  _ __  ___| |_ ___ _ __| (_)_ __    ___ ___  _ __ ___
 * | '_ ` _ \ / _ \| '_ \/ __| __/ _ \ '__| | | '_ \  / __/ _ \| '_ ` _ \
 * | | | | | | (_) | | | \__ \ ||  __/ |  | | | | | || (_| (_) | | | | | |
 * |_| |_| |_|\___/|_| |_|___/\__\___|_|  |_|_|_| |_(_)___\___/|_| |_| |_|
 *
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 数据库业务类
 * @date : 2018/9/28 1:20 PM
 */
public class ResultDao {
    public int insertResult(DataBean dataBean) {
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        int resultCode = 0;

        try {
            con = DbHelper.getConnection();
            String insertResultSql = "INSERT into Result(wName,gender,age,height,weight) values (?,?,?,?,?)";
            psmt = con.prepareStatement(insertResultSql);
            psmt.setString(1, dataBean.getName());
            psmt.setString(2, dataBean.getGender());
            psmt.setString(3, dataBean.getAge());
            psmt.setString(4, dataBean.getHeight());
            psmt.setString(5, dataBean.getWeight());
            resultCode = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbHelper.closeStatement(psmt);
            DbHelper.closeConnection(con);
        }
        return resultCode;
    }
}
