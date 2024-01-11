package com.example.demo.springdatajpa.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Guardian {
	
	private String guardianName;
	private String guardianEmail;
	private Long guardianMobile;

}
