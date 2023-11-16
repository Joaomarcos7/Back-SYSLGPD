package com.syslgpd.springboot.service.impl;

import com.syslgpd.springboot.model.User;
import com.syslgpd.springboot.repo.UserRepository;
import com.syslgpd.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository repo;


    @Override
    public User adduser(User user){
        repo.save(user);
        return user;
    }
    @Override
    public List<User> getallusers(){
        return repo.findAll();
    }

    @Override
    public User getuserbyid(int id) throws Exception{
       Optional<User> user= repo.findById(id);
       if (user.isPresent()){
           return user.get();
       }
       else{
           throw new Exception("usuário nao encontrado");
       }
    }

    @Override
    public void deleteuserbyid(int id){
        repo.deleteById(id);
    }


    @Override
    public void updateuser(User user){
        repo.save(user);
    }





}
