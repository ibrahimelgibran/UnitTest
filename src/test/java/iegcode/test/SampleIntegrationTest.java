package iegcode.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({
        @Tag("integration-test")
})
public class SampleIntegrationTest {

    @Test
    void test1(){

    }

    @Test
    void test2(){

    }

    // bisa run terminal = mvn test -Dgroups=integration-test
}