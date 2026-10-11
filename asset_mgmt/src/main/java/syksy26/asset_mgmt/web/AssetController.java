package syksy26.asset_mgmt.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import syksy26.asset_mgmt.domain.Asset;
import syksy26.asset_mgmt.domain.AssetRepository;
import syksy26.asset_mgmt.domain.CategoryRepository;

@Controller
public class AssetController {
  
    private AssetRepository repository;
    private CategoryRepository categoryRepository;

    //constructor
    public AssetController(AssetRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    //Mapping requests

    //HTTP Get request, read all assets
    @GetMapping("/")
    public String showAssets(Model model) {
        model.addAttribute("assets", repository.findAll());        
        return "assetList";
    }
    
    //HTTP Get request, go to add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("asset", new Asset());
        model.addAttribute("categories", categoryRepository.findAll());
        return "assetAdd";
    }

    //HTTP Post request, save new asset
    @PostMapping("/save")
    public String saveAsset(@ModelAttribute Asset asset) {
        repository.save(asset);
        return "redirect:/";
    }
   
    
}
