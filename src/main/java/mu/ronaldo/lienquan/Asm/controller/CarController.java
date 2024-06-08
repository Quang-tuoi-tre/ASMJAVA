/*
package mu.ronaldo.lienquan.Asm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mu.ronaldo.lienquan.Asm.Service.CarService;
import mu.ronaldo.lienquan.Asm.model.Car;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car get(@PathVariable int id) {
        return carService.get(id);
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        carService.add(car);
        return car;
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable int id, @RequestBody Car car) {
        carService.update(id, car);
        return car;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        carService.remove(id);
    }

    @GetMapping("/bien-so-dep")
    public List<Car> findBeautifulCars() {
        return carService.findBeautifulCars();
    }

    @GetMapping("/so-cho-ngoi")
    public List<Car> findCarsBySeats(@RequestParam int seats) {
        return carService.findCarsBySeats(seats);
    }

    @GetMapping("/nam-san-xuat")
    public List<Car> findCarsByYear(@RequestParam int year) {
        return carService.findCarsByYear(year);
    }
    @PostMapping("/CheckString")
    public String CheckString(@RequestBody String str) {
        return isStringBalanced(str) ? "Ok" : "Not Ok";
    }

    private boolean isStringBalanced(String str) {
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('>', '<');

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (matchingBrackets.values().contains(ch)) {
                stack.push(ch);
            } else if (matchingBrackets.keySet().contains(ch)) {
                if (stack.isEmpty() || stack.pop() != matchingBrackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
*/
