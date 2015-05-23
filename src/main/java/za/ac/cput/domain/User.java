package za.ac.cput.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.security.acl.Owner;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String name;
    @OneToMany
    private List<Owner> ownerList;

    private User(){
    }

    public User(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
        this.ownerList=builder.ownerList;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public List<Owner> getInventoryItemList() {
        return ownerList;
    }

    public static class Builder{
        private long id;
        private String code;
        private String name;
        private List<Owner> ownerList;

        public Builder(String code){
            this.code=code;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }


        public Builder ownerList(List<Owner> value){
            this.ownerList=value;
            return this;
        }

        public Builder copy(User value){
            this.id=value.id;
            this.code=value.code;
            this.name=value.name;
            this.ownerList=value.ownerList;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User supplier = (User) o;

        if (code != null ? !code.equals(supplier.code) : supplier.code != null) return false;
        if (id != null ? !id.equals(supplier.id) : supplier.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
