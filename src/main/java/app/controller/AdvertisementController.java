package app.controller;

import app.controller.model.AdvertisementJSON;
import app.service.advertisement.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping("/advertisements")
    public ResponseEntity createAdvertisement(@RequestBody AdvertisementJSON json) {
        Integer advertisementId = advertisementService.create(json);
        Object obj = new Object(){
            {
                setId(advertisementId);
            }

            private Integer id;

            public void setId(Integer id){
                this.id = id;
            }

            public Integer getId(){
                return this.id;
            }
        };
        return ResponseEntity.ok(obj);
    }

}
