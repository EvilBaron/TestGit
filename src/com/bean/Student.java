package com.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;



public class Student{
	private Integer id;
	private String name;
	private Boolean sex;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	/*@JSONField(format="yyyy-MM-dd")*/
	private Date birthday;
	private Integer gradeId;
	private Double score;
	
	private Grade grade;


	public Student(){
		super();
	}
	public Student(Integer id,String name,Boolean sex,Date birthday,Integer gradeId,Double score) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.gradeId = gradeId;
		this.score = score;

	}
	
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
	public Boolean getSex(){
		return sex;
	}

	public void setSex(Boolean sex){
		this.sex = sex;
	}
	public Date getBirthday(){
		return birthday;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	public Integer getGradeId(){
		return gradeId;
	}

	public void setGradeId(Integer gradeId){
		this.gradeId = gradeId;
	}
	public Double getScore(){
		return score;
	}

	public void setScore(Double score){
		this.score = score;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	

}