package syksy26.asset_mgmt.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import syksy26.asset_mgmt.domain.Asset;
import syksy26.asset_mgmt.domain.AssetRepository;

@Controller
public class AssetController {
  
    private AssetRepository repository;

    //constructor
    public AssetController(AssetRepository repository) {
        this.repository = repository;
    }


    //HTTP GET request, read all assets
    @GetMapping("/")
    public String showAssets(Model model) {
        model.addAttribute("assets", repository.findAll());
        return "assetList";
    }

    //Post request, save new asset
    @PostMapping("/save")
    public String saveAsset(@ModelAttribute Asset asset) {
        repository.save(asset);
        return "redirect:/";
    }
   
    
}
