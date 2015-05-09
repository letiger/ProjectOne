package za.ac.cput.fatory;

import za.ac.cput.domain.User;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class UserFactory {
    public static User createUser(Map<String,String> value){
        User object_one = new User
                .Builder(value.get("Code"))
                .name("Asset")
                .build();
        return object_one;
    }
}
