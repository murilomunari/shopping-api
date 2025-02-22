package com.shopping.Service;

import com.shopping.DTO.UserDTO;
import com.shopping.Entity.User;
import com.shopping.Repsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setAddress(userDTO.address());
        user.setEmail(userDTO.email());
        user.setPhone(userDTO.phone());

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new RuntimeException("Usuário com o ID " + id + " não encontrado");
        }
    }

    public Page<User> findAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }
}
