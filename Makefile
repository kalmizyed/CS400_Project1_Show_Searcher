# Once everyone adds all of their dependencies this should just work
run: ShowSearcherApp.class HashTableSortedSets.class ShowSearcherBackend.class
	java ShowSearcherApp
clean:
	rm *.class

# Not handled by any role
ShowSearcherApp.class: ShowSearcherApp.java
	javac ShowSearcherApp.java

# Add your run[Role]Tests here
runTests: runDataWranglerTests runAlgorithmEngineerTests runFrontendDeveloperTests runBackendDeveloperTests

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

# Frontend Developer
runFrontendDeveloperTests: FrontendDeveloperTests.class
	java FrontendDeveloperTests

FrontendDeveloperTests.class: FrontendDeveloperTests.java ShowSearcherFrontend.class ShowSearcherBackendPlaceholder.class TextUITester.class ShowSearcherBackend.class
	javac FrontendDeveloperTests.java

ShowSearcherFrontend.class: ShowSearcherFrontend.java ShowPlaceholder.class IShowSearcherFrontend.class
	javac ShowSearcherFrontend.java

ShowPlaceholder.class: ShowPlaceholder.java IShow.class
	javac ShowPlaceholder.java

ShowSearcherBackendPlaceholder.class: ShowSearcherBackendPlaceholder.java ShowPlaceholder.class IShowSearcherBackend.class
	javac ShowSearcherBackendPlaceholder.java

TextUITester.class: TextUITester.java
	javac TextUITester.java

IShowSearcherFrontend.class: IShowSearcherFrontend.java
	javac IShowSearcherFrontend.java

# End of Frontend Developer

#Backend Developer
runBackendDeveloperTests: BackendDeveloperTests.class
	java BackendDeveloperTests

BackendDeveloperTests.class: BackendDeveloperTests.java
	javac BackendDeveloperTests.java

ShowSearcherBackend.class: IShowSearcherBackend.class ShowSearcherBackend.java
	javac ShowSearcherBackend.java

IShowSearcherBackend.class: IShowSearcherBackend.java
	javac IShowSearcherBackend.java

#End of Backend Developer
