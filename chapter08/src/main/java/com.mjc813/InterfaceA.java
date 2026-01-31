package com.mjc813;

public sealed interface InterfaceA permits InterfaceB{
    // 추상 메소드
    void methodA();
}
