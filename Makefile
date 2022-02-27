# Once everyone adds all of their dependencies this should just work
run: ShowSearcherApp.class HashTableSortedSets.class
	java ShowSearcherApp
clean:
	rm *.class

# Add your run[Role]Tests here
runTests: runDataWranglerTests runAlgorithmEngineerTests

# DataWrangler
runDataWranglerTests: DataWranglerTests.class 
	java DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java ShowLoader.class
	javac DataWranglerTests.java

ShowLoader.class: ShowLoader.java IShowLoader.class IShow.class Show.class
	javac ShowLoader.java

IShowLoader.class: IShowLoader.java
	javac IShowLoader.java

IShow.class:
	javac IShow.java

Show.class: Show.java
	javac Show.java
# End of DataWrangler

# Algorithm Engineer
runAlgorithmEngineerTests: AlgorithmEngineerTests.class
	java AlgorithmEngineerTests

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

#End of Algorithm Engineer
