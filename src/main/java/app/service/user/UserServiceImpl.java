package app.service.user;

import app.controller.user.model.UserJSON;
import app.repository.user.UserRepository;
import app.service.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
}
