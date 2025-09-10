# Finance-Tracker  

[![Build with Maven](https://img.shields.io/badge/Maven-Build-blue)](https://maven.apache.org/)  
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)](https://spring.io/projects/spring-boot)  
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)](https://www.mysql.com/)  
[![License](https://img.shields.io/badge/License-MIT-lightgrey)](LICENSE)  

A comprehensive personal finance management tool to monitor your financial health with a clean, user-friendly interface.  

---

## Features  
- **User registration & login** (Spring Security + MySQL)  
- **Add, delete, and view transactions** (income/expense)  
- **Track balance, total income, and total expenses**  
- **Sorting transactions** (by date, amount, type)  
- **User-specific data** (each user only sees their own transactions)  

---

## Tech Stack  
- **Backend**: Spring Boot (Spring MVC, Spring Data JPA, Spring Security)  
- **Database**: MySQL  
- **Frontend**: Thymeleaf + CSS  
- **Build Tool**: Maven  
- **IDE**: IntelliJ IDEA  

---

## Security  
- Passwords are encrypted using **BCrypt**  
- Session-based authentication  
- **CSRF protection** enabled  
- Input validation and sanitization  

---

## Environment Variables  

Before running the application, set the following environment variables:  

- `DB_URL` → Database connection URL (default: `jdbc:mysql://localhost:3306/financetracker`)  
- `DB_USERNAME` → Your MySQL username  
- `DB_PASSWORD` → Your MySQL password  

If environment variables are not set, the app will use the default values from `application.properties`.  

---

## Setup and Installation

### 1. Clone the repository  
```bash
git clone https://github.com/Parthi-bun/Finance-Tracker.git
cd Finance-Tracker
```

### 2. Configure Database
	- Create a MySQL database named financetracker
	- Set environment variables:
```bash
export DB_URL=jdbc:mysql://localhost:3306/financetracker
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
```

### 3. Run the application
```bash
mvn spring-boot:run
```


