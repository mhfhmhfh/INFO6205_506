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
* Gene code:

* Gene expression:

* Fitness function:<br>
  We use the distance between two cities to show fitness. Of course the fitness is the inverse of the distance. And “coor.txt” is the initialization data of city positions.

* Select function:<br>
  Select individuals with the highest fitness in the generation and copy them directly to the child generation. And those good individuals are also used to generate children.<br>
  We have two select method: Quicksort and Roulette Wheel Selection.
  
* Evolution:<br>
  It include crossover and mutation. <br>
  For crossover, we generate a random number and the child's chromosome is part chromosome od father plus part chromosme of mother according to the random number.<br>
  For mutation, we swap two cities which are chosen randomly.

----

Detailed information is in our report.
