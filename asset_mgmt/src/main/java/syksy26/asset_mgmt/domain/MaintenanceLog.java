package syksy26.asset_mgmt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate; //Needed for LocalDate data type

import org.springframework.format.annotation.DateTimeFormat; //For date formatting


@Entity
public class MaintenanceLog {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long maintenanceid;
	@DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
	private String description;
	
	
	public MaintenanceLog() {}
	
	 public MaintenanceLog(String description, LocalDate date) {
		super();
		this.date = date;
        this.description = description;

	}
	
	public Long getMaintenanceid() {
		return maintenanceid;
	}
	
	public void setMaintenanceid(Long maintenanceid) {
		this.maintenanceid = maintenanceid;
	}
	
 	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	} 

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "MaintenanceLog [maintenanceid=" + maintenanceid + ", date=" + date + ", description=" + description + " ]";
	}

}
