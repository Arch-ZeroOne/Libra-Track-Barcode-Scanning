# 📘 Java Faker Setup in Apache NetBeans (Manual JAR Setup) + DAO Pattern Reference

This guide explains how to set up **Java Faker** in **Apache NetBeans IDE** using downloaded JAR files instead of Maven/Gradle.  
Additionally, it links to resources about the **DAO (Data Access Object) design pattern**.

---

## 🚀 1. Download Required JARs

Java Faker depends on other libraries, so we need multiple JARs:

1. **[Java Faker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker)**  
   - The main library used to generate fake data like names, emails, addresses, etc.

2. **[SnakeYAML](https://mvnrepository.com/artifact/org.yaml/snakeyaml)**  
   - Required by Faker to parse its internal YAML files (used for localized fake data like names, countries).

3. **[Apache Commons Lang3](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3)**  
   - Utility library providing helpers (string handling, randomization, object utilities) used internally by Faker.

---

## 📂 2. Project Setup in NetBeans

1. Create a folder named `libs/` inside your NetBeans project root.  
   Example:  
MyProject/
├── src/
├── libs/
│ ├── javafaker-<version>.jar
│ ├── snakeyaml-<version>.jar
│ └── commons-lang3-<version>.jar


2. Open **NetBeans → Project Properties → Libraries → Compile Tab**.  
3. Click **Add JAR/Folder**.  
4. Select all JARs inside the `libs/` folder.  
5. Apply and save. ✅  

---

## 📝 3. Example Usage

```java
import com.github.javafaker.Faker;

public class FakerDemo {
 public static void main(String[] args) {
     Faker faker = new Faker();

     System.out.println("Name: " + faker.name().fullName());
     System.out.println("Address: " + faker.address().fullAddress());
     System.out.println("Email: " + faker.internet().emailAddress());
     System.out.println("Book: " + faker.book().title());
 }
}
