package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
public class Asset implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String name;
    private List<Software> softwareList;
    private List<Hardware> hardwareList;
    private List<Equipment> equipmentList;



    private Asset(){
    }

    public Asset(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
        this.softwareList = builder.softwareList;
        this.hardwareList = builder.hardwareList;
        this.equipmentList = builder.equipmentList;
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

    public List<Software> getSoftwareList(){
        return softwareList;
    }

    public List<Hardware> getHardwareList(){
        return hardwareList;
    }
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }



    public static class Builder{
        private long id;
        private String code;
        private String name;
        private List<Software> softwareList;
        private List<Hardware> hardwareList;
        private List<Equipment> equipmentList;

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


        public Builder softwareList(List<Software> value){
            this.softwareList=value;
            return this;
        }

        public Builder hardwareList(List<Hardware> value){
            this.hardwareList=value;
            return this;
        }
        public Builder equipmentList(List<Equipment> value){
            this.equipmentList=value;
            return this;
        }


        public Builder copy(Asset value){
            this.id=value.id;
            this.code=value.code;
            this.name=value.name;
            this.softwareList=value.softwareList;
            this.hardwareList=value.hardwareList;
            this.equipmentList=value.equipmentList;
            return this;
        }

        public Asset build(){
            return new Asset(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset supplier = (Asset) o;

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
        return "Asset";
    }
}