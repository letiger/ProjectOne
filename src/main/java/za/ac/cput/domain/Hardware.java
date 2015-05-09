package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@Entity
public class Hardware implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String name;
    private List<HardwareType> list;



    private Hardware(){
    }

    public Hardware(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
        this.list = builder.list;

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

    public List<HardwareType> getList(){
        return list;
    }

    public static class Builder{
        private long id;
        private String code;
        private String name;
        private List<HardwareType> list;

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

        public Builder hardwareList(List<HardwareType> value){
            this.list=value;
            return this;
        }

        public Builder copy(Hardware value){
            this.id=value.id;
            this.code=value.code;
            this.name=value.name;
            this.list=value.list;
            return this;
        }

        public Hardware build(){
            return new Hardware(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hardware supplier = (Hardware) o;

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
        return "Hardware";
    }
}