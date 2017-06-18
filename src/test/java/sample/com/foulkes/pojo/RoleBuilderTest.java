package sample.com.foulkes.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by danfoulkes on 18/06/2017.
 * Project: SampleApp
 * Package: sample.com.foulkes.pojo
 */
public class RoleBuilderTest {


    public static final String ROLE_NAME = "role_name";

    @Test
    public void shouldBuildRole(){
        Role role = RoleBuilder.getBuilder().withId(1L).withName(ROLE_NAME).build();
        assertThat(role.getName(), is(ROLE_NAME));
        assertThat(role.getRoleId(), is(1L));
    }


}