import java.util.*;

public class EvaluateRPN {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {

            if (s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/")) {

                int b = st.pop();
                int a = st.pop();

                if (s.equals("+"))
                    st.push(a + b);
                else if (s.equals("-"))
                    st.push(a - b);
                else if (s.equals("*"))
                    st.push(a * b);
                else
                    st.push(a / b);

            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};

        System.out.println(evalRPN(tokens));
    }
}