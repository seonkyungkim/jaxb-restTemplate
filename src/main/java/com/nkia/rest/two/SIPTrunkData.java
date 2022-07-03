package com.nkia.rest.two;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@XmlRootElement(name = "sipTrunkData")
public class SIPTrunkData {
/*
    @Getter @Setter
    private int trunkNum;   //sequence data (ex. 1,2,3...)
*/
    @XmlAttribute(name="id")
    private String sipTrunkData_id;

    @XmlElement(name="TRUNK")
    private String trunkName;

    @XmlElement(name="CURRENT_CALLS")
    private String activeCall;

    @XmlElement(name="PEAK_CALLS")
    private String peakCalls;

    @XmlElement(name="CALL_ATTEMPTS")
    private String callAttempts;

    @XmlElement(name="IN_SERVICE")
    private Boolean trunkStatus;

    /*    @Override
    public String toString() {
        return "TrunkDataInfo{" +
//                "trunkNum=" + trunkNum +
                ", trunkName='" + trunkName + '\'' +
                ", trunkStatus='" + trunkStatus + '\'' +
                ", activeCall='" + activeCall + '\'' +
                ", peakCalls='" + peakCalls + '\'' +
                ", callAttempts='" + callAttempts + '\'' +
                '}';
    }*/
}
