package com.mjc813.machine;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Test;

public class Test_Calculator {
    @Test
    public void testAdd(){
        Calculator cal = new Calculator();
//        assertEqual(왼쪽값과, 오른쪽 값을 비교) 옛날 방식
        // assertThat(실제값).isEqualTo(기대하는값).메소드2().메소드3()  최근 방식
        assertThat(cal.add(1, 2, 3, 7, 9)).isEqualTo(22L);
        assertThat(cal.add(-33, -77, -909)).isEqualTo(-1019L);
        assertThat(cal.add(99999, 88888, 77777, 66666, 55555)).isEqualTo(388885L);

    }
}
