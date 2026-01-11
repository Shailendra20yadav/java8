package com.sk.java8.dsalgo.array;

public class CustomLinkedList<E> {

	private static class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<E> root;
	
	private int size =0;

	public static <T> CustomLinkedList<T> createFromArray(T[] arr) {
		CustomLinkedList<T> linkedlist = new CustomLinkedList<>();
		if (arr == null || arr.length == 0)
			return linkedlist;
		for (int i = 0; i < arr.length; i++) {
			linkedlist.add(arr[i]);
		}
		return linkedlist;
	}

	public void add(E data) {
		Node<E> tmp = new Node<>(data);
		if (root == null) {
			root = tmp;
			size++;
			return;
		}

		Node<E> last = root;
		while (last.next != null) {
			last = last.next;
		}
		last.next = tmp;
		size++;

	}
	
	public boolean remove (E data) {
		if(size ==0)
			return false;
		Node<E> first = root;
		if(first.data ==data || first.data.equals(data) && size ==1) {
			first.data =null; 
			size--;
			return true;
		}
		boolean result =false;
		if(first.data ==data || first.data.equals(data)){
			size--;
			root= first.next;
			return true;
		}
		while(first.next !=null) {
			Node<E> next = first.next;
			
		}
		
		return result;

	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("[]");
			return sb.toString();
		}
		sb.append("[ ");
		Node<E> tmp = root;
		while (tmp.next != null) {
			sb.append(tmp.data).append(", ");
			tmp = tmp.next;
		}
		sb.append(tmp.data);
		sb.append(" ]");
		return sb.toString();
	}

}
