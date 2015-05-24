package za.ac.cput.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import za.ac.cput.App;
import za.ac.cput.config.factory.SoftwareFactory;
import za.ac.cput.domain.Software;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/24.
 */
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class SoftwareCrudTest extends AbstractTestNGSpringContextTests{

    private Long id;

    @Autowired
    private SoftwareRepository repository;

    @Test
    public void create() throws Exception{
        Map<String,String> values = new HashMap<String,String>();
        values.put("Code", "Anti-Virus");
        values.put("Asset","FirstOne");

        Software software = SoftwareFactory.createSoftware(values);

        repository.save(software);
        id=software.getId();
        Assert.assertNotNull(software);
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Software software = repository.findOne(id);
        Assert.assertEquals(software.getName(), "Anti-Virus");
        Assert.assertNotNull(software);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Software software = repository.findOne(id);
        Software software2 = new Software
                .Builder("IntelliJ")
                .copy(software)
                .name("Second One")
                .build();
        repository.save(software2);
        Assert.assertTrue(repository.count() == 2);
        Assert.assertEquals(software2.getName(), "Second One");
        Assert.assertEquals(software.getName(), "First One");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        Software software = repository.findOne(id);
        repository.delete(software);
        Software deletedSoftware = repository.findOne(id);
        Assert.assertTrue(repository.count() ==1);
        Assert.assertNull(deletedSoftware.getId());
    }
    @AfterMethod
    public void tearDown() throws Exception {
        repository.deleteAll();

    }
}
