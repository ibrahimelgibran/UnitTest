package iegcode.test;

import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class LifecycleTest {

    private String temp;
    @Test
    void testA(){
        temp = "Gibran";
    }

    @Test
    void testB(){
        System.out.println(temp);
    }
}
