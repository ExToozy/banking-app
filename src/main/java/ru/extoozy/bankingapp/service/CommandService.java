package ru.extoozy.bankingapp.service;

public interface CommandService<T> {

    void create(T object);

}
