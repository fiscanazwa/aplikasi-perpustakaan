
package id.ac.ub.filkom.contoh.controller;

import id.ac.ub.filkom.contoh.entity.Anggota;
import id.ac.ub.filkom.contoh.repository.AnggotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnggotaController {

    private final AnggotaRepository anggotaRepository;

    public AnggotaController(AnggotaRepository anggotaRepository) {
        this.anggotaRepository = anggotaRepository;
    }

    @GetMapping("/anggota")
    public String daftarAnggota(Model model) {
        model.addAttribute(
            "daftarAnggota",
            anggotaRepository.findAll()
        );
        return "anggota";
    }

    @PostMapping("/anggota")
    public String tambahAnggota(
            @RequestParam String idAnggota,
            @RequestParam String nama,
            @RequestParam int batasPinjam) {

        Anggota anggota =
            new Anggota(idAnggota, nama, batasPinjam);

        anggotaRepository.save(anggota);

        return "redirect:/anggota";
    }
}

