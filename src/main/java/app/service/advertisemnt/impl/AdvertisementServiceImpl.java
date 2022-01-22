package app.service.advertisemnt.impl;

import app.controller.model.AdvertisementJSON;
import app.repository.advertisement.AdvertisementRepository;
import app.service.advertisemnt.AdvertisementService;
import app.service.advertisemnt.utils.AdvertisementUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private AdvertisementUtils advertisementUtils;

    @Override
    public Integer create(AdvertisementJSON json) {
        return advertisementRepository.create(advertisementUtils.toEntity(json));
    }
}
