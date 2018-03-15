package com.example.marvin.ontheway;

/**
 * Created by Judy Lee on 3/14/2018.
 */

public class CustomObject {
    private String prop1;
    private String prop2;

    public CustomObject(String prop1, String prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }
    public void setProp(String prop1,String prop2)
    {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }
    public String getProp1() {
        return prop1;
    }

    public String getProp2() {
        return prop2;
    }
}
