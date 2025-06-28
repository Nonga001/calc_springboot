# Calculator App with Login/Signup

A modern Spring Boot web application featuring user authentication and a functional calculator dashboard. Built with Spring Boot, Thymeleaf, JPA, and H2 database.

## 🚀 Features

- **User Authentication System**
  - User registration with secure password hashing (BCrypt)
  - User login with session management
  - Logout functionality
  - Username uniqueness validation

- **Calculator Dashboard**
  - Basic arithmetic operations (+, -, *, /)
  - Real-time calculation results
  - Error handling for division by zero
  - Clean, modern UI

- **Database Integration**
  - H2 in-memory database for development
  - JPA/Hibernate for data persistence
  - Automatic table creation
  - H2 console for database inspection

- **Security Features**
  - CSRF protection disabled for development
  - Session-based authentication
  - Secure password storage

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.2.5
- **Database**: H2 (in-memory)
- **ORM**: Spring Data JPA / Hibernate
- **Template Engine**: Thymeleaf
- **Security**: Spring Security
- **Build Tool**: Maven
- **Java Version**: 17

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Maven** 3.6+ 
- **Git** (for cloning the repository)

### Installing Java 17

#### On Ubuntu/Debian:
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

#### On CentOS/RHEL/Fedora:
```bash
sudo dnf install java-17-openjdk-devel
```

#### On macOS:
```bash
brew install openjdk@17
```

#### On Windows:
Download and install from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/#java17) or [OpenJDK](https://adoptium.net/)

### Installing Maven

#### On Ubuntu/Debian:
```bash
sudo apt install maven
```

#### On CentOS/RHEL/Fedora:
```bash
sudo dnf install maven
```

#### On macOS:
```bash
brew install maven
```

#### On Windows:
Download from [Maven Official Site](https://maven.apache.org/download.cgi)

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/calculator-app.git
cd calculator-app
```

### 2. Build the Application

```bash
mvn clean package
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will start on **http://localhost:8081**

## 📱 Usage

### 1. Access the Application

Open your web browser and navigate to:
- **Main Application**: http://localhost:8081
- **Login Page**: http://localhost:8081/login
- **Signup Page**: http://localhost:8081/signup
- **Dashboard**: http://localhost:8081/dashboard (after login)
- **H2 Database Console**: http://localhost:8081/h2-console

### 2. Create an Account

1. Go to **http://localhost:8081/signup**
2. Enter a username and password
3. Click "Sign Up"
4. You'll be redirected to the login page

### 3. Login

1. Go to **http://localhost:8081/login**
2. Enter your username and password
3. Click "Login"
4. You'll be redirected to the calculator dashboard

### 4. Use the Calculator

1. Enter two numbers in the input fields
2. Select an operation (+, -, *, /)
3. Click "Calculate"
4. View the result below the form

### 5. Logout

Click the "Logout" link in the top-right corner of the dashboard.

## 🗄️ Database Access

### H2 Console

To inspect the database:

1. Go to **http://localhost:8081/h2-console**
2. Use these connection details:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: (leave empty)
3. Click "Connect"
4. You can view the `USERS` table to see registered users

## 📁 Project Structure

```
calculator-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/calculatorapp/
│   │   │       ├── CalculatorAppApplication.java
│   │   │       ├── config/
│   │   │       │   └── SecurityConfig.java
│   │   │       ├── controller/
│   │   │       │   ├── AuthController.java
│   │   │       │   └── DashboardController.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java
│   │   │       └── service/
│   │   │           └── UserService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       │   └── css/
│   │       │       └── style.css
│   │       └── templates/
│   │           ├── dashboard.html
│   │           ├── login.html
│   │           └── signup.html
│   └── test/
├── pom.xml
└── README.md
```

## ⚙️ Configuration

### Application Properties

The main configuration is in `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8081

# Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# H2 Console
spring.h2.console.enabled=true

# Thymeleaf Configuration
spring.thymeleaf.cache=false
```

### Changing the Port

To run the application on a different port, modify `server.port` in `application.properties`:

```properties
server.port=8080
```

## 🔧 Development

### Running in Development Mode

```bash
mvn spring-boot:run
```

### Building for Production

```bash
mvn clean package
```

This creates a JAR file in the `target/` directory that can be run with:

```bash
java -jar target/calculator-app-0.0.1-SNAPSHOT.jar
```

### Running Tests

```bash
mvn test
```

## 🐛 Troubleshooting

### Port Already in Use

If you get an error that port 8081 is already in use:

1. Find the process using the port:
   ```bash
   lsof -i :8081
   ```

2. Kill the process:
   ```bash
   kill -9 <PID>
   ```

3. Or change the port in `application.properties`

### Database Issues

If you encounter database-related errors:

1. Stop the application
2. Delete the `target/` directory: `rm -rf target/`
3. Rebuild: `mvn clean package`
4. Restart: `mvn spring-boot:run`

### Login Not Working

If login doesn't work:

1. Check if the application is running on the correct port
2. Clear your browser cache
3. Try accessing the H2 console to verify user data exists
4. Check the application logs for errors

## 📝 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/login` | Login page |
| POST | `/login` | Process login |
| GET | `/signup` | Signup page |
| POST | `/signup` | Process registration |
| GET | `/dashboard` | Calculator dashboard |
| POST | `/dashboard` | Process calculation |
| GET | `/logout` | Logout user |
| GET | `/h2-console` | H2 database console |

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Commit your changes: `git commit -am 'Add feature'`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- H2 Database for the lightweight in-memory database
- Thymeleaf for the template engine

## 📞 Support

If you encounter any issues or have questions:

1. Check the troubleshooting section above
2. Search existing issues in the repository
3. Create a new issue with detailed information

---

**Happy Calculating! 🧮** # calc_springboot
