# Jlox - Java Lox Interpreter

![Java](https://img.shields.io/badge/Language-Java-orange)
![Status](https://img.shields.io/badge/Status-In%20Progress-yellow)
![Chapter](https://img.shields.io/badge/Chapter-7%3A%20Evaluating%20Expressions-blue)

A tree-walk interpreter for the **Lox** programming language, built in Java following the book *[Crafting Interpreters](https://craftinginterpreters.com/)* by Robert Nystrom.

---

## 🚀 Current Progress
**Chapter 7: Evaluating Expressions**
The interpreter can now parse and evaluate arithmetic and logical expressions.

## 🛠️ Architecture

The project follows a classic interpreter pipeline:

1.  **Scanner (`Scanner.java`)**
    *   Converts raw source code into a stream of `Token`s.
    *   Handles keywords, literals, and operators.

2.  **Parser (`Parser.java`)**
    *   **Recursive Descent Parser** that constructs an Abstract Syntax Tree (AST).
    *   Handles operator precedence and error synchronization.

3.  **AST (`Expr.java`)**
    *   Represents the code structure.
    *   Uses the **Visitor Pattern** for operations like printing (`AstPrinter`) and evaluation (`Interpreter`).

4.  **Interpreter (`Interpreter.java`)**
    *   Traverses the AST recursively to execute code.
    *   Handles dynamic typing, truthiness, and arithmetic.

## 📂 Project Structure

```text
src/lox/
├── Lox.java          # Entry point (REPL & Script runner)
├── Scanner.java      # Lexical Analysis
├── Token.java        # Token definition
├── TokenType.java    # Enum of token types
├── Parser.java       # Syntax Analysis
├── Expr.java         # AST Node definitions
├── Interpreter.java  # Evaluation logic
└── AstPrinter.java   # Debug utility to print AST
```

## 💻 Usage

### Run a script
```bash
java lox.Lox script.lox
```

### Interactive REPL
```bash
java lox.Lox
> 1 + 2 * 3
7
```

---
*Built with ❤️ while learning compiler design.*
