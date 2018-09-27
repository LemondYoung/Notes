package com.monsterlin.main;

import java.util.List;

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
 * @desc : Excel处理类
 * @date : 2018/9/27 11:33 PM
 */
public class MainJava {
    /**
     * 「历史记录」: /Users/monsterlin/Desktop/excel/data_history.xlsx
     * 「信息表」 : /Users/monsterlin/Desktop/excel/data_keyMember_0915.xlsx
     * 「汇总记录」: /Users/monsterlin/Desktop/excel/fina_wc_data.xlsx
     * <p>
     * 31个人在「历史记录」中没有生成的记录，则直接根据「信息表」生成
     * 31个人在「历史记录」中存在数据的，则去查找相应的记录，取最后一条，然后取「历史记录」的体重，然后取获取「信息表」中年龄和身高
     */
    public static void main(String[] args) {
        String dataHistoryPath = "/Users/monsterlin/Desktop/excel/data_history.xlsx";
        String dataKeyMember0915Path = "/Users/monsterlin/Desktop/excel/data_keyMember_0915.xlsx";
        String finaWcDataPath = "/Users/monsterlin/Desktop/excel/fina_wc_data.xlsx";

        List<List<String>> dataHistoryList = ExcelUtil.readExcel(dataHistoryPath);
        List<List<String>> dataKeyMemberList = ExcelUtil.readExcel(dataKeyMember0915Path);
        List<List<String>> finaWcDataList = ExcelUtil.readExcel(finaWcDataPath);

        System.out.println(dataHistoryList.size());
        System.out.println(dataKeyMemberList.size());
        System.out.println(finaWcDataList.size());
    }
}
