public class PostfixStack {

    private int[] stack;
    private int top;

    public PostfixStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        stack[++top] = value;
    }

    public int pop() {
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public void displayStack() {

        System.out.print("Stack: [");

        for (int i = 0; i <= top; i++) {

            System.out.print(stack[i]);

            if (i < top) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static int evaluatePostfix(
            String expression) {

        String[] tokens =
                expression.split(" ");

        PostfixStack stack =
                new PostfixStack(tokens.length);

        for (String token : tokens) {

            if (token.matches("\\d+")) {

                stack.push(
                        Integer.parseInt(token));

                System.out.print(
                        "Read " + token + " -> ");
                stack.displayStack();
            }
            else {

                int right = stack.pop();
                int left = stack.pop();

                int result = 0;

                switch (token) {

                    case "+":
                        result = left + right;
                        break;

                    case "-":
                        result = left - right;
                        break;

                    case "*":
                        result = left * right;
                        break;

                    case "/":
                        result = left / right;
                        break;
                }

                stack.push(result);

                System.out.print(
                        "Apply "
                                + left + " "
                                + token + " "
                                + right + " -> ");

                stack.displayStack();
            }
        }

        return stack.peek();
    }
}
