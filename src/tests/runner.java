package tests;
import libGrid.Grid;
import libGrid.Node;



public class runner {
	public static void main(String[] args) {
		Grid gridTest  = new Grid(4, 4);
		//gridTest.fillGrid("#");
		recursiveGridFillLine(gridTest.getNode(0, 0), Node.EAST);
		Node[] surround = gridTest.getNode(1, 1).getNeighbors();
		int inc = 0;
		for (Node sdata: surround){
			sdata.setData(inc);
			inc++;
		}
		System.out.println(gridTest.toString());
	}
	public static void recursiveGridFillLine(Node node, int direction){
		node.setData("R");
		Node rnode = node.getInDirection(direction);
		if (rnode == null){
			return;
		}
		recursiveGridFillLine(rnode, direction);
	}
}
