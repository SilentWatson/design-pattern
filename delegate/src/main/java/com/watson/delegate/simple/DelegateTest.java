package com.watson.delegate.simple;

public class DelegateTest {
    public static void main(String[] args) {
        Leader xgg = new Leader();
        Boss watson = new Boss(xgg);
        watson.command("加密");
        watson.command("架构");
    }
}
