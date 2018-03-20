package oop.lab.admin.api;

import oop.lab.admin.model.MetricsResponse;
import oop.lab.admin.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private MetricsService metricsService;

    @RequestMapping("/metrics")
    public MetricsResponse metrics() {
        return new MetricsResponse(metricsService.isOkay());
    }
}
