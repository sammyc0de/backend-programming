package syksy26.asset_mgmt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String vendor;
    private String model;
    private String description;
    private String OS;
    private String hostname;

    //Category and maintenance log will be added later
   
    public Asset() {
        
    }

    public Asset(String vendor, String model, String description, String OS, String hostname) {
        this.vendor = vendor;
        this.model = model;
        this.description = description;
        this.OS = OS;
        this.hostname = hostname;
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

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public String getOS() {
        return OS;
    }

    public String getHostname() {
        return hostname;
    }

    @Override
	public String toString() {
		return "Asset id=" + id + ", vendor=" + vendor + ",model=" + model + ",description=" + description + ",OS=" + OS;
	}


    
}
