package za.ac.cput.factory;


import za.ac.cput.domain.OwnerType;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class OwnerTypeFactory {
    public static OwnerType createOwnerType(Map<String,String> value){
        OwnerType object_one = new OwnerType
                .Builder(value.get("Code"))
                .name("OwnerType")
                .build();
        return object_one;
    }
}
