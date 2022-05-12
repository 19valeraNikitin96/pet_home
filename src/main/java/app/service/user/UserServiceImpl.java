package app.service.user;

import app.controller.user.security.CustomUserDetails;
import app.controller.user.model.UserJSON;
import app.repository.user.UserRepository;
import app.repository.user.model.UserEntity;
import app.service.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserUtils userUtils;

    @Override
    public Integer create(UserJSON json) {
        return userRepository.save(userUtils.toEntity(json)).getId();
    }

    @Override
    public UserJSON getById(Integer id) {
        return userUtils.toJSON(userRepository.findById(id).get());
    }

    @Override
    public Integer updateUser(Integer id, UserJSON json) {
        UserEntity entity = userRepository.findById(id).get();
        if (json.getFirstname() != null) {
            entity.getPerson().setFirstname(json.getFirstname());
        }
        if (json.getLastname() != null) {
            entity.getPerson().setLastname(json.getLastname());
        }
        if (json.getUsername() != null) {
            entity.setUsername(json.getUsername());
        }
        userRepository.save(entity);
        return entity.getId();
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        UserEntity entity = this.findByUsername(username);
        if (entity.getPassword().equals(password)) {
            return entity;
        }
        return null;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = this.findByUsername(username);
        return new CustomUserDetails(entity);
    }
}
