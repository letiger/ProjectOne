package za.ac.cput.config.factory;

import za.ac.cput.domain.SoftwareType;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class SoftwareTypeFactory {
    public static SoftwareType createSoftwareType(Map<String,String> value){
        SoftwareType object_one = new SoftwareType
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
