package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@Entity
public class Software implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="software_id")
    private List<SoftwareType> softwareList;



    private Software(){
    }

    public Software(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
        this.softwareList = builder.softwareList;

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

    public List<SoftwareType> getSoftwareList(){
        return softwareList;
    }

    public static class Builder{
        private long id;
        private String code;
        private String name;
        private List<SoftwareType> softwareList;

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

        public Builder softwareList(List<SoftwareType> value){
            this.softwareList=value;
            return this;
        }

        public Builder copy(Software value){
            this.id=value.id;
            this.code=value.code;
            this.name=value.name;
            this.softwareList=value.softwareList;
            return this;
        }

        public Software build(){
            return new Software(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Software supplier = (Software) o;

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
        return "Software";
    }
}
