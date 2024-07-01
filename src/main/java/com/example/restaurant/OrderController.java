package com.example.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MealService mealService;

    private final TableService tableService;

    // Spring ищет контроллер с аннотацией Post(отправить) и адресом"/orders"
    //затем идет запрос (обращение) к серверу, в коде в html в методе(post, put, get, delete)
    @PostMapping("/orders")
    public String createOrder(OrderRequest orderRequest) {
        var meals = mealService.findAllByIds(orderRequest.getMealIds());
        var order = new Order();
        order.setMeals(meals);
        orderService.saveOrder(order); // 1 - коричневым, с этими пармаметрами сделает заказ
        return "redirect:order-details?id=" + order.getId();  //"redirect:order-details?id=" возвращает цифровое id
        // сохраняет в базу заказ и делает редирект на страницу
        // (url в браузере изменится,т.е. страница браузера перезагрузится)
    }

    @PostMapping("/order-delete")
    public String deleteOrder(OrderDeleteRequest orderDeleteRequest) {
        orderService.deleteOrderById(orderDeleteRequest.getOrderId());
        return "redirect:order-list";
    }

    @GetMapping("/order-details") //браузер отправляет запрос на сервер и отображает ту страницу кот сервер вернул
    public String showOrderById(@RequestParam("id") Long id, Model model) { //запрос отправляется браузером
        // с параметром id на (веб-приложение запущенное на сервере),@RequestParam(говорим спрингу достань параметр запроса)
        var order = orderService.getOrderById(id).get();
        model.addAttribute("order", order);
        return "order-details"; // детали прописаны в order-details.html(что должно быть на возвращаемой странице)
    }

    @GetMapping("/order-list")
    public String showAllOrders(Model model) {
        var orders = orderService.getAllOrders();
        Collections.sort(orders,new Comparator<Order>(){
            public int compare(Order o1, Order o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        model.addAttribute("orders", orders);
        model.addAttribute("tables", tableService.getAllTables());
        return "order-list";
    }

    @PostMapping("/update-order")
    public String updateOrder(UpdateOrderRequest updateOrderRequest) {

            var order = orderService.getOrderById(updateOrderRequest.getUpdateOrderId()).get();
            var table = tableService.getTableById(updateOrderRequest.getTableId()).get();
            order.setTable(table);

            orderService.saveOrder(order); //
            return "redirect:order-list";  //"redirect:order-details?id=" возвращает цифровое id
            // сохраняет в базу заказ и делает редирект на страницу
            // (url в браузере изменится,т.е. страница браузера перезагрузится)
        }
    }
