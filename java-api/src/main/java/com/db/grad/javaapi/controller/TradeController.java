package com.db.grad.javaapi.controller;

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
        Security security = securityRepository.findById(trade.getSecurityId())
                .orElseThrow(() -> new ResourceNotFoundException("Security for found for this id :: " + id));
        return ResponseEntity.ok().body(security);
        
    }
    
    @PostMapping("/trade")
    public Trade createSecurity(@Valid @RequestBody Trade trade) {
        return tradeRepository.saveAndFlush(trade);
    }
    
    @PutMapping("/trade/{id}")
    public ResponseEntity<Trade> updateSecurity(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody Trade tradeDetails) throws ResourceNotFoundException {
        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));

        trade.setId(tradeDetails.getId());
        trade.setBookId(tradeDetails.getBookId());
        trade.setbuySell(tradeDetails.getBuySell());
        trade.setCounterpartyId(tradeDetails.getCounterpartyId());
        trade.setPrice(tradeDetails.getPrice());
        trade.setQuantity(tradeDetails.getPrice());
        trade.setSecurityId(trade.getSecurityId());
        trade.setSettlementDate(tradeDetails.getSettlementDate());
        trade.setStatus(tradeDetails.getStatus());
        trade.setTradeDate(tradeDetails.getTradeDate());
        trade.setUserId(tradeDetails.getUserId());

        final Trade updatedTrade = tradeRepository.save(trade);
        return ResponseEntity.ok(updatedTrade);
    }

}
