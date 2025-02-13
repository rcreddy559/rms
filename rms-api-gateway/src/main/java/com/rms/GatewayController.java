package com.rms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api-gateway")
public class GatewayController {

    @GetMapping
    public String getMethodName() {
        return "welcome to api gateway";
    }

}
