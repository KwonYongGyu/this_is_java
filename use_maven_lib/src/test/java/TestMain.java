import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class TestMain {
    @Test
    public void TestMain1(){
        assertThat(2+1).isEqualTo(3);
        assertThat(4).isEqualTo(3+1);
    }

    @Test
    public void testMain2(){
        assertThat("aaa").isEqualTo("a"+"aa").isAlphanumeric();
    }
}
