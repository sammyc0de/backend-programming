package syksy26.asset_mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import syksy26.asset_mgmt.domain.Asset;
import syksy26.asset_mgmt.domain.AssetRepository;

import syksy26.asset_mgmt.domain.Category;
import syksy26.asset_mgmt.domain.CategoryRepository;



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

	public CommandLineRunner demo(AssetRepository assetRepository, CategoryRepository categoryRepository ) {
	return (args) -> {

			Category category1 = new Category("Computer");
			Category category2 = new Category("Network");
			Category category3 = new Category("Server");
			Category category4 = new Category("Other");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);

			assetRepository.save(new Asset("Dell", "Latitude", "i5 16GB 14 inch screen", "Win11", "DESKTOP-LSJFIA", category1));

			assetRepository.save(new Asset("Cisco", "C9300", "24 ports non POE", "IOS", "NA", category2));

			assetRepository.save(new Asset("HP", "Proliant", "2xXeon, 256GB, 2TB ", "IOS", "NA", category3));

			
			
		}; 

 
	}

}