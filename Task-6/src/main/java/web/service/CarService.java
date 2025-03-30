package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars;

    public CarService() {
        // Инициализируем список автомобилей
        cars = new ArrayList<>();
        cars.add(new Car("Toyota Camry", "Black", 2020));
        cars.add(new Car("Honda Civic", "White", 2019));
        cars.add(new Car("BMW X5", "Blue", 2021));
        cars.add(new Car("Audi A4", "Silver", 2018));
        cars.add(new Car("Mercedes E-Class", "Red", 2022));
    }

    public List<Car> getCars(int count) {
        // Если запрошено больше чем есть или меньше 1 - возвращаем весь список
        if (count >= cars.size() || count <= 0) {
            return cars;
        }
        return cars.subList(0, count);
    }
}