package com.mjc813;

import static com.mjc813.DaoExample.dbWork;
import static com.mjc813.SoundExample.printSound;

public class Chapter08 {

    public void RemoteControlExample() {

        RemoteControl rc;
        rc = new Television();
        rc.turnOn();
        // p.354
        rc.setVolume(5);
        rc.turnOff();

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        // p.349
        System.out.println("리모콘 최대 불륨: " + RemoteControl.MAX_VOLUME);
        System.out.println("리모콘 최저 불륨: " + RemoteControl.MIN_VOLUME);

    }


    // 확인문제 5.
    public void ConfirmationProblem5() {
        Remocon r = new TV();
        r.powerOn();
    }

    // 확인문제 6.
    public void ConfirmationProblem6() {
        printSound(new Cat());
        printSound(new Dog());
    }

//    private void printSound(Soundable soundable){
//
//    }

    // 확인문제 7.
    public void ConfirmationProblem7() {
        dbWork(new OracleDao());
        dbWork(new MySqlDao());

    }

    // 확인문제 8.
    public void ConfirmationProblem8() {

        Example.action(new B());
        Example.action(new C());
    }
}
