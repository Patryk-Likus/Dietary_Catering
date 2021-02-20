package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.Food;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DbFoodRepository implements FoodRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Food> getAllFoods() {
        return em.createQuery("FROM Food ORDER BY id ASC", Food.class).getResultList();
    }

    @Transactional
    public void createFood(Food food) {
        em.persist(food);
    }


    @Transactional
    public void updateFood(Food food) {
        em.merge(food);
    }

    @Transactional
    public void deleteFood(Food food) {
        Food searchFood = em.find(Food.class, food.getId());
        em.remove(searchFood);
    }


    @Transactional
    public Food getFoodById(int id) {
        return em.createQuery("from Food where id=:id", Food.class).setParameter("id", id).getSingleResult();
    }

}
