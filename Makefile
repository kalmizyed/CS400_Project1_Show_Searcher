runFrontendDeveloperTests: FrontendDeveloperTests.class
	java FrontendDeveloperTests

FrontendDeveloperTests.class: FrontendDeveloperTests.java ShowSearcherFrontend.class ShowSearcherBackendPlaceholder.class TextUITester.class
	javac FrontendDeveloperTests.java

ShowSearcherFrontend.class: ShowSearcherFrontend.java ShowPlaceholder.class
	javac ShowSearcherFrontend.java

ShowPlaceholder.class: ShowPlaceholder.java
	javac ShowPlaceholder.java

ShowSearcherBackendPlaceholder.class: ShowSearcherBackendPlaceholder.java ShowPlaceholder.class
	javac ShowSearcherBackendPlaceholder.java

TextUITester.class: TextUITester.java
	javac TextUITester.java

clean:
	rm *.class
