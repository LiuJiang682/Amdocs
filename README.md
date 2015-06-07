# Amdocs

It is a Maven project, so you can download it to a directory and build it with maven command

mvn clean install

after you run the maven build, go to the target directory and runt this command in command prompt:


java -cp .:Car-0.0.1-SNAPSHOT.jar au.com.amdocs.AmdocsCarTable

the application will start up in user interactive mode. You can enter any command as your wish. I have include a data.txt in the resource directory for all examples I have run passed.


Or you can the data.txt file as part of the command line as follow:

java -cp .:Car-0.0.1-SNAPSHOT.jar au.com.amdocs.AmdocsCarTable ../src/test/resources/data.txt


the application will read all input from the data file and display all car moves.
