package com.example.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TableService {
    private final TableRepository tableRepository;
    public List<Table>  getAllTables() {
        return (List<Table>)tableRepository.findAll();
    }
    public List<Table> findAllByIds(List<Long> ids) {
        return (List<Table>) tableRepository.findAllById(ids);
    }
    public Optional<Table> getTableById(Long id) {
        return tableRepository.findById(id);
    }
    public void save(Table table) {
        tableRepository.save(table);
    }
}
