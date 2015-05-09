package za.ac.cput.fatory;

import za.ac.cput.domain.HardwareType;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class HardwareTypeFactory {
    public static HardwareType createHardwareType(Map<String,String> value){
        HardwareType object_one = new HardwareType
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
