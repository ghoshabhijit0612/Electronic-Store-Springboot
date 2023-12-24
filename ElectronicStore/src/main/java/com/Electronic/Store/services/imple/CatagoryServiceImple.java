package com.Electronic.Store.services.imple;

import com.Electronic.Store.dtos.Catagorydtos;
import com.Electronic.Store.entities.Catagory;
import com.Electronic.Store.exceptions.ResourceNotFoundException;
import com.Electronic.Store.repositories.CatagoryRepository;
import com.Electronic.Store.services.CatagoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatagoryServiceImple implements CatagoryService {


    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CatagoryRepository catagoryRepository;
    @Override
    public Catagorydtos createCatagory(Catagorydtos catagorydtos) {
        Catagory catagory= CatagorydtosToCatagory(catagorydtos);
        catagoryRepository.save(catagory);
        return CatagoryToCatagorydto(catagory);
    }

    @Override
    public Catagorydtos updateCatagory(Catagorydtos catagorydtos, String id) {
        Catagory catagory1 =(catagoryRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
        catagory1.setCatagoryId(id);
        catagory1.setTitle(catagorydtos.getTitle());
        catagory1.setDescription(catagorydtos.getDescription());
        catagoryRepository.save(catagory1);
        Catagorydtos catagorydtos1= CatagoryToCatagorydto(catagory1);
        return catagorydtos1;
    }

    @Override
    public void deletecatagory(String id) {
        Catagory catagory1 =(catagoryRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
        catagoryRepository.delete(catagory1);
        return;
    }

    @Override
    public List<Catagorydtos> getAllCatagory() {
        List<Catagorydtos>list = new ArrayList<>();
        for (Catagory catagory : catagoryRepository.findAll()) {
            list.add(CatagoryToCatagorydto(catagory));
        }
        return list;

    }

    @Override
    public Catagory getCatagory(String id) {
        Catagory catagory1 =(catagoryRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
        return catagory1;
    }


    public Catagorydtos CatagoryToCatagorydto(Catagory catagory){
        return modelMapper.map(catagory,Catagorydtos.class);
    }
    public Catagory CatagorydtosToCatagory(Catagorydtos catagorydtos){
        return modelMapper.map(catagorydtos,Catagory.class);
    }
}
