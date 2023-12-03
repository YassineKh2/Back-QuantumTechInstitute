package tn.si2.projectsi2.Services;

import tn.si2.projectsi2.Entites.Chambre;

import java.util.Set;

public interface ChambreService {
    public Set<Chambre> findChambesByIds(Set<Long> idChambres);
}
