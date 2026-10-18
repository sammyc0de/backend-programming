package syksy26.asset_mgmt.web;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import syksy26.asset_mgmt.domain.Asset;
import syksy26.asset_mgmt.domain.AssetRepository;
import syksy26.asset_mgmt.domain.CategoryRepository;
import syksy26.asset_mgmt.domain.MaintenanceLogRepository;


@Controller
public class AssetController {
  
    private AssetRepository repository;
    private CategoryRepository categoryRepository;
    private MaintenanceLogRepository maintenanceLogRepository;

    //constructor
    public AssetController(AssetRepository repository, CategoryRepository categoryRepository, MaintenanceLogRepository maintenanceLogRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;  
        this.maintenanceLogRepository = maintenanceLogRepository;   
    }

    //HTTP mapping annotations

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
   
    //HTTP request for editing item
    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long assetId, Model model) {
        model.addAttribute("asset",repository.findById(assetId).orElseThrow());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("logs", maintenanceLogRepository.findAll());
        return "assetEdit";
    }

    //HTTP request for delete item
    @PreAuthorize("hasAuthority('ADMIN')") //Only admins can delete items
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long assetId, Model model) {
        repository.deleteById(assetId);
        return "redirect:../";    }
    
}
