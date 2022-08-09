package com.shrimpco.omikujiproject.modules;

public class Omikuji {
	private Integer years;
	private String city;
	private String person;
	private String hobby;
	private String creature;
	private String nice;
	
	public Omikuji(Integer years, String city, String person, String hobby, String creature, String nice) {
		this.years = years;
		this.city = city;
		this.person = person;
		this.hobby = hobby;
		this.creature = creature;
		this.nice = nice;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getCreature() {
		return creature;
	}

	public void setCreature(String creature) {
		this.creature = creature;
	}

	public String getNice() {
		return nice;
	}

	public void setNice(String nice) {
		this.nice = nice;
	}
}
