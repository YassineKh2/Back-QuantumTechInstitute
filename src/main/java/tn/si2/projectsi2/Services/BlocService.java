package tn.si2.projectsi2.Services;

import tn.si2.projectsi2.Entites.Bloc;

import java.util.List;

public interface BlocService {
    public Bloc AddBloc(Bloc Bloc);
    public List<Bloc> GetAllBlocs();
    public Bloc UpdateBloc(Bloc Res);
    public void DeleteBloc(Bloc Res);

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;
}
