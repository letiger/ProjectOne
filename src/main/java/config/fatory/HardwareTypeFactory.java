package config.fatory;

import domain.HardwareType;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class HardwareTypeFactory {
    public static domain.HardwareType createHardwareType(Map<String,String> value){
        HardwareType object_one = new HardwareType
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
