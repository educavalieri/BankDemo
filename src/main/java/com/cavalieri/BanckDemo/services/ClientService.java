package com.cavalieri.BanckDemo.services;

import com.cavalieri.BanckDemo.dtos.ClientDTO;
import com.cavalieri.BanckDemo.dtos.ClientSaveDTO;
import com.cavalieri.BanckDemo.entities.Client;
import com.cavalieri.BanckDemo.exceptions.ResourceNotFondException;
import com.cavalieri.BanckDemo.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public List<ClientDTO> findAllService(){
        try {
            List<Client> entity = clientRepository.findAll();
            List<ClientDTO> dto = entity.stream().map(this::entityToDto).collect(Collectors.toList());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

    @Transactional
    public ClientDTO findByIdService(Long id){
        Client entity = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFondException("entitiy not found"));
        return this.entityToDto(entity);
    }

    @Transactional
    public ClientDTO saveService(ClientSaveDTO dto){
        try {
            Client entity = modelMapper.map(dto, Client.class);
            entity = clientRepository.save(entity);
            return entityToDto(entity);
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

    @Transactional
    public ClientDTO updateService(Long id , ClientSaveDTO dto){
        try {
            Client entity = clientRepository.findById(id).get();
            entity.setName(dto.getName());
            entity.setLastName(dto.getLastName());
            entity.setDocument(dto.getDocument());
            entity.setTitular(dto.getTitular());
            entity = clientRepository.save(entity);
            return modelMapper.map(entity, ClientDTO.class);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFondException("entity not found");
        }
    }

    public ClientDTO entityToDto(Client entity){
        return modelMapper.map(entity, ClientDTO.class);
    }

    public Client dtoToEntity(ClientDTO dto){
        return modelMapper.map(dto, Client.class);
    }

}
