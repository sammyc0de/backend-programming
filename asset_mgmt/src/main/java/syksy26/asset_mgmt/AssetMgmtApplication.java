package syksy26.asset_mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import syksy26.asset_mgmt.domain.Asset;
import syksy26.asset_mgmt.domain.AssetRepository;

import syksy26.asset_mgmt.domain.Category;
import syksy26.asset_mgmt.domain.CategoryRepository;

import syksy26.asset_mgmt.domain.MaintenanceLog;
import syksy26.asset_mgmt.domain.MaintenanceLogRepository;

import syksy26.asset_mgmt.domain.User;
import syksy26.asset_mgmt.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class AssetMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetMgmtApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(AssetMgmtApplication.class);

	//Test data for db
	@Bean
/* 	public CommandLineRunner data(AssetRepository repository) {
	return (args) -> {
	  repository.save(new Asset(
			"Dell",
			"Latitude",
			"i5 16GB 14 inch screen",
			"Win11",
			"DESKTOP-LSJFIA"
			));
	};
 */

	public CommandLineRunner demo(AssetRepository assetRepository, CategoryRepository categoryRepository, MaintenanceLogRepository maintenanceLogRepository, UserRepository userRepository) {
	return (args) -> {

			Category category1 = new Category("Computer");
			Category category2 = new Category("Network");
			Category category3 = new Category("Server");
			Category category4 = new Category("Other");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);

			MaintenanceLog maint1 = new MaintenanceLog("Computer reloaded", LocalDate.of(2026, 8, 24));
			MaintenanceLog maint2 = new MaintenanceLog("SSD swapper", LocalDate.of(2026, 10, 8));

		/* 	maintenanceLogRepository.save(maint1);
			maintenanceLogRepository.save(maint2); */
			
			assetRepository.save(new Asset("Dell", "Latiude 5410", "i7 32GB", "Win11", "NA", category1, maint1));
			assetRepository.save(new Asset("Dell", "Latiude 5440", "i5 16GB", "Win11", "NA", category1, maint2));

			// Create users
			User user1 = new User("user", "$2a$10$1nzWR.4DwZRUm3rdhNCkSOklsyCphKp1Ydkq3lETnPx99oAa3F9Ti","user@assets.com", "USER");
			User user2 = new User("admin", "$2a$10$3JleYlauJBlqY47vqfbj4.xAJ.0QIhpQW5A1U0r2fNQK7kXj3V.hq", "admin@assets.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			
			
		}; 

 
	}

}