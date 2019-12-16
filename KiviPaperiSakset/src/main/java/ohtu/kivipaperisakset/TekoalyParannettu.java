
package ohtu.kivipaperisakset;

// "Muistava tekoäly"

public class TekoalyParannettu extends Tekoaly {
  private final String[] muisti;
  private int vapaaMuistiIndeksi;

  public TekoalyParannettu(int muistinKoko) {
    muisti = new String[muistinKoko];
    vapaaMuistiIndeksi = 0;
  }
  
  @Override
  public void asetaSiirto(String siirto) {
    if(vapaaMuistiIndeksi == muisti.length) {
      for(int i = 1; i < muisti.length; i++) {
        muisti[i-1] = muisti[i];
      }
      
      vapaaMuistiIndeksi--;
    }
    
    muisti[vapaaMuistiIndeksi] = siirto;    
    vapaaMuistiIndeksi++;
  }

  @Override
  public String annaSiirto() {
    if(vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
      return "k";
    }
    
    String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];
    
    int kivet = 0, paperit = 0, sakset = 0;
    
    
    for(int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
      if(viimeisinSiirto.equals(muisti[i])) {
        String seuraava = muisti[i+1];
        
        if(null == seuraava) {
            sakset++;
        }
        else switch (seuraava) {
              case "k":
                  kivet++;
                  break;
              case "p":
                  paperit++;        
                  break;
              default:
                  sakset++;
                  break;
          }        
      }
    }
    
    if(kivet > paperit && kivet > sakset) {
      return "p";
    }
    else if (paperit > kivet && paperit > sakset) {
      return "s";
    }
    else {
      return "k";
    }
    
  }
}