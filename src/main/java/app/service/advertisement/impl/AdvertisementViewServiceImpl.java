package app.service.advertisement.impl;

import app.controller.advertisement.model.AdvertisementView;
import app.controller.user.model.UserFirstInteraction;
import app.repository.advertisement.AdvertisementRepository;
import app.repository.advertisement.model.AdvertisementEntity;
import app.service.advertisement.AdvertisementViewService;
import app.service.advertisement.utils.AdvertisementUtils;
import app.service.location.utils.LocationUtils;
import app.service.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementViewServiceImpl implements AdvertisementViewService {
    @Autowired
    private AdvertisementRepository repository;
    @Autowired
    private AdvertisementUtils advertisementUtils;
    @Autowired
    private LocationUtils locationUtils;
    @Autowired
    private UserUtils userUtils;

    @Override
    public List<AdvertisementView> getAll() {
        class Utils{
            public AdvertisementView toView(AdvertisementEntity e){
                return AdvertisementView.builder()
                        .petName(e.getPetName())
                        .date(advertisementUtils.toJSON(e.getDate()))
                        .location(locationUtils.toJSON(e.getLocation()))
                        .user(UserFirstInteraction.builder()
                                .firstname(e.getOwner().getPerson().getFirstname())
                                .username(e.getOwner().getUsername())
                                .build())
                        .build();
            }
        }
        return repository.findAll().stream().map(e -> new Utils().toView(e)).collect(Collectors.toList());
    }
}
