package game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Node implements Serializable,Cloneable{

	
	public String value;	
	
	//�ж�ĳ�����Ƿ������
	public boolean isReachable(){
		
		if(value == "x"||value == "o" ) return false;
		else return true;
	}
	
	
	/**
	 * @param value,X,Y
	 * @return node
	 */
	public Node(String value,int X,int Y){
		super();
		this.value = value;

		
	}
	
	public Node (){
		super();
	}
	
	 public  Node deepClone() throws IOException, ClassNotFoundException{
	        //������д������
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream(bos);
	        oos.writeObject(this);
	        //�����������
	        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
	        ObjectInputStream ois = new ObjectInputStream(bis);
	        return (Node)ois.readObject();
	    }
	 
	 @Override
	    protected Object clone() throws CloneNotSupportedException {
	        return super.clone();
	        
	    }

	
}
