package com.example.inventory.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.inventory.Data.RegionInstances;

@Repository
public interface RegionInstancesRepository extends JpaRepository< RegionInstances,Integer> {
    @Query("SELECT ri FROM RegionInstances ri JOIN ri.region r JOIN ri.instance ei JOIN ei.vcpuCore vc JOIN ei.operatingSystem os WHERE (:regionName IS NULL OR r.regionLongName = :regionName) AND (:coreCount = 0 OR vc.coreCount = :coreCount) AND (:osName IS NULL OR os.operatingSystemName = :osName)")
    List<RegionInstances> findRegionInstances(@Param("regionName") String regionName, @Param("osName") String osName, @Param("coreCount") Integer coreCount);

    
}
