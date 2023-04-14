//package web.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import web.service.CarService;
//
//
//@Controller
//public class CarController {
//
//    private final CarService carService;
//
//    public CarController(CarService carService) {
//        this.carService = carService;
//    }
//
//
//    @GetMapping("/cars")
//    public String carsList(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap modelMap) {
//        if (count < 5 && count > -1) {
//            modelMap.addAttribute("cars", carService.carsList().subList(0, count));
//        } else {
//            modelMap.addAttribute("cars", carService.carsList());
//        }
//        return "cars";
//    }
//
//}