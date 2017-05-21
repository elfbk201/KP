package test.java;


import main.java.Lab2;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.Assert;

import static junit.framework.TestCase.assertEquals;


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
    @Test
    public void eval2() throws Exception  {
        assertEquals("","Ошибка! Использование некорректных символов",la.eval("2+a"));
    }
    @Test
    public void eval3()  throws Exception{
        assertEquals("","Ошибка! Деление на ноль!",la.eval("2/0"));
    }
    @Test
    public void eval4() throws Exception {
        assertEquals("","Ошибка! Недопустимое использование операторов подряд",la.eval("2++2*(2+1)"));
    }
    @Test
    public void eval5() throws Exception {
        assertEquals("","Ошибка! Нет второго операнда",la.eval("2+"));
    }
    @Test
    public void eval6() throws Exception {
        assertEquals("","4.0",la.eval("2^2"));
    }
    @Test
    public void eval7() throws Exception {
        assertEquals("","2.0",la.eval("8%3"));
    }

}