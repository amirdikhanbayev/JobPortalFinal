package com.umniki.JobPortal.Controller;

import com.umniki.JobPortal.Entity.Summary;
import com.umniki.JobPortal.Service.Vacancy.SummeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/summery")
public class SummaryController {

    private final SummeryService service;

    @GetMapping ("/find-by-id/{id}")
    public Summary findById(@PathVariable String id){
        return service.findById(id).orElseThrow();
    }

    @DeleteMapping("/delete-summery/{id}")
    public void delete(@PathVariable String id){
        service.deleteById(id);
    }

    @GetMapping("/list-all")
    public List<Summary> listAll(){
        return service.listAll();
    }
}
