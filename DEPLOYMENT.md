# Deployment Guide

This guide will help you deploy the Calculator App to GitHub and run it locally.

## 🚀 Deploying to GitHub

### 1. Initialize Git Repository

```bash
# Initialize git repository
git init

# Add all files
git add .

# Create initial commit
git commit -m "Initial commit: Calculator App with Login/Signup"

# Add your GitHub repository as remote
git remote add origin https://github.com/yourusername/calculator-app.git

# Push to GitHub
git push -u origin main
```

### 2. GitHub Repository Setup

1. Go to [GitHub](https://github.com) and create a new repository
2. Name it `calculator-app`
3. Make it public or private (your choice)
4. Don't initialize with README (we already have one)
5. Copy the repository URL

### 3. Update README.md

Before pushing, update the repository URL in the README.md file:

```bash
# Replace 'yourusername' with your actual GitHub username
sed -i 's/yourusername/YOUR_ACTUAL_USERNAME/g' README.md
```

## 🏃‍♂️ Running the Application

### Prerequisites Check

First, verify you have the required software:

```bash
# Check Java version (should be 17 or higher)
java -version

# Check Maven version (should be 3.6 or higher)
mvn -version
```

### Quick Start Commands

```bash
# Clone the repository
git clone https://github.com/yourusername/calculator-app.git
cd calculator-app

# Build the application
mvn clean package

# Run the application
mvn spring-boot:run
```

### Access the Application

Once running, open your browser and go to:
- **http://localhost:8081** - Main application
- **http://localhost:8081/signup** - Create account
- **http://localhost:8081/login** - Login
- **http://localhost:8081/dashboard** - Calculator (after login)

## 🔧 Production Deployment

### Building JAR File

```bash
mvn clean package -DskipTests
```

This creates a JAR file in the `target/` directory.

### Running JAR File

```bash
java -jar target/calculator-app-0.0.1-SNAPSHOT.jar
```

### Environment Variables

For production, you can override configuration using environment variables:

```bash
# Change port
export SERVER_PORT=8080

# Change database (for production database)
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/calculator_db
export SPRING_DATASOURCE_USERNAME=your_username
export SPRING_DATASOURCE_PASSWORD=your_password

# Run the application
java -jar target/calculator-app-0.0.1-SNAPSHOT.jar
```

## 🌐 Cloud Deployment

### Heroku

1. Create a `Procfile`:
```
web: java -jar target/calculator-app-0.0.1-SNAPSHOT.jar
```

2. Deploy:
```bash
heroku create your-app-name
git push heroku main
```

### AWS EC2

1. Launch an EC2 instance with Java 17
2. Upload the JAR file
3. Run:
```bash
java -jar calculator-app-0.0.1-SNAPSHOT.jar
```

### Google Cloud Run

1. Create a `Dockerfile` (see above)
2. Build and deploy:
```bash
gcloud builds submit --tag gcr.io/PROJECT_ID/calculator-app
gcloud run deploy --image gcr.io/PROJECT_ID/calculator-app --platform managed
```

## 🔍 Troubleshooting

### Common Issues

1. **Port already in use**:
   ```bash
   lsof -i :8081
   kill -9 <PID>
   ```

2. **Java version issues**:
   ```bash
   # Install Java 17
   sudo apt update && sudo apt install openjdk-17-jdk
   ```

3. **Maven issues**:
   ```bash
   # Clear Maven cache
   mvn clean
   rm -rf ~/.m2/repository
   ```

4. **Database connection issues**:
   - Check if H2 console is accessible at http://localhost:8081/h2-console
   - Verify database configuration in `application.properties`

### Logs

Check application logs for errors:

```bash
# If running with Maven
mvn spring-boot:run

# If running JAR
java -jar target/calculator-app-0.0.1-SNAPSHOT.jar --debug
```

## 📞 Support

If you encounter issues:

1. Check the main README.md troubleshooting section
2. Verify all prerequisites are installed
3. Check the application logs
4. Create an issue in the GitHub repository

---

**Happy Deploying! 🚀** 