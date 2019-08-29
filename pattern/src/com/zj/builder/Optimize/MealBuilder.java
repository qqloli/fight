package com.zj.builder.Optimize;

import com.zj.builder.Meal;

public class MealBuilder {
    //如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大。
    //采用这种构建方式避免了创建过多的缺点
    private Meal meal = new Meal();

    public MealBuilder(String food,String drink){
        this.meal.setDrink(drink);
        this.meal.setFood(food);
    }

    public void build(){
        System.out.println("食物："+meal.getFood()+"；   "+"饮品："+meal.getDrink());

    }
}
