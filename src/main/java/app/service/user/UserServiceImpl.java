package app.service.user;

import app.controller.user.security.CustomUserDetails;
import app.controller.user.model.UserJSON;
import app.repository.activation.ActivationRepository;
import app.repository.activation.model.ActivationEntity;
import app.repository.user.UserRepository;
import app.repository.user.model.UserEntity;
import app.service.email.EmailService;
import app.service.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActivationRepository activationRepository;
    @Autowired
    private UserUtils userUtils;
    @Autowired
    @Qualifier("randomUUID")
    private UUID randomUUID;
    @Autowired
    private EmailService emailService;
    @Value("${pethome.protocol}")
    private String pethomeProtocol;
    @Value("${pethome.addr}")
    private String pethomeAddr;
    @Value("${pethome.port}")
    private String pethomePort;
    @Value("${pethome.activation.urlpath}")
    private String pethomeUrlPath;

    @Override
    public Integer create(UserJSON json) {
        Integer res = userRepository.save(userUtils.toEntity(json)).getId();
        String token = randomUUID.toString();
        String emailAddr = json.getEmailAddresses().get(0);
        ActivationEntity activation = ActivationEntity.builder()
                        .email(emailAddr)
                        .token(token)
                        .build();
        activationRepository.save(activation);
        String url = pethomeProtocol +
                "://" +
                pethomeAddr +
                ":" +
                pethomePort +
                pethomeUrlPath
                + token;

        String mailText = "Вітаємо! " +
                "Для активації акаунту перейдіть за посиланням: " +
                url;
        emailService.sendSimpleMessage(emailAddr, "Активація PetHome акаунта", mailText);
        return res;
    }

    @Override
    public UserJSON getById() {
        return userUtils.toJSON(userRepository.findById(this.getCurrentUserId()).get());
    }

    @Override
    public Integer updateUser(UserJSON json) {
        UserEntity entity = userRepository.findById(this.getCurrentUserId()).get();
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

    @Override
    public Integer getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails details = (CustomUserDetails) principal;
        return details.getId();
    }

    @Override
    public void activate(String token) {
        ActivationEntity activation = activationRepository.findByToken(token).get();
        activationRepository.delete(activation);
    }

    @Override
    public boolean isActivated(String email) {
        Optional<ActivationEntity> activation = activationRepository.findByEmail(email);
        return activation.isEmpty();
    }
}
