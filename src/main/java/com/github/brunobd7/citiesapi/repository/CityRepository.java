package com.github.brunobd7.citiesapi.repository;

import com.github.brunobd7.citiesapi.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {

    /**USING NATIVE QUERY IMPLEMENTATION DIRECTLY INTO INTERFACE REPRESENTATIO,
     *  USES ("?1","?2"...) WIHT NUMBER OF PARAMS
     *
     * param 1 first param used in query
     * param 2 second param used in query
     * param N *
     *
     * */
    @Query(value = "select ((select lat_lon from cidade where id = ?1 ) <@> (select lat_lon from cidade where id= ?2)) as distance;", nativeQuery = true)
    Double distanceByPoints(Long city1, Long city2);


    @Query( value = "select earth_distance( ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance;", nativeQuery = true)
    Double distanceByCube(double x, double y, double x1, double y1);
}
