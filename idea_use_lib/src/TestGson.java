import com.google.gson.Gson;

public class TestGson {
    public void runTestGson(){
        int[] intArray = {1, 2, 3, 4, 5, 6};
        Gson gs25 = new Gson();
        String s = gs25.toJson(intArray);
      System.out.println(s);

        KygClass kc = new KygClass();
        kc.setMyArray(intArray);
        String s2 = gs25.toJson(kc);
        System.out.println(s2);

    }
}
