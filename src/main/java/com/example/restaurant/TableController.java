package com.example.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TableController {
    private final TableService tableService;

    @GetMapping("/table-list")
    public String showAllTables(Model model) {
        var tables = tableService.getAllTables();
        model.addAttribute("tables", tables);
        return "table-list";
    }

}
