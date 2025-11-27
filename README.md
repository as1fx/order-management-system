# 🍽️ Order Management & Delivery Tracking System

<div align="left">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)  
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)  
![MySQL](https://img.shields.io/badge/MySQL-8.x-blue?style=for-the-badge&logo=mysql)  
![JWT](https://img.shields.io/badge/JWT-Auth-purple?style=for-the-badge&logo=jsonwebtokens)

A backend system for food ordering and delivery tracking built with **Spring Boot** and **MySQL**.

</div>

---

## 🚀 Overview

A **robust and scalable backend system** for food ordering platforms — from user authentication to real-time delivery tracking.  
It follows **clean architecture**, **best practices**, and **production-ready design patterns**.

---

## ✨ Features

### 🔐 Authentication
- JWT-based authentication
- Role-based access (Admin, Customer, Delivery Partner)

### 🏪 Restaurant & Menu
- Restaurant management
- Menu & category system
- Admin-level menu control

### 🛒 Ordering System
- Shopping cart & order creation
- Order item mapping
- Status update workflow

### 📦 Delivery Tracking
- Assign delivery partner
- Delivery status timeline
- Real-time updates (planned)

### 🛡 Secure REST APIs
- Spring Security integration
- Proper exception handling

---

## 🛠 Tech Stack

| Category | Technology |
|---------|------------|
| Backend | Spring Boot 3.x |
| Language | Java 17 |
| Security | Spring Security, JWT |
| Database | MySQL 8.x |
| ORM | Spring Data JPA |
| Build Tool | Maven |
| API Docs | Swagger / OpenAPI 3 |
| Testing | JUnit, Mockito |

---

## 🏗 Architecture

```
┌─────────────────┐
│   Controller     │  ← REST API Layer
└─────────────────┘
         ↓
┌─────────────────┐
│     Service      │  ← Business Logic
└─────────────────┘
         ↓
┌─────────────────┐
│   Repository     │  ← Data Access Layer
└─────────────────┘
         ↓
┌─────────────────┐
│  MySQL Database  │  ← Data Storage
└─────────────────┘
```

### Design Patterns Used
- MVC Pattern
- DTO Pattern
- Repository Pattern
- Builder Pattern
- Mapper Pattern

---

## 🚀 Quick Start

### ✔ Prerequisites
- Java 17+
- MySQL 8+
- Maven 3.6+

---

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/as1fx/order-management-system.git
cd order-management-system
```

### 2️⃣ Create Database

```sql
CREATE DATABASE orderdb;
```

### 3️⃣ Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/orderdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=your-secure-secret-key-32chars-min
jwt.expiration-ms=86400000

server.port=8080
```

### 4️⃣ Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

### 5️⃣ Initialize Roles

```sql
INSERT INTO roles (name) VALUES
('ADMIN'),
('CUSTOMER'),
('DELIVERY_PARTNER');
```

---

## 📚 API Documentation

Swagger UI →  
👉 **http://localhost:8080/swagger-ui/index.html**

---

## 🔐 Authentication APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | Login user |

**Sample Register Request**
```json
{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "securepassword",
  "phone": "+1234567890",
  "address": "123 Main St",
  "role": "CUSTOMER"
}
```

---

## 🏪 Restaurant APIs

| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/restaurants` | ADMIN |
| GET | `/api/restaurants` | All |
| GET | `/api/restaurants/{id}` | All |
| PUT | `/api/restaurants/{id}` | ADMIN |

---

## 🍔 Menu APIs

| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/menu` | ADMIN |
| GET | `/api/menu/{restaurantId}` | All |
| PUT | `/api/menu/{id}` | ADMIN |

---

## 🛒 Order APIs

| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/orders` | CUSTOMER |
| GET | `/api/orders/customer/{id}` | CUSTOMER |
| PUT | `/api/orders/{id}` | ADMIN |

---

## 📦 Delivery APIs

| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/delivery/assign` | ADMIN |
| POST | `/api/delivery/status` | DELIVERY_PARTNER |
| GET | `/api/delivery/order/{orderId}` | All |

---

## 🗄 Database Schema

### Main Tables
- users
- roles
- restaurants
- menu_items
- orders
- order_items
- delivery
- delivery_status

### ER Diagram
![ER Diagram.png](src/main/resources/ER%20Diagram/ER%20Diagram.png)

---

## 📁 Project Structure

```
src/main/java/com/asif/ordermanagement/
│
├── config/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── mapper/
├── security/
└── exception/
```

---

## 🔐 Authentication Flow

```
Login → Receive JWT Token →  
Send token in header → Authorization: Bearer <token>
```

Role Access:
- **ADMIN** → Full access
- **CUSTOMER** → Place/view orders
- **DELIVERY_PARTNER** → Update delivery status

---


## 👨‍💻 Author

**Asif Reja Mondal**  