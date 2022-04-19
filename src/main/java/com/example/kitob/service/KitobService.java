package com.example.kitob.service;

import com.example.kitob.dto.ApiResponse;
import com.example.kitob.dto.KitobDto;
import com.example.kitob.entity.Kitob;
import com.example.kitob.repository.KitobRepositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KitobService {
    final KitobRepositary kitobRepositary;

    public ApiResponse add(KitobDto kitobDto){
        Kitob kitob=new Kitob();
        kitob.setName(kitobDto.getName());
        kitob.setSinf(kitobDto.getSinfi());
        kitob.setTil(kitobDto.getTili());
        Kitob save=kitobRepositary.save(kitob);
        return new ApiResponse("Qo'shildi",true);
    }
    public ApiResponse edit(Integer id, KitobDto kitobDto){
        Optional<Kitob> byid=kitobRepositary.findById(id);
        if (!byid.isPresent()){
            return new ApiResponse("kitob topilmadi",false);
        }
        Kitob kitob= new Kitob();
        kitob.setName(kitobDto.getName());
        kitob.setSinf(kitobDto.getSinfi());
        kitob.setTil(kitobDto.getTili());
        Kitob save= kitobRepositary.save(kitob);
     return new ApiResponse("O'zgartirildi",true);
    }

    public ApiResponse delet(Integer id){
        Optional<Kitob> byId = kitobRepositary.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("kitob topilmadi", false);
        }
        kitobRepositary.deleteById(id);
        return new ApiResponse("O'chirildi",true);
    }
}
