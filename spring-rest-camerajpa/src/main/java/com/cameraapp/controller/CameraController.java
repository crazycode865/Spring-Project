package com.cameraapp.controller;

import com.cameraapp.exception.CameraNotFoundException;
import com.cameraapp.model.Camera;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera-api")
public class CameraController {
    @Autowired
    ICameraService iCameraService;
    //http://localhost:8080/camera-api/cameras/
   @PostMapping("/cameras")
   public void addCamera(@RequestBody Camera camera){
        iCameraService.addCamera(camera);
   }
   @PutMapping("/cameras")
   public void updateCamera(@RequestBody Camera camera){
        iCameraService.updateCamera(camera);
   }
   @DeleteMapping("/cameras/cameraId/{cameraId}")
   public void deleteCamera(@PathVariable("cameraId") int cameraId){
        iCameraService.deleteCamera(cameraId);
   }

    @GetMapping("/cameras")
    public List<Camera> showAllCamera()  {
        return iCameraService.getAll();
    }

    @GetMapping("/cameras/cameraType/{cameraType}")
    public List<Camera> showByCameraType(@PathVariable("cameraType") String cameraType) {
        return iCameraService.getByCameraType(cameraType);
    }

    @GetMapping("/cameras/lensType/{lensType}")
    public  List<Camera> showByLensType(@PathVariable("lensType")String lensType){
        return iCameraService.getByLensType(lensType);
    }
    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public List<Camera> showByBrandAndPrice(@PathVariable("brand")String brand,@PathVariable("price") double price){
        return iCameraService.getByBrandAndPrice(brand,price);
    }
    @GetMapping("/cameras/price/{price}")
    public  List<Camera> showByPrice(@PathVariable("price") double price){
        return iCameraService.getByPrice(price);
    }
}
