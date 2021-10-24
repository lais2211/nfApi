package com.desafio.nfapi.repository;

import com.desafio.nfapi.entity.MainEntity;
import com.desafio.nfapi.statusEnum.StatusEnum;
import com.desafio.nfapi.statusIndisp.StatusIndisp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MainRepository extends JpaRepository <MainEntity, String> {

    List<MainEntity> findTop15ByOrderByDataDesc();
    List<MainEntity> findFirstByEstadoOrderByDataDesc(String estado);
    List<MainEntity> findTop15ByData(LocalDate localDate);
    @Query ("select new com.desafio.nfapi.statusIndisp.StatusIndisp(a.estado, count (a.status))"+
    "from MainEntity a where a.status=:status GROUP BY  a.estado")
    List<StatusIndisp> instabilidade(String status);
}
