package com.yangx.day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DateTest {

    @DataProvider(name = "data1")
    public Object[][] data(){
            return new Object[][]{{"1","a"},{"2","b"},{"3","c"}};
    }
    @Test(dataProvider = "data1")
    public void dataProviderTest(String i,String j){
        System.out.println("i:"+i+"和j:"+j);
    }


}
