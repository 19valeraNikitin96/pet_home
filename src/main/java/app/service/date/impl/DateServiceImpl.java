package app.service.date.impl;

import app.repository.date.DateRepository;
import app.repository.date.model.DateEntity;
import app.service.date.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DateServiceImpl implements DateService {
    @Autowired
    private DateRepository dateRepository;

    @Override
    public DateEntity find(DateEntity entity) {
        List<DateEntity> locations = dateRepository.findAll().stream()
                .filter(e -> {
                    if (entity.getDay() == null) {
                        return true;
                    }
                    return entity.getDay().equals(e.getDay());
                })
                .filter(e -> {
                    if (entity.getMonth() == null) {
                        return true;
                    }
                    return entity.getMonth().equals(e.getMonth());
                })
                .filter(e -> {
                    if (entity.getYear() == null) {
                        return true;
                    }
                    return entity.getYear().equals(e.getYear());
                })
                .collect(Collectors.toList());

        return locations.size() == 0 ? null : locations.get(0);
    }
}
