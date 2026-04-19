package lox;

import java.util.HashMap;
import java.util.Map;

public class GlobalEnvironment extends Environment {
    private final Map<String, Object> globals = new HashMap<>();

    GlobalEnvironment() {
        super();
    }

    @Override
    void define(String name, Object value) {
        globals.put(name, value);
    }

    @Override
    Object get(Token name) {
        if (globals.containsKey(name.lexeme)) {
            return globals.get(name.lexeme);
        }
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    @Override
    void assign(Token name, Object value) {
        if (globals.containsKey(name.lexeme)) {
            globals.put(name.lexeme, value);
            return;
        }
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }
}