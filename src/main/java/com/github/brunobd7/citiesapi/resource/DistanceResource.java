package com.github.brunobd7.citiesapi.resource;

import com.github.brunobd7.citiesapi.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

//    private final DistanceService service;
//    public DistanceResource(DistanceService service) {
//        this.service = service;
//    }

    @Autowired
    DistanceService distanceService;

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return distanceService.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return distanceService.distanceByCubeInMeters(city1, city2);
    }

    /**Manual calculate*/
//    @GetMapping("/by-math")
//    public Double byMath(@RequestParam(name = "from") final Long city1,
//                         @RequestParam(name = "to") final Long city2,
//                         @RequestParam final EarthRadius unit) {
//        log.info("byMath");
//        return distanceService.distanceUsingMath(city1, city2, unit);
//    }

}
