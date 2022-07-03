package com.nkia.rest;

import com.nkia.rest.two.SIPServer;
import com.nkia.rest.two.SIPTrunkData;
import com.nkia.rest.two.SIPTrunkStatistics;
import com.nkia.rest.two.SIPTrunkTable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootApplication
public class RestApplication {

    //XML 데이터를 response 받을 API 주소
    static private String URL = "http://";
    static private String SIP_SERVER_URL = "/serverx?sipServer";
    static private String SIP_TRUNK_URL = "/serverx?sipTrunkStatistics";

    public static void main(String[] args) {
//        SpringApplication.run(RestApplication.class, args);

        //RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request, body);
            response.getHeaders().setContentType(MediaType.APPLICATION_XML);
            return response;
        });

        //두 곳에서 나눠서 받아오는 경우
        try {
            /*
            * SIP SERVER INFO
            * */
            URI serverURI = new URI(URL + SIP_SERVER_URL);
            SIPServer sipServer = restTemplate.getForObject(serverURI, SIPServer.class);
            System.out.println(sipServer.toString());

            String serverName = sipServer.getServerName();
            String serverStatus = sipServer.getServerStatus();
            System.out.println("SIP Server Name = " + serverName);
            System.out.println("SIP Server Status = " + serverStatus);

            /*
            * SIP TRUNK INFO
            * */
            URI trunkURI = new URI(URL + SIP_TRUNK_URL);
            SIPTrunkStatistics sipTrunkStatistics = restTemplate.getForObject(trunkURI, SIPTrunkStatistics.class);
//            SIPTrunkTable sipTrunkTable = restTemplate.getForObject(trunkURI, SIPTrunkTable.class);
            List<SIPTrunkTable> sipTrunkTable = sipTrunkStatistics.getSipTrunkTable();
            System.out.println(sipTrunkTable.toString());
            System.out.println(sipTrunkStatistics.toString());

            System.out.println(sipTrunkStatistics.toString());


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
