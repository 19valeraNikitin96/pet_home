import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.DateJSON;
import app.controller.advertisement.model.LocationJSON;
import app.repository.advertisement.model.AdvertisementEntity;
import app.repository.location.model.LocationEntity;
import app.service.advertisement.utils.impl.AdvertisementUtilsImpl;
import app.service.location.utils.LocationUtils;
import app.service.location.utils.LocationUtilsImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class LocationUtilsTest {

//    @Autowired
    private LocationUtils locationUtils;

    @Before
    public void setUp(){
        locationUtils = new LocationUtilsImpl();
    }

    @Test
    public void JSONObjectMappedToEntity(){
        LocationJSON json = new LocationJSON();
        json.setId(1);
        json.setCity("Kyiv");
        json.setDistrict("Shevchenkovskiy");
        json.setStreet("Shevchenko");

        LocationEntity entity = locationUtils.toEntity(json);
        assertThat(entity.getId())
                .isEqualTo(json.getId());
        assertThat(entity.getCity())
                .isEqualTo(json.getCity());
        assertThat(entity.getStreet())
                .isEqualTo(json.getStreet());
        assertThat(entity.getDistrict())
                .isEqualTo(json.getDistrict());
    }
}
