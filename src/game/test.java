package game;

import java.io.IOException;

import org.junit.Test;

public class test {

	@Test
	 void testCloneMap() throws ClassNotFoundException, IOException{
		
		System.out.println("-----��ʼ��---------");
		Map m = new Map();
		m.display();
		System.out.println("------��¡Ч��---------------");
		Map temp = m.deepClone() ;
		temp.display();
		System.out.println("------��¡�޸�------------");
		temp.MAP[1][1]= new Node("x", 2, 2);
		temp.display();
		System.out.println("-------ԭ��ʼ��------------");
		m.display();
	}
	
	@Test
	 void testCloneNode() throws ClassNotFoundException, IOException{
		
		Node node = new Node(".",1,1);
		System.out.println("-----��ʼ��---------");
		System.out.println(node.value);
		System.out.println("-----��¡Ч��---------");
		Node nodeClone = node.deepClone();
		System.out.println(nodeClone.value);
		System.out.println("-----��¡�޸�---------");
		nodeClone.value = "o";
		System.out.println(nodeClone.value);
		System.out.println("-----ԭ��ʼ��---------");
		System.out.println(node.value);
	}	

	@Test
	 void testtree(){
		
		
		//tree test = new tree(new tree(null, 1, 1).childs,0,0);
		
		
		 
	 }

}