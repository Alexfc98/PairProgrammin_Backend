package com.AppBackend.Users.Service;

import com.AppBackend.Users.Exceptions.RecordNotFoundException;
import com.AppBackend.Users.Model.User;
import com.AppBackend.Users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers()
    {
        List<User> UserList = repository.findAll();

        if(UserList.size() > 0) {
            return UserList;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserById(String id) throws RecordNotFoundException {
        Optional<User> user = repository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }

    public User createUser(User entity){
        entity = repository.save(entity);
        return entity;
    }


    public void deleteUserById(String id) throws RecordNotFoundException
    {
        Optional<User> item = repository.findById(id);

        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }


    public User UpdateUser(User entity) throws RecordNotFoundException
    {

        Optional<User> item = repository.findById(entity.getId());

        if(item.isPresent())
        {
            User newEntity = item.get();
            //newEntity.setId(entity.getId());
            newEntity.setName(entity.getName());
            newEntity.setSurname(entity.getSurname());
            newEntity.setAge(entity.getAge());
            newEntity.setDNI(entity.getDNI());
            newEntity.setNationality(entity.getNationality());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException("Item not found",entity.getId());
        }
    }
}
