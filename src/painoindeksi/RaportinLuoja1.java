package painoindeksi;

import java.util.List;
import java.util.stream.Collectors;

public class RaportinLuoja1 implements Raportoiva {

    public RaportinLuoja1() {
    }

    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {
        List<String> alipainoiset = henkilotiedot
                .stream()
                .filter(h -> h.getPaino()/(h.getPituus()*h.getPituus()) < 18.5)
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
        
        List<String> normaalipainoiset = henkilotiedot
                .stream()
                .filter(h -> h.getPaino()/(h.getPituus()*h.getPituus()) >= 18.5 && h.getPaino()/(h.getPituus()*h.getPituus())<25)
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
        
        List<String> ylipainoiset = henkilotiedot
                .stream()
                .filter(h -> h.getPaino()/(h.getPituus()*h.getPituus()) >= 25 && h.getPaino()/(h.getPituus()*h.getPituus())<30)
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
        
        List<String> merkittavastiYlipainoiset = henkilotiedot
                .stream()
                .filter(h -> h.getPaino()/(h.getPituus()*h.getPituus()) >= 30)
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
        
        PainoindeksiRaportti raportti = new PainoindeksiRaportti(alipainoiset,normaalipainoiset,ylipainoiset,merkittavastiYlipainoiset);
                
        return raportti;
    }
}
