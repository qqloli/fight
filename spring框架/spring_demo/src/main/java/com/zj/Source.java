package com.zj;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class Source {
    private String fruit;   // 类型
    private String sugar;   // 糖分描述
    private String size;    // 大小杯

    @Autowired
    private Consumer consumer;

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
