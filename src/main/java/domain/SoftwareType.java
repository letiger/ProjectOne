package domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by student on 2015/05/03.
 */
public class SoftwareType implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String name;


    private SoftwareType(){
    }

    public SoftwareType(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
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

    public static class Builder{
        private long id;
        private String code;
        private String name;

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

        public Builder copy(SoftwareType value){
            this.id=value.id;
            this.code=value.code;
            this.name=value.name;
            return this;
        }

        public SoftwareType build(){
            return new SoftwareType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareType supplier = (SoftwareType) o;

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
        return "SoftwareType";
    }
}
