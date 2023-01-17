package com.jpaTransaction.demo.controller;

import com.jpaTransaction.demo.entity.Ticket;
import com.jpaTransaction.demo.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    Logger logger = LoggerFactory.getLogger(TicketController.class);
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    @GetMapping("/tickets")
    public List<Ticket> showTickets(Model model){
        return ticketService.findAll(Sort.by(Sort.Direction.ASC, "createDate"));
    }

    @PostMapping("/new-ticket")
    public Ticket createNewTicket(@RequestBody Ticket ticket){
        ticket.setId(0);
        return ticketService.addOrUpdateTicket(ticket);
    }

    @GetMapping("/update-ticket")
    public Ticket updateTicket(@RequestBody Ticket ticket){
        return ticketService.addOrUpdateTicket(ticket);
    }

    @DeleteMapping("/delete-ticket")
    public void deleteTicket(@RequestBody Ticket ticket){
        ticketService.deleteTicket(ticket);
    }

    @GetMapping("/search-ticket")
    public List<Ticket> searchTicket(@RequestBody String title){
        return ticketService.searchTicket(title);
    }


}
