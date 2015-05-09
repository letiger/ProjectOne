package za.ac.cput.fatory;

import za.ac.cput.domain.Hardware;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class HardwareFactory {
    public static Hardware createHardware(Map<String,String> value){
        Hardware object_one = new Hardware
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
