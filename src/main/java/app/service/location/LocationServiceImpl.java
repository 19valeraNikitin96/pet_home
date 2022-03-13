package app.service.location;

import app.repository.location.LocationRepository;
import app.repository.location.model.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Integer create(LocationEntity entity) {
        return locationRepository.save(entity).getId();
    }
}
