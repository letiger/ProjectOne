package za.ac.cput.factory;

import za.ac.cput.domain.Region;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class RegionFactory {
    public static Region createRegion(Map<String,String> value){
        Region object_one = new Region
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
