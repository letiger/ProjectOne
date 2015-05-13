package za.ac.cput.fatory;

import za.ac.cput.domain.Asset;
import za.ac.cput.domain.Equipment;
import za.ac.cput.domain.Hardware;
import za.ac.cput.domain.Software;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class AssetFactory {
    public static Asset createAsset(List<Software> softwareList, List<Hardware> hardwareList, List<Equipment> equipmentList, Map<String,String> value){
        Asset object_one = new Asset
                .Builder(value.get("Code"))
                .name(value.get("Name"))
                .softwareList(softwareList)
                .hardwareList(hardwareList)
                .equipmentList(equipmentList)
                .build();
        return object_one;
    }
}
