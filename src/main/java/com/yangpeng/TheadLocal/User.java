
package com.yangpeng.TheadLocal;

public class User {
	public User(int id,String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		
		return "id"+id +",name:"+name;
	}
	int id;
	String name;

}
