package Calculator;

public class Splitter {

    private static char operator;
    private static String[] spl;

    public static String[] getSpl() { return spl; }
    public static char getOperator() {
        return operator;
    }

    public static void split(String str) {

        if (str.contains("+")) {
            operator = '+';
            spl = str.split("\\+");

        } else {if (str.contains("-")) {
            operator = '-';
            spl = str.split("\\-");

        }
        else {
            if (str.contains("*")) {
                operator = '*';
                spl = str.split("\\*");

            } else {
                if (str.contains("/")) {
                    operator = '/';
                    spl = str.split("\\/");

                }
            }
        }
        }
        }
}