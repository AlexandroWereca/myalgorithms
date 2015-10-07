package com.alex.algorithms;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Node {
	private int x;
	private int y;
	private Node parent;
	public Node(int i, int j, Node p){
		this.x = i;
		this.y = j;
		this.parent = p;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Node getParent(){
		return this.parent;
	}
	
	public String toString(){
		return "[" +getX()+ "," + getY()+ "]";
	}
}

public class BFS {

	
	
	public static void main(String[] args) {
		String [][] maze = {{"1","1","1","1"},
					        {"1","0","0","1"},
					        {"1","1","1","1"},
					        {"0","0","3","1"}};
		bfs(maze);
	}
	
	private static void bfs(String [][] matrix){
		int mSize = matrix.length;
		Node start = new Node(0,0,null);
		Queue<Node> path = new LinkedList<Node>();
		Set<Integer> memory = new HashSet<Integer>();
		path.add(start);
		boolean isFound = false;
		Node parent = null;
		while(!path.isEmpty()){
			Node next;
			parent = path.remove();
			int x = parent.getX(), y = parent.getY(), id;
			if(matrix[x][y] == "3"){
				isFound = true;
				break;
			}
			
			//UP
			if(!(x-1 == -1) && matrix[x-1][y] != "0"){
				id = ((x-1) * mSize) + y;
				if(!memory.contains(id)){
					memory.add(id);
					next = new Node(x-1, y, parent);
					path.add(next);
				}
			}
			
			//DOWN
			if(!(x+1 > mSize - 1) && matrix[x+1][y] != "0"){
				id = ((x+1) * mSize) + y;
				if(!memory.contains(id)){
					memory.add(id);
					next = new Node(x+1, y, parent);
					path.add(next);
				}
			}
			
			//LEFT
			if(!(y-1 == -1) && matrix[x][y-1] != "0"){
				id = (x * mSize) + y-1;
				if(!memory.contains(id)){
					memory.add(id);
					next = new Node(x, y-1, parent);
					path.add(next);
				}
			}
			
			//RIGTH
			if(!(y+1 > matrix[x].length-1) && matrix[x][y+1] != "0"){
				id = (x * mSize) + y+1;
				if(!memory.contains(id)){
					memory.add(id);
					next = new Node(x, y+1, parent);
					path.add(next);
				}
			}
		}
		if(isFound){
			LinkedList<Node> trace = new LinkedList<Node>();
			Node node = parent;
			while(node != null){
				trace.add(node);
				node = node.getParent();
			}
			Collections.reverse(trace);
			for(int i=0, l = trace.size(); i<l; i++){
				if(i == l-1){
					System.out.print(trace.get(i));
				}else{
					System.out.print(trace.get(i)+"->");
				}
				
			}
		}
	}

}
