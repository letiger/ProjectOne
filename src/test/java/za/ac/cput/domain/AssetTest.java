package za.ac.cput.domain;

import org.junit.Assert;
import za.ac.cput.domain.Asset;
import za.ac.cput.domain.Equipment;
import za.ac.cput.domain.Hardware;
import za.ac.cput.domain.Software;
import za.ac.cput.fatory.AssetFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by student on 2015/05/03.
 */
public class AssetTest {
    @Before
    public void setup() throws Exception{}

    //create ann asset and test it
    @Test
    public void CreateAsset() throws Exception{
        String ownerName = "Travis Wade";
        List<Software> softwareList = new ArrayList<Software>();
        List<Hardware> hardwareList= new ArrayList<Hardware>();
        List<Equipment> equipmentList= new ArrayList<Equipment>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("Name", ownerName);
        values.put("Code", "1234qwerty");

        Asset asset = AssetFactory
                .createAsset(softwareList, hardwareList, equipmentList, values);
        System.out.println(asset.getName());
        assertEquals(ownerName, asset.getName());
    }

    //update the asset entry
    @Test
    public void UpdateAsset() throws Exception{
        String ownerName = "Travis Wade";
        List<Software> softwareList = new ArrayList<Software>();
        List<Hardware> hardwareList= new ArrayList<Hardware>();
        List<Equipment> equipmentList= new ArrayList<Equipment>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("Name", ownerName);
        values.put("Code", "1234qwerty");

        Asset asset = AssetFactory
                .createAsset(softwareList, hardwareList, equipmentList, values);

        Asset newAsset = new Asset
                .Builder(asset.getCode())
                .copy(asset)
                .name("Raymond Newton")
                .build();
        Assert.assertEquals("1234qwerty", newAsset.getCode());
        Assert.assertEquals("Raymond Newton", newAsset.getName());
        Assert.assertEquals("Travis Wade", asset.getName());
    }

}
