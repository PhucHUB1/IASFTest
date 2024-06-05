package com.example.iasftest.service;
import com.example.iasftest.entity.Roles;
import com.example.iasftest.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyNameException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Optional<Roles> getRoleById(Long id) {
        return rolesRepository.findById(id);
    }

    public Roles saveRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    public void deleteRoles(Long id) {
        Roles roles = rolesRepository.findById(id).orElseThrow(null);
        rolesRepository.delete(roles);
    }

}