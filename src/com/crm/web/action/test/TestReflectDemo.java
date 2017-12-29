package com.crm.web.action.test;

public class TestReflectDemo {

	private Long id ;
	private String name;
	private String title;
	private int num;
	
	private TestReflectDemo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TestReflectDemo(Long id, String name, String title, int num) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.num = num;
	}
	
	public String testGo(String name,int num){
		System.out.println("名字："+name+"; 号码："+num);
		return "yes";
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public int getNum() {
		return num;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
