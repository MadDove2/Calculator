package Calculator;

public class CalcInt {

   private int var1;
   private int var2;
   private char operator = Splitter.getOperator();
   private static int intResult;
   private boolean isRoman = Input.getIsRoman();
   private String result;

    public int calculate() throws Exceptions {
        Splitter.split(Input.getInput());
        if (isRoman) {
            var1 = Converter.toArabic(Splitter.getSpl()[0]);
            var2 = Converter.toArabic(Splitter.getSpl()[1]);
        } else {
            var1 = Integer.parseInt(Splitter.getSpl()[0]);
            var2 = Integer.parseInt(Splitter.getSpl()[1]);
        }

        intResult = 0;
        switch (operator) {
            case ('+'):
                return intResult = var1 + var2;
            case ('-'):
                if (isRoman & var1 <= var2){ throw new Exceptions("Римское вычисление не может приводить к 0 или отрицательному результату");} else{
                return intResult = var1 - var2;}
            case ('*'):
                return intResult = var1 * var2;
            case ('/'):
                return intResult = var1 / var2;

            default:

                // throw new OperationException();
                return intResult;
        }
    }
    public String res() {
        if (isRoman) {
            result = Converter.toRoman(intResult);
        } else {
            result = Integer.toString(intResult);
        }
        System.out.println("Результат: "+result);
        return result;

    }
}


