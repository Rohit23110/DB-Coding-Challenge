package com.db.grad.javaapi.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.repository.TradeRepository;

@RestController
@RequestMapping("/api/v1")
public class SecurityController {

    @Autowired
    private SecurityRepository securityRepository;

    @Autowired
    private TradeRepository tradeRepository;

    @GetMapping("/security")
    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    @GetMapping("/security/{id}")
    public ResponseEntity<Security> getSecurityById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Security security = securityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));
        return ResponseEntity.ok().body(security);
    }

    @GetMapping("/tradesforsecurity/{id}")
    public ResponseEntity<List<Trade>> getTradesForSecurity(@PathVariable(value = "id") Integer id) {
        List<Trade> trades = tradeRepository.findBySecurityid(id);

        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("/security/date-range")
    public ResponseEntity<List<Security>> getSecurityByDateRange(@RequestParam Date date1, @RequestParam Date date2) {
        List<Security> security = securityRepository.findByMaturitydateBetween(date1, date2);
        return ResponseEntity.ok().body(security);
    }

    @PostMapping("/security")
    public Security createSecurity(@Valid @RequestBody Security security) {
        Security lastSecurity = securityRepository.findTopByOrderByIdDesc();
        security.setId(lastSecurity.getId() + 1);
        return securityRepository.saveAndFlush(security);
    }

    @PutMapping("/security/{id}")
    public ResponseEntity<Security> updateSecurity(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {
        Security security = securityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));

        // security.setId(securityDetails.getId());
        security.setISIN(securityDetails.getISIN());
        security.setCUSIP(securityDetails.getCUSIP());
        security.setIssuer(securityDetails.getIssuer());
        security.setMaturitydate(securityDetails.getMaturitydate());
        security.setCoupon(securityDetails.getCoupon());
        security.setType(securityDetails.getType());
        security.setFacevalue(securityDetails.getFacevalue());
        security.setStatus(securityDetails.getStatus());

        final Security updatedSecurity = securityRepository.save(security);
        return ResponseEntity.ok(updatedSecurity);
    }

    @DeleteMapping("/security/{id}")
    public Boolean deleteSecurity(@PathVariable(value = "id") Integer id) {
        securityRepository.deleteById(id);
        return true;
    }
}