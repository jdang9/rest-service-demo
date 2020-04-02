package com.demo.rest_service.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Player")
public class Player {
	private long id;
	private String name;
	private String position;
	private String nationality;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
