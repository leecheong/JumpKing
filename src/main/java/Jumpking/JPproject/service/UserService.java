package Jumpking.JPproject.service;

import Jumpking.JPproject.DTO.UserDTO;
import Jumpking.JPproject.Entity.User;
import Jumpking.JPproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void save(UserDTO userDTO){

        User user = User.user(userDTO);
        userRepository.save(user);
    }

    public UserDTO login(UserDTO userDTO) {
        /*
        1. 회원이 입력한 id로 조회
        2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 확인
         */

        Optional<User> byid = userRepository.findByid(userDTO.getId());
        if(byid.isPresent()){
            //조회 결과가 있다.(해당 이메일을 가진 회원 정보가 있다.)
            User user = byid.get();
            if(user.getPassword().equals(userDTO.getPassword())){
                //비밀번호가 일치한다.
                // entity객체를 dto로 변환 후 리턴해야함
                UserDTO dto = UserDTO.touserDTO(user);
                return dto;

            }else{
                //비밀번호가 일치하지 않는다.
                return null;
            }
        }else{
            //조회 결과가 없다.(해당 이메일을 가진 회원이 없다.)
            return null;
        }
    }
}
