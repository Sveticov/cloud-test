package com.sveticov.cloudtest.service;

import com.sveticov.cloudtest.model.CloudModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CloudService{
    List<CloudModel> models = new ArrayList<>();

    public void saveModel(CloudModel model) {
        models.add(model);
    }

    public List<CloudModel> listModels() {
        return models;
    }

    public CloudModel modelFindByID(int id)  {

        CloudModel cloudModel = models.stream()
                .filter(model -> model.getId_model() == id)
                .findAny()
                .get();


        return cloudModel;
    }
}
