package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DbHistoryRepository implements HistoryRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void saveOrderHistory(OrderHistory orderHistory) {
        em.persist(orderHistory);
    }


    @Transactional
    public Collection<OrderHistory> getAllOrderHistory() {
        return em.createQuery("from OrderHistory", OrderHistory.class).getResultList();
    }

    @Transactional
    public void deleteHistory(OrderHistory orderHistory) {
        OrderHistory searchHistory = em.find(OrderHistory.class, orderHistory.getId());
        em.remove(searchHistory);
    }

    @Transactional
    public OrderHistory getOrderHistoryById(int id) {
        return em.createQuery("from OrderHistory where id=:id", OrderHistory.class).setParameter("id", id).getSingleResult();
    }



}
