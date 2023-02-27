package com.co.blankfactor.rest.utils.dataProviders;

import com.co.blankfactor.rest.models.User;
import com.co.blankfactor.rest.utils.manager.FileReaderManager;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class JsonDataReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "user.json";
    private List<User> customerList;

    public JsonDataReader(){
        customerList = getCustomerData();
    }

    public List<User> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(customerFilePath));
            User[] customers = gson.fromJson(bufferReader, User[].class);
            return Arrays.asList(customers);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + customerFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final User getCustomerByName(String name){
        return customerList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findAny().get();
    }

    public final User getUserJob(String job){
        return customerList.stream().filter(x -> x.getJobTitle().equalsIgnoreCase(job)).findAny().get();
    }

}
