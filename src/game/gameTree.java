package game;

import java.io.IOException;

//��MAP��Node���͵�ֵ��value��position��������
//�ݹ�����List<tree>����

public class gameTree {

	public int gameTreeWeight;
	
	public gameTree(){
		super();		
	}
	
	/**
	 * 
	 * @param MAP
	 * @return positionX&&Y

	 */
	public void getCopePosition(Map map) throws ClassNotFoundException, IOException{
		
		try {
			gameTreeWeight = getGameTreeWeight(map);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param MAP
	 * @return gameTreeWeight
	 * @throws CloneNotSupportedException 
	 */
	public int getGameTreeWeight(Map map) throws ClassNotFoundException, IOException, CloneNotSupportedException{

		Map m1 = (Map)map.clone();//�������x
		Map m2 = (Map)map.clone();//�������o
		int humanMapWeight = 0;
		int AIMapWeight = 0;
		
		//��Ϊ������AI����ͼ��Ȩ��
		//if(map.whoTurn%2!=0){
			for(Node[] temp :m1.MAP){
				for(Node temp1 : temp){
					if(temp1.value == ".")temp1.value = "x";
				}
			}
			 humanMapWeight = getHumanMapWeight(m1);
			for(Node[] temp :m2.MAP){
				for(Node temp1 : temp){
					if(temp1.value == ".")temp1.value = "o";
				}
			}
			 AIMapWeight = getAIMapWeight(m2);
		//}

		return humanMapWeight - AIMapWeight;
	}
	
	/**
	 * 
	 * @param map
	 * @return humanMapWeight
	 */
	public int getHumanMapWeight(Map m){
		//һ�У�һ�У����Խǣ����Խ�
		int count = 0;
		for(int i=0;i<3;i++){
			
				if(m.MAP[i][0].value == "x" &&m.MAP[i][1].value == "x" &&m.MAP[i][2].value == "x")
				count++;			
		}
		for(int j = 0;j < 3;j++){
			
			if(m.MAP[0][j].value == "x" &&m.MAP[1][j].value == "x" &&m.MAP[2][j].value == "x")
				count++;	
		}
		
		if(m.MAP[0][0].value == "x" &&m.MAP[1][1].value == "x" &&m.MAP[2][2].value == "x")
			count++;
		
		if(m.MAP[0][2].value == "x" &&m.MAP[1][1].value == "x" &&m.MAP[2][0].value == "x")
			count++;
			
		return count;
	}
	/**
	 * 
	 * @param m
	 * @return AIMapWeight
	 */
	public int getAIMapWeight(Map m){
		int count = 0;
		for(int i=0;i<3;i++){
			
				if(m.MAP[i][0].value == "o" &&m.MAP[i][1].value == "o" &&m.MAP[i][2].value == "o")
				count++;			
		}
		for(int j = 0;j < 3;j++){
			
			if(m.MAP[0][j].value == "o" &&m.MAP[1][j].value == "o" &&m.MAP[2][j].value == "o")
				count++;	
		}
		
		if(m.MAP[0][0].value == "o" &&m.MAP[1][1].value == "o" &&m.MAP[2][2].value == "o")
			count++;
		
		if(m.MAP[0][2].value == "o" &&m.MAP[1][1].value == "o" &&m.MAP[2][0].value == "o")
			count++;
			
		return count;
	}
	

	
	public void buildTree(){
		
		
	}
	
	
	
	
	
}









