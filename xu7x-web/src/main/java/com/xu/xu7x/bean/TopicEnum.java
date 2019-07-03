package com.xu.xu7x.bean;


/**
 * @author xuhongda on 2019/7/3
 * com.xu.xu7x.bean
 * xu7x
 */
public enum TopicEnum {


    /**
     * girl 主题
     */
    GIRL("girl", "献给女孩们");

    private String name;

    private String desc;

    TopicEnum(String name, String desc) {

        this.name = name;

        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
