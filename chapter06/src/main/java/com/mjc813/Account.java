package com.mjc813;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Account {

    static final int MIN_BALANCE = 0;
    static final int MAX_BALANCE = 1000000;

    // 외부에서 직접 변경하지 못하도록 private 선언
    @Getter
    private int balance;

    // Getter: 현재 잔고를 반환
//    public int getBalance() {
//        return this.balance;
//    }

    // Setter: 조건에 맞는 값만 balance에 저장
    public void setBalance(int balance) {
        // 조건: 매개값이 0보다 작거나 1,000,000보다 크면 현재 balance 유지
        if (balance < MIN_BALANCE || balance > MAX_BALANCE) {
            return;
        } else {
            this.balance = balance;
        }
    }



}
