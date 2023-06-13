package Jumpking.JPproject.service;

import Jumpking.JPproject.Entity.User;
import Jumpking.JPproject.Entity.post;
import Jumpking.JPproject.repository.JPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JPService {
    @Autowired

    private JPRepository jpRepository;

    public void write(post Spost) {

        jpRepository.save(Spost);


    }
    public List<post> postList() {
        return jpRepository.findAll();
    }

    public post postView(Integer id){

        return jpRepository.findById(id).get();
    }

}

