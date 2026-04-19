# Jlox - Java Lox Interpreter

![Java](https://img.shields.io/badge/Language-Java-orange)
![Status](https://img.shields.io/badge/Status-In%20Progress-yellow)
![Chapter](https://img.shields.io/badge/Chapter-11%3A%20Resolving%20and%20Binding-blue)

A tree-walk interpreter for the **Lox** programming language, built in Java following the book *[Crafting Interpreters](https://craftinginterpreters.com/)* by Robert Nystrom.

---

## Current Progress
**Chapter 11: Resolving and Binding**
The interpreter now includes a semantic analysis pass (Resolver) that resolves variable bindings before execution, fixing closure semantics and enabling static error detection.

### Features implemented so far:
- Scanning, parsing, and tree-walk interpretation
- Variables, scopes, and block environments
- Control flow: `if`, `while`, `for`, `break`, `continue`
- Functions, closures, and recursion
- Lambda expressions
- **Resolver** for static variable resolution and closure correctness
- **Unused variable detection** (reports error for unused local variables)
- **Index-based environment lookup** for faster variable access

## Architecture

The project follows a classic interpreter pipeline:

1. **Scanner (`Scanner.java`)**
    - Converts raw source code into a stream of `Token`s.
    - Handles keywords, literals, and operators.

2. **Parser (`Parser.java`)**
    - **Recursive Descent Parser** that constructs an Abstract Syntax Tree (AST).
    - Handles operator precedence, error synchronization, and statement parsing.

3. **AST (`Expr.java`, `Stmt.java`)**
    - Represents the code structure (expressions and statements).
    - Uses the **Visitor Pattern** for operations like printing (`AstPrinter`) and evaluation (`Interpreter`).

4. **Resolver (`Resolver.java`)**
    - Performs a static analysis pass over the AST before execution.
    - Resolves each variable to its exact scope depth and index.
    - Detects errors such as `return` outside functions, `break`/`continue` outside loops, and unused local variables.

5. **Interpreter (`Interpreter.java`)**
    - Traverses the AST recursively to execute code.
    - Uses pre-resolved variable locations for correct and efficient lookup.

6. **Environment (`Environment.java`, `GlobalEnvironment.java`)**
    - Local environments use an index-based `List<Object>` for fast variable access.
    - Global environment uses a `Map<String, Object>` for named variable lookup.

## Project Structure

```text
src/lox/
├── Lox.java                # Entry point (REPL & Script runner)
├── Scanner.java            # Lexical Analysis
├── Token.java              # Token definition
├── TokenType.java          # Enum of token types
├── Parser.java             # Syntax Analysis
├── Expr.java               # AST Expression Node definitions
├── Stmt.java               # AST Statement Node definitions
├── Resolver.java           # Semantic Analysis & Variable Resolution
├── Interpreter.java        # Evaluation logic
├── Environment.java        # Local scope management (index-based)
├── GlobalEnvironment.java  # Global scope management (name-based)
├── LoxCallable.java        # Callable interface
├── LoxFunction.java        # Function representation
├── BreakException.java     # Break control flow
├── ContinueException.java  # Continue control flow
├── Return.java             # Return control flow
└── AstPrinter.java         # Debug utility to print AST
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
