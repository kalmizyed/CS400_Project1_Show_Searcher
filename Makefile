# Once everyone adds all of their dependencies this should just work
run: ShowSearcherApp.class
	java ShowSearcherApp

# Add your run[Role]Tests here
runTests: runDataWranglerTests

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

clean: 
	rm *.class
