package LucasL706.com.github.math;

import LucasL706.com.github.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {
    public Double sum(Double num1, Double num2){
        return num1 + num2;
    }

    public Double sub(Double num1, Double num2){
        return num1 - num2;
    }

    public Double mult(Double num1, Double num2){
        return num1 * num2;
    }

    public Double div(Double num1, Double num2){
        return num1 / num2;
    }

    public Double media(Double num1, Double num2){
        return (num1 + num2) / 2;
    }

    public Double raiz(Double num1){
        return Math.sqrt(num1);
    }
}
