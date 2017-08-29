package br.com.jonss.homeboy.repository;

import br.com.jonss.homeboy.model.WorkRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRegisterRepository extends JpaRepository<WorkRegister, Long> {
    WorkRegister findTop1ByUserId(String userId);

    List<WorkRegister> findAllByUserName(String userName);
}
