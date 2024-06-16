# MeanStdDevCalculator Project

This project provides a command-line tool to calculate the mean and standard deviation of numeric values from a file, supporting multiple tables of data.

## File Format

The tool processes **.txt** files where each file can contain multiple tables of numeric data. The structure of the .txt file is as follows:

- Each table of numbers is separated by a blank line.
- Within a table, each line contains either a numeric value or text.
- The tool will ignore lines of text and only process numeric values for the calculation.

    ```txt
    Table 1
    My numbers
    5.5
    10.0
    15.5

    Table 2
    My numbers
    20.0
    foo
    25.5
    30.0
    ```
In the example above, the file contains two tables:

1. The first table contains the numeric values: 5.5, 10.0, 15.5
2. The second table contains the numeric values: 20.0, 25.5, 30.0
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to install the following tools and configure their dependencies:

1. **Java** (versions 7 or 8)
    ```sh
    java -version
    ```
    Should return something like:
    ```sh
    java version "1.8.0"
    Java(TM) SE Runtime Environment (build 1.8.0-b132)
    Java HotSpot(TM) 64-Bit Server VM (build 25.0-b70, mixed mode)
    ```

2. **Maven**
    - Download Maven from [here](http://maven.apache.org/download.html)
    - Follow the installation instructions [here](http://maven.apache.org/download.html#Installation)

    Verify the installation:
    ```sh
    mvn -version
    ```
    Should return something like:
    ```sh
    Apache Maven 3.2.5 (12a6b3acb947671f09b81f49094c53f426d8cea1; 2014-12-14T12:29:23-05:00)
    Maven home: /Users/dnielben/Applications/apache-maven-3.2.5
    Java version: 1.8.0, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre
    Default locale: es_ES, platform encoding: UTF-8
    OS name: "mac os x", version: "10.10.1", arch: "x86_64", family: "mac"
    ```

3. **Git**
    - Install Git by following the instructions [here](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

    Verify the installation:
    ```sh
    git --version
    ```
    Should return something like:
    ```sh
    git version 2.2.1
    ```

### Installing

1. Clone the repository and navigate into the project directory:
    ```sh
    git clone https://github.com/alexandrac1420/MeanStdDevCalculator.git

    cd MeanStdDevCalculator
    ```

2. Build the project:
    ```sh
    mvn package
    ```

    Should display output similar to:
    ```sh
    [INFO] --- jar:3.2.0:jar (default-jar) @ LinkedListMeanStdDevCalculator ---
    [INFO] Building jar: C:\Users\alexa\Downloads\Ejemplo\MeanStdDevCalculator\target\LinkedListMeanStdDevCalculator-1.0-SNAPSHOT.jar
    [INFO] BUILD SUCCESS
    ```

3. Run the application:
    ```sh
    java -cp target/LinkedListMeanStdDevCalculator-1.0-SNAPSHOT.jar edu.escuelaing.arsw.MeanStdDevCalculator
    <Add your file path>
    ```
     For example:

    If we want to know the standard deviation and the arithmetic mean of the following two tables, which are in the 'example' file

     ```txt
    Column 1 
    Estimate Proxy
    Size
    160
    591
    114
    229
    230
    270
    128
    1657
    624
    1503

    Column 2
    Development
    Hours
    15.0
    69.9
    6.5
    22.4
    28.4
    65.9
    19.4
    198.7
    38.8
    138.2

    ```

    We need to enter the following commands

    ```sh
    java -cp target/LinkedListMeanStdDevCalculator-1.0-SNAPSHOT.jar edu.escuelaing.arsw.MeanStdDevCalculator
     
    Ingrese la ruta del archivo: C:/Users/alexa/LinkedListMeanStdDevCalculator/src/test/java/edu/escuelaing/arsw/resources/example.txt
    ```

    The output should be:
    ```sh
    Tabla 1:
    Media: 550,60
    Desviación Estándar: 572,03

    Tabla 2:
    Media: 60,32
    Desviación Estándar: 62,26
    ```
![Example](<https://github.com/alexandrac1420/MeanStdDevCalculator/blob/master/Pictures/Captura%20de%20pantalla%202024-06-16%20160516.png>)

## Test Report - MeanStdDevCalculator

### Author
Name: Alexandra Cortes Tovar

### Date
Date: 16/06/2024

### Summary
This report details the unit tests performed for the classes in the MeanStdDevCalculator project. Various scenarios were tested to verify the correct functionality of calculating mean and standard deviation.

### Tests Conducted

1. **Test `testMultipleTables`**
   - **Description**: Test to verify the calculations for multiple tables in a file.
   - **File Used**: multiple_tables.txt
   - **Expected Result**: The program correctly identifies and processes multiple tables, calculating the mean and standard deviation for each.
   - **Outcome**: The results matched the expected outcome.

2. **Test `testEmptyFile`**
   - **Description**: Test to verify behavior with an empty file.
   - **File Used**: empty_file.txt
   - **Expected Result**: The program should produce no output.
   - **Outcome**: The result matched the expected outcome.

3. **Test `testSingleValue`**
   - **Description**: Test to verify calculations with a single value.
   - **File Used**: single_value.txt
   - **Expected Result**: The program should calculate the mean and standard deviation (which will be NaN for a single value).
   - **Outcome**: The result matched the expected outcome.

4. **Test `testTwoValues`**
   - **Description**: Test to verify calculations with two values.
   - **File Used**: two_values.txt
   - **Expected Result**: The program should calculate the mean and standard deviation correctly.
   - **Outcome**: The result matched the expected outcome.

5. **Test `testProcessNumbersIgnoreText`**
   - **Description**: This test verifies that the calculator correctly ignores text lines and processes only numeric values in the input file.
   - **File Used**: file_with_text.txt
   - **Expected Result**: The calculator should process the numeric values in each table, ignoring any lines containing text.
   - **Outcome**: The test should pass, confirming that the calculator accurately processes the numbers and ignores text.

### Conclusions

All unit tests conducted produced expected results and successfully validated the functionalities implemented in the MeanStdDevCalculator project. No significant errors were found during testing, indicating that the tested code functions as designed.

## Design 

### Title
MeanStdDevCalculator

### Author
Alexandra Cortes Tovar

### Date
16/06/2024

### Class Diagram

![Class Diagram](![alt text](https://github.com/alexandrac1420/MeanStdDevCalculator/blob/master/Pictures/image.png))

### Description of Class Diagram

#### Class `MeanStdDevCalculator`
- **Description**: This class handles reading from a file and calculating the mean and standard deviation for multiple tables of numeric data.
- **Operations**:
  - `public static void main(String[] args)`: Main method that initiates the program. It reads the file, processes each table of data, and calculates the mean and standard deviation.
  - `private static void processTable(LinkedList<Double> numbers, int tableNumber)`: Private method that processes each table of data, calculating and printing the mean and standard deviation.

#### Interface `MeanCalculator`
- **Description**: This interface defines a method to calculate the mean of a list of numbers.
- **Operations**:
  - `double calculate(LinkedList<Double> numbers)`: Method to calculate the mean of the numbers.

#### Interface `StdDevCalculator`
- **Description**: This interface defines a method to calculate the standard deviation of a list of numbers given the mean.
- **Operations**:
  - `double calculate(LinkedList<Double> numbers, double mean)`: Method to calculate the standard deviation of the numbers given the mean.

#### Class `LinkedList<T>`
- **Description**: This class provides a simple linked list implementation.
- **Operations**:
  - `public void addFirst(T val)`: Adds a value at the beginning of the list.
  - `public void addLast(T val)`: Adds a value at the end of the list.
  - `public boolean isEmpty()`: Checks if the list is empty.
  - `public void print()`: Prints all values in the list.
  - `public T deleteFirst()`: Deletes the first value in the list.
  - `public T deleteLast()`: Deletes the last value in the list.
  - `public T delete(int pos)`: Deletes a value at a specific position in the list.
  - `public boolean search(T val)`: Searches for a value in the list.

#### Relationships Between Classes
- `LinkedList<T>` has an aggregation relationship with `Node<T>` because it contains instances of `Node<T>`. `MeanCalculator` and `StdDevCalculator` are interfaces that define methods for calculating the mean and standard deviation respectively. These interfaces are implemented by concrete classes that provide the implementation of the calculate methods. `MeanStdDevCalculator` uses instances of `MeanCalculator` and `StdDevCalculator` to perform calculations. Additionally, `MeanStdDevCalculator` uses `LinkedList<Double>` to store and process numbers.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Git](http://git-scm.com/) - Version Control System

## Versioning

I use [GitHub](https://github.com/) for versioning. For the versions available, see the [tags on this repository](https://github.com/alexandrac1420/MeanStdDevCalculator).

## Authors

* **Alexandra Cortes Tovar** - [alexandrac1420](https://github.com/alexandrac1420)

## License

This project is licensed under the GNU
