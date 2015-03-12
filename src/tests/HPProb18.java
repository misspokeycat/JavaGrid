//HPProb18.java
//A class designed to beat HP Code Wars 2015 Problem 18 using libGrid and a recursive solving method.
package tests;
import java.util.Scanner;

import libGrid.*;
public class HPProb18 {
	public static Grid solutionGrid;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		int startx = 0, starty = 0;
		Grid dataGrid = new Grid(rows, cols);
		for (int x=0; x<rows; x++){
			for(int y=0; y<cols; y++){
				dataGrid.getNode(x, y).setData(scan.next());
				if (dataGrid.getNode(x, y).getData().equals("S")){
					startx = x;
					starty = y;
				}
			}
			scan.nextLine();
		}
		solutionGrid = new Grid(rows, cols);
		solutionGrid.fillAllEmpty("#");
		solveMaze(dataGrid.getNode(startx, starty), null);
		System.out.println(solutionGrid.toString());
		scan.close();
	}
	
	private static boolean solveMaze(Node node, Node refnode) { //Recursive method used to solve the maze.
		int currentHeight = -1;
		if (node.getData().equals("S")){
			refnode = node;
			currentHeight = 99;
			solutionGrid.getNode(node.getXpos(), node.getYpos()).setData("S");
		} else if (node.getData().equals("X")){
			solutionGrid.getNode(node.getXpos(), node.getYpos()).setData("X");
			return true;
		}
		else currentHeight = Integer.parseInt((String)node.getData());
		Node[] neighbors = new Node[]{node.getInDirection(Node.NORTH), node.getInDirection(Node.SOUTH), node.getInDirection(Node.EAST), node.getInDirection(Node.WEST)};
		for (Node nnode: neighbors){
			if (!(nnode == null) && !(nnode.equals(refnode))){ //We can't traverse to a null node, and we also can't traverse to the referrer.
				if (nnode.getData().equals("X")){
					solveMaze(nnode, node);
					solutionGrid.getNode(node.getXpos(), node.getYpos()).setData(".");
					return true;
				}
					int testval = 100;
				try {
					testval = Integer.valueOf((String) nnode.getData());
				} catch (Exception ex) {

				}
				if (testval <= currentHeight) {
					if (solveMaze(nnode, node)) {
						if (!(node.getData().equals("S"))){ //So we don't override the "S".
							solutionGrid.getNode(node.getXpos(), node.getYpos()).setData(".");
						}
						return true;
					}
				}
			} else {System.out.print("");}
		}
		return false;
	}
}
