package za.ac.cput.domain;

/**
 * Created by student on 2015/05/03.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class OwnerType implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(unique = true)//makes the code unique
private String code;
private String name;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="owner_id")
private List<Asset> assetList;


private OwnerType(){
        }

public OwnerType(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
        this.assetList=builder.assetList;
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


public List<Asset> getList() {
        return assetList;
        }

public static class Builder{
    private long id;
    private String code;
    private String name;
    private List<Asset> assetList;

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


    public Builder assetList(List<Asset> value){
        this.assetList=value;
        return this;
    }

    public Builder copy(OwnerType value){
        this.id=value.id;
        this.code=value.code;
        this.name=value.name;
        this.assetList=value.assetList;
        return this;
    }

    public OwnerType build(){
        return new OwnerType(this);
    }
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerType supplier = (OwnerType) o;

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
        return "OwnerType";
    }
}