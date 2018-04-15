package GA;
public class Population 
{
	public IndividualNode head;
	public int speciesNum;
        
	public Population()
	{
		head=new IndividualNode();
		speciesNum=NatureCondition.SPECIES_NUM;
	}
	
	void add(IndividualNode species)
	{
		IndividualNode point=head;
		while(point.next != null)
			point=point.next;
		point.next=species;
	}
	
	void traverse()
	{
		IndividualNode point=head.next;
		while(point != null)
		{
			for(int i=0;i<NatureCondition.CITY_NUM;i++)
				System.out.print(point.genes[i]+" ");
			System.out.println(point.distance);
			point=point.next;
		}
		System.out.println("------------------");
	}
}
