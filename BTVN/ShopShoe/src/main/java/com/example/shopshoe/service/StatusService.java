package com.example.shopshoe.service;

import com.example.shopshoe.model.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAll();
    void save(Status status);
    void edit(Status status);
    void delete(Status status);
    Status findById(int id);
}
