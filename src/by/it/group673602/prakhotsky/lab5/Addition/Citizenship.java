package by.it.group673602.prahotsky.lab5.Addition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum Citizenship {

    @XmlEnumValue("Беларусь") BELARUS("Беларусь"),
    @XmlEnumValue("Россися") RUSSIAN("Россися"),
    @XmlEnumValue("Украина") UKRAIN("Украина"),
    @XmlEnumValue("Польша") POLAND("Польша"),
    @XmlEnumValue("Латвия") LATVIAN("Латвия"),
    @XmlEnumValue("Литва") LITHUANIA("Литва");

    private String value;

    Citizenship(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

