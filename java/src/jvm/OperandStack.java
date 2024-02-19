package jvm;

public class OperandStack {
    public static void main(String[] args) {
        OperandStack operandStack = new OperandStack();
        operandStack.methodA(3);
    }
    private int methodA(int param){
        int a = 2;
        int sum = a + param;
        methodB();
        return sum;
    }
    private void methodB() {

    }
}
