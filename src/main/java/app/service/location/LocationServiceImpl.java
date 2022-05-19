package app.service.location;

import app.repository.location.LocationRepository;
import app.repository.location.model.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Integer create(LocationEntity entity) {
        return locationRepository.save(entity).getId();
    }

    @Override
    public LocationEntity find(LocationEntity entity) {
        List<LocationEntity> locations = locationRepository.findAll().stream()
                .filter(e -> {
                    if (entity.getCity() == null) {
                        return true;
                    }
                    return entity.getCity().equals(e.getCity());
                })
                .filter(e -> {
                    if (entity.getDistrict() == null) {
                        return true;
                    }
                    return entity.getDistrict().equals(e.getDistrict());
                })
                .filter(e -> {
                    if (entity.getStreet() == null) {
                        return true;
                    }
                    return entity.getStreet().equals(e.getStreet());
                })
                .collect(Collectors.toList());

        return locations.size() == 0 ? null : locations.get(0);
    }
}
