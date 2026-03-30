# 🚀 JobPortal Backend

A backend REST API for a Job Portal system built using Spring Boot and MySQL.  
This project supports role-based authentication and allows recruiters to post jobs and users to apply for them securely.

---

## 🛠️ How to Run

1. Create MySQL database:
   CREATE DATABASE jobportaldb;

2. Set environment variable for DB password.

3. Run the project:
   **Windows:**
   .\mvnw spring-boot:run

   **Mac/Linux:**
   ./mvnw spring-boot:run

4. Open in browser:
   http://localhost:8081

 ---

## 🔐 Login Information

⚠️ **IMPORTANT:**

Create your own users in the MySQL `users` table.

Login using the **email and password YOU created**.

❌ Do NOT use the hashed password (like `$2a$10...`) in the browser.

---

## Features

- User Authentication using Spring Security
- Role-Based Access Control (ADMIN, RECRUITER, USER)
- Recruiters can post jobs
- Users can apply for jobs
- Applications linked with authenticated users
- View applications by job ID
- RESTful API architecture
- MySQL database integration using JPA/Hibernate

---

## Technologies Used

- Java
- Spring Boot
- Spring Security
- MySQL
- JPA / Hibernate
- Maven
- Postman (API Testing)

---

## Project Structure

src/main/java/com/jobportal

- controller → Handles API requests
- entity → Database models
- repository → Database access layer
- security → Authentication & authorization config

---

## API Endpoints

### Job APIs

POST /jobs → Create job (Recruiter)

GET /jobs/{id} → Get job details

---

### Application APIs

POST /applications → Apply for job (User)

GET /applications → View all applications

GET /applications/job/{jobId} → View applications by job ID

---

### Security

- BCrypt password encryption
- Role-based authorization
- Authenticated users mapped to job applications

---

## Database

MySQL database used

Tables:

- users
- jobs
- applications

---

## How to Run Project

1. Clone repository

git clone https://github.com/your-username/jobportal.git


2. Open project in VS Code / IntelliJ

3. Configure MySQL in application.properties

4. Run Spring Boot application

5. Test APIs using Postman

---

## Future Improvements

- Users can view their applied jobs
- Recruiter dashboard
- Job search filters
- Frontend integration (React)

---

## Author

Rajashree
