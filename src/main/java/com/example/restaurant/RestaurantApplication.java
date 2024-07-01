package com.example.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RestaurantApplication implements CommandLineRunner {

	private final MealService mealService;
	private final TableService tableService;
	//private final MealNumber mealNumber;

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mealService.save(new Meal(null, "Салат с говядиной", "говядина-гриль, помидоры черри, грецкие орехи, ягоды брусники, редис, салат айсберг", 15));
		mealService.save(new Meal(null, "Xолодный свекольный суп", "свекла, картофель, морковь, лук, чеснок, гренки, зелень,яйца, сметана", 11.5));
		mealService.save(new Meal(null, "Салат с курицей", "курица-гриль, помидоры черри, грецкие орехи, ягоды брусники, редис, салат айсберг", 5.65));

		tableService.save(new Table(null, "Стол 1",5));
		tableService.save(new Table(null, "Стол 2",8));
		tableService.save(new Table(null, "Стол 3",10));

		User user=new User();
		user.setUsername("admin");
		user.setPassword("{bcrypt}$2a$10$2YCHfWNsgWBz2k6AK4zic.U.5s.0DqNMncr0swS5lT72PLXr3Skzu");//admin
		userRepository.save(user);

	}
}
