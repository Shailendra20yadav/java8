package com.sk.java8.dsalgo.array;

public class TestCustomLinkedList {

	public static void main(String[] args) {
		Integer [] arr = { 1, 5, 6, 9, 8 };
		System.out.println(CustomLinkedList.createFromArray(arr));
		System.out.println(CustomLinkedList.createFromArray(null));
		CustomLinkedList <Integer>linkedList = new CustomLinkedList<>();
		System.out.println(linkedList);
		linkedList.add(1);
		linkedList.add(2);
		
		System.out.println(linkedList);
		
		String [] str = {"abc","xx","xyz"};
		System.out.println(CustomLinkedList.createFromArray(str));
		
		CustomLinkedList <String> strList = new CustomLinkedList<>();
		System.out.println(strList);
		strList.add("Hello how are you");
		strList.add("Hello world !");
		
		System.out.println(strList + "Size = " +strList.getSize());

	}

}
