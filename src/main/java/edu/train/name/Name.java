package edu.train.name;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Name {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
}
