# Jlox - Java Lox Interpreter

![Java](https://img.shields.io/badge/Language-Java-orange)
![Status](https://img.shields.io/badge/Status-In%20Progress-yellow)
![Chapter](https://img.shields.io/badge/Chapter-8%3A%20Statements%20and%20State-blue)

A tree-walk interpreter for the **Lox** programming language, built in Java following the book *[Crafting Interpreters](https://craftinginterpreters.com/)* by Robert Nystrom.

---

## Current Progress
**Chapter 8: Statements and State**
The interpreter can now parse and execute statements, including variable declarations, assignments, and block scopes.

## Architecture

The project follows a classic interpreter pipeline:

1.  **Scanner (`Scanner.java`)**
    *   Converts raw source code into a stream of `Token`s.
    *   Handles keywords, literals, and operators.

2.  **Parser (`Parser.java`)**
    *   **Recursive Descent Parser** that constructs an Abstract Syntax Tree (AST).
    *   Handles operator precedence, error synchronization, and statement parsing.

3.  **AST (`Expr.java`, `Stmt.java`)**
    *   Represents the code structure (expressions and statements).
    *   Uses the **Visitor Pattern** for operations like printing (`AstPrinter`) and evaluation (`Interpreter`).

4.  **Interpreter (`Interpreter.java`)**
    *   Traverses the AST recursively to execute code.
    *   Handles dynamic typing, truthiness, arithmetic, and state management.

5.  **Environment (`Environment.java`)**
    *   Manages variable scopes and bindings.
    *   Supports nested environments for block scopes.

## Project Structure

```text
src/lox/
├── Lox.java          # Entry point (REPL & Script runner)
├── Scanner.java      # Lexical Analysis
├── Token.java        # Token definition
├── TokenType.java    # Enum of token types
├── Parser.java       # Syntax Analysis
├── Expr.java         # AST Expression Node definitions
├── Stmt.java         # AST Statement Node definitions
├── Interpreter.java  # Evaluation logic
├── Environment.java  # Variable scope management
└── AstPrinter.java   # Debug utility to print AST
```

## Usage

### Run a script
```bash
java lox.Lox script.lox
```

### Interactive REPL
```bash
java lox.Lox
> var a = 1;
> var b = 2;
> print a + b;
3
```

---
