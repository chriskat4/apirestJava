package com.Api.tcc.repositories;



/* import java.util.UUID; */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/* import org.springframework.data.repository.query.Param; */

import com.Api.tcc.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    @Query(value = "SELECT name FROM tb_users WHERE id = :id", nativeQuery = true)
    UserModel findNameById(Long id);
    
    @Query(value = "SELECT password FROM tb_users WHERE id = :id", nativeQuery = true)
    UserModel findPasswordById(Long id);

    @Query(value = "SELECT * FROM tb_user WHERE email = :email", nativeQuery = true)
    UserModel findUserByEmail(String email);

    /* BookModel findBookModelByTitle(String title);
    
    @Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
    List<BookModel> findBooksByPublisherId(@Param("id") UUID id);
 */
}
