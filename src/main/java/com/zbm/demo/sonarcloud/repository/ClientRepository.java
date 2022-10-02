package com.zbm.demo.sonarcloud.repository;

import com.zbm.demo.sonarcloud.domain.ClientInfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientInfos, Long> {

    ClientInfos findById(long clientId);
}
