package com.study.patent.repositories;

import com.study.patent.domain.Patent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface patentRepository extends JpaRepository<Patent, Integer> {

    @Query(value = "select * from 11_apply a where a.province = ?1", nativeQuery = true)
    Patent queryFrom11Apply(String province);

    @Query(value = "select * from 11_grant a where a.province = ?1", nativeQuery = true)
    Patent queryFrom11Grant(String province);

    @Query(value = "select * from 12_apply a where a.province = ?1", nativeQuery = true)
    Patent queryFrom12Apply(String province);

    @Query(value = "select * from 12_grant a where a.province = ?1", nativeQuery = true)
    Patent queryFrom12Grant(String province);

    @Query(value = "select * from 13_apply a where a.province = ?1", nativeQuery = true)
    Patent queryFrom13Apply(String province);

    @Query(value = "select * from 13_grant a where a.province = ?1", nativeQuery = true)
    Patent queryFrom13Grant(String province);

    @Query(value = "select * from 14_apply a where a.province = ?1", nativeQuery = true)
    Patent queryFrom14Apply(String province);

    @Query(value = "select * from 14_grant a where a.province = ?1", nativeQuery = true)
    Patent queryFrom14Grant(String province);

    @Query(value = "select * from 15_apply a where a.province = ?1", nativeQuery = true)
    Patent queryFrom15Apply(String province);

    @Query(value = "select * from 15_grant a where a.province = ?1", nativeQuery = true)
    Patent queryFrom15Grant(String province);
}
