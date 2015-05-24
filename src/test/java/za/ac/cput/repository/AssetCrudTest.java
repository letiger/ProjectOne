package za.ac.cput.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.App;
import za.ac.cput.domain.Asset;
import za.ac.cput.domain.Equipment;
import za.ac.cput.domain.Hardware;
import za.ac.cput.domain.Software;
import za.ac.cput.config.factory.AssetFactory;

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
    List<Equipment> equipmentList;
    List<Hardware> hardwareList;
    List<Software> softwareList;


    @Autowired
    private AssetRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        softwareList = new ArrayList<Software>();

    }

    @Test
    public void create() throws Exception{
        System.out.println("Creating the db entries");
        String ownerName = "Travis Wade";

        //Complete software list
        Software antiVirus = new Software.Builder("Kasperskey").name("firstOne").build();
        Software OS = new Software.Builder("Windows 7").name("firstOne").build();
        Software office = new Software.Builder("MS Office").name("firstOne").build();

        softwareList.add(0, antiVirus);
        softwareList.add(1, OS);
        softwareList.add(2, office);
        //Complete software list

        hardwareList= new ArrayList<Hardware>();
        equipmentList= new ArrayList<Equipment>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("Name", ownerName);
        values.put("Code", "1stOne");

        Asset asset = AssetFactory
                .createAsset(softwareList, hardwareList, equipmentList, values);
        repository.save(asset);
        id = asset.getId();
        Assert.assertNotNull(asset.getId());
        Assert.assertTrue(asset.getSoftwareList().size() == 3);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Asset asset = repository.findOne(id);
        Assert.assertNotNull(asset.getId());
        Assert.assertTrue(asset.getSoftwareList().size()==3);
    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Asset asset = repository.findOne(id);
        Asset newAsset = new Asset
                .Builder(asset.getName())
                .copy(asset)
                .name("2ndOne")
                .build();

        repository.save(newAsset);

        Asset updatedAsset = repository.findOne(id);
        Assert.assertEquals(updatedAsset.getName(), "2ndOne");
        Assert.assertEquals(asset.getCode(), "1stOne");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        Asset asset = repository.findOne(id);
        repository.delete(asset);
        Asset deletedAsset = repository.findOne(id);
        Assert.assertNull(deletedAsset);//check for specific asset
        Assert.assertTrue(repository.count() == 1); //checks that one 1 is left after delete
    }

    @AfterMethod
    public void tearDown() throws Exception {
        repository.deleteAll();
    }
}
