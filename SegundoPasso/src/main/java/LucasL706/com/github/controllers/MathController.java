package LucasL706.com.github.controllers;

import LucasL706.com.github.exception.UnsupportedMathOperationException;
import LucasL706.com.github.math.SimpleMath;
import LucasL706.com.github.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/math")
public class MathController {
    private SimpleMath math = new SimpleMath();
    //http://localhost:8080/math/sum/2/3
    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.sum(NumberConverter.convertToDouble(num1),NumberConverter.convertToDouble(num2));
    }

    @RequestMapping("/sub/{num1}/{num2}")
    public Double sub(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.sub(NumberConverter.convertToDouble(num1),NumberConverter.convertToDouble(num2));
    }
    //http://localhost:8080/math/sub/2/3

    @RequestMapping("/mult/{num1}/{num2}")
    public Double mult(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.mult(NumberConverter.convertToDouble(num1),NumberConverter.convertToDouble(num2));
    }

    @RequestMapping("/div/{num1}/{num2}")
    public Double div(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        if (NumberConverter.convertToDouble (num2) == 0) throw new UnsupportedMathOperationException("Please set a second value different from 0!");
        return math.div(NumberConverter.convertToDouble(num1),NumberConverter.convertToDouble(num2));
    }

    @RequestMapping("/media/{num1}/{num2}")
    public Double media(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.media(NumberConverter.convertToDouble(num1),NumberConverter.convertToDouble(num2));
    }

    @RequestMapping("/raiz/{num1}")
    public Double raiz(
            @PathVariable("num1") String num1
    ) throws Exception {
        if(!NumberConverter.isNumeric(num1)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.raiz(NumberConverter.convertToDouble(num1));
    }
}