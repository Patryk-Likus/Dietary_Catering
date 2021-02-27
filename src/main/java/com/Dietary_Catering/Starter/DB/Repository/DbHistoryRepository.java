package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

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

    @Transactional
    public List<OrderHistory> getOrderHistoryByIdList(int id) {
        return em.createQuery("from OrderHistory where person_id=:id", OrderHistory.class).setParameter("id", id).getResultList();
    }

    @Transactional
    public void DeleteOrderHistoryByIdList(int id) {
        List<OrderHistory> orderHistoryList = em.createQuery("from OrderHistory where person_id=:id", OrderHistory.class).setParameter("id", id).getResultList();
        for(OrderHistory o: orderHistoryList){
            em.remove(o);
        }
    }



}
