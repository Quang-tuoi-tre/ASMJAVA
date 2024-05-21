/*
package mu.ronaldo.lienquan.Asm.Service;
import mu.ronaldo.lienquan.Asm.model.Xe;
import mu.ronaldo.lienquan.Asm.Repository.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
public class XeService {
    private XeRepository xeRepository;

    public List<Xe> getAllXe() {
        return xeRepository.findAll();
    }

    public Optional<Xe> getXeById(Long id) {
        return xeRepository.findById(id);
    }

    public Xe addXe(Xe xe) {
        return xeRepository.save(xe);
    }

    public Xe updateXe(Long id, Xe xeDetails) {
        Xe xe = xeRepository.findById(id).orElseThrow();
        xe.setBienSoXe(xeDetails.getBienSoXe());
        xe.setNgaySanXuat(xeDetails.getNgaySanXuat());
        xe.setSoChoNgoi(xeDetails.getSoChoNgoi());
        xe.setDangKyKinhDoanh(xeDetails.getDangKyKinhDoanh());
        return xeRepository.save(xe);
    }

    public void deleteXe(Long id) {
        xeRepository.deleteById(id);
    }

    public List<Xe> findXeBySoChoNgoi(Integer soChoNgoi) {
        return xeRepository.findBySoChoNgoi(soChoNgoi);
    }

    public List<Xe> findXeByNgaySanXuat(LocalDate ngaySanXuat) {
        return xeRepository.findByNgaySanXuat(ngaySanXuat);
    }

    public List<Xe> findXeBienSoDep() {
        List<Xe> allXe = xeRepository.findAll();
        return allXe.stream().filter(this::isBienSoDep).toList();
    }

    private boolean isBienSoDep(Xe xe) {
        String bienSo = xe.getBienSoXe().split("-")[1];
        return Pattern.matches("(\\d)\\1{3,}", bienSo) || isIncreasingSequence(bienSo);
    }

    private boolean isIncreasingSequence(String bienSo) {
        for (int i = 0; i < bienSo.length() - 1; i++) {
            if (bienSo.charAt(i) + 1 != bienSo.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
*/
