package com.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Student_Details")
@Data 
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	@Id
	private int id;
	private String name;
	private String city;
	
	private Certificate certificate;
	
}
