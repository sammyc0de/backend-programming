package syksy26.asset_mgmt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String vendor;
    private String model;
    private String description;
    private String OS;
    private String hostname;

    //Maintenance log will be added later

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
   
    public Asset() {
        
    }

    public Asset(String vendor, String model, String description, String OS, String hostname, Category category) {
        super();
        this.vendor = vendor;
        this.model = model;
        this.description = description;
        this.OS = OS;
        this.hostname = hostname;
        this.category = category;
    }

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


    @Override
	public String toString() {
		return "Asset id=" + id + ", vendor=" + vendor + ",model=" + model + ",description=" + description + ",OS=" + OS;
	}


    
}
