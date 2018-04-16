package GA;

import java.util.Random;
import java.util.logging.Logger;

public class GeneAlgorithm 
{
    
        private static Logger log = Logger.getLogger(GeneAlgorithm.class.getName());
    
	IndividualNode run(Population list)
	{
		createBeginningSpecies(list);
		
		for(int i=1;i<=NatureCondition.DEVELOP_NUM;i++)
		{
                        
			select(list);
			
			crossover(list);
			
			mutate(list);
                        
		}	
		
                list.traverse();
                
		return getBest(list);
	}
	
	public void createBeginningSpecies(Population list)
	{
		int randomNum=(int)(NatureCondition.SPECIES_NUM);
		for(int i=1;i<=randomNum;i++)
		{
			IndividualNode species=new IndividualNode();
			species.createByRandomGenes();

			list.add(species);
		}
		
	}

	void calRate(Population list)
	{
		float totalFitness=0.0f;
		list.speciesNum=0;
		IndividualNode point=list.head.next;
		while(point != null)
		{
			point.calFitness();
			
			totalFitness += point.fitness;
			list.speciesNum++;

			point=point.next;
		}

		
		point=list.head.next;
		while(point != null)
		{
			point.rate=point.fitness/totalFitness;
			point=point.next;
		}
	}
	
	
	public void select(Population list)
	{			
		//log.info("selection begin");
		calRate(list);
		
		
		float talentDis=Float.MAX_VALUE;
		IndividualNode talentSpecies=null;
		IndividualNode point=list.head.next;

		while(point!=null)
		{
			if(talentDis > point.distance)
			{
				talentDis=point.distance;
				talentSpecies=point;
			}
			point=point.next;
		}

		
		Population newPopulation=new Population();
		int talentNum=(int)(list.speciesNum/4);
		for(int i=1;i<=talentNum;i++)
		{
			
			IndividualNode newSpecies=talentSpecies.clone();
			newPopulation.add(newSpecies);
		}

		
		int roundNum=list.speciesNum-talentNum;
		for(int i=1;i<=roundNum;i++)
		{
			
			float rate=(float)Math.random();
			
			IndividualNode oldPoint=list.head.next;
			while(oldPoint != null && oldPoint != talentSpecies)
			{
				if(rate <= oldPoint.rate)
				{
					IndividualNode newSpecies=oldPoint.clone();
					newPopulation.add(newSpecies);
					
					break;
				}
				else
				{
					rate=rate-oldPoint.rate;
				}
				oldPoint=oldPoint.next;
			}
			if(oldPoint == null || oldPoint == talentSpecies)
			{
				
				point=list.head;
				while(point.next != null)
					point=point.next;
				IndividualNode newSpecies=point.clone();
				newPopulation.add(newSpecies);
			}
			
		}
		list.head=newPopulation.head;
                //log.info("selection end....");
	}
	
	public void crossover(Population list)
	{
		float rate=(float)Math.random();
		if(rate > NatureCondition.pcl && rate < NatureCondition.pch)
		{			
			IndividualNode point=list.head.next;
			Random rand=new Random();
			int find=rand.nextInt(list.speciesNum);
			while(point != null && find != 0)
			{
				point=point.next;
				find--;
			}
		
			if(point.next != null)
			{
				int begin=rand.nextInt(NatureCondition.CITY_NUM);

				for(int i=begin;i<NatureCondition.CITY_NUM;i++)
				{
					int fir,sec;
					for(fir=0;!point.genes[fir].equals(point.next.genes[i]);fir++);
					for(sec=0;!point.next.genes[sec].equals(point.genes[i]);sec++);
					String tmp;
					tmp=point.genes[i];
					point.genes[i]=point.next.genes[i];
					point.next.genes[i]=tmp;
					
					point.genes[fir]=point.next.genes[i];
					point.next.genes[sec]=point.genes[i];
					
				}
			}
		}
	}
	
	void mutate(Population list)
	{	
		IndividualNode point=list.head.next;
		while(point != null)
		{
			float rate=(float)Math.random();
			if(rate < NatureCondition.pm)
			{
				Random rand=new Random();
				int left=rand.nextInt(NatureCondition.CITY_NUM);
				int right=rand.nextInt(NatureCondition.CITY_NUM);
				if(left > right)
				{
					int tmp;
					tmp=left;
					left=right;
					right=tmp;
				}
				
				while(left < right)
				{
					String tmp;
					tmp=point.genes[left];
					point.genes[left]=point.genes[right];
					point.genes[right]=tmp;

					left++;
					right--;
				}
			}
			point=point.next;
		}
	}

	IndividualNode getBest(Population list)
	{
		float distance=Float.MAX_VALUE;
		IndividualNode bestSpecies=null;
		IndividualNode point=list.head.next;
		while(point != null)
		{
			if(distance > point.distance)
			{
				bestSpecies=point;
				distance=point.distance;
			}

			point=point.next;
		}
		
		return bestSpecies;
	}
}
