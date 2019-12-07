Compilation:

	    javac -d build -cp src src/battleship/Battleship.java


Execution:
	
	    java -cp build battleship.Battleship


Packaging:

	    jar cfe Battleship.jar battleship.Battleship -C build 


Documentation:

	    javadoc -d doc -cp src -subpackages battleship


*IMPORTANT*

On met "Random" dans la case "Nom Joueur" pour jouer contre un jouer aléatoire.