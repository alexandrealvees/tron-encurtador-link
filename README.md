# 🔗 buildrun-link-shortener-fbr

A SaaS URL Shortener developed by the [Build & Run](https://github.com/buildrun-tech) community.  
This project serves as an educational and collaborative platform for students to develop real-world skills. It demonstrates how to build software from scratch — from architecture diagrams to full-stack implementation.

This system provides robust URL shortening capabilities, including analytics, redirect management, and scalability using modern tools.

---

## 📌 Project Overview

The **buildrun-link-shortener-fbr** is designed to:

- Shorten long URLs into manageable links.
- Provide detailed statistics on each shortened link.
- Offer a user-friendly interface for link management.
- Support deployment in scalable environments (Docker, AWS).
- Serve as an open-source foundation for learning and contribution.

---

## 🚀 Technologies Used

- **Java 17+**
- **Spring Boot**
- **MongoDB**
- **AWS (S3, EC2, etc.)**
- **Docker**
- **Maven**

---

## 🛠️ Features

- Long URL shortening.
- Automatic redirection.
- Interface for managing links.
- Usage statistics (clicks).
- AWS integration for scalability.

---

## 📁 Project Structure

```
buildrun-link-shortener/
├── app/                   # Source code
├── diagrama.drawio        # Architecture diagram (Draw.io)
├── encurtador-fbr.png     # Application UI preview
├── README.md              # Documentation
└── .gitignore             # Git ignore rules
```

---

## ⚙️ How to Run the Project

### 🔧 Requirements

- Java 17 or higher
- Maven
- Docker (optional, for containerized execution)
- MongoDB instance (local or cloud)

### ▶️ Option 1: Local Execution

1. **Clone the repository**

```bash
git clone https://github.com/alexandrealvees/tron-encurtador-link
cd tron-encurtador-link
```

2. **Configure environment variables**

Create a `.env` file or set the environment variables required by MongoDB and AWS. Example:

```env
MONGO_URI=mongodb://localhost:27017/shortenerdb
AWS_ACCESS_KEY_ID=your_key
AWS_SECRET_ACCESS_KEY=your_secret
```

3. **Run the application**

```bash
./mvnw spring-boot:run
```

Access at: [http://localhost:8080](http://localhost:8080)

---

### 🐳 Option 2: Docker Execution

```bash
docker build -t buildrun-link-shortener .
docker run -p 8080:8080 --env-file .env buildrun-link-shortener
```

---

## 🧪 Working API Requests

### ✅ Shorten a URL

```http
POST /api/shorten
Content-Type: application/json

{
  "originalUrl": "https://www.example.com/very/long/url"
}
```

### 🔁 Redirect

```http
GET /s/{shortCode}
```

Example: `GET /s/abc123`

### 📊 Get URL Analytics

```http
GET /api/analytics/{shortCode}
```

Example: `GET /api/analytics/abc123`

All requests are **tested and up to date**.

---

## 🔗 Useful Resources

- [Spring Boot Official Docs](https://spring.io/projects/spring-boot)
- [MongoDB Documentation](https://www.mongodb.com/docs/)
- [Docker Reference](https://docs.docker.com/)
- [AWS Developer Guide](https://docs.aws.amazon.com/)
- [Build & Run GitHub](https://github.com/buildrun-tech)

---

## 🤝 Contributing Guidelines

We encourage community collaboration!  
If you'd like to contribute:

1. Fork the project.
2. Create a new branch.
3. Submit a Pull Request with your changes.

Please ensure your code is clean and tested.

---

## 📄 License

This project is licensed under the **MIT License**.  
See the [LICENSE](LICENSE) file for more details.

---

## 🖼️ Application Preview

![App Screenshot](encurtador-fbr.png)
