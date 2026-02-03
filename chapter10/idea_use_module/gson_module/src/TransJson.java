import com.google.gson.Gson;

import java.lang.reflect.Type;

public class TransJson {
    private Gson gson;

    public TransJson(){
        this.gson = new Gson();
    }
    public String toStringfromString(Object obj){
        return this.gson.toJson(obj);
    }
    
    public Object toStringfromObject(String str, Type type){
        return this.gson.fromJson(str, type);
    }
}
