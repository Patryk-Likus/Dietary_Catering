package com.Dietary_Catering.Starter.Services;

import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

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

    public List<OrderHistory> getAllOrderHistoryByIDList(int id){
        return historyRepository.getOrderHistoryByIdList(id);
    }

    public void deleteOrderHistoryUser(int id){
        historyRepository.DeleteOrderHistoryByIdList(id);
    }
}
