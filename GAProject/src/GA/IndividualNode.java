/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;


import java.util.Random;


public class IndividualNode 
{	
	public String[] genes;
        public String[] genecode;
        
	public float distance;
	public float fitness;
	public IndividualNode next;
	float rate;
	
	IndividualNode()
	{
		this.genes=new String[NatureCondition.CITY_NUM];
                this.genecode = new String[NatureCondition.CITY_NUM];
		this.fitness=0.0f;
		this.distance=0.0f;
		this.next=null;
		rate=0.0f;
	}
	
	void createByRandomGenes()
	{
		for(int i = 0;i < genes.length;i++)
		{
			genes[i]=Integer.toString(i+1);
		}
		
		Random rand=new Random();

		for(int j=0;j<genes.length;j++)
		{
			int num= j + rand.nextInt(genes.length-j);
			
			String tmp;
			tmp=genes[num];
			genes[num]=genes[j];
			genes[j]=tmp;
                }
                
                
	}
        
        public void geneCode(){
            for (int i = 0; i < genes.length; i++) {
                    this.genecode[i] = Gene.encode(Integer.parseInt(genes[i]));
                }
            
        }
	
	void calFitness()
	{
		float totalDis=0.0f;
		for(int i = 0;i < NatureCondition.CITY_NUM;i++)
		{
			int curCity=Integer.parseInt(this.genes[i])-1;
			int nextCity=Integer.parseInt(this.genes[(i+1) % NatureCondition.CITY_NUM])-1;

			totalDis += NatureCondition.disMap[curCity][nextCity];
		}
		
		this.distance=totalDis;
		this.fitness=1.0f/totalDis;
	}
	
	public IndividualNode clone()
	{	
		IndividualNode species=new IndividualNode();
		
		for(int i=0;i<this.genes.length;i++)
			species.genes[i]=this.genes[i];
		species.distance=this.distance;
		species.fitness=this.fitness;
	
		return species;	
	}
	
	public void printRate()
	{
		System.out.print("Shortest Path:");
		for(int i=0;i<genes.length;i++){
                    System.out.print(genes[i]+"->");
                }
			
		System.out.print(genes[0]+"\n");
                
                geneCode();
                System.out.print("Gene Code: ");
                for(int i=0;i<genes.length;i++){
                    
                    System.out.print(genecode[i]);
                }
                System.out.println("");
		System.out.println("Shortest distance:" + distance);
	}
}
