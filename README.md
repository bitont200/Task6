# Calculator TDD

## Overview

A Java-based calculator implementation following Test-Driven Development (TDD) principles and Object-Oriented Programming (OOP) design.

## 🎯 Project Goals

- Implement calculator using TDD methodology
- Apply OOP principles (Encapsulation, Single Responsibility, Separation of Concerns)
- Demonstrate professional Git workflow with Pull Requests

## 🚀 Features

- ✅ Addition (+)
- ✅ Subtraction (-)
- ✅ Multiplication (*)
- ✅ Division (/)
- ✅ Operator precedence (multiplication and division before addition and subtraction)
- ✅ Whitespace handling
- ✅ Exception handling (division by zero)

## 🧱 Architecture

This project follows Object-Oriented Programming principles:

- **Calculator**: Main facade class
- **Operator Interface**: Contract for all operators
- **Concrete Operators**: AdditionOperator, SubtractionOperator, MultiplicationOperator, DivisionOperator
- **ExpressionParser**: Tokenizes mathematical expressions
- **ExpressionEvaluator**: Evaluates expressions using Shunting Yard algorithm
- **Token/TokenType**: Representation of expression components


## 📁 Project Structure
```
.
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── calculator
│   │               ├── Calculator.java
│   │               ├── Operator.java
│   │               ├── AdditionOperator.java
│   │               ├── SubtractionOperator.java
│   │               ├── MultiplicationOperator.java
│   │               ├── DivisionOperator.java
│   │               ├── ExpressionParser.java
│   │               ├── ExpressionEvaluator.java
│   │               ├── Token.java
│   │               └── TokenType.java
│   └── test
│       └── java
│           └── com
│               └── calculator
│                   └── CalculatorTest.java
└── pom.xml
```

## 🧪 Running Tests
```bash
mvn test
```

## 🛠️ Technologies

- Java 17
- JUnit 5
- Maven

## 📚 TDD Approach

Each feature follows the Red-Green-Refactor cycle:
1. 🔴 **Red**: Write failing test
2. 🟢 **Green**: Write minimal code to pass
3. ♻️ **Refactor**: Improve code quality

## 👩‍💻 Development

This project uses feature branches and Pull Requests for all changes.
