package com.forexservice.client.exchange;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "forexclient")
//@RibbonClient(name = "forex-service") uncomment if you wanna ribbon gets ulrs from eureka
public interface ForexClient extends ForexController {
}
