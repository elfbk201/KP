package main.java;

import java.util.LinkedList;

/**
 * Created by Ko4evnik on 21.05.2017.
 */
public class Lab2 {
    static boolean isDelim(char c) {
        return c == ' ';
    }
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/'|| c == '%' || c == '^';
    }
    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public String Errormsg="";
     void processOperator(LinkedList<Float> st, char op) {
         if(st.size() == 1) {
             Errormsg = "Ошибка! Нет второго операнда";
             return;
         }
        Float r = st.removeLast();
        Float l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                if(r == 0) {
                    Errormsg = "Ошибка! Деление на ноль!";
                    return;
                }
                st.add(l / r);
                break;
            case '^':
                st.add((float)Math.pow(l,r));
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }
    public void check(String s)
    {
        String operand = "1234567890()";
        String operator = "+-*/^%";
        int d=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(operand.indexOf(c) == -1)
                if(operator.indexOf(c) == -1)
                {
                    Errormsg = "Ошибка! Использование некорректных символов";
                    break;
                }
                else
                {
                    d++;
                    if(d == 2)
                    {
                        Errormsg = "Ошибка! Недопустимое использование операторов подряд";
                        break;
                    }

                }
                else
                    d=0;
        }
    }
    public  String eval(String s) {
         check(s);
        if(Errormsg != "")
        {
            return Errormsg;
        }
        LinkedList<Float> st = new LinkedList<Float>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Float.parseFloat(operand));
            }
        }
        while (!op.isEmpty()) {
            processOperator(st, op.removeLast());
            if(Errormsg != "")
            {
                return Errormsg;
            }
        }
        return st.get(0).toString();
    }
}
