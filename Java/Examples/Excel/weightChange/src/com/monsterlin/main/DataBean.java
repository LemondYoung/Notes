package com.monsterlin.main;

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
 * @desc : 数据模型
 * @date : 2018/9/28 8:58 AM
 */
public class DataBean {
    private String id ;
    private String name ;
    private String gender ;

    private String age ;
    private String height ;
    private String weight ;

    public DataBean() {
    }

    public DataBean(String name, String gender, String age, String height, String weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public DataBean(String id, String name, String gender, String age, String height, String weight) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
