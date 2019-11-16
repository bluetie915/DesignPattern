package com.model;

public class Student {

	private Integer id;
	private String name;
	private String hobby;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", hobby=" + hobby + "]";
	}
	public Student(Integer id, String name, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.hobby = hobby;
	}
	
}
