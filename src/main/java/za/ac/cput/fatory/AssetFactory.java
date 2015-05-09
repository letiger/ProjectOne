package za.ac.cput.fatory;

import za.ac.cput.domain.Asset;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class AssetFactory {
    public static Asset createAsset(Map<String,String> value){
        Asset object_one = new Asset
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
