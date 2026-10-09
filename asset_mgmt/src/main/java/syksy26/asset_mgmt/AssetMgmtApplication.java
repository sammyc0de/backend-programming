package syksy26.asset_mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import syksy26.asset_mgmt.domain.Asset;
import syksy26.asset_mgmt.domain.AssetRepository;

@SpringBootApplication
public class AssetMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetMgmtApplication.class, args);
	}

	//Test data for db
	@Bean
	public CommandLineRunner data(AssetRepository repository) {
	return (args) -> {
	  repository.save(new Asset(
			"Dell",
			"Latitude",
			"i5 16GB 14 inch screen",
			"Win11",
			"DESKTOP-LSJFIA"
			));
	};
 
	}

}