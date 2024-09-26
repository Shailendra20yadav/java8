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
			return;
		}

		Node<E> last = root;
		while (last.next != null) {
			last = last.next;
		}
		last.next = tmp;

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
