package com.app.gym.controller;

import com.app.gym.service.StatisticsService;
import com.app.gym.service.ExportService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;
    private final ExportService exportService;

    public StatisticsController(StatisticsService statisticsService, ExportService exportService) {
        this.statisticsService = statisticsService;
        this.exportService = exportService;
    }

    @GetMapping("/active-clients")
    public long getActiveClientsCount() {
        return statisticsService.getActiveClientsCount();
    }

    @GetMapping("/revenue")
    public double getEstimatedMonthlyRevenue() {
        return statisticsService.getEstimatedMonthlyRevenue();
    }

    @GetMapping("/export-csv")
    public ResponseEntity<byte[]> exportSubscriptionsCsv() throws IOException {
        ByteArrayInputStream stream = exportService.exportSubscriptionsToCsv();
        byte[] data = stream.readAllBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=subscriptions.csv");
        headers.setContentType(MediaType.TEXT_PLAIN);

        return ResponseEntity.ok().headers(headers).body(data);
    }
}
