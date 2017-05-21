import java.util.LinkedList;

/**
 * Created by Ko4evnik on 21.05.2017.
 */
public class Lab2 {
    static boolean isDelim(char c) {
        return c == ' ';
    }
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    static void processOperator(LinkedList<Float> st, char op) {
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
                st.add(l / r);
                break;
        }
    }
    public static String eval(String s) {
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
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0).toString();
    }
}
