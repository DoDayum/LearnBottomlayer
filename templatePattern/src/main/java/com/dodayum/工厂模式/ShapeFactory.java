package com.dodayum.工厂模式;

/**
 * @author DoDayum
 * @date 2021/4/20 17:31
 */
public class ShapeFactory {
    public Shape getShape(String shapeType){
        if (shapeType.isEmpty()){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
