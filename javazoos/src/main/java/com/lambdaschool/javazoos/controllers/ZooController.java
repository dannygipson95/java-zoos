package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/zoos")
public class ZooController {
    @Autowired
    ZooService zooService;

    // http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> findAllZoos(){
        List<Zoo> list = zooService.findAllZoos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    // http://localhost:2019/zoo/{id}
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> findZooById(@PathVariable long id){
        Zoo newZoo = zooService.findZooById(id);
        return new ResponseEntity<>(newZoo, HttpStatus.OK);
    }
}
