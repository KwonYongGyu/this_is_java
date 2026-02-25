package com.mjc813.BookExample;


// 제너릭 타입
public class Product <K,M> {
    // 필드
    private K kind; // 타입 파라미터를 필드로 사용
    private M model;

    // 메소드
    public K getKind() { return this.kind; }
    public M getModel() { return this.model; }
    public void setKind(K kind) {this.kind = kind; }
    public void setModel(M model) {this.model = model; }
}
