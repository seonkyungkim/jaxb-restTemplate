package com.nkia.rest.two;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="sipServer")
@XmlAccessorType(XmlAccessType.FIELD)
public class SIPServer {

    @XmlElement(name="NAME")
    @Getter @Setter
    private String serverName;

    @XmlElement(name="HA_ROLE")
    @Getter @Setter
    private String serverStatus;

    @Override
    public String toString() {
        return "SIPServer{" +
                "serverName='" + serverName + '\'' +
                ", serverStatus='" + serverStatus + '\'' +
                '}';
    }
}
