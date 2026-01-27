package test.pack;
import com.mjc813.AClass;
public class DClass extends AClass{
    // 생성자 선언
    public DClass(){
        // AClass() 생성자 호출
        super();    //o     // 상속을 통해서만 가능
    }

    // 메소드 선언
    public void method1(){
        // A 필드값 변경
        this.field = "value"; //o
        // A 메소드 호출
        this.method();  //o
    }

    // 메소드 선언
    public void method2(){  // 직접 객체 생성해서 사용하는것은 안됨
//        AClass a = new AClass(); //x
//        a.field = "value";  //x
//        a.method(); //x
    }

}
