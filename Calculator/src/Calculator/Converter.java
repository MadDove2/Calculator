package Calculator;

public class Converter{

    public static int toArabic(String romanNumeral){
        int arabicNumeral =0;
        int placeValue;
        for(int i=0;i<romanNumeral.length();i++){

            if(i+1<romanNumeral.length()){
                if(valueOfRomanChar(romanNumeral.charAt(i))<valueOfRomanChar(romanNumeral.charAt(i+1))){
                    placeValue = valueOfRomanChar(romanNumeral.charAt(i+1)) - valueOfRomanChar(romanNumeral.charAt(i));
                    arabicNumeral = arabicNumeral + placeValue;
                    i++;
                } else{
                    placeValue = valueOfRomanChar(romanNumeral.charAt(i));
                    arabicNumeral= arabicNumeral + placeValue;
                }
            } else {
                placeValue = valueOfRomanChar(romanNumeral.charAt(i));
                arabicNumeral= arabicNumeral + placeValue;
            }
        }
        return arabicNumeral;
    }

    private static int valueOfRomanChar(char ch){
        switch(ch){
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
        }
        return 0;
    }

    public static String toRoman(int number) {
        String arabicNumeral = String.valueOf(number);
        String baseRoman;
        String romanNumeral="";
        int i=3-arabicNumeral.length();
        int location=0;
        switch (i) {
            case 1:   // число двухзначное
                baseRoman=getBaseRoman(arabicNumeral.charAt(location++));
                romanNumeral =convertIVXtoXLC(baseRoman, romanNumeral);
            case 2:  // число однозначное
                baseRoman=getBaseRoman(arabicNumeral.charAt(location++));
                romanNumeral+=baseRoman;
                break;
            default:
        }
        return romanNumeral;
    }


    private static String getBaseRoman(char ch) {
        String romanBase="";
        if ((ch>='1') && (ch<='3')){
            for(int i=0;i<Character.getNumericValue(ch);i++){
                romanBase=romanBase + "I";

            }
        }else if((ch>='5') && (ch<'9')){
            romanBase=romanBase+'V';
            for(int i=5;i<Character.getNumericValue(ch);i++){
                romanBase=romanBase+ 'I';
            }
        }else if(ch=='9'){
            romanBase=romanBase+"IX" ;
        }else if(ch=='4'){
            romanBase=romanBase+"IV" ;
        }else if(ch=='0'){

        }
        return romanBase;
    }

    private static String convertIVXtoXLC(String baseRoman, String romanNumeral) {
        if (baseRoman != null) {
            for (int location = 0; location <baseRoman.length(); location++) {
                switch(baseRoman.charAt(location)){
                    case 'I':
                        romanNumeral = romanNumeral + "X";
                        break;
                    case 'V':
                        romanNumeral = romanNumeral + "L";
                        break;
                    case 'X':
                        romanNumeral = romanNumeral + "C";
                        break;
                }
            }
        }
        return romanNumeral;
    }
}