package config.fatory;

import domain.Software;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class SoftwareFactory {
    public static Software createSoftware(Map<String,String> value){
        Software object_one = new Software
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
