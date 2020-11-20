package tudelft.myRoman;

import java.util.ArrayList;

public class MyRomanNumeral {

    public static Integer romanToNormal(char romanChar) {
        romanChar = Character.toLowerCase(romanChar);
        switch (romanChar) {
            case 'i':
                return 1;
            case 'v':
                return 5;
            case 'x':
                return 10;
            case 'l':
                return 50;
            case 'c':
                return 100;
            case 'd':
                return 500;
            case 'm':
                return 1000;
            default:
                return null;
        }
    }

    public static Integer convert(String romanNumeral) {
        // your implementation here
        char[] romanArray = romanNumeral.toCharArray();
        ArrayList<Integer> normalArray = new ArrayList<Integer>();
        for (char number :
                romanArray) {
            normalArray.add(romanToNormal(number));
        }
        Integer result = 0;
        for (int i = 0; i < normalArray.size(); i++) {
            Integer primero = normalArray.get(i);
            if (i == normalArray.size() - 1) {
                result += primero;
                break;
            }
            Integer segundo = normalArray.get(i + 1);
            if (primero >= segundo) {
                result += primero;
            } else {
                result -= primero;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Integer result = convert("CDXCIX");
        System.out.println(result);
    }
}
