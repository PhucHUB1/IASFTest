package com.example.iasftest.service;

import com.example.iasftest.entity.Members;
import com.example.iasftest.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersService {

    @Autowired
    private MembersRepository membersRepository;

    public void deleteMembers(long id) {
        membersRepository.deleteById(id);
     }
}