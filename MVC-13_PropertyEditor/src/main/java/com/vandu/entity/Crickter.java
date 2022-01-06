package com.vandu.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CricketersInfo_LDT")
public class Crickter{
	@Id
	@SequenceGenerator(name = "gen1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer cno;
	private String cname;
	private String ctype;
	//private Date dob;
	//private Date doj;
	
	private LocalDateTime dob;
	private LocalDate doj;


}
