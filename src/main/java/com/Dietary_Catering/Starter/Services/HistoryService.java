package com.Dietary_Catering.Starter.Services;

import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public void saveOrderHistory(OrderHistory orderHistory) {
        historyRepository.saveOrderHistory(orderHistory);
    }

    public OrderHistory getHistoryByID(int id){
        return historyRepository.getOrderHistoryById(id);
    }

    public void deleteHistory(OrderHistory orderHistory) {
        historyRepository.deleteHistory(orderHistory);
    }

    public List<OrderHistory> getAllOrderHistory() {
        return new ArrayList<>(historyRepository.getAllOrderHistory());
    }
}
