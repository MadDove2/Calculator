package Calculator;


public class Main {
    public static void main (String[] args) throws Exceptions {
        Input.inputString();
        Input.inputVerification();
        Splitter.split(Input.getInput());
        CalcInt calcInt = new CalcInt();
        calcInt.calculate();
        calcInt.res();
    }
}