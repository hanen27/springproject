package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Salariee;
import com.example.demo.repository.salarieeRepository;

@RestController
@RequestMapping("/api/v1/")
public class SalarieeController {
	@Autowired
  private salarieeRepository salarieeRepository;
  //get all salariees
	@GetMapping("/salariees")
	public List<Salariee> getAllSalariee(){
		return salarieeRepository.findAll();
	}
	//salrieebyid
	@GetMapping("/salariees/{id}")
	public ResponseEntity<Salariee> getSalrieeById(@PathVariable(value = "id") Long id){
		Salariee salriee = salarieeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(salriee);
		
	}
	// create employee rest api
		@PostMapping("/salariees")
		public Salariee createSalariee(@RequestBody Salariee salariee) {
			return salarieeRepository.save(salariee);
		}
		// update salariee rest api
		
		@PutMapping("/salariees/{id}")
		public ResponseEntity<Salariee> updateSalariee(@PathVariable Long id, @RequestBody Salariee salarieeDetails){
			Salariee salariee = salarieeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("salarié not exist with id :" + id));
			
			salariee.setNom(salarieeDetails.getNom());
			salariee.setPrenom(salarieeDetails.getPrenom());
			salariee.setAdresse(salarieeDetails.getAdresse());
			salariee.setEmail(salarieeDetails.getEmail());
            salariee.setTel(salarieeDetails.getTel());

			
			Salariee updatedSalariee = salarieeRepository.save(salariee);
			return ResponseEntity.ok(updatedSalariee);
		}
		// delete employee rest api
		@DeleteMapping("/salariees/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteSalariee(@PathVariable Long id){
			Salariee salariee = salarieeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Salariee not exist with id :" + id));
			
			salarieeRepository.delete(salariee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
