import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JunitTest {
    @Test
    public void test1(){
        Junit j = new Junit();
        int result = j.add(1,1);
        assertEquals(2,result);

    }
}