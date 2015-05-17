package za.ac.cput.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.App;
import za.ac.cput.domain.Asset;
import za.ac.cput.domain.Equipment;
import za.ac.cput.domain.Hardware;
import za.ac.cput.domain.Software;
import za.ac.cput.factory.AssetFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/15.
 */
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class AssetCrudTest extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    AssetRepository repository;

    @Test
    public void create() throws Exception{
        System.out.println("Creating the db entries");
        String ownerName = "Travis Wade";
        List<Software> softwareList = new ArrayList<Software>();
        List<Hardware> hardwareList= new ArrayList<Hardware>();
        List<Equipment> equipmentList= new ArrayList<Equipment>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("Name", ownerName);
        values.put("Code", "1234qwerty");

        Asset asset = AssetFactory
                .createAsset(softwareList, hardwareList, equipmentList, values);
        repository.save(asset);
        id = asset.getId();
        Assert.assertNotNull(asset.getId());
    }
}
