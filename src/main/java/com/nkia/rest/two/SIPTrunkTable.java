package com.nkia.rest.two;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter @ToString
@XmlRootElement(name="sipTrunkStatistics")
public class SIPTrunkTable {

    @XmlAttribute(name="id")
    private String sipTrunkTable_id;

    @XmlElement(name="sipTrunkData")
    private List<SIPTrunkData> sipTrunkData;

}
