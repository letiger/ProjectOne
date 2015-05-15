package za.ac.cput.factory;

import za.ac.cput.domain.Equipment;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class EquipmentFactory {
    public static Equipment createEquipment(Map<String,String> value){
        Equipment object_one = new Equipment
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
