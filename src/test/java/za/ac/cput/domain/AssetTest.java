package za.ac.cput.domain;

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

    @Test
    public void createAsset() throws Exception{
        List<Software> softwareList = new ArrayList<Software>();
        List<Hardware> hardwareList= new ArrayList<Hardware>();
        List<Equipment> equipmentList= new ArrayList<Equipment>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("Name", "2015-05-01-12:00");
        values.put("Code", "201505011200");

        Asset asset = AssetFactory
                .createAsset(values);

        assertEquals("201505011200", asset.getCode());

    }

}
