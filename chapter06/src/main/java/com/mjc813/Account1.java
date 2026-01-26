package com.mjc813;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter // 19번과 달리 조건이 없기때문에 @Setter 한줄로 끝낼 수 있음
@AllArgsConstructor // 모든 필드를 매개값으로 받는 생성자 생성
//        this.ano = ano;
//        this.owner = owner;
//        this.balance = balance;
public class Account1 {
    private String ano;    // 계좌번호
    private String owner;  // 계좌주
    private int balance;   // 잔고

//    public Account1(String ano, String owner, int balance) {
//        this.ano = ano;
//        this.owner = owner;
//        this.balance = balance;
//    }

//    public String getAno() {
//        return ano;
//    }
//
//    public void setAno(String ano) {
//        this.ano = ano;
//    }
//
//    public String getOwner() {
//        return owner;
//    }
//
//    public void setOwner(String owner) {
//        this.owner = owner;
//    }
//
//    public int getBalance() {
//        return balance;
//    }
//
//    public void setBalance(int balance) {
//        this.balance = balance;
//    }
}

