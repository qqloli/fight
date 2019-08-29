package com.example.demo.CodeStandard;

import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CodeStandardDemo {
    // 代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。
    private String age_;
    private String age;

    // 代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式。
    private String pingfen;
    private String score;

    // 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格，必须遵从
    // 驼峰形式。
    private String localname;
    private String localName;

    // 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。
    public static final String MAXCOUNT = "name";
    public static final String MAX_PEOPLE_COUNT = "name";

    // 类型与中括号紧挨相连来表示数组。
    int testList[];
    int[] logList;


    // POJO 类中布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。
    public boolean isLocked;
    public boolean locked;

    // 杜绝完全不规范的缩写，避免望文不知义。
    public String comm;
    public String comment;

    // 为了达到代码自解释的目标，任何自定义编程元素在命名时，使用尽量完整的单词
    // 组合来表达其意。
    public int a;
    public int userAge;

    // 在 long 或者 Long 赋值时，数值后使用大写的 L，不能是小写的 l，小写容易跟数字
    // 1 混淆，造成误解。
    public long testLong1 = 12l;
    public long testLong = 12L;

    //这是一行注释
    // 这也是一行注释

    // 大括号的使用约定。如果是大括号内为空，则简洁地写成{}即可，不需要换行；
    public void test()
    {

    }

    public void test1(){
        // 单行字符数限制不超过 120 个，超出需要换行，换行时遵循如下原则
        StringBuffer sb = new StringBuffer();
        sb.append("nihao").append("nihao").append("nihao").append("nihao").append("nihao").append("nihao").append("nihao").append("nihao");
        StringBuffer sb1 = new StringBuffer();
        sb1.append("nihao")
                .append("nihao")
                .append("nihao")
                .append("nihao")
                .append("nihao");

        // 左小括号和字符之间不出现空格；同样，右小括号和字符之间也不出现空格；而左大
        // 括号前需要空格。
        // if/for/while/switch/do 等保留字与括号之间都必须加空格。
        if( sb==sb1 ){
            System.out.println("相等");
        }

        if (sb==sb1){
            System.out.println("相等");
        }

        // 不同逻辑、不同语义、不同业务的代码之间插入一个空行分隔开来以提升可读性。
        if( sb==sb1 ){
            System.out.println("相等");
        }




        if (sb==sb1){
            System.out.println("相等");
        }

        // 方法参数在定义和传入时，多个参数逗号后边必须加空格。
        localValue("jacker",18);
        localValue("tom" ,18);
    }

    // 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格，必须遵从
    // 驼峰形式。
    public void localvalue(){}
    public void localValue(String name,int age){
        System.out.println("name:"+name+"age:"+age);
    }

    Log log = (Log) LoggerFactory.getLogger(CodeStandardDemo.class);
    public void exceptionTest(String name){
        log.info("接受参数"+name);
        File file = new File(name);
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);
        }catch (IOException e){
            log.error("文件不存在");
            throw new RuntimeException("文件不存在");
        }finally {
            try {
                inputStream.close();
            }catch (IOException io){
                log.error("流关闭异常");
                throw new RuntimeException("流关闭异常");
            }

        }

    }
}
