package com.yangpeng.TheadLocal;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

public class ThreadDemo {
	ThreadLocal<User> userLocal = new ThreadLocal<User>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();
	
	public void set() {
		userLocal.set(new User(10,"yang"));
		stringLocal.set("hello");
	}
	public User getUser() {
		return userLocal.get();
	}
	public String getString() {
		return stringLocal.get();
	}
	public static void main(String[] args) throws InterruptedException {
		final ThreadDemo demo = new ThreadDemo();
		System.out.println(demo.getUser());
		System.out.println(demo.getString());
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				demo.set();
				System.out.println(demo.getUser());
				System.out.println(demo.getString());
				System.out.println(Thread.currentThread().getName());
			}
		});
		thread1.start();
		thread1.join();
		System.out.println(Thread.currentThread().getName());
		System.out.println(demo.getUser());
		System.out.println(demo.getString());
		
		
	}

}
