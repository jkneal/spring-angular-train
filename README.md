Spring to Angular Training
============

Training covers a wide range of topics, including JPA, Spring MVC, jQuery, and Angular JS.

Requirements
------------

This document will guide you through the setup of the training project. If you already have the required tools installed, please verify you have the correct versions.

Having a high performance machine will greatly help in staying up with exercises. You should
have at least 2gb of memory (4gb is recommended), 10gb of free storage, and a modern high
performing processor.

Supported platforms include Mac OS X 10.5 or greater, Windows XP, Windows Vista, Windows
7, and Windows 8.

Setup
------------

### JDK

Download JDK 8u45 from the following location:

[JDK Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Please make sure to get the JDK and not the JRE. If necessary, setup the environment variable `JAVA_HOME` that points to the JDK installation directory. Then add `JAVA_HOME/bin` to your PATH environment variable.

If you already have a JDK installed and the version is 7 or greater you should be fine.

When you are done, open a console and type the following command:

    java -version
    
You should see output similar to the following:

   ```
   java version "1.8.0_40"
   Java(TM) SE Runtime Environment (build 1.8.0_40-b26)
   Java HotSpot(TM) 64-Bit Server VM (build 25.40-b25, mixed mode)
   ```
   
### Eclipse

For the training, everyone should use Eclipse. Please install a clean copy of Eclipse. The latest Eclipse bundle (Luna SR2 (4.4.2)) can be downloaded here:

[Eclipse Download](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr2)

Follow the above link to the Eclipse Luna download page. Here select the download link appropriate for your platform. After you have downloaded the archive, extract the eclipse directory to your local file system.

In the extracted eclipse folder, click the file `eclipse.exe` to launch the application (Note you might want to create a desktop shortcut to exclipse.exe).

The first time Eclipse is launched it will ask you to define a workspace. Choose a location on your file system you wish to store projects in (ex. `/projects`). Click the checkbox to always use this workspace location. After this Eclipse will finish opening and you should see the ‘Welcome’ tab.

Now verify Eclipse is using Java 8. Open the menu item Window -> Preferences (or Eclipse -> Preferences). In the Preferences editor, expand the ‘Java’ group in the left pane, then select ‘Installed JREs’. You should see 'Java SE 8' listed under installed JREs. If not, click the Add button and select the directory where the jdk is located.

#### Spring Tool Suite

Next in Eclipse go to Help -> Eclipse Marketplace. Search for 'Spring Tool Suite (STS) for Eclipse Luna (4.4)'. When the results return click the 'Install' button for Spring Tool Suite. When the dialog comes up Click 'Confirm >'. Finally accept the terms and click 'Finish'.

#### Lombok

Download Lombok from the following location:

[Lombok Download](https://projectlombok.org/)

This should download an executable JAR. Click the JAR to run the executable. It should then find the Eclipse IDE. Next click the 'Install/Update' button. Do not worry about adding Lombok to the training project. 

### Git

Download Git version 2.4.2 from the following location:

[Git Download](https://git-scm.com/downloads)

Click the download link appropriate for you platform. After downloading run the provided installer. During the install you will be prompted for how you would like to use Git, select one of the options to update your path
(for example, ‘Run Git from the Windows Command Prompt’).

When you are done, open a console and type the following command:

    git --version
    
You should see output similar to the following:

   ```
   git version 2.4.0
   ```
  
### Obtaining The Project

1. Using Git, clone the training repo [https://github.com/jkneal/spring-angular-train](https://github.com/jkneal/spring-angular-train) to a local repo (ex. '/projects/spring-angular-train'). Make sure to name your project 'spring-angular-train'. You can do this with the following command (assuming you are in the '/projects' directory):

   ```
   git clone https://github.com/jkneal/spring-angular-train spring-angular-train
   ```
   
2. Within Eclipse, choose the File->Import menu action. Next select 'Existing Projects into Workspace' and click 'Next'. Now select 'Browse' next to root directory and select the location of the training project.

### Running

1. In the Eclipse Package Explorer find the file named `RunSpringTrain.launch` (in root of project). Right click this file and select 'Run As -> RunSpringTrain'. When the project is done starting up you should see this:

   ```
   edu.train.SpringTrainApplication : Started SpringTrainApplication in 4.135 seconds (JVM running for 4.669)
   ```

2. Open a browser and go to [http://localhost:8080/](http://localhost:8080/). You should see the training home (menu) page. Note the exercise links will not necessarily work yet (until they are completed)

Exercises
------------

See [Training Exercises](https://github.com/jkneal/spring-angular-train/wiki)

The training repository contains a branch for each exercise. The branches are named as ‘exercise’ followed by the exercise number. For example, if you wish to work on exercise 5, you should check out the branch named ‘exercise5’.

If you don't complete an exercise, you can commit work in progress to your local repository. Then, switch to the next branch to work on the next exercise. Finally, at any time come back to the uncompleted exercise branch and continue your work. If you haven't used Git before, you might spend some time getting familar with branches and switching. Note, besides the command line, Eclipse provdes Git integration. You can invoke many Git commands by right clicking on the project and selecting 'Team ->' ('Switch To' can be used to switch branches).

Agenda
------------

[Agenda](https://github.com/jkneal/spring-angular-train/wiki/Training-Agenda)

Presentations
------------

[Module 1: JPA](https://iu.box.com/s/9e3hn8ktipx3gm11io9cv0cwnbwz17r2)

Module 2: Spring

Module 3: JavaScript and jQuery

[Module 4: AngularJS](https://iu.box.com/s/bju7f0bm8p9tdubocgnwrgs7mx0a6elg) 
