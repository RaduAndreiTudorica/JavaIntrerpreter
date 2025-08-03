
# 🦎 Lox Interpreter – Java Implementation

This is a basic interpreter for the **Lox programming language**, implemented in Java.  
It closely follows the structure and design from the book *Crafting Interpreters* by Robert Nystrom.

---

## ✅ Features Implemented

| Component         | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| `Lox.java`       | Main entry point. Runs `.lox` scripts or launches an interactive REPL.      |
| `Scanner.java`   | Converts raw source code into a list of **tokens** (lexical analysis).      |
| `TokenType.java` | Enum of all token types used in Lox (keywords, operators, etc.).            |
| `Token.java`     | Representation of a token (type, lexeme, literal, line).                    |
| `Expr.java`      | Abstract syntax tree (AST) class hierarchy for expressions.                 |
| `AstPrinter.java`| A **visitor** that prints the AST in fully parenthesized form.              |
| `GenerateAst.java`| Tool to auto-generate `Expr` subclasses using the AST grammar definition.  |

---

## 🧠 How It Works

- **Lexical Analysis**: The scanner (`Scanner.java`) transforms raw source into a list of tokens.
- **Parsing**: `Expr.java` represents expressions, and the visitor pattern is used for traversal.
- **AST Printing**: `AstPrinter` prints the parsed expressions using a parenthesized prefix notation.
- **REPL Mode**: If no `.lox` script is passed, it enters an interactive mode for testing.

---

## 💻 Example Usage

### Compile

```bash
javac -d out src/lox/*.java src/tool/*.java
```

### Run REPL

```bash
java -cp out lox.Lox
```

### Run a Lox script

```bash
java -cp out lox.Lox path/to/script.lox
```

---

## 🛠 In Progress

- [ ] Parser (`Parser.java`) – builds an AST from token sequence.
- [ ] Runtime evaluator (interpreter).
- [ ] Statements (`Stmt`) and control flow (`if`, `while`, `print`, etc.).
- [ ] Environment for variables and scoping.
- [ ] Error reporting and recovery.

---

## 📚 Based On

**Crafting Interpreters** by [Robert Nystrom](https://craftinginterpreters.com/) – an excellent book on building programming languages.
