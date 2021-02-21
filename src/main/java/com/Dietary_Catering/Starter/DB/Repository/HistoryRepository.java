package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;

import java.util.Collection;

public interface HistoryRepository {

    void saveOrderHistory(OrderHistory orderHistory);

    Collection<OrderHistory> getAllOrderHistory();

    void deleteHistory(OrderHistory orderHistory);

    OrderHistory getOrderHistoryById(int id);
}
