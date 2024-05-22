package mu.ronaldo.lienquan.Asm.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import mu.ronaldo.lienquan.Asm.model.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private List<Car> listCar = new ArrayList<>(Arrays.asList(
            new Car(1, "1234-56789", LocalDate.of(2020, 1, 1), 4, true),
            new Car(2, "6498-85881", LocalDate.of(2021, 5, 10), 7, false),
            new Car(3, "3456-78901", LocalDate.of(2019, 3, 15), 4, true),
            new Car(4, "7736-60193", LocalDate.of(2018, 7, 25), 16, false)
    ));

    public List<Car> getAll() {
        return listCar;
    }

    public Car get(int id) {
        return listCar.stream().filter(car -> car.getId() == id).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void add(Car newCar) {
        int maxId = listCar.stream().mapToInt(Car::getId).max().orElse(0);
        newCar.setId(maxId + 1);
        listCar.add(newCar);
    }

    public void update(int id, Car updatedCar) {
        Car car = get(id);
        car.setBienSoXe(updatedCar.getBienSoXe());
        car.setNgaySanXuat(updatedCar.getNgaySanXuat());
        car.setSoChoNgoi(updatedCar.getSoChoNgoi());
        car.setCoDangKyKinhDoanh(updatedCar.isCoDangKyKinhDoanh());
    }

    public void remove(int id) {
        Car car = get(id);
        listCar.remove(car);
    }

    public List<Car> findBeautifulCars() {
        return listCar.stream().filter(car -> isBeautifulPlate(car.getBienSoXe())).collect(Collectors.toList());
    }

    public List<Car> findCarsBySeats(int seats) {
        return listCar.stream().filter(car -> car.getSoChoNgoi() == seats).collect(Collectors.toList());
    }

    public List<Car> findCarsByYear(int year) {
        return listCar.stream().filter(car -> car.getNgaySanXuat().getYear() == year).collect(Collectors.toList());
    }

    private boolean isBeautifulPlate(String plate) {
        String[] parts = plate.split("-");
        String numberPart = parts[1];
        return numberPart.chars().distinct().count() <= 6 || isConsecutive(numberPart);
    }

    private boolean isConsecutive(String numberPart) {
        for (int i = 0; i < numberPart.length() - 1; i++) {
            if (numberPart.charAt(i) + 1 != numberPart.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

