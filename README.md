# How to Use ConsoleMenuApp

This application is a simple console menu that provides options for calculating statistics in the game Dead by Daylight.

## Prerequisites
• Java Development Kit (JDK) installed on your system.

## Usage Instructions

1.Open a development environment or terminal in the directory where the ConsoleMenuApp.java file is located.

2.Compile the application using the command:

    javac -d bin src/*.java 



3.Run the compiled application with the command:

    java -cp bin ConsoleMenuApp

## Available Menu Options

**1. Total account base by Devour and Level**
    • Calculate the total account base based on Devotion and Level.
**2. Total Time for Iridescent Shards Target**
    • Calculate the total time required to reach a certain number of Iridescent Shards.
**3. Close**
    • Close the application.

## Specific Instructions for Options

**1. Total account base by Devour and Level**

    • Enter the Devotion level and the level.
    • The total Iridescent Shards and XP will be displayed.

**2. Total Time for Iridescent Shards Target**

    • Enter the target number of Iridescent Shards, the level, and the current number of Iridescent Shards.
    • The time required to reach the target, expressed in hours and minutes, as well as the estimated number of matches, will be displayed.

## Closing the Application

To close the application, select option "3. Close" from the menu.

###### Creating a Runnable JAR for ConsoleMenuApp

## Step 1: Compile the Java Application
Compile the ConsoleMenuApp.java file into bytecode .class files using the javac command:

    javac -d bin ./src/*.java

## Step 2: Create a Manifest File
Create a manifest file named manifest.txt with the following content:

    Main-Class: ConsoleMenuApp
**This specifies the entry point for the JAR file.**

## Step 3: Create the JAR File
Create a JAR file named ConsoleMenuApp.jar using the following command:

    jar cfm dir/ConsoleMenuApp.jar manifest.txt -C bin . README.md
This command creates a JAR file named **ConsoleMenuApp.jar** with the specified manifest file, along with the compiled **.class** files and the README.

## Step 4: Run the JAR File
You can now run the application using the JAR file:

    java -jar ./dir/ConsoleMenuApp.jar

## Step 5: Distribution
Distribute the **ConsoleMenuApp.jar** file along with any instructions necessary. Recipients can run the application using the provided JAR file.

### Note

Make sure the manifest file (manifest.txt), the compiled .class files (ConsoleMenuApp.class and DbdMathCalculator.class), and the README (README.md) are in the same directory when creating the JAR file.

This process will package your application into a standalone JAR file, making it convenient for distribution and execution on any system with Java installed.




