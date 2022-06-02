package app.service.user.utils;

import app.controller.user.model.NotificationJSON;
import app.controller.user.model.UserJSON;
import app.repository.location.LocationRepository;
import app.repository.user.model.NotificationEntity;
import app.repository.user.model.PersonEntity;
import app.repository.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserUtilsImpl implements UserUtils{
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public UserEntity toEntity(UserJSON json) {
        UserEntity res = UserEntity.builder()
                .username(json.getUsername())
                .password(json.getPassword())
                .person(PersonEntity.builder()
                        .firstname(json.getFirstname())
                        .lastname(json.getLastname())
                        .emailAddresses(json.getEmailAddresses())
                        .phoneNumbers(json.getPhoneNumbers())
//                        TODO fix warning
                        .location(locationRepository.findById(json.getLocationId()).get())
                        .build())
//                .notifications(json.getNotifications().stream().map(this::toEntity).collect(Collectors.toList()))
                .build();
//        res.getNotifications().forEach(n->n.setUserEntity(res));
        return res;
    }

    @Override
    public NotificationEntity toEntity(NotificationJSON json) {
        return NotificationEntity.builder()
                .appName(json.getAppName())
                .frequency(json.getFrequency())
                .build();
    }

    @Override
    public UserJSON toJSON(UserEntity e) {
        return UserJSON.builder()
                .firstname(e.getPerson().getFirstname())
                .lastname(e.getPerson().getLastname())
                .username(e.getUsername())
                .password(e.getPassword())
                .emailAddresses(e.getPerson().getEmailAddresses())
                .phoneNumbers(e.getPerson().getPhoneNumbers())
                .locationId(e.getPerson().getLocation().getId())
                .build();
    }
}
