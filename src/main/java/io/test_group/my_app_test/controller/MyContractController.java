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
        String privateKey = "0x0dbbe8e4ae425a6d2687f1a7e3ba17bc98c673636790f1b8ad91193c05875ef1";
        myContractService.storeString(value, privateKey);
    }

    @GetMapping("/get")
    public String getString() throws Exception {
        String privateKey = "0x0dbbe8e4ae425a6d2687f1a7e3ba17bc98c673636790f1b8ad91193c05875ef1";
        return myContractService.getString(privateKey);
    }
}