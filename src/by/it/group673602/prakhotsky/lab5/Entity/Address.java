package by.it.group673602.prahotsky.lab5.Entity;

import Addition.City;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Address", propOrder = {
        "actualCity",
        "actualAddress",
})
@Embeddable
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {
    @Enumerated(EnumType.STRING)
    private City actualCity;
    private String actualAddress;

    public City getActualCity() {
        return actualCity;
    }

    public void setActualCity(City actualCity) {
        this.actualCity = actualCity;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        System.out.println(actualAddress);
        this.actualAddress = actualAddress;
    }
}

