package com.cavalieri.BanckDemo.controllers;

import com.cavalieri.BanckDemo.dtos.ClientDTO;
import com.cavalieri.BanckDemo.dtos.ClientSaveDTO;
import com.cavalieri.BanckDemo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")

public class ClientControllers {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO> dto = clientService.findAllService();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findByID(@PathVariable("id") Long id){
        ClientDTO dto = clientService.findByIdService(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ClientDTO> save(@RequestBody ClientSaveDTO dto){
        ClientDTO saveDto = clientService.saveService(dto);
        return ResponseEntity.ok().body(saveDto);
    }

    @PostMapping(value = "/update{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable("id") Long id,
                                            @RequestBody ClientSaveDTO dto){
        ClientDTO saveDTO = clientService.updateService(id, dto);
        return ResponseEntity.ok().body(saveDTO);
    }



}
