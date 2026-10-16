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


@SpringBootApplication
public class AssetMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetMgmtApplication.class, args);
	}

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

	public CommandLineRunner demo(AssetRepository assetRepository, CategoryRepository categoryRepository, MaintenanceLogRepository maintenanceLogRepository) {
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
			
			
		}; 

 
	}

}