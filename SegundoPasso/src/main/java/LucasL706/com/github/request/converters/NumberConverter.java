package LucasL706.com.github.request.converters;

import LucasL706.com.github.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNum) throws IllegalArgumentException {
        if (strNum == null || strNum.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String num = strNum.replace(",",".");
        return Double.parseDouble(num);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null || strNum.isEmpty()) return false;
        String num = strNum.replace(",","."); // No Brasil utiliza-se ',' em numeros com casas decimais, nos EUA utiliza-se '.'
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
