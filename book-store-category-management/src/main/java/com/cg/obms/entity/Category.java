package com.cg.obms.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category_tbl")
public class Category {
	@Id
	@Column(name = "category_id")
	@GeneratedValue(generator = "category_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "category_seq",sequenceName = "category_seq",allocationSize = 1)
	private int categoryId;
	
	@Column(name = "category_name",length = 20)
	private String categoryName;
	
	 
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	 
	
	

}
