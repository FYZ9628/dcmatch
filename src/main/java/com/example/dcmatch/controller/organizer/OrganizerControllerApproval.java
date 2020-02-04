package com.example.dcmatch.controller.organizer;

import com.example.dcmatch.model.Organizer;
import com.example.dcmatch.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class OrganizerControllerApproval {

    @Autowired
    OrganizerService organizerService;

    @GetMapping("/api/organizerInfo")
    public List<Organizer> organizerList() throws Exception {
        return organizerService.organizerList();
    }
}
