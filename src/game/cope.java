package game;

import java.io.IOException;

public class cope {

	public int positionX;
	public int positionY;

	/**
	 * 
	 * @param MAP
	 * @return positionX&&Y
	 * 
	 */
	public void getCopePosition(Map map) throws ClassNotFoundException, IOException {

		try {
			tree Tree = new tree();
			gameTree g = new gameTree();
			g.buildTree(map, Tree, 3);
			g.alphaBeta(Tree);
			positionX = Tree.positionX;
			positionY = Tree.positionY;
			System.out.println("AIÂä×Ó:("+positionX+","+positionY+")");
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
