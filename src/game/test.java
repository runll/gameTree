package game;

import java.io.IOException;

import org.junit.Test;

public class test {

	@Test
	 void testCloneMap() throws ClassNotFoundException, IOException{
		
		System.out.println("-----初始化---------");
		Map m = new Map();
		m.display();
		System.out.println("------克隆效果---------------");
		Map temp = m.deepClone() ;
		temp.display();
		System.out.println("------克隆修改------------");
		temp.MAP[1][1]= new Node("x", 2, 2);
		temp.display();
		System.out.println("-------原初始化------------");
		m.display();
	}
	
	@Test
	 void testCloneNode() throws ClassNotFoundException, IOException{
		
		Node node = new Node(".",1,1);
		System.out.println("-----初始化---------");
		System.out.println(node.value);
		System.out.println("-----克隆效果---------");
		Node nodeClone = node.deepClone();
		System.out.println(nodeClone.value);
		System.out.println("-----克隆修改---------");
		nodeClone.value = "o";
		System.out.println(nodeClone.value);
		System.out.println("-----原初始化---------");
		System.out.println(node.value);
	}	

	@Test
	 void testtree(){
		
		
		//tree test = new tree(new tree(null, 1, 1).childs,0,0);
		
		
		 
	 }

}