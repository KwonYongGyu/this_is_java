package com.mjc813.BookExample;

public class Chapter13 {
    public void GenericExample(){
        // Box<String> box1 = new Box<String>();
        Box<String> box1 = new Box<>();
        box1.content = "안녕하세요.";
        String str = box1.content;
        System.out.println(str);

        //Box<Integer> box2 = new Box<Integer>();
        Box<Integer> box2 = new Box<>();
        box2.content = 100;
        int value = box2.content;
        System.out.println(value);
    }
    public void GenericExample1(){
        // K는 TV로 대체, M은 String으로 대체
        Product <Tv, String> product1 = new Product<>();

        // Setter 매개값은 반드시 Tv와 String을 제공
        product1.setKind(new Tv());
        product1.setModel("스마트Tv");

        // Getter 리턴값은 Tv와 String이 됨
        Tv tv = product1.getKind();
        String tvModel = product1.getModel();
        // -------------------------------------------------------------------
        // K는 Car로 대체, M은 String으로 대체
        Product<Car, String> product2 = new Product<>();

        // Setter 매개값은 반드시 Car와 String을 제공
        product2.setKind(new Car());
        product2.setModel("SUV자동차");

        // Getter 리턴값은 Car와 String이 됨
        Car car = product2.getKind();
        String carModel = product2.getModel();
    }

    public void GenericExample2(){
        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent();
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        Car car = carAgency.rent();
        car.run();
        System.out.println();

    }

    public void GenericExample3(){
        Box<String> box1 = new Box<>();
        box1.content = "100";

        Box<String> box2 = new Box<>();
        box2.content = "100";

        boolean result1 = box1.compare(box2);
        System.out.println("result1: " + result1);
    }

    public void GenericExample5(){
        // 모든 사람이 신청 가능
        Course.registerCourse1(new Applicant<Person>(new Person()));
        Course.registerCourse1(new Applicant<Worker>(new Worker()));
        Course.registerCourse1(new Applicant<Student>(new Student()));
        Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
        Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();

        // 학생만 신청 가능
        Course.registerCourse2(new Applicant<Student>(new Student()));
        Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
        Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();

        // 직장인 및 일반인만 신청 가능
        Course.registerCourse3(new Applicant<Person>(new Person()));
        Course.registerCourse3(new Applicant<Worker>(new Worker()));
        System.out.println();

    }


}
