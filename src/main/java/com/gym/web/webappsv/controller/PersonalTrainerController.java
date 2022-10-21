package com.gym.web.webappsv.controller;

import com.gym.web.webappsv.DTO.PersonalTrainerDTO;
import com.gym.web.webappsv.Response.PersonalTrainerResponse;
import com.gym.web.webappsv.service.IPersonalTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/PT")
public class PersonalTrainerController {
    @Autowired
    IPersonalTrainerService personalTrainerService;
    @GetMapping
    public List<PersonalTrainerDTO> getPersonalTrainer(){
        return personalTrainerService.findAll();
    }

    @GetMapping
            ("/{pageSize}/{pageNo}")
    public PersonalTrainerResponse getAllPersonalTrainer(
//            Case1: Using @RequestParam
//            http://localhost:8081/PT?pageSize= ... ?pageNo= ...
//            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
//            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
//            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
//            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
//          Case2:Using @PathVariable
//            http://localhost:8081/PT/{pageNo}/{pageSize}
            @PathVariable(value = "pageNo",required = false) int pageNo,
            @PathVariable(value = "pageSize") int pageSize,
            @PathVariable(value = "sortBy", required = false) String sortBy,
            @PathVariable(value = "sortDir", required = false) String sortDir
    ){
//        case2
        sortBy = "id";
        sortDir = "asc";
        return personalTrainerService.getAllPT(pageNo, pageSize, sortBy, sortDir);
    }

    @PostMapping
    public PersonalTrainerDTO createPersonalTrainer(PersonalTrainerDTO personalTrainerDTO){
        return personalTrainerService.save(personalTrainerDTO);
    }
    @PutMapping(value = "/{id}")
    public PersonalTrainerDTO updatePersonalTrainerDTO(@RequestBody PersonalTrainerDTO dto, @PathVariable("id") long id){
        dto.setId(id);
        return personalTrainerService.save(dto);
    }
    @DeleteMapping
    public void deletePersonalTrainer(@RequestBody long [] ids){
        personalTrainerService.delete(ids);
    }
}
