#  Library Book Manager System

A desktop-based **Library Book Manager System** developed using **Java Swing**. This application helps manage books, members, borrowing records, and library operations efficiently. The project follows **Object-Oriented Programming (OOP)** principles and uses file handling for permanent data storage.



#  Project Overview

The Library Book Manager is a Java-based desktop application designed to automate library management tasks. It provides a graphical user interface where users can manage books, register members, issue and return books, and maintain borrowing records.

The system automatically saves and loads data, allowing information to remain available even after restarting the application.



#  Features

##  Book Management

- Add new books
- Remove books
- Update book information
- Search books by:
  - Title
  - ISBN
  - Category
  - Genre
- View complete book inventory
- Manage book quantity
- Prevent duplicate ISBN entries
- Automatically save book records



##  Member Management

- Add new members
- Update member information
- Remove members
- Search members
- Maintain member records



##  Issue & Return Management

- Issue books to members
- Return issued books
- Automatically update book quantity
- Maintain issue records
- Track issued and returned books
- Store issue date and return date
- Calculate fine for late book returns



##  Dashboard

The dashboard provides library statistics including:

- Total books
- Available books
- Unavailable books

**Note:**  
The dashboard counts different book records instead of total copies. Multiple copies of the same book are counted as one book.



#  Data Storage

The project uses file handling to store data permanently.

Implemented using:

- FileReader
- FileWriter
- BufferedReader
- BufferedWriter

The application automatically:

- Loads data when the program starts
- Saves data after performing operations

Stored data includes:

- Book records
- Member records
- Issue records



# 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Java Swing | Graphical User Interface |
| OOP Concepts | Object-Oriented Design |
| ArrayList | Data Management |
| File Handling | Data Persistence |

---

#  Class Description

##  Book Class

Stores book information.

Includes:

- Title
- Author
- ISBN
- Quantity
- Category
- Genre



##  Member Class

Stores library member information.

Includes:

- Member ID
- Name
- Member details



##  IssueRecord Class

Represents a book borrowing transaction.

Stores:

- Member ID
- Book ISBN
- Issue date
- Return date
- Return status
- Fine amount



##  Library Class

Responsible for managing the main library operations:

- Book management
- Member management
- Issue and return operations
- Searching books
- Saving and loading data



##  LibraryGUI Class

Provides the graphical user interface.

Includes:

- Dashboard
- Book management interface
- Member management interface
- Issue and return forms
- Tables for displaying records



#  OOP Concepts Implemented

## Encapsulation
- Private attributes
- Getter and setter methods

## Constructors
- Used to initialize objects

## Inheritance
- Used for code reuse and better organization

## Polymorphism
- Provides flexible behavior through method overriding

## Abstraction
- Separates implementation details from user interaction



#  How to Run the Project

### Requirements

- Java JDK 17 or above
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans, or VS Code)

### Steps

1. Clone or download this repository.

2. Open the project in your Java IDE.

3. Run the `Main.java` file.

4. The Library Book Manager application will start.



#  Future Improvements

- Database integration using MySQL
- User authentication system
- Role-based access control
- Generate PDF reports
- Barcode scanning
- Improved modern UI design



#  Author

**Khadija Mehmood**

BS Computer Science Student



