# 📚 Library Book Manager System

A desktop-based **Library Book Manager System** developed using **Java Swing**. This application helps manage books, members, and borrowing records efficiently. The project follows **Object-Oriented Programming (OOP)** principles and uses file handling for permanent data storage.

---

# 📌 Project Overview

The Library Book Manager is a Java GUI application designed to automate library operations. It allows users to manage books, register members, issue and return books, and maintain complete borrowing records.

The system provides an easy-to-use graphical interface and automatically saves data using file handling, ensuring that information remains available after restarting the application.

---

# ✨ Features

## 📖 Book Management

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
- Automatically save book data

---

## 👥 Member Management

- Add new members
- Update member information
- Remove members
- Search members
- Maintain member records
- Store member information permanently

---

## 🔄 Issue & Return Management

- Issue books to members
- Return issued books
- Automatically update book quantity
- Track issued books
- Maintain complete issue history
- Store return status and return dates

---

## 📊 Dashboard

The dashboard provides library statistics including:

- Total books
- Available books
- Unavailable books
- Library overview information

**Note:**  
The dashboard counts different book records, not total copies. Multiple copies of the same book are counted as one book.

---

# 💾 Data Storage

The project uses file handling for permanent data storage.

Implemented using:

- BufferedReader
- BufferedWriter
- FileReader
- FileWriter

Data is automatically:
- Loaded when the application starts
- Saved after performing operations

Stored data includes:

- Book records
- Member records
- Issue records

---

# 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Java Swing | Graphical User Interface |
| OOP Concepts | Object-Oriented Design |
| ArrayList | Data Management |
| File Handling | Data Persistence |

---

# 🧩 Class Description

## 📘 Book Class

Responsible for storing book information.

Attributes:

- Title
- Author
- ISBN
- Quantity
- Category
- Genre

Responsibilities:

- Store book details
- Update book information
- Manage book quantity

---

## 👤 Member Class

Responsible for storing library member information.

Attributes:

- Member ID
- Name
- Contact information

Responsibilities:

- Maintain member details
- Support member management operations

---

## 📄 IssueRecord Class

Represents a book borrowing transaction.

Stores:

- Member ID
- Book ISBN
- Issue date
- Return status
- Return date

---

## 🏛️ Library Class

The main management class responsible for:

- Managing books
- Managing members
- Adding and removing books
- Issuing and returning books
- Searching books
- Saving and loading data

---

## 📋 IssueRecordManager Class

Handles borrowing records.

Responsibilities:

- Store issue records
- Save issue history
- Load issue records
- Track returned books

---

## 🖥️ LibraryGUI Class

Provides the graphical user interface.

Includes:

- Dashboard
- Navigation sidebar
- Book management windows
- Member management windows
- Issue and return forms
- Tables for displaying records

---

# 🧠 OOP Concepts Implemented

## Encapsulation

- Private attributes
- Getter and setter methods

## Constructors

- Used to initialize objects with required information

## Inheritance

- Allows reuse of existing class functionality

## Polymorphism

- Provides flexible behavior through method overriding

## Abstraction

- Separates implementation details from user interaction

---

# 🚀 How to Run the Project

## Requirements

- Java JDK 17 or above
- Java IDE:
  - IntelliJ IDEA
  - Eclipse
  - NetBeans
  - VS Code

## Steps

1. Clone the repository:

```bash
git clone <repository-url>
Open the project in your Java IDE.
Run:
Main.java
The Library Book Manager System will start.
🔮 Future Improvements
Database integration using MySQL
User authentication system
Fine calculation for late returns
PDF report generation
Barcode scanning
Advanced search filters
Improved modern UI themes
👩‍💻 Author

Khadija Mehmood

BS Computer Science Student

📄 License

This project is developed for educational purposes.


This version is better because it focuses on **what the project does**, **technologies**, **features**, a
