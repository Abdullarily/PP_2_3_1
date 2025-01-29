package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class Car {

    @GetMapping(value = "/cars")
    public String printCar(ModelMap model, @RequestParam(value = "count", required = false) String count) {
        List<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");
        cars.add("Opel");
        cars.add("Ford");
        List<String> carsOut = new ArrayList<>();
        if (Integer.parseInt(count) < 5) {
            for (int i = 0; i < Integer.parseInt(count); i++) {
                carsOut.add(cars.get(i));
            }
            model.addAttribute("cars", carsOut);
        } else {
            model.addAttribute("cars", cars);
        }
        return "cars";
    }

}
