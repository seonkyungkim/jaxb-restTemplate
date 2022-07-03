package com.nkia.rest.two;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter @ToString
@XmlRootElement(name="sipTrunkStatistics")
public class SIPTrunkStatistics {

    @XmlAttribute(name="id")
    private String sipTrunkStatistics_id;

    private List<SIPTrunkTable> sipTrunkTable;

    @XmlElement(name="sipTrunkStatistics")
    public List<SIPTrunkTable> getSipTrunkTable() {
        return sipTrunkTable;
    }

    public void setSipTrunkTable(List<SIPTrunkTable> sipTrunkTable) {
        this.sipTrunkTable = sipTrunkTable;
    }
}
