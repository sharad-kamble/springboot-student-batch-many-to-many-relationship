# 📚 Student-Batch Enrollment API

This project demonstrates a **Many-to-Many relationship** between `Student` and `Batch` entities using **Spring Boot**, **Spring Data JPA**, and **PostgresSQL**.

---

## 📂 Table Structure

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
POST /students
Content-Type: application/json
```
#### Request Body:
```json
{
    "name": "John Doe",
    "address": "Pune"
}
```


---

### **2️⃣ Add a Batch**
```http
POST /batches
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
#### Response:
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
#### Response:
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

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Hibernate**
- **Postgress**
- **Maven**

---

## ⚙️ How to Run
1. Clone the repository  
   ```bash
   git clone https://github.com/your-username/your-repo.git
   ```
2. Create a MySQL database:  
   ```sql
   CREATE DATABASE student_batch_db;
   ```
3. Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_batch_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
4. Run the application:  
   ```bash
   mvn spring-boot:run
   ```

---

## 📌 Notes
- **Owning Side:** `Student` entity owns the relationship (`@JoinTable` in `Student`).
- **Inverse Side:** `Batch` entity uses `mappedBy = "batches"`.
- Use `studentRepo.save(student)` to insert into the join table.

---
