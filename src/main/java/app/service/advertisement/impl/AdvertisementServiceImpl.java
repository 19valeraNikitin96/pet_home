package app.service.advertisement.impl;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.AdvertisementRequestJSON;
import app.repository.advertisement.AdvertisementRepository;
import app.repository.advertisement.model.AdvertisementEntity;
import app.repository.date.model.DateEntity;
import app.repository.location.model.LocationEntity;
import app.repository.user.UserRepository;
import app.service.UserPOVType;
import app.service.advertisement.AdvertisementService;
import app.service.advertisement.utils.AdvertisementUtils;
import app.service.date.DateService;
import app.service.location.LocationService;
import app.service.location.utils.LocationUtils;
import app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private AdvertisementUtils advertisementUtils;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationUtils locationUtils;
    @Autowired
    private DateService dateService;

    @Override
    public Integer create(AdvertisementJSON json) {
        return advertisementRepository.save(advertisementUtils.toEntity(json)).getId();
    }

    @Override
    public List<Integer> getAdvertisementIds(AdvertisementRequestJSON json) {
        UserPOVType type = UserPOVType.getBy(json.getPov());
        List<AdvertisementEntity> entities = advertisementRepository.findAll();

        Predicate<AdvertisementEntity> predicate;
        switch (type) {
            case OWNER:
                predicate = (entity) -> Objects.equals(entity.getOwner().getId(), userService.getCurrentUserId());
                break;
            case VIEWER:
                predicate = (entity) -> !Objects.equals(entity.getOwner().getId(), userService.getCurrentUserId());
                break;
            default:
                throw new RuntimeException("Unexpected user POV");
        }

        int skip = (json.getPaged().getCurrent() - 1) * json.getPaged().getSize();
        return entities.stream().
                filter(predicate).
                skip(skip).
                limit(json.getPaged().getSize()).
                map(AdvertisementEntity::getId).
                collect(Collectors.toList());
    }

    @Override
    public AdvertisementJSON getBy(Integer advertisementId) {
        AdvertisementEntity entity = advertisementRepository.getOne(advertisementId);
        return advertisementUtils.toJSON(entity);
    }

    @Override
    public void deleteBy(Integer advertisementId) {
        AdvertisementEntity entity;
        try {
            entity = advertisementRepository.getOne(advertisementId);
        } catch (EntityNotFoundException e) {
            return;
        }
        advertisementRepository.delete(entity);
    }

    @Override
    public List<AdvertisementJSON> getAll() {
        return advertisementRepository.findAll().stream().map(e -> advertisementUtils.toJSON(e)).collect(Collectors.toList());
    }

    @Override
    public Integer updateBy(Integer advertisementId, AdvertisementJSON json) {
        AdvertisementEntity entity = advertisementRepository.getOne(advertisementId);
        if (json.getAge() != null) {
            entity.setAge(json.getAge());
        }
        if (json.getPetName() != null) {
            entity.setPetName(json.getPetName());
        }
        if (json.getOwnerId() != null) {
            entity.setOwner(userRepository.getOne(json.getOwnerId()));
        }
        if (json.getLocation() != null) {
            LocationEntity newLocation = locationUtils.toEntity(json.getLocation());
            LocationEntity existing = locationService.find(newLocation);
            if (existing != null) {
                entity.setLocation(existing);
            } else {
                entity.setLocation(newLocation);
            }
        }
        if(json.getDate() != null){
            DateEntity newDate = advertisementUtils.toEntity(json.getDate());
            DateEntity existing = dateService.find(newDate);
            if (existing != null){
                entity.setDate(existing);
            }else{
                entity.setDate(newDate);
            }
        }
        if(json.getSigns() != null){
            entity.setSigns(json.getSigns());
        }
        if(json.getType() != null){
            entity.setType(json.getType());
        }
        return advertisementRepository.save(entity).getId();
    }
}
