package com.example.support;

public interface TypeConverter<S> {

    S convertFrom(String input);
}
