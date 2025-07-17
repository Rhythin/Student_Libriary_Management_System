# 📚 Student Library Management System

A comprehensive library management system built with Spring Boot that allows students to manage library operations including book borrowing, returning, and catalog management.

## 🚀 Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![REST API](https://img.shields.io/badge/REST%20API-FF6C37?style=for-the-badge&logo=api&logoColor=white)

## 🌟 Features

- **Student Management**: Register and manage student accounts
- **Book Catalog**: Comprehensive book inventory with genres and author information
- **Library Card System**: Issue and manage library cards with different statuses
- **Author Management**: Maintain author information and book associations
- **Genre Classification**: Categorize books by multiple genres
- **RESTful API**: Clean and well-documented API endpoints
- **Database Integration**: Persistent data storage with MySQL
- **Automatic Timestamps**: Track creation and update times for records

## 📋 Project Structure

```
Student_Libriary_Management_System/
├── src/
│   ├── main/
│   │   ├── java/com/example/Student_Libriary_Management_System/
│   │   │   ├── Controllers/           # REST API Controllers
│   │   │   │   ├── AuthorController.java
│   │   │   │   ├── BookController.java
│   │   │   │   └── StudentController.java
│   │   │   ├── Enums/                 # Enumeration Classes
│   │   │   │   ├── CardStatus.java
│   │   │   │   └── Genre.java
│   │   │   ├── Models/                # JPA Entity Classes
│   │   │   │   ├── Author.java
│   │   │   │   ├── Book.java
│   │   │   │   ├── Card.java
│   │   │   │   └── Student.java
│   │   │   ├── Repository/            # Data Access Layer
│   │   │   │   ├── AuthorRepository.java
│   │   │   │   ├── BookRepository.java
│   │   │   │   ├── CardRepository.java
│   │   │   │   └── StudentRepository.java
│   │   │   ├── Service/               # Business Logic Layer
│   │   │   │   ├── AuthorService.java
│   │   │   │   ├── BookService.java
│   │   │   │   └── StudentService.java
│   │   │   └── StudentLibriaryManagementSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## 🗄️ Database Schema

The system uses the following main entities:

### Student
- **id**: Primary key
- **name**: Student's full name
- **email**: Unique email address
- **mobNo**: Mobile number
- **age**: Student's age
- **country**: Country of residence
- **card**: One-to-one relationship with Card

### Book
- **id**: Primary key
- **name**: Book title
- **pages**: Number of pages
- **genre**: Book genre (enum)
- **author**: Many-to-one relationship with Author
- **card**: Many-to-one relationship with Card

### Author
- **id**: Primary key
- **name**: Author's name
- **age**: Author's age
- **country**: Author's country
- **rating**: Author's rating
- **books**: One-to-many relationship with Books

### Card
- **id**: Primary key
- **cardStatus**: Card status (enum)
- **createdOn**: Creation timestamp
- **updatedOn**: Last update timestamp
- **student**: One-to-one relationship with Student
- **booksIssued**: One-to-many relationship with Books

## 🎯 Supported Genres

- FICTIONAL
- SELF_HELP
- PHILOSOPHY
- ROMANTIC
- SPIRITUAL
- THRILLER
- MYSTERY
- ADVENTURE

## 📡 API Endpoints

### Student Management
- `POST /student/add` - Register a new student

### Book Management
- `POST /book/add` - Add a new book to the catalog

### Author Management
- `POST /author/add` - Add a new author

## 🛠️ Prerequisites

- Java 19 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/Student_Libriary_Management_System.git
   cd Student_Libriary_Management_System
   ```

2. **Configure MySQL Database**
   - Create a MySQL database named `slms`
   - Update `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/slms?createTableIfNotExists=true
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build the project**
   ```bash
   ./mvnw clean install
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the application**
   - The application will start on `http://localhost:9991`
   - API endpoints are available at `http://localhost:9991/api/...`

## 📝 Usage Examples

### Register a Student
```bash
curl -X POST http://localhost:9991/student/add \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john.doe@email.com",
    "mobNo": "1234567890",
    "age": "20",
    "country": "USA"
  }'
```

### Add an Author
```bash
curl -X POST http://localhost:9991/author/add \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Robert C. Martin",
    "age": 65,
    "country": "USA",
    "rating": 4.8
  }'
```

### Add a Book
```bash
curl -X POST http://localhost:9991/book/add \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Clean Code",
    "pages": 464,
    "genre": "SELF_HELP"
  }'
```

## 🔧 Configuration

The application can be configured through `application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/slms?createTableIfNotExists=true
spring.datasource.username=root
spring.datasource.password=password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update

# Server Configuration
server.port=9991
```

## 🧪 Testing

Run the test suite with:
```bash
./mvnw test
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Rhythin**
- GitHub: [Rhythin](https://github.com/Rhythin)
- LinkedIn: [Rhythin](https://linkedin.com/in/rhythin)

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- Java community for continuous support
- MySQL team for robust database solution

---

⭐ **Star this repository if you find it helpful!** 