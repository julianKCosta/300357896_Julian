package org.example.savings.controller;

import org.example.savings.model.Saving;
import org.example.savings.dao.SavingDAO;
import org.example.savings.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SavingController {

    @Autowired
    private SavingRepository savingRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        List<Saving> savings = savingRepository.findAll();
        model.addAttribute("savings", savings);
        return "index";
    }

    @PostMapping("/save")
    public String saveSales(
            @RequestParam("salesmanName") String salesmanName,
            @RequestParam("itemType") String itemType,
            @RequestParam("salesAmount") double salesAmount,
            @RequestParam("transactionDate") String transactionDate,
            Model model) {

        Saving saving = new Saving();
        saving.setSalesmanName(salesmanName);
        saving.setItemType(itemType);
        saving.setSalesAmount(salesAmount);
        saving.setTransactionDate(transactionDate);

        savingRepository.save(saving);

        // Fetch updated list of savings and pass to the view
        List<Saving> savings = savingRepository.findAll();
        model.addAttribute("savings", savings);

        return "index"; // Redirect back to the form
    }
}