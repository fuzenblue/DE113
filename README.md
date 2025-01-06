This repository contains two projects developed for academic purposes. The **Midterm Project** focuses on implementing and testing geometric classes, while the **Final Project** involves building a text-based search engine for analyzing word frequencies in documents.

---

## 1. **Midterm Project: MyTriangle Class**
### **Description**
The midterm project aimed to design and implement geometric classes, including **MyTriangle** and **MyPoint**, along with test cases to ensure their functionality. The project emphasized understanding OOP principles and class design.

### **Key Features**
- **MyTriangle Class**:
  - Designed a triangle class with private instance variables `v1`, `v2`, and `v3` to represent the vertices.
  - Implemented methods for calculating the perimeter and classifying the triangle type (equilateral, isosceles, scalene).
  - Included constructors for initializing objects with coordinates or `MyPoint` instances.

- **TestMyTriangle Driver Class**:
  - Created robust test cases to verify the methods of `MyTriangle` and ensure edge cases were handled properly.

### **Key Methods**
- `getPerimeter()`: Calculates the perimeter of the triangle.
- `printType()`: Determines the type of triangle.

---

## 2. **Final Project: Java word document metrix**
### **Description**
The final project is a **text-based search engine** that processes a set of documents to analyze word frequencies and export the results to a CSV file. It demonstrates core file-handling, text processing, and data visualization concepts.

### **Key Features**
- Reads and tokenizes text files from a predefined directory.
- Constructs a **Word-Document Matrix** that maps word occurrences across multiple documents.
- Exports the processed data to a CSV file (`word_result.csv`) for analysis.

### **Key Components**
1. **File Reading**:
   - Reads all `.txt` files from the directory and processes their contents.
2. **Tokenization**:
   - Removes non-alphabetic characters and splits text into lowercase tokens.
3. **Word-Document Matrix**:
   - Maps unique words to their frequency counts across multiple documents.
4. **CSV Export**:
   - Saves the word frequency matrix in a well-structured CSV format.

### **Implementation Details**
- Language: Java
- File I/O and Path Handling: `java.io.*`, `java.nio.file.*`
- Data Structures: `Map`, `List`, and `Set` for word mapping and frequency calculation.

### **How to Run**
1. Place the text files in the `lyrics_data/` directory.
2. Compile and run the program:
   ```bash
   javac SearchEngine.java
   java SearchEngine
