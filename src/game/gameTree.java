package game;

import java.io.IOException;
import java.util.*;


//将MAP中Node类型的值的value和position存入树中
//递归增加List<tree>子树

public class gameTree {

	public int gameTreeWeight;

	public gameTree() {
		super();
	}

	public boolean humanWin(Map m) {
		for (int i = 0; i < 3; i++) {

			if (m.MAP[i][0].value == "x" && m.MAP[i][1].value == "x" && m.MAP[i][2].value == "x")
				return true;
		}
		for (int j = 0; j < 3; j++) {

			if (m.MAP[0][j].value == "x" && m.MAP[1][j].value == "x" && m.MAP[2][j].value == "x")
				return true;
		}

		if (m.MAP[0][0].value == "x" && m.MAP[1][1].value == "x" && m.MAP[2][2].value == "x")
			return true;

		if (m.MAP[0][2].value == "x" && m.MAP[1][1].value == "x" && m.MAP[2][0].value == "x")
			return true;

		return false;
	}

	public boolean AIWin(Map m) {
		for (int i = 0; i < 3; i++) {

			if (m.MAP[i][0].value == "o" && m.MAP[i][1].value == "o" && m.MAP[i][2].value == "o")
				return true;
		}
		for (int j = 0; j < 3; j++) {

			if (m.MAP[0][j].value == "o" && m.MAP[1][j].value == "o" && m.MAP[2][j].value == "o")
				return true;
		}

		if (m.MAP[0][0].value == "o" && m.MAP[1][1].value == "o" && m.MAP[2][2].value == "o")
			return true;

		if (m.MAP[0][2].value == "o" && m.MAP[1][1].value == "o" && m.MAP[2][0].value == "o")
			return true;

		return false;
	}

	/**
	 * 
	 * @param MAP
	 * @return gameTreeWeight
	 * @throws CloneNotSupportedException
	 */
	public int getGameTreeWeight(Map map) throws ClassNotFoundException, IOException, CloneNotSupportedException {

		Map m1 = (Map) map.clone();// 用于填充x
		Map m2 = (Map) map.clone();// 用于填充o
		int humanMapWeight = 0;
		int AIMapWeight = 0;

		if (AIWin(map))
			return Integer.MIN_VALUE;
		if (humanWin(map))
			return Integer.MAX_VALUE;

		for (Node[] temp : m1.MAP) {
			for (Node temp1 : temp) {
				if (temp1.value == ".")
					temp1.value = "x";
			}
		}
		humanMapWeight = getHumanMapWeight(m1);

		for (Node[] temp : m2.MAP) {
			for (Node temp1 : temp) {
				if (temp1.value == ".")
					temp1.value = "o";
			}
		}
		AIMapWeight = getAIMapWeight(m2);
		return humanMapWeight - AIMapWeight;
	}

	/**
	 * 
	 * @param map
	 * @return humanMapWeight
	 */
	public int getHumanMapWeight(Map m) {
		// 一行，一列，正对角，反对角
		int count = 0;
		for (int i = 0; i < 3; i++) {

			if (m.MAP[i][0].value == "x" && m.MAP[i][1].value == "x" && m.MAP[i][2].value == "x")
				count++;
		}
		for (int j = 0; j < 3; j++) {

			if (m.MAP[0][j].value == "x" && m.MAP[1][j].value == "x" && m.MAP[2][j].value == "x")
				count++;
		}

		if (m.MAP[0][0].value == "x" && m.MAP[1][1].value == "x" && m.MAP[2][2].value == "x")
			count++;

		if (m.MAP[0][2].value == "x" && m.MAP[1][1].value == "x" && m.MAP[2][0].value == "x")
			count++;

		return count;
	}

	/**
	 * 
	 * @param m
	 * @return AIMapWeight
	 */
	public int getAIMapWeight(Map m) {
		int count = 0;
		for (int i = 0; i < 3; i++) {

			if (m.MAP[i][0].value == "o" && m.MAP[i][1].value == "o" && m.MAP[i][2].value == "o")
				count++;
		}
		for (int j = 0; j < 3; j++) {

			if (m.MAP[0][j].value == "o" && m.MAP[1][j].value == "o" && m.MAP[2][j].value == "o")
				count++;
		}

		if (m.MAP[0][0].value == "o" && m.MAP[1][1].value == "o" && m.MAP[2][2].value == "o")
			count++;

		if (m.MAP[0][2].value == "o" && m.MAP[1][1].value == "o" && m.MAP[2][0].value == "o")
			count++;

		return count;
	}

	public void buildTree(Map map, tree parent, int depth)
			throws CloneNotSupportedException, ClassNotFoundException, IOException {

		if (depth > 1) {
			List<Map> maps = new ArrayList<Map>();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {// 向前探索，当AI已落子时

					if (map.MAP[i][j].isReachable() && (depth == 4 || depth == 2)) {
						Map map2 = map.clone();
						map2.MAP[i][j].value = "x";
						maps.add(map2);
						tree treeNode = new tree();
						treeNode.positionX = i;
						treeNode.positionY = j;
						parent.children.add(treeNode);

					}
					if (map.MAP[i][j].isReachable() && depth % 2 != 0) {// 向前探索，当human已落子时
						Map map2 = map.clone();
						if (humanWin(map2) == false) {
							map2.MAP[i][j].value = "o";
						}
						maps.add(map2);
						tree treeNode = new tree();
						treeNode.positionX = i;
						treeNode.positionY = j;
						parent.children.add(treeNode);

					}

				}
			}
			for (int t = 0; t < maps.size(); t++) {
				buildTree(maps.get(t), parent.children.get(t), depth - 1);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {// 向前探索，当轮到AI落子时

					if (map.MAP[i][j].isReachable()) {
						Map map2 = map.clone();
						if (humanWin(map2) == false) {
							map2.MAP[i][j].value = "o";
						}
						tree treeNode = new tree();
						treeNode.positionX = i;
						treeNode.positionY = j;
						treeNode.nodeData = getGameTreeWeight(map2);
						parent.children.add(treeNode);
					}
				}
			}
		}
	}

	// 最大
	public int max(int a, int b) {
		return a >= b ? a : b;
	}

	// 最小
	public int min(int a, int b) {
		return a <= b ? a : b;
	}

	public void print(tree Tree, int depth) {
		if (depth < 5) {
			System.out.println("..." + depth);
			System.out.println(Tree.nodeData);
			for (tree childs : Tree.children) {
				print(childs, depth + 1);
			}
		} else {
			return;
		}
	}

	public void alphaBeta(tree parent) {

		for (int i = 0; i < parent.children.size(); i++) {
			for (int j = 0; j < parent.children.get(i).children.size(); j++) {
				for (int t = 0; t < parent.children.get(i).children.get(j).children.size(); t++) {

					parent.children.get(i).children.get(j).b = min(parent.children.get(i).children.get(j).b,
							parent.children.get(i).children.get(j).children.get(t).nodeData);
					if (parent.children.get(i).children.get(j).b <= parent.children.get(i).a)
						break;
				}
				parent.children.get(i).children.get(j).nodeData = parent.children.get(i).children.get(j).b;
				parent.children.get(i).a = max(parent.children.get(i).children.get(j).b, parent.children.get(i).a);
				if (parent.children.get(i).a >= parent.b)
					break;
			} // mid
			parent.children.get(i).nodeData = parent.children.get(i).a;
			parent.b = min(parent.b, parent.children.get(i).nodeData);
		}
		parent.nodeData = parent.b;
		int temp = Integer.MAX_VALUE;
		for (int i = 0; i < parent.children.size(); i++) {
			if (parent.children.get(i).nodeData < temp) {
				temp = parent.children.get(i).nodeData;
				parent.positionX = parent.children.get(i).positionX;
				parent.positionY = parent.children.get(i).positionY;
			}
		}
	}
}

