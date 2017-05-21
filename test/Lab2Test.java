import org.junit.Before;
import org.junit.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.Assert.*;

/**
 * Created by Ko4evnik on 21.05.2017.
 */
public class Lab2Test {
    private Lab2 la;

    @Before
    public void init(){
        la = new Lab2();
    }
    @Test
    public void eval() throws Exception {
        assertEquals("","4.0",la.eval("2+2"));
    }
    @Test
    public void eval1() throws Exception {
        assertEquals("","8.0",la.eval("2+2*(2+1)"));
    }
    @Test(expected = Exception.class)
    public void eval2()  {
        assertEquals("","",la.eval("2+a"));
    }
    @Test
    public void eval3()  throws Exception{
        assertEquals("","Infinity",la.eval("2/0"));
    }

}