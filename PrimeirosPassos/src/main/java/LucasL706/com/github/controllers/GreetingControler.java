package LucasL706.com.github.controllers;

import LucasL706.com.github.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingControler {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=Lucas
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")
            String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
