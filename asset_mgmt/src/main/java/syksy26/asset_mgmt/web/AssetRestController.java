package syksy26.asset_mgmt.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import syksy26.asset_mgmt.domain.Asset;
import syksy26.asset_mgmt.domain.AssetRepository;

@RestController
public class AssetRestController {

    private final AssetRepository assetRepository;

     public AssetRestController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
       
    }
    
    //Get all assets
	@GetMapping("/assets")
    public Iterable<Asset> findAllAssets() {
        return assetRepository.findAll();
    }
    
    //Get one asset by id
    @GetMapping("/asset/{id}")
    public Optional<Asset> findById(@PathVariable("id") Long assetId) {
        return assetRepository.findById(assetId);
    }

    //Create new asset
    @PostMapping("/asset")
    public Asset saveAsset(@RequestBody Asset asset) {		
        return assetRepository.save(asset);
    }
    
    // Update asset by id
    @PutMapping("asset/{id}")
    public Asset saveEditedAsset(@RequestBody Asset editedAsset, @PathVariable Long id) {
		editedAsset.setId(id);
		return assetRepository.save(editedAsset);
	}

    //Delele asset by id
    @DeleteMapping("/asset/{id}")   
    public Iterable<Asset> deleteAsset(@PathVariable Long id) {
        
        assetRepository.deleteById(id);
        return assetRepository.findAll();
    }

    //Note! Using rest api clients like postman, "Basic Auth" authorization is needed 

}