package edu.train;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GenericEntity {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT")
	@Getter
	@Setter
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DT")
	@Getter
	@Setter
	private Date lastUpdateDate;
	
	@PrePersist @PreUpdate
	public void updateTimestamps() {
		if(createDate == null) {
			setCreateDate(new Date());
		}
		setLastUpdateDate(new Date());
	}

}
