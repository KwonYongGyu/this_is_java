module gson.module {
    requires com.google.gson;
    exports com.mjc813;
    // exports com.mjc813_2; 이 문장을 사용하면 외부에서 사용 가능하게 하는 문장을 주석처리했지만 외부에서 사용가능
    // main의 21번째 줄 즉 외부에서 사용이 가능했다.
//    Create module-info.java file
//    module name: maven_use_module
}