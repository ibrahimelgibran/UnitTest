package iegcode.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void testMock(){

        // membuat Mock object
        List<String> list = Mockito.mock(List.class);

        // menambah behavior ke mock object
        Mockito.when(list.get(0)).thenReturn("Gibran");
        Mockito.when(list.get(100)).thenReturn("Ibrahim");

        // Test Mock
        System.out.println(list.get(0));
        System.out.println(list.get(100));

        // Verify Mock
        Mockito.verify(list, Mockito.times(1)).get(0);


    }
}
