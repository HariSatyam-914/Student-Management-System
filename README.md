# 🎓 Student Management System

A modern CRUD-based Student Management System built using **Java Servlets, JDBC, MySQL, and Tailwind CSS**. The application provides a simple and responsive interface for managing student records with support for adding, viewing, editing, and deleting data.

---

## ✨ Features

* ➕ Add new students
* 📋 View all records in a structured table
* ✏️ Edit existing student details
* 🗑️ Delete records with confirmation dialog
* 🎨 Responsive UI built with Tailwind CSS
* 🔄 Automatic refresh after updates
* 📦 JDBC-based database connectivity
* ⚡ Runs on Apache Tomcat

---

## 🛠 Tech Stack

| Layer        | Technology                  |
| ------------ | --------------------------- |
| Backend      | Java Servlets (HttpServlet) |
| Database     | MySQL                       |
| Connectivity | JDBC                        |
| Frontend     | HTML + Tailwind CSS         |
| Server       | Apache Tomcat               |
| Driver       | `com.mysql.cj.jdbc.Driver`  |

---

## 📸 Application Workflow

### 🏠 Dashboard

A central home page providing quick navigation to:

* Student Registration
* Student Directory

---

### ➕ Student Registration

* Capture student details
* Store records in MySQL
* Display success modal after insertion
* Navigate directly to the student list

---

### 📋 Student Directory

Displays:

* Student ID
* Name
* Email
* Course
* Mobile Number

Features:

* Edit records
* Delete records
* Responsive card-based layout

---

### ✏️ Update Student

* Fetch existing details
* Pre-fill edit form
* Save changes
* Auto redirect back to directory

---

### 🗑 Delete Student

* Confirmation popup
* Remove selected record
* Refresh student list automatically

---

## 🗄 Database Schema

```sql
CREATE DATABASE advjava;

USE advjava;

CREATE TABLE StudentDemo (
    Sid INT AUTO_INCREMENT PRIMARY KEY,
    Sname VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100) NOT NULL,
    mobile VARCHAR(15) NOT NULL
);
```

---

## 📂 Project Structure

```text
src
└── main
    ├── java
    │   └── p1
    │       ├── AddStudent.java
    │       ├── ReadStudentData.java
    │       ├── EditStudent.java
    │       ├── UpdateStudent.java
    │       └── DeleteStudent.java
    │
    └── webapp
        ├── index.html
        └── login.html
```

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/student-management-system.git
```

### 2. Configure MySQL

Create the database and table using the schema above.

### 3. Add MySQL Connector

Include:

```text
mysql-connector-j
```

in your project dependencies.

### 4. Deploy on Apache Tomcat

Run the project and access:

```text
http://localhost:8080/StudentManagementSystem
```

---

## 📷 Demo

## 🎥 Demo

<div align="center">

### Video Walkthrough

https://github.com/user-attachments/assets/your-video-asset-id

### Application Preview

<img src="https://github.com/user-attachments/assets/6617083e-dfc0-4a66-b60d-940ddd82b784" width="900">

</div>
---

## 🌟 Highlights

* Pure Java Servlet Architecture
* JDBC-Based CRUD Operations
* Responsive Tailwind CSS UI
* Modal-Based User Experience
* Lightweight and Beginner-Friendly
* Suitable for learning Advanced Java concepts

---

## 📄 License

This project is open-source and available under the **MIT License**.
