# 📚 Student-Batch Enrollment API

This project demonstrates a **Many-to-Many relationship** between `Student` and `Batch` entities using **Spring Boot**, **Spring Data JPA**, and **PostgreSQL/MySQL**.  
It allows you to manage students, batches, and enrollments between them.

---

## ✨ Features
- Add students  
- Add batches  
- Enroll a student into one or multiple batches  
- Retrieve all students with their batches  
- Retrieve all batches with their enrolled students  
- Uses **Hibernate Many-to-Many mapping** with a join table

---

## 📂 Database Structure

### **Student_info Table**
| Column Name | Data Type | Description |
|-------------|-----------|-------------|
| id          | INT (PK)  | Auto-generated Student ID |
| name        | VARCHAR   | Student's name |
| address     | VARCHAR   | Student's address |

### **Batch Table**
| Column Name | Data Type | Description |
|-------------|-----------|-------------|
| id          | INT (PK)  | Auto-generated Batch ID |
| name        | VARCHAR   | Batch name |
| duration    | INT       | Duration in months |
| fees        | INT       | Fees for the batch |

### **batch_student (Join Table)**
| Column Name | Data Type | Description |
|-------------|-----------|-------------|
| student_id  | INT (FK)  | Refers to `Student_info.id` |
| batch_id    | INT (FK)  | Refers to `Batch.id` |

---

## 🔗 API Endpoints

### **1️⃣ Add a Student**
```http
POST /student
Content-Type: application/json
```
#### Request Body:
```json
{
    "name": "John Doe",
    "address": "Pune"
}
```
#### Response:
```
student added
```

---

### **2️⃣ Add a Batch**
```http
POST /batch
Content-Type: application/json
```
#### Request Body:
```json
{
    "name": "Java Full Stack",
    "duration": 6,
    "fees": 15000
}
```
#### Response:
```
batch added
```

---

### **3️⃣ Enroll a Student in a Batch**
```http
GET /enroll/{batch_id}/{student_id}
```
#### Example:
```
GET /enroll/1/1
```
#### Response:
```
Student Enrolled
```

---

### **4️⃣ Get All Students**
```http
GET /students
```
#### Example Response:
```json
[
    {
        "id": 1,
        "name": "John Doe",
        "address": "Pune",
        "batches": [
            {
                "id": 1,
                "name": "Java Full Stack",
                "duration": 6,
                "fees": 15000
            }
        ]
    }
]
```

---

### **5️⃣ Get All Batches**
```http
GET /batches
```
#### Example Response:
```json
[
    {
        "id": 1,
        "name": "Java Full Stack",
        "duration": 6,
        "fees": 15000,
        "students": [
            {
                "id": 1,
                "name": "John Doe",
                "address": "Pune"
            }
        ]
    }
]
```

---

## 📊 Entity Relationship Diagram (ERD)
```
Student_info           batch_student            Batch
------------           -------------            -----
id (PK)   <---------+  student_id (FK)  +-----> id (PK)
name                  batch_id (FK)     <-----  name
address                                      duration
                                             fees
```

---

## ⚠️ Error Handling
- If an invalid `student_id` or `batch_id` is passed, the application will throw a **NoSuchElementException**.
- Recommended improvement: replace `.get()` with `.orElseThrow()` and return proper HTTP status codes.

---

## 📂 Folder Structure
```
src/main/java/com/example/demo
│
├── controller
│   ├── BatchController.java
│   ├── EnrollController.java
│   └── StudentController.java
│
├── controller/service
│   ├── BatchService.java
│   ├── BatchServiceImpl.java
│   ├── EnrollmentService.java
│   ├── EnrollmentServiceImpl.java
│   ├── StudentService.java
│   └── StudentServiceImpl.java
│
├── entity
│   ├── Batch.java
│   └── Student.java
│
└── repository
    ├── BatchRepository.java
    └── StudentRepository.java
```

---

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL/MySQL**
- **Maven**

---

## 🚀 How to Run
1. Clone the repository  
   ```bash
   git clone https://github.com/your-username/student-batch-enrollment.git
   ```
2. Create the database:
   ```sql
   CREATE DATABASE student_batch_db;
   ```
3. Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/student_batch_db
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
