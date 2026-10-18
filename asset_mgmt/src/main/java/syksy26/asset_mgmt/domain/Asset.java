package syksy26.asset_mgmt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;


@Entity
public class Asset {

    //Create variables
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String vendor;
    private String model;
    private String description;
    private String OS;
    private String hostname;

    //Annotations needed for relationships between asset and other entities
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maintenancelogid")
    private MaintenanceLog maintenanceLog;
   
    public Asset() {
        
    }

    //Create asset object

    public Asset(String vendor, String model, String description, String OS, String hostname, Category category, MaintenanceLog maintenanceLog) {
        super();
        this.vendor = vendor;
        this.model = model;
        this.description = description;
        this.OS = OS;
        this.hostname = hostname;
        this.category = category;
        this.maintenanceLog = maintenanceLog;
      

    }

    //Get and set methods for getting and storing object data

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
		this.vendor = vendor;
	}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
		this.model = model;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
		this.description = description;
	}

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
		this.OS = OS;
	}

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
		this.hostname = hostname;
	}

    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

    public MaintenanceLog getMaintenanceLog() {
		return maintenanceLog;
	}

	public void setMaintenanceLog(MaintenanceLog maintenanceLog) {
		this.maintenanceLog = maintenanceLog;
	}
 
    //Return string containing asset data
    @Override
	public String toString() {
		return "Asset id=" + id + ", vendor=" + vendor + ",model=" + model + ",description=" + description + ",OS=" + OS;
	}


    
}
