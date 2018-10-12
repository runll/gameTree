package game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Map implements Serializable,Cloneable{

	
	public Node[][] MAP;
	public int whoTurn;//human先手，奇数为human刚落子，偶数为AI
						//换种说法，当whoTurn为奇数时，轮到AI落子
	

	//初始化MAP
	public Map(){
		super();
		MAP = new Node[3][3];
		for(int i = 0 ;i < 3;i++){
			for(int j = 0;j < 3 ;j++)
			MAP[i][j] = new Node (".",i+1,j+1);
		}
		//this.step = 9;
		this.whoTurn = 0;
	}
	
	public void display(){
		for(int i = 0 ;i < 3;i++){
			for(int j = 0;j < 3 ;j++){
				System.out.print(MAP[i][j].value + " ");	
			}
			
		System.out.println();
	  }
	}
	
	
	 public  Map deepClone() throws IOException, ClassNotFoundException{
	        //将对象写到流里
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream(bos);
	        oos.writeObject(this);
	        //从流里读回来
	        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
	        ObjectInputStream ois = new ObjectInputStream(bis);
	        return (Map)ois.readObject();
	    }
	 @Override
	    protected Map clone() throws CloneNotSupportedException {
		 	Map object = new Map();
	        object.whoTurn = whoTurn;
	        object.MAP = new Node[3][3];
	        for(int i = 0; i<3;i++){
	        	for(int j = 0;j<3;j++)
	        		object.MAP[i][j] = (Node) MAP[i][j].clone();
	        }
			 return object;
	    }
	 


}
