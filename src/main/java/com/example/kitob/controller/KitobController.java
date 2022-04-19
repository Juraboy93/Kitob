package com.example.kitob.controller;

import com.example.kitob.dto.ApiResponse;
import com.example.kitob.dto.KitobDto;
import com.example.kitob.entity.Kitob;
import com.example.kitob.excaption.Not_Found;
import com.example.kitob.repository.KitobRepositary;
import com.example.kitob.service.KitobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class KitobController {
    final  KitobService kitobService;
    final  KitobRepositary kitobRepositary;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping
    public HttpEntity<?> getAll() {

        List<Kitob> all = kitobRepositary.findAll();
        if (all.isEmpty()) {
            return new HttpEntity<Not_Found>(new Not_Found("List bo'sh"));
        }
        return ResponseEntity.ok().body(all);
//        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getByID(@PathVariable String id) {
        for (char c : id.toCharArray()) {
            if (!Character.isDigit(c)) {
                return new HttpEntity<Not_Found>(new Not_Found("Bunday id li product mavjud emas"));
            }
        }
        Optional<Kitob> kitobOptional =kitobRepositary.findById(Integer.valueOf(id));
        return ResponseEntity.ok().body(kitobOptional.get());

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody KitobDto kitobDto) {
        ApiResponse add = kitobService.add(kitobDto);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(add);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public HttpEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody KitobDto kitobDto) {
        ApiResponse edit = kitobService.edit(id, kitobDto);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(edit);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id) {
        ApiResponse delet = kitobService.delet(id);
        return ResponseEntity.status(delet.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(delet);
    }
}
