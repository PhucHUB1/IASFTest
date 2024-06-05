package com.example.iasftest.controller;
import com.example.iasftest.entity.Vehicle;
import com.example.iasftest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public String getAllVehicles(Model model) {
        model.addAttribute("vehicle", vehicleService.getAllVehicles());
        return "vehicle";
    }
    @GetMapping("/{id}")
    public String getVehicleDetails(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicle-details";
    }

    @GetMapping("/new-vehicle")
    public String showNewVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "new-vehicle";
    }

    @PostMapping
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicle";
    }

    @GetMapping("/edit/{id}")
    public String showEditVehicleForm(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "edit-vehicle";
    }

    @PostMapping("/{id}")
    public String updateVehicle(@PathVariable Long id, @ModelAttribute Vehicle vehicle) {
        vehicle.setVehicle_id(id);
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicle";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicle";
    }

}