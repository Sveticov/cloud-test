package com.sveticov.cloudtest.controller;

import com.sveticov.cloudtest.model.CloudModel;
import com.sveticov.cloudtest.service.CloudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class CloudController {
//C:\Users\Svetikov\IdeaProjects\cloud-test\target\cloud-test-0.0.1-SNAPSHOT.jar

    @Autowired
    CloudService cloudService;


    @GetMapping("/")
    public String welcomePage(Model model){
        model.addAttribute("welcome","Hello this test project Spring Boot and Cloud");
        return "welcome";
    }


    @ResponseBody
    @GetMapping("cloud/find/{id_model}")
    public CloudModel findByID(@PathVariable(value = "id_model") int id_model) {
        log.info(String.valueOf(id_model));
        CloudModel cloudModel = cloudService.modelFindByID(id_model);
        log.info("find by id model: " + cloudModel.toString());
        return cloudModel;
    }

    @GetMapping("/cloud/save/model")
    public String saveModel(Model model) {
        model.addAttribute("model_post", new CloudModel());

        return "save_model";
    }

    @PostMapping("/cloud/save/model")
    public String saveModel(@ModelAttribute("model_post") CloudModel cloudModel, Model model) {

        log.info(cloudModel.toString());
        cloudService.saveModel(cloudModel);

        model.addAttribute("name_model", cloudModel.getName_model());
        model.addAttribute("description_model", cloudModel.getDescription_model());

        return "new_model";
    }
    @ResponseBody
    @GetMapping("/cloud/all")
    public List<CloudModel> cloudModels()
    {
        return cloudService.listModels();
    }
}
