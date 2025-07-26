# Lox - Java Interpreter (In Progress)

This is a basic interpreter for the **Lox programming language**, written in Java. It follows the design and implementation described in the book *Crafting Interpreters* by Robert Nystrom.

## ✅ Features Implemented

So far, the project includes:

- ✅ A **main driver** (`Lox.java`) that can run `.lox` scripts or start an interactive prompt (REPL).
- ✅ A **scanner (lexer)** (`Scanner.java`) that converts source code into a list of tokens.
- ✅ A complete enumeration of **token types** (`TokenType.java`).
- ✅ A `Token` class representing each token with type, lexeme, literal value, and line number.

## 🔍 How It Works

- If you run the program with a `.lox` file, it reads and scans the file.
- If you run the program without arguments, it launches a REPL (interactive mode) in the console.

### Example usage:

```bash
# Run a Lox script
java lox.Lox path/to/script.lox
