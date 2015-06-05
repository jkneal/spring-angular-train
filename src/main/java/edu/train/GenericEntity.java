package edu.train;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GenericEntity {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT", nullable=false)
	@Getter
	@Setter
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DT")
	@Getter
	@Setter
	private Date lastUpdateDate;

}
