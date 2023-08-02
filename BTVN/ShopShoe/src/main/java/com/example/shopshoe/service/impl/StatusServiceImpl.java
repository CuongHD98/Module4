package com.example.shopshoe.service.impl;

import com.example.shopshoe.model.Status;
import com.example.shopshoe.repository.StatusRepository;
import com.example.shopshoe.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void edit(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void delete(Status status) {
        statusRepository.delete(status);
    }

    @Override
    public Status findById(int id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.orElse(null);
    }
}
