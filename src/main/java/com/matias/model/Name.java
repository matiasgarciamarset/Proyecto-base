package com.matias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* Query para crear tabla
 CREATE TABLE test.name_table (
  id int(20) NOT NULL,
  name varchar(255) NULL,
  PRIMARY KEY (id)
);
 */
@Entity
@Table(name = "name_table")
public class Name {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
