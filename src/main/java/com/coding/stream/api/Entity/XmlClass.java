package com.coding.stream.api.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlClass {
    @XmlAttribute
    private Integer id;
    @XmlElement
    private String name;
    @XmlElement
    private String description;
}
