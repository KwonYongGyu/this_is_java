import com.google.gson.Gson;
import com.mjc813.MyClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class TestMyClass {
    @Test
    public void TestMain1(){
        assertThat(2+1).isEqualTo(3);
        assertThat(4).isEqualTo(3+1);
    }

    @Test
    public void testMain2(){
        assertThat("aaa").isEqualTo("a"+"aa").isAlphanumeric();
    }

    @Test
    public void testGson(){
        Gson gs = new Gson();
        MyClass mc = new MyClass();
        String s = gs.toJson(mc);

        MyClass mc2 = gs.fromJson(s, MyClass.class);
        assertThat(mc2.getMyArray().length).isEqualTo(mc.getMyArray().length);
        assertThat(mc2.getMyArray()).isEqualTo(mc.getMyArray());

    }
}
