package game;

import java.util.List;
import java.util.Scanner;



public class tree {


	public List<tree> childs;
	public int weight;
	public int positionX;
	public int positionY;
	
	
	public tree(){
		
	}
	/**
	 * 
	 * @param positionX
	 * @param positionY
	 * @param weight
	 */
	
	public tree(int positionX,int positionY){
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.weight = weight;
	}
	/**
	 * 
	 * @param childs
	 * @param positionX
	 * @param positionY
	 * @return gameTree
	 */
	
    public tree(List<tree> childs,int positionX,int positionY){
    	
    	super();
    	this.childs = childs;
    	this.positionX = positionX;
    	this.positionY = positionY;
    }
    
    
	//ÃÓ≥‰¿©’πchilds
    public void addChilds(tree g){
    	
    	childs.add(g);
    	
    }
    
}
