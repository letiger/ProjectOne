package za.ac.cput.config.factory;

import za.ac.cput.domain.Owner;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class OwnerFactory {
    public static Owner createOwner(Map<String,String> value){
        Owner object_one = new Owner
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
