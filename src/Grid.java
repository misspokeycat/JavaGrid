//Grid.java
//A grid full of data nodes, essentially a two-dimensional array with helpers for traversal/filling.
public class Grid {
	private Node[][] data;
	private int height, width;
	public Grid(int height, int width){
		data = new Node[height][width];
		this.height = height;
		this.width = width;
		for (int x=0; x<height; x++){
			for(int y=0; y<width; y++){
				data[x][y] = new Node(this, null, x, y);
			}
		}
	}
	
	public void fillGrid (Object fillObject){
		for (int x=0; x<height; x++){
			for(int y=0; y<width; y++){
				data[x][y].setData(fillObject);
			}
		}
	}
	
	public void fillAllEmpty (Object fillObject){
		for (int x=0; x<height; x++){
			for(int y=0; y<width; y++){
				if (data[x][y].getData() == null) data[x][y].setData(fillObject);
			}
		}
	}
	
	public Node getNode(int x, int y){
		return data[x][y];
	}
	
	public Node[] getColumn(int ColumnNumber){
		Node[] colArray = new Node[height];
			for(int x=0; x<height; x++){
				colArray[x] = data[x][ColumnNumber];
			}
		return colArray;
	}
	
	public Node[] getRow(int RowNumber){
		return data[RowNumber];
	}
	
	public String toString(){
		String outString = "";
		for (int x=0; x<height; x++){
			for (int y=0; y<width; y++){
				outString = outString + data[x][y].toString() + " ";
			}
			if (x != height - 1)outString = outString + "\n";
		}
		return outString;
	}
	
}
