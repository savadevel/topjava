package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
    @Query("select m from Meal m where m.id=?1 and m.user.id=?2")
    Meal get(int id, int userId);

    @Query("select m from Meal m where m.user.id=?1 order by m.dateTime desc")
    List<Meal> getAll(int userId);

    @Query("select m from Meal m where m.user.id = ?3 and m.dateTime >= ?1 and m.dateTime < ?2 order by m.dateTime desc")
    List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);

    @Transactional
    @Modifying
    @Query("delete from Meal m where m.id = ?1 and m.user.id = ?2")
    int delete(int id, int userId);

    @Query("select m from Meal m inner join fetch m.user where m.id=?1 and m.user.id=?2")
    Meal getWithUser(int id, int userId);
}
