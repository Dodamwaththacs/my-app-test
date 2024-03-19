package io.test_group.my_app_test.service;

//import nova.stringstore.contract.MyContract;
import io.test_group.my_app_test.contract.MyContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import java.math.BigInteger;

@Service
public class MyContractService {

    @Autowired
    private Web3j web3j;

    @Value("${contract.address}")
    private String contractAddress;

    private MyContract loadContract(String privateKey) {
        BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L);
        BigInteger gasLimit = BigInteger.valueOf(4_300_000);
        Credentials credentials = Credentials.create(privateKey);
        ContractGasProvider gasProvider = new StaticGasProvider(gasPrice, gasLimit);
        return MyContract.load(contractAddress, web3j, credentials, gasProvider);
    }

    public String getString(String privateKey) throws Exception {
        MyContract contract = loadContract(privateKey);
        return contract.getString().send();
    }

    public void storeString(String newValue, String privateKey) throws Exception {
        MyContract contract = loadContract(privateKey);
        contract.storeString(newValue).send();
    }
}