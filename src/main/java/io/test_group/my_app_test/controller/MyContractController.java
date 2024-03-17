package io.test_group.my_app_test.controller;

//import nova.stringstore.service.MyContractService;
import io.test_group.my_app_test.service.MyContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
public class MyContractController {

    @Autowired
    private MyContractService myContractService;

    @PostMapping("/store")
    public void storeString(@RequestBody String value) throws Exception {
        String privateKey = "d736cd72f5eb0a75224c9742a04aee46ce7148d2480275768b4bdbe4a57074fd";
        myContractService.storeString(value, privateKey);
    }

    @GetMapping("/get")
    public String getString() throws Exception {
        String privateKey = "b736cd72f5eb0a75224c9742a04aee46ce7148d2480275768b4bdbe4a57074dd";
        return myContractService.getString(privateKey);
    }
}