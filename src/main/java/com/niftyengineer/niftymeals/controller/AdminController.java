package com.niftyengineer.niftymeals.controller;

import com.niftyengineer.niftymeals.dto.requestmodels.AddMealRequest;
import com.niftyengineer.niftymeals.service.AdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/secure/increase/meal/quantity")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void increaseMealQuantity(@RequestParam Long mealId) throws Exception {
        adminService.increaseMealQuantity(mealId);
    }

    @PutMapping("/secure/decrease/meal/quantity")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void decreaseMealQuantity(@RequestParam Long mealId) throws Exception {
        adminService.decreaseMealQuantity(mealId);
    }

    @PostMapping("/secure/add/meal")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void postMeal(@RequestBody AddMealRequest addMealRequest) throws Exception {
        adminService.postMeal(addMealRequest);
    }

    @DeleteMapping("/secure/delete/meal")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteMeal(@RequestParam Long mealId) throws Exception {
        adminService.deleteMeal(mealId);
    }

}
