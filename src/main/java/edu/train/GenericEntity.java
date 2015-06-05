package edu.train;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@MappedSuperclass
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GenericEntity {
	
  @Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT", nullable=false)
	private Date createDate;

}
