runTests: AlgorithmEngineerTests.class
	java AlgorithmEngineerTests

clean:
	rm -f *.class

AlgorithmEngineerTests.class: HashTableSortedSets.class
	javac AlgorithmEngineerTests.java

HashTableSortedSets.class: HashTableMap.class MapADT.class
	javac HashTableSortedSets.java

HashTableMap.class: MapADT.class
	javac HashTableMap.java
IHashTableSortedSets.class: MapADT.class
	javac IHashTableSortedSets.java
MapADT.class: 
	javac MapADT.java
