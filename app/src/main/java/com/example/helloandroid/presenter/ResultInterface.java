package com.example.helloandroid.presenter;

public interface ResultInterface {
    <T> void sucesso(T requestResult);

    void falha(String message);
}
