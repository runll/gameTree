package game;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class match {

	public static boolean isOver;
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, CloneNotSupportedException {
		
	Map m = new Map();
	
	while(!isOver){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入坐标落点：");
		int humanPositionX = scanner.nextInt();
		int humanPositionY = scanner.nextInt();
		
		m.MAP[humanPositionX][humanPositionY].value = "x";
		m.display();
		(m.whoTurn)++;
		System.out.println("whoTurn"+m.whoTurn);
		
		
		gameTree g = new gameTree();
		g.getCopePosition(m);//获得m.MAP的weight
		
		
		Random random = new Random();
		
		int AIPositionX = random.nextInt(3);
		int AIPositionY = random.nextInt(3);
		System.out.println("copePosition:("+AIPositionX+","+AIPositionY+")");
		if(m.MAP[AIPositionX][AIPositionY].isReachable()){
			m.MAP[AIPositionX][AIPositionY].value = "o";
			m.display();
			m.whoTurn++;
			System.out.println("whoTurn"+m.whoTurn);
			g.getCopePosition(m);
			
		}
		else System.out.println("此点已有落点");
		
	}
		
	}
	
	
}
