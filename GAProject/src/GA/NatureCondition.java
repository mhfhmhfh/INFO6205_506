/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

/**
 *
 * @author zinanwang
 */
public class NatureCondition 
{
	public static int CITY_NUM; 
	public static final int SPECIES_NUM=200;
	public static final int DEVELOP_NUM=100;
	public static final float pcl=0.2f,pch=0.95f;
	public static final float pm=0.4f;
	static final float[][] disMap;
	static
        {
		
		int[][] cityPosition={
				{1304,        2312},{3639,        1315},         
				{4177,        2244},{3712,        1399},         	
				{3488,        1535},{3326,        1556},         
				{3238,        1229},{4196,        1004},         
				{4312,         790},{4386,         570},
				{3007,        1970},{2562,        1756},
				{2788,        1491},{2381,        1676},
				{1332,         695},{3715,        1678},
				{3918,        2179},{4061,        2370},
				{3780,        2212},{3676,        2578},
				{4029,        2838},{4263,        2931},
				{3429,        1908},{3507,        2367},
				{3394,        2643},{3439,        3201},
				{2935,        3240},{3140,        3550},
				{2545,        2357},{2778,        2826},
				{2370,        2975}};
		
		
		CITY_NUM=cityPosition.length;
		disMap=new float[CITY_NUM][CITY_NUM];
		for(int i=0;i<CITY_NUM;i++)
		{
			for(int j=i;j<CITY_NUM;j++)
			{
				float dis=(float)Math.sqrt(Math.pow((cityPosition[i][0] - cityPosition[j][0]),2) + Math.pow((cityPosition[i][1] - cityPosition[j][1]),2));
				
				disMap[i][j]=dis;
				disMap[j][i]=disMap[i][j];
			}
		}	
	}
}
