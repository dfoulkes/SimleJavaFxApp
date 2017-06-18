package sample.com.foulkes.pojo;

/**
 * Created by danfoulkes on 18/06/2017.
 * Project: SampleApp
 * Package: sample.com.foulkes.pojo
 */
public class RoleBuilder {

    Long id;
    String name;

    public RoleBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public RoleBuilder withName(String name){
        this.name = name;
        return this;
    }

    public Role build(){
       return  new Role(id, name);
    }

    public static RoleBuilder getBuilder(){
        return new RoleBuilder();
    }
}
