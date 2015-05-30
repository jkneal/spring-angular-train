package edu.train;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public class GenericEntity {
	
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name="CREATE_DT")
	  private Date createDate;

}
