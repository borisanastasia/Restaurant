package com.example.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;
    public void saveOrder(Order order) {
        if (order.getTable() == null) {
            var tables = new ArrayList<Table>();
            tableRepository.findAll().forEach(tables::add);
            var random = new Random();
            var table = tables.get(random.nextInt(tables.size()));

            order.setTable(table);
        }

        orderRepository.save(order);
    }
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order>getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public void deleteOrderById(Long orderId){
        orderRepository.deleteById(orderId);
    }







}
