package edu.upc.dsa;

import edu.upc.dsa.models.Arma;
import edu.upc.dsa.models.Casillas_mapa;
import edu.upc.dsa.models.Compra_arma;

import java.util.List;

public interface ICasillasDAO {

    public List<Casillas_mapa> getCasillasLevel(int level);
    public List<Casillas_mapa> getCasillasLevelType(int level, String tipo);

}
