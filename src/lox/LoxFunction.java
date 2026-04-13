package lox;

import java.util.List;

class LoxFunction implements LoxCallable {
    private final String name;
    private final List<Token> params;
    private final List<Stmt> body;
    private final Environment closure;

    LoxFunction(Stmt.Function declaration, Environment closure) {
        this.name = declaration.name.lexeme;
        this.params = declaration.params;
        this.body = declaration.body;
        this.closure = closure;
    }

    LoxFunction(String name, List<Token> params, List<Stmt> body, Environment closure) {
        this.name = name;
        this.params = params;
        this.body = body;
        this.closure = closure;
    }

    @Override
    public int arity() {
        return this.params.size();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        Environment environment = new Environment(closure);

        for (int i = 0; i < this.params.size(); i++) {
            environment.define(this.params.get(i).lexeme, arguments.get(i));
        }

        try {
            interpreter.executeBlock(this.body, environment);
        } catch (Return returnValue) {
            return returnValue.value;
        }

        return null;
    }

    @Override
    public String toString() {
        return "<fn " + this.name + ">";
    }
}
