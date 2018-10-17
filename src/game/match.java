package game;

import java.io.IOException;
import java.util.Scanner;

public class match {

	public static boolean isOver;
	
	public static void checkWin(Map m) {
		gameTree gTree = new gameTree();
		if (gTree.humanWin(m)) {
			isOver = true;
			System.out.println("您赢啦！");
		}
		if (gTree.AIWin(m)) {
			isOver = true;
			System.out.println("很遗憾您输啦，再接再厉！");
		}		
		else
			return;
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, CloneNotSupportedException {

		Map m = new Map();
		int step = 0;
		
		while (!isOver) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入坐标落点：");
			int humanPositionX = scanner.nextInt();
			int humanPositionY = scanner.nextInt();

			m.MAP[humanPositionX][humanPositionY].value = "x";
			step++;
			m.display();
			checkWin(m);
			
			cope c = new cope();
			c.getCopePosition(m);

			m.MAP[c.positionX][c.positionY].value = "o";
			step++;
			m.display();
			checkWin(m);
			System.out.println();
			if(step == 10){
				isOver = true;
				System.out.println("平局！");
			}
		}

	}

}
