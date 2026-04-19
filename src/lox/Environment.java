package lox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Environment {
    final Environment enclosing;
    private final List<Object> values = new ArrayList<>();
    public static final Object UNINITIALIZED = new Object();

    Environment() {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    Object get(Token name, int index) {
        if (values.size() > index) {
            Object value = values.get(index);
            if (value == UNINITIALIZED) {
                throw new RuntimeError(name, "Variable '" + name.lexeme + "' is not initialized.");
            }

            return value;
        }

        if (enclosing != null) return enclosing.get(name, index);

        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    void assignAt(int distance, int index, Object value) {
        ancestor(distance).values.set(index, value);
    }

    Environment ancestor(int distance) {
        Environment environment = this;
        for(int i = 0; i < distance; i++) {
            environment = environment.enclosing;
        }
        return environment;
    }

    Object getAt(int distance, int index) {
        return ancestor(distance).values.get(index);
    }

    void define(Object value) {
        values.add(value);
    }

    void assign(Token name, int index, Object value) {
        if (values.size() > index) {
            values.set(index, value);
            return;
        }

        if (enclosing != null) {
            enclosing.assign(name, index, value);
            return;
        }

        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    void define(String name, Object value) {
        throw new RuntimeError(null, "Can't define by name in local environment.");
    }

    Object get(Token name) {
        throw new RuntimeError(name, "Can't get by name in local environment.");
    }

    void assign(Token name, Object value) {
        throw new RuntimeError(name, "Can't assign by name in local environment.");
    }
}
