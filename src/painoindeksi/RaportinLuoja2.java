package painoindeksi;

import java.util.List;
import java.util.ArrayList;

public class RaportinLuoja2 implements Raportoiva {

    RaportinLuoja2() {
    }

    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {
        List<String> alipainoiset = new ArrayList();
        List<String> normaalipainoiset = new ArrayList();
        List<String> ylipainoiset = new ArrayList();
        List<String> merkittavastiYlipainoiset = new ArrayList();

        for (Henkilo hlo : henkilotiedot) {
            double pi = hlo.getPaino() / (hlo.getPituus() * hlo.getPituus());
            String nimi = hlo.getNimi();
            if (pi < 18.5) {
                alipainoiset.add(nimi);
            }

            if (pi >= 18.5 && pi < 25) {
                normaalipainoiset.add(nimi);
            }

            if (pi >= 25 && pi < 30) {
                ylipainoiset.add(nimi);
            }

            if (pi >= 30) {
                merkittavastiYlipainoiset.add(nimi);
            }
        }

        PainoindeksiRaportti raportti = new PainoindeksiRaportti(alipainoiset, normaalipainoiset, ylipainoiset, merkittavastiYlipainoiset);

        return raportti;
    }
}
