# GoEuroTest
GoEuroTest

This application uses goeuro location api to fetch the location details & create a cvs file out of it.
Please visit https://github.com/goeuro/dev-test for more details.

Technology Used:

Apache Maven 3.3.9 | 
spring-core 4.2.4.RELEASE | 
java version "1.7.0_80" | 
slf4j-api 1.7.12 | 
httpclient 4.5.1.jar | 
jackson-mapper-asl 1.9.13.jar | 

# BUILD:

--checkout project--

git clone https://github.com/vibhorrastogi-github/GoEuroTest.git

--enter into project root directory--

cd GoEuroTest

--build project, this will run test case/s as well. to avoid test cases, execute mvn clean install -Dmaven.test.skip=true--

mvn clean install

--if above command executed successfully, it will generate a GoEuroTest.jar file in /target folder.--
--This jar file contains all required dependencies.--

# EXECUTION:

java -jar target/GoEuroTest.jar "Berlin"

-- if above command executed successfully, Berlin_locations.csv file will get generated.--

-- find GoEuroTest.jar in current folder
