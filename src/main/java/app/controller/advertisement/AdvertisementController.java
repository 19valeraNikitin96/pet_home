package app.controller.advertisement;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.AdvertisementRequestJSON;
import app.service.advertisement.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/advertisements")
    public ResponseEntity getAdvertisements(@RequestBody AdvertisementRequestJSON json) {
        List<Integer> advertisementIds = advertisementService.getAdvertisementIds(json);
        Object obj = new Object(){
            {
                setAdvertisementIds(advertisementIds);
            }

            private List<Integer> ids;

            public void setAdvertisementIds(List<Integer> ids){
                this.ids = ids;
            }

            public List<Integer> getIds(){
                return this.ids;
            }
        };
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/advertisements/{advertisementId}")
    public ResponseEntity getAdvertisementBy(@PathVariable Integer advertisementId){
        AdvertisementJSON res = advertisementService.getBy(advertisementId);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/advertisements/{advertisementId}")
    public ResponseEntity deleteAdvertisement(@PathVariable Integer advertisementId){
        advertisementService.deleteBy(advertisementId);
        Object obj = new Object(){
            {
                setMsg("Ok");
            }

            private String msg;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }
        };
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/advertisements/{advertisementId}")
    public ResponseEntity updateById(@PathVariable Integer advertisementId, @RequestBody AdvertisementJSON json){
        Integer res = advertisementService.updateBy(advertisementId, json);

        Object obj = new Object(){
            {
                setId(res);
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
