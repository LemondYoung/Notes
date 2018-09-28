package com.monsterlin.main;

import java.util.ArrayList;
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
     * 「31人名单表」:  /Users/monsterlin/Desktop/excel/member.xlsx
     * <p>
     * 31个人在「历史记录」中没有生成的记录，则直接根据「信息表」生成
     * 31个人在「历史记录」中存在数据的，则去查找相应的记录，取最后一条，然后取「历史记录」的体重，然后取获取「信息表」中年龄和身高
     */
    public static void main(String[] args) {
        String dataHistoryPath = "/Users/monsterlin/Desktop/excel/data_history.xlsx";
        String dataKeyMember0915Path = "/Users/monsterlin/Desktop/excel/data_keyMember_0915.xlsx";
        String finaWcDataPath = "/Users/monsterlin/Desktop/excel/fina_wc_data.xlsx";
        String memberPath = "/Users/monsterlin/Desktop/excel/member.xlsx";

        //Excel中的原始数据
        List<List<String>> originalDataMemberList = ExcelUtil.readExcel(memberPath);
        List<List<String>> originalDataHistoryList = ExcelUtil.readExcel(dataHistoryPath);
        List<List<String>> originalDataKeyMemberList = ExcelUtil.readExcel(dataKeyMember0915Path);

        //封装好的数据
        List<String> dataMemberList = new ArrayList<>();
        List<DataBean> dataHistoryList = new ArrayList<>();
        List<DataBean> dataKeyMemberList = new ArrayList<>();

        //最终的结果
        List<DataBean> dataResult = new ArrayList<>();

        /**
         * 封装31人名单
         */
        for (int i = 1; i < originalDataMemberList.size(); i++) {
            List<String> tempList = originalDataMemberList.get(i);
            dataMemberList.add(tempList.get(0));
        }

        /**
         * 封装历史记录的数据
         */
        for (int i = 1; i < originalDataHistoryList.size(); i++) {
            List<String> tempList = originalDataHistoryList.get(i);
            dataHistoryList.add(new DataBean(
                    tempList.get(0),
                    tempList.get(1),
                    tempList.get(2),
                    tempList.get(3),
                    tempList.get(4),
                    tempList.get(5)
            ));
        }

        /**
         * 封装信息表的数据
         */

        for (int i = 1; i < originalDataKeyMemberList.size(); i++) {
            List<String> tempList = originalDataKeyMemberList.get(i);
            dataKeyMemberList.add(new DataBean(
                    tempList.get(0),
                    tempList.get(1),
                    tempList.get(2),
                    tempList.get(3),
                    tempList.get(4),
                    tempList.get(5)
            ));
        }

        System.out.println("31强：" + dataMemberList.size());
        System.out.println("信息表：" + dataKeyMemberList.size());
        System.out.println("历史记录：" + dataHistoryList.size());

        System.out.println("--------------->>>数据封装完毕<<<---------------");


        for (int i = 0; i < dataMemberList.size(); i++) {
            int countHistory = 0;
            String memberName = dataMemberList.get(i).trim();

            for (int j = 0; j < dataHistoryList.size(); j++) {
                String historyName = dataHistoryList.get(j).getName().trim();
                if (memberName.equals(historyName)) {
                    //存在历史记录 => 体重取历史记录表，个人信息取信息表
                    countHistory++;
                    int countKeyMember = 0;
                    //历史记录中的体重
                    String weight = dataHistoryList.get(j).getWeight();
                    for (int k = 0; k < dataKeyMemberList.size(); k++) {
                        String keyMember = dataKeyMemberList.get(k).getName().trim();
                        if (memberName.equals(keyMember)) {
                            countKeyMember++;
                            System.out.println(memberName + " ==> 历史记录存在，信息表数据存在 => 重新整理数据填入正式库数据");
                            dataResult.add(new DataBean(
                                    dataKeyMemberList.get(k).getName(),
                                    dataKeyMemberList.get(k).getGender(),
                                    dataKeyMemberList.get(k).getAge(),
                                    dataKeyMemberList.get(k).getHeight(),
                                    weight
                            ));
                        } else {
                            if (k == dataKeyMemberList.size() - 1 && countKeyMember == 0) {
                                System.out.println("「" + memberName + "」" + " ==> 历史记录存在，信息表数据不存在");
                            }
                        }
                    }
                } else {
                    //历史记录不存在
                    if (j == dataHistoryList.size() - 1 && countHistory == 0) {
                        int countKeyMember = 0;

                        //不存在去扫描信息表
                        for (int k = 0; k < dataKeyMemberList.size(); k++) {
                            String keyMember = dataKeyMemberList.get(k).getName().trim();
                            if (memberName.equals(keyMember)) {
                                //信息表中存在记录
                                countKeyMember++;
                                System.out.println(memberName + " ===> 历史记录不存在 && 信息表中数据存在 => 直接将信息表填充正式库数据");
                                dataResult.add(dataKeyMemberList.get(k));
                            } else {
                                if (k == dataKeyMemberList.size() - 1 && countKeyMember == 0) {
                                    System.out.println("【" + memberName + "】" + " ===> 历史记录不存在 && 信息表数据不存在");
                                }
                            }
                        }
                    }
                }
            }
        }


        System.out.println("=====>>>>> 统计结果 <<<<<=====");
        System.out.println("合法数据" + dataResult.size());
        for (DataBean dataBean : dataResult) {
            System.out.println(dataBean.getName() + " " + dataBean.getGender() + " "
                    + dataBean.getAge() + " " + dataBean.getHeight() + " " + dataBean.getWeight());
        }
    }
}