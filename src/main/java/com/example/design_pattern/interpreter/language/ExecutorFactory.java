package com.example.design_pattern.interpreter.language;

public interface ExecutorFactory {
    public abstract Executor createExecutor(String name);
}
