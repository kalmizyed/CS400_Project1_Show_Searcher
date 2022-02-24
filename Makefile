run: BackendDeveloperTests.class IHashTableSortedSets.class IShow.class IShowSearcherBackend.class ShowSearcherBackend.class HashTableSortedSets.class Show.class MapADT.class
	java BackendDeveloperTests

BackendDeveloperTests.class: BackendDeveloperTests.java
	javac BackendDeveloperTests.java


ShowSearcherBackend.class: ShowSearcherBackend.java
	javac ShowSearcherBackend.java

HashTableSortedSets.class: HashTableSortedSets.java
	javac HashTableSortedSets.java

Show.class: Show.java
	javac Show.java

IShow.class: IShow.java
	javac IShow.java

IHashTableSortedSets.class: IHashTableSortedSets.java
	javac IHashTableSortedSets.java

IShowSearcherBackend.class: IShowSearcherBackend.java
	javac IShowSearcherBackend.java

MapADT.class: MapADT.java
	javac MapADT.java
clean: 
	rm *.class
