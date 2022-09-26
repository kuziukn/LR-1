import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator calc = new StringCalculator();

    @Test
    public void step1(){
        assertEquals(0, calc.add(""));
        assertEquals( 1, calc.add("1"));
        assertEquals( 3, calc.add("1,2"));
    }

    @Test
    public void step2(){
        assertEquals( 20, calc.add("1,1,2,2,3,3,4,4"));
        assertEquals( 25, calc.add("5,6,3,0,7,4"));
        assertEquals( 3, calc.add("1,1,1"));
    }

    @Test
    public void step3(){
        assertEquals( 6, calc.add("1\n2,3"));
        assertEquals( 25, calc.add("4\n8\n1\n7\n5"));
        assertEquals( 24, calc.add("3,7,5\n1,4\n4"));
    }

    @Test
    public void step4(){
        assertEquals( 5, calc.add("//l\n4l1"));
        assertEquals( 25, calc.add("//!\n3!5,7!9\n1"));
        assertEquals( 23, calc.add("//;\n9;5;7\n2"));
        assertEquals( 15, calc.add("//[ and ]\n2 and 5 and 8"));
    }

    @Test
    public void step5(){
        //assertThrows(NegativeException.class, () -> calc.add("-1,-2,-3"));
        //assertThrows(NegativeException.class, () -> calc.add("-3,2,1,4,7"));
        //assertThrows(NegativeException.class, () -> calc.add("6,3,2,-1"));
        //assertEquals( 0, calc.add("//;\n-1;-2"));
        //assertEquals( 20, calc.add("//!\n3!-5,7!9\n1"));
        //assertEquals( 14, calc.add("//[*]\n9*5*-7*-2"));
        assertThrows(NegativeException.class, () -> {calc.add("//!\n3!-5,7!9\n1");});
    }

    @Test
    public void step6(){
        assertEquals( 1999, calc.add("1000,999,1001"));
        assertEquals( 0, calc.add("1003,1002,1001"));
        assertEquals( 2994, calc.add("997,998,999"));
    }

    @Test
    public void step7(){
        //assertEquals( 6, calc.add("//[*]\n1**2*3"));
        assertEquals( 15, calc.add("//[@!b]\n5@!b8,2\n0"));
        //assertEquals( 22, calc.add("//[xx]\n6xx7xx9"));
    }

    @Test
    public void step8(){
        assertEquals( 25, calc.add("//[;][?]\n6;2,8?6;1\n2"));
        assertEquals( 22, calc.add("//[{][}][s]\n9{0}1{4s8"));
        assertEquals( 10, calc.add("//[!][!][!]\n3!6!1"));
    }

    @Test
    public void step9(){
        assertEquals( 20, calc.add("//[;;][!!]\n2;;0!!18"));
        //assertEquals( 9, calc.add("//[s][xx][{}]\n6{}s2xx1"));
        //assertEquals( 13, calc.add("//[33][s]\n7331s2333"));
    }
}