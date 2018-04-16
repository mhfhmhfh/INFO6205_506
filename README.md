# INFO6205_506
INFO6205 Final Project by Zinan Wang and Zhifei Lin
==
Our project is aim to solve Traveling Salesman Problem by Genetic Algorithm. We need to find the shortest possible route that visit every city. 


Team Member: Zinan Wang, Zhifei Lin<br>
Team Number: 506<br>
Language: Java


Flow
-----
![](https://imgsa.baidu.com/forum/w%3D580/sign=ab5b6c78b499a9013b355b3e2d940a58/fc73f6bf6c81800aadb33962bd3533fa828b4737.jpg)


Implmentation:
------------
* Gene code:<br>
  Our gene is coded as the four DNA bases(A,T,C,G).<br>
  We use 4 gene to show one genotye,such as [ATCG], [AGAA].
* Gene expression:<br>
  We use quatemary coding to show gene expression.<br?
  A→0， T→1， C→2, G→3.<br>
  For example:<br>
  [ATCG,ATAA,AGAC,AGAG] → [0123,0100,0302,0303] → [27,16,50,51]
  

* Fitness function:<br>
  We use the distance between two cities to show fitness. The fitness is the inverse of the sum of distance. Larger the fitness is, the better result we have.

* Select function:<br>
  Select individuals with the highest fitness in the generation and copy them directly to the child generation. And those good individuals are also used to generate children.<br>
  We have two select method: Quicksort and Roulette Wheel Selection.
  
* Evolution:<br>
  It include crossover and mutation. <br>
  For crossover, we generate a random number and the child's chromosome is part chromosome od father plus part chromosme of mother according to the random number.<br>
  For mutation, we swap two cities which are chosen randomly.

----

Detailed information is in our report.
