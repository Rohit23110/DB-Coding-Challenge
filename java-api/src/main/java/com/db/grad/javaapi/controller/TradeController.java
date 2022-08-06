package com.db.grad.javaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.repository.SecurityRepository;

@RestController
@RequestMapping("/api/v1")
public class TradeController {

    @Autowired
    private TradeRepository tradeRepository;
    
    @Autowired
    private SecurityRepository securityRepository;

    @GetMapping("/trade")
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @GetMapping("/trade/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trade not found for this id :: " + id));
        return ResponseEntity.ok().body(trade);
    }
    
    @GetMapping("/securityfromtrade/{id}")
    public ResponseEntity<Security> getSecurityFromTrade(@PathVariable(value = "id") Integer id)
    	throws ResourceNotFoundException {
    	Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trade not found for this id :: " + id));
        Security security = securityRepository.findById(trade.getSecurityid())
                .orElseThrow(() -> new ResourceNotFoundException("Security not for found for this id :: " + id));
        return ResponseEntity.ok().body(security);
        
    }
    
    @PostMapping("/trade")
    public Trade createTrade(@Valid @RequestBody Trade trade) {
        Trade lastTrade = tradeRepository.findTopByOrderByIdDesc();
        trade.setId(lastTrade.getId() + 1);
        return tradeRepository.saveAndFlush(trade);
    }
    
    @PutMapping("/trade/{id}")
    public ResponseEntity<Trade> updateSecurity(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody Trade tradeDetails) throws ResourceNotFoundException {
        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trade not found for this id :: " + id));

        // trade.setId(tradeDetails.getId());
        trade.setBookid(tradeDetails.getBookid());
        trade.setBuysell(tradeDetails.getBuysell());
        trade.setCounterpartyid(tradeDetails.getCounterpartyid());
        trade.setPrice(tradeDetails.getPrice());
        trade.setQuantity(tradeDetails.getPrice());
        trade.setSecurityid(trade.getSecurityid());
        trade.setSettlementdate(tradeDetails.getSettlementdate());
        trade.setStatus(tradeDetails.getStatus());
        trade.setTradedate(tradeDetails.getTradedate());
        trade.setUserid(tradeDetails.getUserid());

        final Trade updatedTrade = tradeRepository.save(trade);
        return ResponseEntity.ok(updatedTrade);
    }
}
