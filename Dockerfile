# 1️⃣ Use Maven with Java
FROM maven:3.9.6-eclipse-temurin-17

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy pom.xml first (cache dependencies)
COPY pom.xml .

# 4️⃣ Download dependencies
RUN mvn dependency:go-offline

# 5️⃣ Copy project source
COPY src ./src
COPY pom.xml .
COPY testng.xml . 

# 6️⃣ Run tests
CMD ["mvn", "clean", "test"]