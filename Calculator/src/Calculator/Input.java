package Calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private static String input;
    private static boolean isRoman;

    public static String getInput() { return input; }
    public static boolean getIsRoman() { return isRoman; }

    public static String inputString() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        input = in.nextLine();
        input = input.replace(" ", "");
        input = input.toUpperCase();

        return input;
    }

    public static boolean inputVerification() throws Exceptions {

        String regexArabic = "^[ ]*([1-9]|10)[ ]*([+-/*])[ ]*([1-9]|10)[ ]*$";
        boolean arabicCheck = Pattern.matches(regexArabic, input);
        String regexRome = "^[ ]*(V?I|V?I{2}|V?I{3}|IV|V|IX|X)[ ]*([+-/*])[ ]*(V?I|V?I{2}|V?I{3}|IV|V|IX|X)[ ]*$";
        boolean romanCheck = Pattern.matches(regexRome, input);
        if (romanCheck) {
            isRoman = true;
        } else {
            if (arabicCheck) {
                isRoman = false;
            } else {
                throw new Exceptions("Неверно введены данные, числа могут быть от 1 до 10 и должны соответствовать структуре число,оператор,число одного вида");
            }
        }
        return isRoman;
    }
}